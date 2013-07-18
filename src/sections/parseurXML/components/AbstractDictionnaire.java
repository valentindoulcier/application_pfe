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
 * @author Simon Kesteloot
 * 
 */
public class AbstractDictionnaire {

	private String nomDuFichier;

	private DocumentBuilderFactory docBuilderFactory;
	private DocumentBuilder docBuilder;
	protected Document doc;

	private File fichier;

	private int numeroNoeudCourant;
	private int nombreNoeud;

	private Node noeudCourant;
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

	protected LinkedList<Node> chercherNoeud(Node noeudRacine, String nomNoeud) {
		LinkedList<Node> listeResultat = new LinkedList<Node>();
		Stack<Node> pile = new Stack<Node>();
		Node noeud;

		// initalisation
		pile.push(noeudRacine);

		// parcours de l'arbre sous le noeud racine
		while (!pile.empty()) {
			noeud = pile.pop();
			// test si le noeud est celui recherché
			if (noeud != null) {
				if (noeud.getNodeName() == nomNoeud) {
					listeResultat.add(noeud);
				}

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

	protected Node chercherNoeudUnique(Node noeudRacine, String nomNoeud) {
		LinkedList<Node> liste = chercherNoeud(noeudRacine, nomNoeud);
		if (!liste.isEmpty() && liste.size() == 1) {
			return liste.getFirst();
		}
		return null;
	}

	public void traiter() {

	}
}
