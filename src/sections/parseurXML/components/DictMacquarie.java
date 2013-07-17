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
		extraireToutesCategorie();

		// parcours de tout les headword
		LinkedList<Node> liste = chercherNoeud(doc, "record");

		while (!liste.isEmpty()) {
			enregistrerMot(liste.pollFirst());

		}
	}

	private void extraireToutesCategorie() {

		// liste toutes les catégories déjà existantes dans la base de donnée
		Set<String> listeStringCate = new HashSet<String>();
		for (ListeCategories cate : (List<ListeCategories>) listeCategories) {
			if (!listeStringCate.contains(cate.getNom())) {
				listeStringCate.add(cate.getNom());
			}
		}

		// cherche toute les catégories du dictionnaire
		LinkedList<Node> listeNoeud = chercherNoeud(doc, "pos");
		// test chaque catégorie si elle existe deja dans la base
		while (!listeNoeud.isEmpty()) {
			if (listeNoeud.peek() != null
					&& listeNoeud.peek().getFirstChild() != null) {

				String cate = listeNoeud.pop().getFirstChild().getNodeValue();
				if (!listeStringCate.contains(cate)) {
					Transaction tx = session.beginTransaction();
					listeStringCate.add(cate);
					ListeCategories lc = new ListeCategories();
					lc.setNom(cate);
					System.out.println(cate);
					session.save(lc);
					tx.commit();
				}
			} else {
				listeNoeud.pop();
				if (!listeStringCate.contains("unknow")) {
					Transaction tx = session.beginTransaction();
					listeStringCate.add("unknow");
					ListeCategories lc = new ListeCategories();
					lc.setNom("unknow");
					session.save(lc);
					tx.commit();
				}
			}
		}

		listeCategories = (List<ListeCategories>) new ListeCategoriesDAO(
				"local").findAll();
	}

	private void enregistrerMot(Node noeudMot) {
		Transaction tx = session.beginTransaction();

		this.noeudMot = noeudMot;
		headword = new Headword();
		headword.setDictionnaires(dic);

		extraireHeadword();
//		extraireCategorie();

		session.save(headword);
		tx.commit();
	}
	private void extraireHeadword() {
		Node noeud = chercherNoeudUnique(noeudMot, "head");
		NodeList liste = noeud.getChildNodes();
		String data;
		if (liste.getLength() < 2) {
			// cas simple avec juste le mot
			data = liste.item(0).getNodeValue();
		} else {
			// cas où la balise sup est présente
			data = liste.item(0).getNodeValue();
			data += "(";
			data += liste.item(1).getFirstChild().getNodeValue();
			data += ")";
		}
		System.out.println(data);
		headword.setMot(data);
	}
}
