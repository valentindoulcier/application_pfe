package principal;

import dao.*;
import utils.*;
import database.*;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;


/**
 * Ceci est le Main de l'application.
 * 
 * @author Valentin DOULCIER
 * @version 0.0.1
 */
@SuppressWarnings("unused")
public class Main {
	
	private static Logger logger = Logger.getLogger(Main.class);

	private static String jeTravailleSur = "bdd";

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
			logger.debug("msg de debogage");
			logger.info("msg d'information");
			logger.warn("msg d'avertissement");
			logger.error("msg d'erreur");
			logger.fatal("msg d'erreur fatale"); 
			
			
			useScreenMenuBar();
			
			EventQueue.invokeLater(new Runnable() {
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
			logger.debug("msg de debogage");
			logger.info("msg d'information");
			logger.warn("msg d'avertissement");
			logger.error("msg d'erreur");
			logger.fatal("msg d'erreur fatale"); 
			
			
			//Date date = new Date( System.currentTimeMillis() );
			//SimpleDateFormat maDate = new SimpleDateFormat( "hh:mm:ss" );

			//CREATE
			
			//ListeStatutsDAO test = new ListeStatutsDAO("local");
			//test.create(new ListeStatuts(maDate.format(date)));
			

			//UPDATE

			//PRINT
			
			//List list = test.findAll();

			//for(Object l : list) {
			//	System.out.println("*" + ((ListeStatuts) l).getIdStatut() + "* *" + ((ListeStatuts) l).getStatut() + "*");
			//}


			// Fermeture de la session Hibernate
			//s = HibernateUtils.getInstance();
			//s.close();
			//HibernateUtils.getInstanceLocale().close();
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
