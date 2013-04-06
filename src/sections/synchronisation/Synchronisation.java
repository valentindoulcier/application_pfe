package sections.synchronisation;

import principal.Application;

import sections.synchronisation.ui.contents.ContentFooterSynchronisation;
import sections.synchronisation.ui.contents.ContentHeaderSynchronisation;
import sections.synchronisation.ui.contents.ContentSynchronisation;

import sections.synchronisation.ui.volets.VoletFooterSynchronisation;
import sections.synchronisation.ui.volets.VoletHeaderSynchronisation;
import sections.synchronisation.ui.volets.VoletSynchronisation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;

import dao.SynchronisationDAO;


/**
 * @author Valentin DOULCIER
 *
 */
public class Synchronisation implements Serializable {

	private static final long serialVersionUID = 7666561320641678776L;

	private static Synchronisation instance = null;

	// Synchronisation
	private static VoletHeaderSynchronisation voletHeaderSynchronisation = null;
	private static VoletSynchronisation voletSynchronisation = null;
	private static VoletFooterSynchronisation voletFooterSynchronisation = null;

	private static ContentHeaderSynchronisation contentHeaderSynchronisation = null;
	private static ContentSynchronisation contentSynchronisation = null;
	private static ContentFooterSynchronisation contentFooterSynchronisation = null;

	// Application
	private static Application application = null;

	private Synchronisation() {
		;
	}

	public static Synchronisation getInstance(Application application) {
		if (instance == null) {
			synchronized(Synchronisation.class) {
				Synchronisation.instance = new Synchronisation();

				Synchronisation.application = application;

				Synchronisation.voletHeaderSynchronisation = new VoletHeaderSynchronisation();
				Synchronisation.voletSynchronisation = new VoletSynchronisation();
				Synchronisation.voletFooterSynchronisation = new VoletFooterSynchronisation();

				Synchronisation.contentHeaderSynchronisation = new ContentHeaderSynchronisation(application);
				Synchronisation.contentSynchronisation = new ContentSynchronisation(application);
				Synchronisation.contentFooterSynchronisation = new ContentFooterSynchronisation();
			}
		}
		return instance;
	}


	public void chargerSynchronisation() {
		// Volets
		Synchronisation.application.getvHeader().add(voletHeaderSynchronisation, "voletHeaderSynchronisation");
		Synchronisation.application.getvPanel().add(voletSynchronisation, "voletSynchronisation");
		Synchronisation.application.getvFooter().add(voletFooterSynchronisation, "voletFooterSynchronisation");

		Synchronisation.application.getVoletHeader().show(application.getvHeader(), "voletHeaderSynchronisation");
		Synchronisation.application.getVoletPanel().show(application.getvPanel(), "voletSynchronisation");
		Synchronisation.application.getVoletFooter().show(application.getvFooter(), "voletFooterSynchronisation");

		// Content
		Synchronisation.application.getcHeader().add(contentHeaderSynchronisation, "contentHeaderSynchronisation");
		Synchronisation.application.getcPanel().add(contentSynchronisation, "contentSynchronisation");
		Synchronisation.application.getcFooter().add(contentFooterSynchronisation, "contentFooterSynchronisation");

		Synchronisation.application.getContentHeader().show(application.getcHeader(), "contentHeaderSynchronisation");
		Synchronisation.application.getContentPanel().show(application.getcPanel(), "contentSynchronisation");
		Synchronisation.application.getContentFooter().show(application.getcFooter(), "contentFooterSynchronisation");

		//
		Synchronisation.application.OuvrirVolet();
	}

	public void dechargerSynchronisation() {
		Synchronisation.application.getContentHeader().show(application.getcHeader(), "ContentHeaderHome");
		Synchronisation.application.getContentPanel().show(application.getcPanel(), "ContentHome");
		Synchronisation.application.getContentFooter().show(application.getcFooter(), "ContentFooterHome");

		Synchronisation.application.FermerVolet();

		Synchronisation.application.getcHeader().remove(getContentHeaderSynchronisation());
		Synchronisation.application.getcPanel().remove(getContentSynchronisation());
		Synchronisation.application.getcFooter().remove(getContentFooterSynchronisation());

		Synchronisation.application.getvHeader().remove(getVoletHeaderSynchronisation());
		Synchronisation.application.getvPanel().remove(getVoletSynchronisation());
		Synchronisation.application.getvFooter().remove(getVoletFooterSynchronisation());
	}



	public void resetDatabase() {  
		String ligne;
		StringBuffer sb = new StringBuffer();
		SynchronisationDAO synchroDAO = new SynchronisationDAO("local");

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/sections/synchronisation/scripts/structure.sql")));

			while((ligne = br.readLine()) != null) {
				sb.append(ligne);
			}
			br.close();
			
			String[] requete = sb.toString().split(";");

			for(int i = 0; i<requete.length; i++) {
				if(!requete[i].trim().equals("")) {
					System.out.println("Je demande l'exécution");
					synchroDAO.executerRequete(requete[i]);
					System.out.println("Au suivant !!");
				}
			}
		}
		catch(Exception e) {
			System.out.println("LOLILOULOL");
		}

	}  







	/**
	 * @return the voletHeaderSynchronisation
	 */
	public static VoletHeaderSynchronisation getVoletHeaderSynchronisation() {
		return voletHeaderSynchronisation;
	}

	/**
	 * @param voletHeaderSynchronisation the voletHeaderSynchronisation to set
	 */
	public static void setVoletHeaderSynchronisation(VoletHeaderSynchronisation voletHeaderSynchronisation) {
		Synchronisation.voletHeaderSynchronisation = voletHeaderSynchronisation;
	}

	/**
	 * @return the voletSynchronisation
	 */
	public static VoletSynchronisation getVoletSynchronisation() {
		return voletSynchronisation;
	}

	/**
	 * @param voletSynchronisation the voletSynchronisation to set
	 */
	public static void setVoletSynchronisation(VoletSynchronisation voletSynchronisation) {
		Synchronisation.voletSynchronisation = voletSynchronisation;
	}

	/**
	 * @return the voletFooterSynchronisation
	 */
	public static VoletFooterSynchronisation getVoletFooterSynchronisation() {
		return voletFooterSynchronisation;
	}

	/**
	 * @param voletFooterSynchronisation the voletFooterSynchronisation to set
	 */
	public static void setVoletFooterSynchronisation(VoletFooterSynchronisation voletFooterSynchronisation) {
		Synchronisation.voletFooterSynchronisation = voletFooterSynchronisation;
	}

	/**
	 * @return the contentHeaderSynchronisation
	 */
	public static ContentHeaderSynchronisation getContentHeaderSynchronisation() {
		return contentHeaderSynchronisation;
	}

	/**
	 * @param contentHeaderSynchronisation the contentHeaderSynchronisation to set
	 */
	public static void setContentHeaderSynchronisation(
			ContentHeaderSynchronisation contentHeaderSynchronisation) {
		Synchronisation.contentHeaderSynchronisation = contentHeaderSynchronisation;
	}

	/**
	 * @return the contentSynchronisation
	 */
	public static ContentSynchronisation getContentSynchronisation() {
		return contentSynchronisation;
	}

	/**
	 * @param contentSynchronisation the contentSynchronisation to set
	 */
	public static void setContentSynchronisation(ContentSynchronisation contentSynchronisation) {
		Synchronisation.contentSynchronisation = contentSynchronisation;
	}

	/**
	 * @return the contentFooterSynchronisation
	 */
	public static ContentFooterSynchronisation getContentFooterSynchronisation() {
		return contentFooterSynchronisation;
	}

	/**
	 * @param contentFooterSynchronisation the contentFooterSynchronisation to set
	 */
	public static void setContentFooterSynchronisation(ContentFooterSynchronisation contentFooterSynchronisation) {
		Synchronisation.contentFooterSynchronisation = contentFooterSynchronisation;
	}
}
