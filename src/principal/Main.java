package principal;

import utils.*;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;


/**
 * Ceci est le Main de l'application.
 * 
 * @author Valentin DOULCIER
 * @version 0.0.1
 */
public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

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
			logger.debug("Test Debogage");
			logger.info("Test Information");
			logger.warn("Test Warning");
			logger.error("Test Erreur");
			logger.fatal("Test Fatal\n");
			
			logger.info("***************************************************");
			logger.info("**                  Application                  **");
			logger.info("***************************************************\n");

			useScreenMenuBar();

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						logger.debug("Création de l'application, instanciation OK");
						new Application();
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
			//ListeStatuts tempo = test.findTheStatut(3);
			//logger.info(tempo.getStatut() + "  " + tempo.getIdStatut());
			//test.create(new ListeStatuts(maDate.format(date)));

			//HeadwordDAO test = new HeadwordDAO("local");
			//List<?> tempo = test.findExactly("house", "mcq");

			//for(Object l : tempo) {
			//	logger.info("*" + ((Headword) l).getDictionnaires().getNomDictionnaire() + "* *" + ((Headword) l).getMot() + "*");
			//}


			//UPDATE

			//PRINT

			//List list = test.findAll();

			//for(Object l : list) {
			//	logger.info("*" + ((ListeStatuts) l).getIdStatut() + "* *" + ((ListeStatuts) l).getStatut() + "*");
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
			logger.fatal("ClassNotFoundException: " + e.getMessage());
		}
		catch(InstantiationException e) {
			logger.fatal("InstantiationException: " + e.getMessage());
		}
		catch(IllegalAccessException e) {
			logger.fatal("IllegalAccessException: " + e.getMessage());
		}
		catch(UnsupportedLookAndFeelException e) {
			logger.fatal("UnsupportedLookAndFeelException: " + e.getMessage());
		}
	}


}
