/**
 * 
 */
package sections.parseurXML;

import java.io.Serializable;

import administration.Administration;

import principal.Application;
import sections.parseurXML.ui.contents.ContentFooterParseur;
import sections.parseurXML.ui.contents.ContentHeaderHistorique;
import sections.parseurXML.ui.contents.ContentHeaderParseur;
import sections.parseurXML.ui.contents.ContentHistorique;
import sections.parseurXML.ui.contents.ContentParseur;
import sections.parseurXML.ui.volets.VoletFooterParseur;
import sections.parseurXML.ui.volets.VoletHeaderHistorique;
import sections.parseurXML.ui.volets.VoletHeaderParseur;
import sections.parseurXML.ui.volets.VoletHistorique;
import sections.parseurXML.ui.volets.VoletParseur;
/**
 * @author Valentin DOULCIER
 *
 */
public class ParseurXML implements Serializable {

	private static final long serialVersionUID = -7629923286021981895L;

	private static ParseurXML instance = null;

	// 1 - Parseur XML
	// 2 - Historique
	private int jeViensDe = 1;

	// Recherche

	// Volet
	private static VoletHeaderParseur voletHeaderParseur = null;
	private static VoletParseur voletParseur = null;
	private static VoletFooterParseur voletFooterParseur = null;

	private static VoletHeaderHistorique voletHeaderHistorique = null;
	private static VoletHistorique voletHistorique = null;

	// Content
	private static ContentHeaderParseur contentHeaderParseur = null;
	private static ContentParseur contentParseur = null;
	private static ContentFooterParseur contentFooterParseur = null;

	private static ContentHeaderHistorique contentHeaderHistorique = null;
	private static ContentHistorique contentHistorique = null;



	// Application
	private static Application application = null;

	private ParseurXML() {
		;
	}

	public static ParseurXML getInstance(Application application) {
		if (instance == null) { 	
			synchronized(ParseurXML.class) {
				ParseurXML.instance = new ParseurXML();

				ParseurXML.application = application;
			}
		}
		return instance;
	}


	public void chargerParseurXML() {
		application.dechargerApplication();
		
		ParseurXML.voletFooterParseur = new VoletFooterParseur(application);
		ParseurXML.application.getvFooter().add(voletFooterParseur, "voletFooterParseur");

		ParseurXML.contentFooterParseur = new ContentFooterParseur(application);
		ParseurXML.application.getcFooter().add(contentFooterParseur, "contentFooterParseur");

		ParseurXML.application.getVoletFooter().show(application.getvFooter(), "voletFooterParseur");
		ParseurXML.application.getContentFooter().show(application.getcFooter(), "contentFooterParseur");

		ouvrirOnglet(1);

		//
		ParseurXML.application.OuvrirVolet();
	}

	public void dechargerParseurXML() {
		Administration.getInstance(application).chargerApplicationAdministration();

		ParseurXML.application.FermerVolet();
		
		System.out.println("Application déchargée");		
	}

	public void fermerCurrentOnglet() {
		if(jeViensDe == 1) {
			ParseurXML.application.getvHeader().remove(voletHeaderParseur);
			ParseurXML.application.getvPanel().remove(voletParseur);

			ParseurXML.application.getcHeader().remove(contentHeaderParseur);
			ParseurXML.application.getcPanel().remove(contentParseur);

		}
		else if(jeViensDe == 2) {
			ParseurXML.application.getvHeader().remove(voletHeaderHistorique);
			ParseurXML.application.getvPanel().remove(voletHistorique);

			ParseurXML.application.getcHeader().remove(contentHeaderHistorique);
			ParseurXML.application.getcPanel().remove(contentHistorique);

		}
		ParseurXML.application.revalidate();
	}

	public void ouvrirOnglet(int jeVaisSur) {
		if(jeVaisSur == 1) {
			ParseurXML.voletHeaderParseur = new VoletHeaderParseur();
			ParseurXML.voletParseur = new VoletParseur();

			ParseurXML.application.getvHeader().add(voletHeaderParseur, "voletHeaderParseur");
			ParseurXML.application.getvPanel().add(voletParseur, "voletParseur");

			ParseurXML.contentHeaderParseur = new ContentHeaderParseur(application);
			ParseurXML.contentParseur = new ContentParseur();

			ParseurXML.application.getcHeader().add(contentHeaderParseur, "contentHeaderParseur");
			ParseurXML.application.getcPanel().add(contentParseur, "contentParseur");

			ParseurXML.application.getVoletHeader().show(application.getvHeader(), "voletHeaderParseur");
			ParseurXML.application.getVoletPanel().show(application.getvPanel(), "voletParseur");

			ParseurXML.application.getContentHeader().show(application.getcHeader(), "contentHeaderParseur");
			ParseurXML.application.getContentPanel().show(application.getcPanel(), "contentParseur");

			jeViensDe = 1;

		}
		else if(jeVaisSur == 2) {
			ParseurXML.voletHeaderHistorique = new VoletHeaderHistorique();
			ParseurXML.voletHistorique = new VoletHistorique(application);

			ParseurXML.application.getvHeader().add(voletHeaderHistorique, "voletHeaderHistorique");
			ParseurXML.application.getvPanel().add(voletHistorique, "voletHistorique");

			ParseurXML.contentHeaderHistorique = new ContentHeaderHistorique(application);
			ParseurXML.contentHistorique = new ContentHistorique(application);

			ParseurXML.application.getcHeader().add(contentHeaderHistorique, "contentHeaderHistorique");
			ParseurXML.application.getcPanel().add(contentHistorique, "contentHistorique");

			ParseurXML.application.getVoletHeader().show(application.getvHeader(), "voletHeaderHistorique");
			ParseurXML.application.getVoletPanel().show(application.getvPanel(), "voletHistorique");

			ParseurXML.application.getContentHeader().show(application.getcHeader(), "contentHeaderHistorique");
			ParseurXML.application.getContentPanel().show(application.getcPanel(), "contentHistorique");

			jeViensDe = 2;

		}
		ParseurXML.application.revalidate();
	}

	/**
	 * @return the jeViensDe
	 */
	public int getJeViensDe() {
		return jeViensDe;
	}

	/**
	 * @param jeViensDe the jeViensDe to set
	 */
	public void setJeViensDe(int jeViensDe) {
		this.jeViensDe = jeViensDe;
	}

	/**
	 * @return the voletHeaderParseur
	 */
	public VoletHeaderParseur getVoletHeaderParseur() {
		return voletHeaderParseur;
	}

	/**
	 * @param voletHeaderParseur the voletHeaderParseur to set
	 */
	public static void setVoletHeaderParseur(VoletHeaderParseur voletHeaderParseur) {
		ParseurXML.voletHeaderParseur = voletHeaderParseur;
	}

	/**
	 * @return the voletParseur
	 */
	public VoletParseur getVoletParseur() {
		return voletParseur;
	}

	/**
	 * @param voletParseur the voletParseur to set
	 */
	public static void setVoletParseur(VoletParseur voletParseur) {
		ParseurXML.voletParseur = voletParseur;
	}

	/**
	 * @return the voletFooterParseur
	 */
	public VoletFooterParseur getVoletFooterParseur() {
		return voletFooterParseur;
	}

	/**
	 * @param voletFooterParseur the voletFooterParseur to set
	 */
	public static void setVoletFooterParseur(VoletFooterParseur voletFooterParseur) {
		ParseurXML.voletFooterParseur = voletFooterParseur;
	}

	/**
	 * @return the voletHeaderHistorique
	 */
	public VoletHeaderHistorique getVoletHeaderHistorique() {
		return voletHeaderHistorique;
	}

	/**
	 * @param voletHeaderHistorique the voletHeaderHistorique to set
	 */
	public static void setVoletHeaderHistorique(
			VoletHeaderHistorique voletHeaderHistorique) {
		ParseurXML.voletHeaderHistorique = voletHeaderHistorique;
	}

	/**
	 * @return the voletHistorique
	 */
	public VoletHistorique getVoletHistorique() {
		return voletHistorique;
	}

	/**
	 * @param voletHistorique the voletHistorique to set
	 */
	public static void setVoletHistorique(VoletHistorique voletHistorique) {
		ParseurXML.voletHistorique = voletHistorique;
	}

	/**
	 * @return the contentHeaderParseur
	 */
	public ContentHeaderParseur getContentHeaderParseur() {
		return contentHeaderParseur;
	}

	/**
	 * @param contentHeaderParseur the contentHeaderParseur to set
	 */
	public static void setContentHeaderParseur(
			ContentHeaderParseur contentHeaderParseur) {
		ParseurXML.contentHeaderParseur = contentHeaderParseur;
	}

	/**
	 * @return the contentParseur
	 */
	public ContentParseur getContentParseur() {
		return contentParseur;
	}

	/**
	 * @param contentParseur the contentParseur to set
	 */
	public static void setContentParseur(ContentParseur contentParseur) {
		ParseurXML.contentParseur = contentParseur;
	}

	/**
	 * @return the contentFooterParseur
	 */
	public ContentFooterParseur getContentFooterParseur() {
		return contentFooterParseur;
	}

	/**
	 * @param contentFooterParseur the contentFooterParseur to set
	 */
	public static void setContentFooterParseur(
			ContentFooterParseur contentFooterParseur) {
		ParseurXML.contentFooterParseur = contentFooterParseur;
	}

	/**
	 * @return the contentHeaderHistorique
	 */
	public ContentHeaderHistorique getContentHeaderHistorique() {
		return contentHeaderHistorique;
	}

	/**
	 * @param contentHeaderHistorique the contentHeaderHistorique to set
	 */
	public static void setContentHeaderHistorique(
			ContentHeaderHistorique contentHeaderHistorique) {
		ParseurXML.contentHeaderHistorique = contentHeaderHistorique;
	}

	/**
	 * @return the contentHistorique
	 */
	public ContentHistorique getContentHistorique() {
		return contentHistorique;
	}

	/**
	 * @param contentHistorique the contentHistorique to set
	 */
	public static void setContentHistorique(ContentHistorique contentHistorique) {
		ParseurXML.contentHistorique = contentHistorique;
	}
}
