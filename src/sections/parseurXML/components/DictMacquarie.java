/**
 * 
 */
package sections.parseurXML.components;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Transaction;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dao.ListeCategoriesDAO;
import database.AvoirPourCategorieHeadword;
import database.Dictionnaires;
import database.Headword;
import database.ListeCategories;

/**
 * @author Simon Kesteloot
 * 
 */
public class DictMacquarie extends FichierDictionnaire {

	Headword headword;
	Dictionnaires dic;
	List<ListeCategories> listeCategories;
	Node noeudMot;

	/**
	 * @param nomFichier
	 */
	@SuppressWarnings("unchecked")
	public DictMacquarie(String nomFichier) {

		super(nomFichier);
		dic = new Dictionnaires("Macquarie", null);

		listeCategories = (List<ListeCategories>) new ListeCategoriesDAO(
				"local").findAll();
	}

	public void traiter() {

		// sauvegarde du nom du dictionnaire
		session.saveOrUpdate(dic);

		// ajout des catégories de mots
//		extraireToutesCategorie();

		// parcours de tout les headword
		LinkedList<Node> liste = chercherNoeud(doc, "record");

		while (!liste.isEmpty()) {
			enregistrerMot(liste.pollFirst());

		}
	}
	private void enregistrerMot(Node noeudMot) {
		Transaction tx = session.beginTransaction();

		this.noeudMot = noeudMot;
		headword = new Headword();
		headword.setDictionnaires(dic);

//		extraireHeadword();
//		extraireCategorie();

		session.save(headword);
		tx.commit();
	}
}
