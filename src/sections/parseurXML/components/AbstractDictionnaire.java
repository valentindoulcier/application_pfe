/**
 * 
 */
package sections.parseurXML.components;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Session;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import utils.HibernateUtils;

/**
 * classe ~abstraite servant de base pour le traitement des dictionnaires
 * 
 * @author Simon Kesteloot
 * 
 */
public class AbstractDictionnaire {

	private String nomDuFichier;

	private DocumentBuilderFactory docBuilderFactory;
	private DocumentBuilder docBuilder;
	/**
	 * racine du fichier XML
	 */
	protected Document doc;

	private File fichier;

	private int numeroNoeudCourant;
	/**
	 * nombre de noeud total valeur calculée qui si demandé
	 */
	private int nombreNoeud;
	/**
	 * noeud courant lors du parcours en profondeur
	 */
	private Node noeudCourant;
	/**
	 * pile utile lors du parcours en profondeur
	 */
	private Stack<Node> pile;

	protected Session session;

	public AbstractDictionnaire(String nomFichier) {

		nomDuFichier = nomFichier;
		numeroNoeudCourant = -1;
		nombreNoeud = -1;
		pile = new Stack<Node>();

		docBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		try {
			fichier = new File(nomDuFichier);
			doc = docBuilder.parse(fichier);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		noeudCourant = doc;
		pile.push(noeudCourant);

		session = HibernateUtils.getInstanceLocale();
	}

	/**
	 * retourne le nombre de noeud XML du dictionnaire courant
	 * 
	 * @return nombre de noeud du dictionnaire courant
	 */
	@SuppressWarnings("unchecked")
	public int getNombreNoeud() {
		System.out.println("getNombreNoeud : " + nombreNoeud);
		// compte le nombre de noeud en parcourant tout l'arbre
		if (nombreNoeud == -1) {
			Node tmpNode;
			int tmpNum;
			Stack<Node> tmpPile;
			// sauvegarde le noeud courant
			tmpNode = noeudCourant;
			tmpNum = numeroNoeudCourant;
			tmpPile = (Stack<Node>) pile.clone();

			while (!chercherProchainNoeud())
				;
			nombreNoeud = numeroNoeudCourant;

			// réinitialise le noeud courant et le numero à son etat initiale.
			noeudCourant = tmpNode;
			numeroNoeudCourant = tmpNum;
			pile = (Stack<Node>) tmpPile.clone();
		}
		return nombreNoeud;
	}

	/**
	 * lors du parcours de l'abre XML (en profondeur d'abord), permet de
	 * d'avancer au noeud suivant
	 * 
	 * @return le noeud suivant pendant un parcours de l'abre en profondeur
	 *         d'abord
	 */
	public Noeud prochainNoeud() {
		Noeud noeud;
		String nom;
		String valeur;
		boolean dernier;

		// avance d'un noeud
		dernier = chercherProchainNoeud();

		nom = noeudCourant.getNodeName();
		valeur = noeudCourant.getNodeValue();

		noeud = new Noeud(nom, valeur, numeroNoeudCourant, dernier);
		return noeud;
	}

	/**
	 * cherche le prochain noeud, utilisé uniquement avec prochainNoeud()
	 * 
	 * @return true si c'est le dernier noeud de l'arbre, false sinon
	 */
	private boolean chercherProchainNoeud() {
		NodeList liste;
		int tailleListe;
		boolean dernier;
		if (!pile.empty()) {
			noeudCourant = pile.pop();
			numeroNoeudCourant++;

			if (noeudCourant.getChildNodes() != null) {

				liste = noeudCourant.getChildNodes();
				tailleListe = liste.getLength();

				for (int i = tailleListe; i >= 0; i--) {
					if (liste.item(i) != null) {
						pile.push(liste.item(i));
					}
				}
			}
			dernier = false;
		} else {
			dernier = true;
		}
		return dernier;
	}

	/**
	 * Liste tout les noeuds du sous-abre ayant le noeud fourni en paramètre
	 * comme racine. dans le sens en profondeur d'abord
	 * 
	 * @param noeudRacine
	 *            noeud servant de racine pour le parcours
	 * 
	 * @return une liste chainé de noeud appartenant au sous-arbre
	 */
	protected LinkedList<Node> listerNoeud(Node noeudRacine) {
		LinkedList<Node> listeResultat = new LinkedList<Node>();
		Stack<Node> pile = new Stack<Node>();
		Node noeud;

		// initalisation
		pile.push(noeudRacine);

		// parcours de l'arbre sous le noeud racine
		while (!pile.empty()) {
			noeud = pile.pop();
			if (noeud != null) {
				listeResultat.add(noeud);

				// ajout des noeud enfant dans la pile
				if (noeud.getChildNodes() != null) {
					NodeList listeTmp;
					int tailleListe;

					listeTmp = noeud.getChildNodes();
					tailleListe = listeTmp.getLength();

					for (int i = tailleListe; i >= 0; i--) {
						if (listeTmp.item(i) != null) {
							pile.push(listeTmp.item(i));
						}
					}
				}
			}
		}

		return listeResultat;
	}

	/**
	 * cherche les noeuds d'apres leur nom dans le sous-arbre du noeud fourni en
	 * paramètre
	 * 
	 * @param noeudRacine
	 *            noeud servant de racine pour la recherche
	 * @param nomNoeud
	 *            nom des noeuds recherché
	 * @return une liste chainé de noeud correspondant à la recherche
	 */
	protected LinkedList<Node> chercherNoeud(Node noeudRacine, String nomNoeud) {

		LinkedList<Node> listeResultat = listerNoeud(noeudRacine);
		int taille = listeResultat.size();
		int i = 0;
		while (i < taille) {
			if (listeResultat.get(i).getNodeName() != nomNoeud) {
				listeResultat.remove(i);
				taille--;
			} else {
				i++;
			}
		}
		return listeResultat;
	}

	/**
	 * cherche un noeud d'apres son nom dans le sous-arbre du noeud fourni en
	 * paramètre
	 * 
	 * @param noeudRacine
	 *            noeud servant de racine pour la recherche
	 * @param nomNoeud
	 *            nom du noeud recherché
	 * @return LE noeud correspondant à la recherche ou null si aucun ou
	 *         plusieurs
	 */
	protected Node chercherNoeudUnique(Node noeudRacine, String nomNoeud) {
		LinkedList<Node> liste = chercherNoeud(noeudRacine, nomNoeud);
		if (!liste.isEmpty() && liste.size() == 1) {
			return liste.getFirst();
		}
		return null;
	}

	/**
	 * méthodes à implémenter lancant le traitement du dictionnaire
	 */
	public void traiter() {

	}
}
