package principal;

import utils.*;
import database.*;

import java.util.ArrayList;


/**
 * Ceci est le Main de l'application.
 * 
 * @author Valentin DOULCIER
 * @version 0.0.1
 */
public class Main {

	/**
	 * Fonction Main.
	 * Cette classe lance un thread initialisant la fenêtre.
	 * 
	 * @param args
	 * @throws DatabaseOffException 
	 */
	public static void main(String[] args) throws DatabaseOffException {

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

		// Lancement des tests successifs

		ArrayList<String> columnName = new ArrayList<String>();
		ArrayList<String> comparisonMode = new ArrayList<String>();
		ArrayList<String> value = new ArrayList<String>();
		ArrayList<String> typeValue = new ArrayList<String>();

		columnName.add("statut");
		comparisonMode.add("like");
		value.add("%an%");
		typeValue.add("string");

		//CREATE
		new Queries<ListeStatuts>().create(HibernateUtils.getInstanceLocale(), new ListeStatuts("Dieux"));//ArrayList<ListeStatuts> list = new Queries<ListeStatuts>().print("ListeStatuts", columnName, comparisonMode, value, typeValue);
		
		//UPDATE
		// new Queries<ListeStatuts>().update(new ListeStatuts(27, "Franck"));
		
		//PRINT
		ArrayList<ListeStatuts> list = new Queries<ListeStatuts>().print(HibernateUtils.getInstanceLocale(), "ListeStatuts", null, null, null, null);

		for(ListeStatuts l : list) {
			System.out.println("-" + l.getStatut() + "-");
		}
		
		
		// Fermeture de la session Hibernate
		//s = HibernateUtils.getInstance();
		//s.close();
		HibernateUtils.getInstanceLocale().close();
	}

}
