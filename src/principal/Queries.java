package principal;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


@SuppressWarnings("unchecked")
public class Queries<T> {

	public Queries() {
		;
	}


	/**
	 * Cette méthode prend en paramètre un objet de type T et
	 * l'insère dans la base de données.
	 * 
	 * @param data
	 */
	public void create(Session s, T data) {
		System.out.println("CREATE");

		// Début de la transaction
		Transaction tx = s.beginTransaction();
		
		// Sauvegarde des objets
		s.save(data);
		
		// Fermeture de la transaction
		tx.commit();
	}

	/**
	 * Cette méthode prend en paramètre un objet de type T et
	 * le modifie dans la base de données (mise à jour).
	 * 
	 * @param data
	 */
	public void update(Session s, T data) {
		System.out.println("UPDATE");

		// Début de la transaction
		Transaction tx = s.beginTransaction();

		// Sauvegarde des objets
		s.update(data);

		// Fermeture de la transaction
		tx.commit();
	}

	/**
	 * Cette méthode prend en paramètre un objet de type T et
	 * le supprime de la base de données.
	 * 
	 * @param data
	 */
	public void delete(Session s, T data) {
		System.out.println("DELETE");

		// Début de la transaction
		Transaction tx = s.beginTransaction();

		// Suppression des objets
		s.delete(data);

		// Fin de la transaction
		tx.commit();
	}

	/**
	 * Cette méthode prend en paramètre un objet le nom de la table
	 * à vider et supprime l'ensemble des enregistrements.
	 * 
	 * @param typeData
	 */
	public void clean(Session s, String typeData) {
		System.out.println("CLEAN");

		// Début de la transaction
		Transaction tx = s.beginTransaction();

		// Création de la requête
		Query q = s.createQuery("from database." + typeData);
		ArrayList<T> list = (ArrayList<T>) q.list();

		// Suppression
		for(int i = 0; i < list.size(); i++)
			delete(s, list.get(i));

		// Fin de la transaction
		tx.commit();
	}



	
	
	

	// Lecture d'un objet de type T
	/*
	public void testRead(Session s) {
		System.out.println("--------- testRead ---------");

		// Récupération de l'Event d'après son titre
		Query q = s.createQuery("from  where title= :myTitle");
		q.setString("myTitle", "Titre du premier événement");
		//Event e = (Event) q.uniqueResult();

		// Affichage de l'objet récupéré

	}
	*/
	 

	// Affiche le contenu de la table
	public ArrayList<T> print(Session s, String table, ArrayList<String> columnName, ArrayList<String> comparisonMode, ArrayList<String> value, ArrayList<String> typeValue) {
		System.out.println("PRINT");
		
		// Début de la transaction
		Transaction tx = s.beginTransaction();
		
		String query ="from database." + table;

		if (columnName != null) {
			query += " where ";
			
			int sizeColumnName = columnName.size();
			int sizeComparisonMode = comparisonMode.size();
			int sizeValue = value.size();
			int sizeTypeValue = typeValue.size();
			
			if (sizeColumnName == sizeComparisonMode && sizeComparisonMode == sizeValue && sizeValue == sizeTypeValue) {
				for (int i = 0; i < sizeColumnName; i++) {
					query += " " + columnName.get(i) + " " + comparisonMode.get(i) + " ? ";
					if (i < sizeColumnName - 1) { query += "and"; }
				}
			} else {
				//throw new IOException();
			}
		}
		
		// Création de la requête
		Query q = s.createQuery(query);
		
		if (columnName != null) {
			for (int i = 0; i < columnName.size(); i++) {
				if (typeValue.get(i).equals("int")) {
					q.setInteger(i, Integer.parseInt(value.get(i)));
				} else if (typeValue.get(i).equals("string")) {
					q.setString(i, value.get(i));
				} else {
					// Unkown type
				}
			}
		}
		
		tx.commit();
		
		return (ArrayList<T>) q.list();
		
		//ArrayList<T> list = (ArrayList<T>) q.list();

		// Affichage de la liste de résultats
		
		//int cpt = 0;
		//for (T e: list) {
			//e.toString();
			//System.out.println("test : " + );
		//}

		// Fin de la transaction
		
	}
	

	// Affiche le contenu de la table ListeStatus
	/*
		private static void print() {
			// Début de la transaction
			Transaction tx = s.beginTransaction();

			// Création de la requête
			//Query q = s.createQuery("from database.ListeStatus");
			//List result = s.createQuery( "from database.ListeStatuts" ).list(); //database/ListeStatuts.hbm.xml
			//List result = s.createQuery( "from database.ListeStatuts where statut= ?").setString(0, "dieux").list();
			//List result = s.createQuery( "from database.ListeStatuts where statut like ?").setString(0, "di%").list();
			List result = s.createQuery( "from database.ListeStatuts where statut like 'V%'").list();


			//System.out.println(result.size());
			//for(int i = 0; i < result.size(); i++)
			//	System.out.println(result.get(i) + "\n");


			ArrayList<ListeStatuts> list = (ArrayList<ListeStatuts>) result;
			// Affichage de la liste de résultats
			for (ListeStatuts e: list) {
				System.out.println("ListeStatuts : [" + e.getIdStatut() + "] = " + e.getStatut());
			}

			// Fin de la transaction
			tx.commit();
		}
	 */
};