package principal;

import utils.*;
import database.*;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Ceci est le Main de l'application.
 * 
 * @author Valentin DOULCIER
 * @version 0.0.1
 */
public class Main {

	private static String jeTravailleSur = "appli";

	/**
	 * Fonction Main.
	 * Cette classe lance un thread initialisant la fenêtre.
	 * 
	 * @param args
	 * @throws DatabaseOffException 
	 */
	public static void main(String[] args) throws DatabaseOffException {


		if("appli".equalsIgnoreCase(jeTravailleSur))
		{
			useScreenMenuBar();
			
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
		}
		else if ("bdd".equalsIgnoreCase(jeTravailleSur))
		{
			Date date = new Date( System.currentTimeMillis() );
			SimpleDateFormat maDate = new SimpleDateFormat( "hh:mm:ss" );

			ArrayList<String> columnName = new ArrayList<String>();
			ArrayList<String> comparisonMode = new ArrayList<String>();
			ArrayList<String> value = new ArrayList<String>();
			ArrayList<String> typeValue = new ArrayList<String>();

			columnName.add("statut");
			comparisonMode.add("like");
			value.add("%an%");
			typeValue.add("string");

			//CREATE
			new Queries<ListeStatuts>().create(new ListeStatuts(maDate.format(date)));//ArrayList<ListeStatuts> list = new Queries<ListeStatuts>().print("ListeStatuts", columnName, comparisonMode, value, typeValue);

			//UPDATE
			// new Queries<ListeStatuts>().update(new ListeStatuts(27, "Franck"));

			//PRINT
			ArrayList<ListeStatuts> list = new Queries<ListeStatuts>().print("ListeStatuts", null, null, null, null);

			for(ListeStatuts l : list) {
				System.out.println("*" + l.getIdStatut() + "* *" + l.getStatut() + "*");
			}


			// Fermeture de la session Hibernate
			//s = HibernateUtils.getInstance();
			//s.close();
			HibernateUtils.getInstanceLocale().close();
		}
	}

	public static void useScreenMenuBar() {
		try {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Application L.L.L.");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		}
		catch(InstantiationException e) {
			System.out.println("InstantiationException: " + e.getMessage());
		}
		catch(IllegalAccessException e) {
			System.out.println("IllegalAccessException: " + e.getMessage());
		}
		catch(UnsupportedLookAndFeelException e) {
			System.out.println("UnsupportedLookAndFeelException: " + e.getMessage());
		}
	}


}
