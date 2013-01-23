package principal;

import utils.*;
import database.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 * Ceci est le Main de l'application.
 * 
 * @author Valentin DOULCIER
 * @version 0.0.1
 */
public class Main {
	
	private static Session s = null;

	/**
	 * Fonction Main.
	 * Cette classe lance un thread initialisant la fenêtre.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					Application window = new Application();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
		
		// Ouverture d'une session Hibernate
		s = HibernateUtils.getSession();

		// Lancement des tests successifs
		testCreate();

		// Affiche le contenu de la table ListeStatus
		print();

		// Fermeture de la session Hibernate
		s.close();
		
	}
	
	private static void testCreate(Object obj) {
		
		ListeStatuts ls = new ListeStatuts();
		ls.setIdStatut(7);
		ls.setStatut("Guezgfu");
		
		// Début de la transaction
		Transaction tx = s.beginTransaction();
		// Sauvegarde des objets
		s.save(obj);
		// Fermeture de la transaction
		tx.commit();
	}
	
	
	// Affiche le contenu de la table ListeStatus
	private static void print() {
		// Début de la transaction
		Transaction tx = s.beginTransaction();

		// Création de la requête
		//Query q = s.createQuery("from database.ListeStatus");
		//List result = s.createQuery( "from database.ListeStatuts" ).list(); //database/ListeStatuts.hbm.xml
		//List result = s.createQuery( "from database.ListeStatuts where statut= ?").setString(0, "dieux").list();
		//List result = s.createQuery( "from database.ListeStatuts where statut like ?").setString(0, "di%").list();
		List result = s.createQuery( "from database.ListeStatuts where statut like 'V%'").list();
		
		/*
		System.out.println(result.size());
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i) + "\n");
		*/
		
		ArrayList<ListeStatuts> list = (ArrayList<ListeStatuts>) result;
		// Affichage de la liste de résultats
		for (ListeStatuts e: list) {
			System.out.println("ListeStatuts : [" + e.getIdStatut() + "] = " + e.getStatut());
		}

		// Fin de la transaction
		tx.commit();
	}

}
