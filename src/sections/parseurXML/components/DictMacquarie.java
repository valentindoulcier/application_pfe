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

import dao.HeadwordDAO;
import dao.ListeCategoriesDAO;
import database.AvoirPourCategorieHeadword;
import database.Dictionnaires;
import database.EtymoMcq;
import database.Headword;
import database.ListeCategories;
import database.Sens;
import database.Syllabes;

/**
 * Classe s'occupant du traitement du dictionnaire Macquarie
 * 
 * @author Simon Kesteloot
 * 
 */
public class DictMacquarie extends AbstractDictionnaire {

	Headword headword;
	HeadwordDAO hDAO;
	Dictionnaires dic;
	List<ListeCategories> listeCategories;
	Node noeudMot;

	/**
	 * nom du fichier contenant le dictionnaire Macquarie
	 * 
	 * @param nomFichier
	 * 
	 */
	@SuppressWarnings("unchecked")
	public DictMacquarie(String nomFichier) {

		super(nomFichier);
		dic = new Dictionnaires("Macquarie", null);

		listeCategories = (List<ListeCategories>) new ListeCategoriesDAO(
				"local").findAll();
		hDAO = new HeadwordDAO("local");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sections.parseurXML.components.AbstractDictionnaire#traiter()
	 */
	public void traiter() {

		// sauvegarde du nom du dictionnaire
		session.saveOrUpdate(dic);

		// ajout des catégories de mots
		extraireToutesCategorie();

		// parcours de tout les headword
		LinkedList<Node> liste = chercherNoeud(doc, "record", 3);

		while (!liste.isEmpty()) {
			enregistrerMot(liste.pollFirst());

		}
	}

	/**
	 * extrait toute les catégories existant dans le dictionnaire et les
	 * enregistre dans la base de donnée (table liste_categories)
	 */
	@SuppressWarnings("unchecked")
	private void extraireToutesCategorie() {

		// liste toutes les catégories déjà existantes dans la base de donnée
		Set<String> listeStringCate = new HashSet<String>();
		for (ListeCategories cate : (List<ListeCategories>) listeCategories) {
			if (!listeStringCate.contains(cate.getNom())) {
				listeStringCate.add(cate.getNom());
			}
		}

		// cherche toute les catégories du dictionnaire
		LinkedList<Node> listeNoeud = chercherNoeud(doc, "pos", 5);
		// test chaque catégorie si elle existe deja dans la base
		while (!listeNoeud.isEmpty()) {
			if (listeNoeud.peek() != null
					&& listeNoeud.peek().getFirstChild() != null) {

				String cate = listeNoeud.pop().getFirstChild().getNodeValue();
				if (!listeStringCate.contains(cate)) {
					// si ne contient pas la catégorie, crée une nouvelle et
					// l'enregistre en base
					Transaction tx = session.beginTransaction();
					listeStringCate.add(cate);
					ListeCategories lc = new ListeCategories();
					lc.setNom(cate);
					System.out.println(cate);
					session.save(lc);
					tx.commit();
				}
			} else {
				// si noeud "pos" non renseigner, crée catégorie "unknow" (si
				// non existante)
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
		// mis à jour de la liste local
		listeCategories = (List<ListeCategories>) new ListeCategoriesDAO(
				"local").findAll();
	}

	/**
	 * méthode qui s'occupe du traitement d'une entrée
	 * 
	 * @param noeudMot
	 *            noeud correspondant à l'entrée à traiter
	 */
	private void enregistrerMot(Node noeudMot) {
		 Transaction tx = session.beginTransaction();

		this.noeudMot = noeudMot;
		headword = new Headword();
		headword.setDictionnaires(dic);

		extraireHeadword();
		extraireCategorie();
		extraireSens();
		extraireEty();
		extrairePron();

		session.save(headword);
		
		for (AvoirPourCategorieHeadword cate: (Set<AvoirPourCategorieHeadword>) headword.getAvoirPourCategorieHeadwords()) {
			cate.setHeadword(headword);
			session.save(cate);
		}
//		session.persist(headword);
//		hDAO.create(headword);
		tx.commit();
	}

	/**
	 * extrait le mot (table headword/mot)
	 */
	private void extraireHeadword() {
		Node noeud = chercherNoeudUnique(noeudMot, "head");
		NodeList liste = noeud.getChildNodes();
		String data = liste.item(0).getNodeValue();
		if (liste.getLength() > 1) {
			int sup = Integer.parseInt(liste.item(1).getFirstChild()
					.getNodeValue());
			headword.setFlagAutre(sup);
		}
		System.out.println(data);
		headword.setMot(data);
	}

	/**
	 * extrait la catégorie (table avoir_pour_categorie_headword)
	 */
	private void extraireCategorie() {
		Node noeud = chercherNoeudUnique(noeudMot, "body");
		LinkedList<Node> liste = chercherNoeud(noeud, "chunk");
		Set<AvoirPourCategorieHeadword> data = new HashSet<AvoirPourCategorieHeadword>();
		int i = 1;
		// parcours liste des définitions du mot courant
		while (!liste.isEmpty()) {
			noeud = liste.pop();
			noeud = chercherNoeudUnique(noeud, "pos");
			if (noeud != null) {
				String cat;
				if (noeud.getFirstChild() != null) {
					// si une catégorie existe, stocke
					noeud = noeud.getFirstChild();
					cat = noeud.getNodeValue();
				} else {
					// sinon "unknow"
					cat = "unknow";
				}

				// recherche dans la liste des catégories la catégorie du mot
				// courant
				for (ListeCategories cate : (List<ListeCategories>) listeCategories) {
					if (cate.getNom().equals(cat)) {
						AvoirPourCategorieHeadword avoir = new AvoirPourCategorieHeadword();
						avoir.setHeadword(headword);
						avoir.setOrdre(i);
						avoir.setListeCategories(cate);
						data.add(avoir);
					}
				}
			}
			i++;
		}
		headword.setAvoirPourCategorieHeadwords(data);
	}

	/**
	 * extrait le sens-définition (table sens)
	 */
	private void extraireSens() {
		Node noeud = chercherNoeudUnique(noeudMot, "body");
		LinkedList<Node> listeChunk = chercherNoeud(noeud, "chunk");
		Set<Sens> data = new HashSet<Sens>();

		// parcours liste des chunk (catégorie + definition) du mot courant
		while (!listeChunk.isEmpty()) {
			noeud = listeChunk.pop();

			// parcours des définitions du chunk
			LinkedList<Node> listeDef = chercherNoeud(noeud, "def");

			while (!listeDef.isEmpty()) {
				noeud = listeDef.pop();
				Node noeudText;
				noeudText = chercherNoeudUnique(noeud, "dtext");

				// récupere le label pour la définition
				Node noeudLabel = chercherNoeudUnique(noeud, "label");
				String texteSens = "";
				if (noeudLabel != null && noeudLabel.getFirstChild() != null) {
					texteSens += noeudLabel.getFirstChild().getNodeValue()
							+ "\n";
				}

				// si un seul noeud dtext alors, pas de sous-définition
				if (noeudText != null) {
					texteSens += noeudText.getFirstChild().getNodeValue();
					data.add(new Sens(headword, texteSens, null));
				} else {
					// scan toutes les sous-définitions
					LinkedList<Node> listeSubDef = chercherNoeud(noeud,
							"subdef");
					while (!listeSubDef.isEmpty()) {
						noeudText = listeSubDef.pop();
						if (noeudText != null
								&& noeudText.getFirstChild() != null
								&& noeudText.getFirstChild().getFirstChild() != null) {
							texteSens += " * "
									+ noeudText.getFirstChild().getFirstChild()
											.getNodeValue() + "\n";
						}
					}
					data.add( new Sens(headword, texteSens, ""));
				}
			}
		}
		headword.setSenses(data);
//		for(int i = 0; i<data.size(); i++){
//			session.persist(data.toArray()[i]);
//		}
	}

	/**
	 * extrait etymologie du mot courant (table etymo_mcq)
	 */
	private void extraireEty() {
		Node noeud = chercherNoeudUnique(noeudMot, "ety");
		// vérifie si le noeud ety existe
		if (noeud != null) {

			LinkedList<Node> liste = listerNoeud(noeud);
			Set<EtymoMcq> etys = new HashSet<EtymoMcq>();
			EtymoMcq ety = new EtymoMcq();
			ety.setDate("");
			ety.setFlag(0);
			ety.setLangue("");
			String contenu = "";
			while (!liste.isEmpty()) {
				noeud = liste.pop();
				switch (noeud.getNodeName()) {
				case "lang":
					ety.setLangue(noeud.getNodeValue());
					if (noeud.getNodeValue() != null) {
						contenu += noeud.getNodeValue();
					}
					break;

				case "sup":
					if (noeud.getNodeValue() != null) {
						contenu += " (" + noeud.getNodeValue() + ") ";
					}
					break;

				case "#text":
					String[] contenus = noeud.getNodeValue().split(",");
					if (contenus.length == 1) {
						contenu += noeud.getNodeValue();
					} else {
						for (int j = 0; j < contenus.length; j++) {
							contenu += contenus[j];
							ety.setContenu(contenu);
							contenu = new String("");
							ety.setHeadword(headword);
							etys.add(ety);
//							session.persist(ety);
							ety = new EtymoMcq();
							ety.setDate("");
							ety.setFlag(0);
							ety.setLangue("");
						}
					}
					break;

				default:
					if (noeud.getNodeValue() != null) {
						contenu += noeud.getNodeValue();
					}
					break;
				}
			}
			headword.setEtymoMcqs(etys);
			// for (int i = 0; i < etys.size(); i++) {
			// System.out.println(((EtymoMcq) etys.toArray()[i]).getContenu());
			// }
		}

	}

	/**
	 * extrait la prononciation du mot courant (table syllabes)
	 */
	private void extrairePron() {
		Node noeud = chercherNoeudUnique(noeudMot, "pron", 3);
		LinkedList<Node> liste = listerNoeud(noeud);
		Set<Syllabes> ss = new HashSet<Syllabes>();
		Syllabes s;
		s = new Syllabes();
		s.setHeadword(headword);
		s.setRegion("Australia");
		while (!liste.isEmpty()) {
			noeud = liste.pop();
			System.out.println(noeud.getNodeName());
			if (noeud.getNodeName().equals("prn")&& !noeud.hasAttributes()) {

				s.setSyllabe1(convertirCharPron(getValeurNoeudEnfant(noeud)));
				ss.add(s);
				s = new Syllabes();
				s.setHeadword(headword);
				s.setRegion("Australia");

			} else if (noeud.getNodeName().equals("label")) {
				 s.setCatdefMot(getValeurNoeudEnfant(noeud));
			}
		}
		headword.setSyllabeses(ss);
	}

	/**
	 * convertit la prononciation du Macquarie en IPA
	 * @param pron chaine à convertir (format macquarie)
	 * @return chaine convertit (format IPA)
	 */
	private String convertirCharPron(String pron) {
		String result = "";
		for (int i = 0; i < pron.length(); i++) {
			switch (pron.charAt(i)) {
			case 'i':
				result += "i";
				break;
			case '1':
				result += "I";
				break;
			case '8':
				result += "ε";
				break;
			case '2':
				result += "æ";
				break;
			case 'a':
				result += "a";
				break;
			case '6':
				result += "ɒ";
				break;
			case 'x':
				result += "Λ";
				break;
			case 'c':
				result += "ͻ";
				break;
			case 'y':
				result += "ʊ";
				break;
			case 'u':
				result += "u";
				break;
			case '3':
				result += "ɜ";
				break;
			case '7':
				result += "ɘ";
				break;
			case '0':
				result += "θ";
				break;
			case 'q':
				result += "ð";
				break;
			case '4':
				result += "ʃ";
				break;
			case '5':
				result += "ʒ";
				break;
			case 't':
				result += "t";
				break;
			case 'd':
				result += "d";
				break;
			case '9':
				result += "ŋ";
				break;
			case 'j':
				result += "j";
				break;
			case 'e':
				result += "e";
				break;
			case 'o':
				result += "o";
				break;
			case 'O':
				result += "ɒ̃";
				break;
			case 'A':
				result += "æ̃";
				break;
			case '!':
				result += "y";
				break;
			case '\'':
				result += "ˈ";
				break;
			case '.':
				result += "ˌ";
				break;

			default:
				result += pron.charAt(i);
				break;
			}
		}
		return result;
	}
}
