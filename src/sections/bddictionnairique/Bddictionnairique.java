/**
 * 
 */
package sections.bddictionnairique;

import java.io.Serializable;

import principal.Application;

import sections.bddictionnairique.ui.contents.ContentEdition;
import sections.bddictionnairique.ui.contents.ContentFooterEdition;
import sections.bddictionnairique.ui.contents.ContentFooterRecherche;
import sections.bddictionnairique.ui.contents.ContentHeaderEdition;
import sections.bddictionnairique.ui.contents.ContentHeaderRechercheSimple;
import sections.bddictionnairique.ui.contents.ContentRechercheSimple;

import sections.bddictionnairique.ui.volets.VoletEdition;
import sections.bddictionnairique.ui.volets.VoletFooterEdition;
import sections.bddictionnairique.ui.volets.VoletFooterRecherche;
import sections.bddictionnairique.ui.volets.VoletHeaderEdition;
import sections.bddictionnairique.ui.volets.VoletHeaderRechercheSimple;
import sections.bddictionnairique.ui.volets.VoletRechercheSimple;

/**
 * @author Valentin DOULCIER
 *
 */
public class Bddictionnairique implements Serializable {

	private static final long serialVersionUID = -7401966041439268919L;
	
	private static Bddictionnairique instance = null;

	// Recherche
	private static VoletFooterRecherche voletFooterRecherche = null;
	private static VoletFooterEdition voletFooterEdition = null;
			
	private static VoletHeaderRechercheSimple voletHeaderRechercheSimple = null;
	private static VoletRechercheSimple voletRechercheSimple = null;
			
	private static VoletHeaderEdition voletHeaderEdition = null;
	private static VoletEdition voletEdition = null;

	private static ContentFooterRecherche contentFooterRecherche = null;
	private static ContentFooterEdition contentFooterEdition = null;
			
	private static ContentHeaderRechercheSimple contentHeaderRechercheSimple = null;
	private static ContentRechercheSimple contentRechercheSimple = null;
			
	private static ContentHeaderEdition contentHeaderEdition = null;
	private static ContentEdition contentEdition = null;
	
	// Application
	private static Application application = null;

	private Bddictionnairique() {
		;
	}

	public static Bddictionnairique getInstance(Application application) {
		if (instance == null) { 	
			synchronized(Bddictionnairique.class) {
				Bddictionnairique.instance = new Bddictionnairique();
				
				Bddictionnairique.application = application;
				
				Bddictionnairique.voletFooterRecherche = new VoletFooterRecherche(application);
				Bddictionnairique.voletFooterEdition = new VoletFooterEdition(application);

				Bddictionnairique.voletHeaderRechercheSimple = new VoletHeaderRechercheSimple();
				Bddictionnairique.voletRechercheSimple = new VoletRechercheSimple(application);

				Bddictionnairique.voletHeaderEdition = new VoletHeaderEdition();
				Bddictionnairique.voletEdition = new VoletEdition(application);
				
				Bddictionnairique.contentFooterRecherche = new ContentFooterRecherche(application);
				Bddictionnairique.contentFooterEdition = new ContentFooterEdition(application);

				Bddictionnairique.contentHeaderRechercheSimple = new ContentHeaderRechercheSimple(application);
				Bddictionnairique.contentRechercheSimple = new ContentRechercheSimple(application);

				Bddictionnairique.contentHeaderEdition = new ContentHeaderEdition(application);
				Bddictionnairique.contentEdition = new ContentEdition(application);
			}
		}
		return instance;
	}


	public void chargerBddictionnairique() {
		// Volets
		Bddictionnairique.application.getvHeader().add(voletHeaderEdition, "voletHeaderEdition");
		Bddictionnairique.application.getvPanel().add(voletEdition, "voletEdition");
		Bddictionnairique.application.getvFooter().add(voletFooterEdition, "voletFooterEdition");
		
		Bddictionnairique.application.getvFooter().add(voletFooterRecherche, "voletFooterRecherche");
		
		Bddictionnairique.application.getvHeader().add(voletHeaderRechercheSimple, "voletHeaderRechercheSimple");
		Bddictionnairique.application.getvPanel().add(voletRechercheSimple, "voletRechercheSimple");

		
		Bddictionnairique.application.getVoletHeader().show(application.getvHeader(), "voletHeaderRechercheSimple");
		Bddictionnairique.application.getVoletPanel().show(application.getvPanel(), "voletRechercheSimple");
		Bddictionnairique.application.getVoletFooter().show(application.getvFooter(), "voletFooterRecherche");

		// Content
		Bddictionnairique.application.getcHeader().add(contentHeaderEdition, "contentHeaderEdition");
		Bddictionnairique.application.getcPanel().add(contentEdition, "contentEdition");
		Bddictionnairique.application.getcFooter().add(contentFooterEdition, "contentFooterEdition");
		
		Bddictionnairique.application.getcFooter().add(contentFooterRecherche, "contentFooterRecherche");

		Bddictionnairique.application.getcHeader().add(contentHeaderRechercheSimple, "contentHeaderRechercheSimple");
		Bddictionnairique.application.getcPanel().add(contentRechercheSimple, "contentRechercheSimple");


		Bddictionnairique.application.getContentHeader().show(application.getcHeader(), "contentHeaderRechercheSimple");
		Bddictionnairique.application.getContentPanel().show(application.getcPanel(), "contentRechercheSimple");
		Bddictionnairique.application.getContentFooter().show(application.getcFooter(), "contentFooterRecherche");

		//
		Bddictionnairique.application.OuvrirVolet();
	}

	public void dechargerBddictionnairique() {
		Bddictionnairique.application.getContentHeader().show(application.getcHeader(), "ContentHeaderHome");
		Bddictionnairique.application.getContentPanel().show(application.getcPanel(), "ContentHome");
		Bddictionnairique.application.getContentFooter().show(application.getcFooter(), "ContentFooterHome");

		Bddictionnairique.application.FermerVolet();
		
		Bddictionnairique.application.getcHeader().remove(getContentHeaderEdition());
		Bddictionnairique.application.getcPanel().remove(getContentEdition());
		Bddictionnairique.application.getcFooter().remove(getContentFooterEdition());

		Bddictionnairique.application.getvHeader().remove(getVoletHeaderEdition());
		Bddictionnairique.application.getvPanel().remove(getVoletEdition());
		Bddictionnairique.application.getvFooter().remove(getVoletFooterEdition());

		Bddictionnairique.application.getcFooter().remove(getContentFooterRecherche());
		Bddictionnairique.application.getvFooter().remove(getVoletFooterRecherche());
		
		if(getVoletFooterRecherche().getJeViensDe() == -1) {
			Bddictionnairique.application.getvHeader().remove(getVoletHeaderRechercheSimple());
			Bddictionnairique.application.getvPanel().remove(getVoletRechercheSimple());

			Bddictionnairique.application.getcHeader().remove(getContentHeaderRechercheSimple());
			Bddictionnairique.application.getcPanel().remove(getContentRechercheSimple());
		}
		else if(getVoletFooterRecherche().getJeViensDe() == 1) {
			Bddictionnairique.application.getvHeader().remove(getVoletFooterRecherche().getVoletHeaderRechercheSimple());
			Bddictionnairique.application.getvPanel().remove(getVoletFooterRecherche().getVoletRechercheSimple());

			Bddictionnairique.application.getcHeader().remove(getVoletFooterRecherche().getContentHeaderRechercheSimple());
			Bddictionnairique.application.getcPanel().remove(getVoletFooterRecherche().getContentRechercheSimple());
		}
		else if(getVoletFooterRecherche().getJeViensDe() == 2) {
			Bddictionnairique.application.getvHeader().remove(getVoletFooterRecherche().getVoletHeaderRechercheAvancee());
			Bddictionnairique.application.getvPanel().remove(getVoletFooterRecherche().getVoletRechercheAvancee());
			
			Bddictionnairique.application.getcHeader().remove(getVoletFooterRecherche().getContentHeaderRechercheAvancee());
			Bddictionnairique.application.getcPanel().remove(getVoletFooterRecherche().getContentRechercheAvancee());
		}
		else if(getVoletFooterRecherche().getJeViensDe() == 3) {
			Bddictionnairique.application.getvHeader().remove(getVoletFooterRecherche().getVoletHeaderHistorique());
			Bddictionnairique.application.getvPanel().remove(getVoletFooterRecherche().getVoletHistorique());
			
			Bddictionnairique.application.getcHeader().remove(getVoletFooterRecherche().getContentHeaderHistorique());
			Bddictionnairique.application.getcPanel().remove(getVoletFooterRecherche().getContentHistorique());
		}
	}

	/**
	 * @return the voletFooterRecherche
	 */
	public static VoletFooterRecherche getVoletFooterRecherche() {
		return voletFooterRecherche;
	}

	/**
	 * @param voletFooterRecherche the voletFooterRecherche to set
	 */
	public static void setVoletFooterRecherche(
			VoletFooterRecherche voletFooterRecherche) {
		Bddictionnairique.voletFooterRecherche = voletFooterRecherche;
	}

	/**
	 * @return the voletFooterEdition
	 */
	public static VoletFooterEdition getVoletFooterEdition() {
		return voletFooterEdition;
	}

	/**
	 * @param voletFooterEdition the voletFooterEdition to set
	 */
	public static void setVoletFooterEdition(VoletFooterEdition voletFooterEdition) {
		Bddictionnairique.voletFooterEdition = voletFooterEdition;
	}

	/**
	 * @return the voletHeaderRechercheSimple
	 */
	public static VoletHeaderRechercheSimple getVoletHeaderRechercheSimple() {
		return voletHeaderRechercheSimple;
	}

	/**
	 * @param voletHeaderRechercheSimple the voletHeaderRechercheSimple to set
	 */
	public static void setVoletHeaderRechercheSimple(
			VoletHeaderRechercheSimple voletHeaderRechercheSimple) {
		Bddictionnairique.voletHeaderRechercheSimple = voletHeaderRechercheSimple;
	}

	/**
	 * @return the voletRechercheSimple
	 */
	public VoletRechercheSimple getVoletRechercheSimple() {
		return voletRechercheSimple;
	}

	/**
	 * @param voletRechercheSimple the voletRechercheSimple to set
	 */
	public static void setVoletRechercheSimple(
			VoletRechercheSimple voletRechercheSimple) {
		Bddictionnairique.voletRechercheSimple = voletRechercheSimple;
	}

	/**
	 * @return the voletHeaderEdition
	 */
	public static VoletHeaderEdition getVoletHeaderEdition() {
		return voletHeaderEdition;
	}

	/**
	 * @param voletHeaderEdition the voletHeaderEdition to set
	 */
	public static void setVoletHeaderEdition(VoletHeaderEdition voletHeaderEdition) {
		Bddictionnairique.voletHeaderEdition = voletHeaderEdition;
	}

	/**
	 * @return the voletEdition
	 */
	public static VoletEdition getVoletEdition() {
		return voletEdition;
	}

	/**
	 * @param voletEdition the voletEdition to set
	 */
	public static void setVoletEdition(VoletEdition voletEdition) {
		Bddictionnairique.voletEdition = voletEdition;
	}

	/**
	 * @return the contentFooterRecherche
	 */
	public static ContentFooterRecherche getContentFooterRecherche() {
		return contentFooterRecherche;
	}

	/**
	 * @param contentFooterRecherche the contentFooterRecherche to set
	 */
	public static void setContentFooterRecherche(
			ContentFooterRecherche contentFooterRecherche) {
		Bddictionnairique.contentFooterRecherche = contentFooterRecherche;
	}

	/**
	 * @return the contentFooterEdition
	 */
	public static ContentFooterEdition getContentFooterEdition() {
		return contentFooterEdition;
	}

	/**
	 * @param contentFooterEdition the contentFooterEdition to set
	 */
	public static void setContentFooterEdition(
			ContentFooterEdition contentFooterEdition) {
		Bddictionnairique.contentFooterEdition = contentFooterEdition;
	}

	/**
	 * @return the contentHeaderRechercheSimple
	 */
	public static ContentHeaderRechercheSimple getContentHeaderRechercheSimple() {
		return contentHeaderRechercheSimple;
	}

	/**
	 * @param contentHeaderRechercheSimple the contentHeaderRechercheSimple to set
	 */
	public static void setContentHeaderRechercheSimple(
			ContentHeaderRechercheSimple contentHeaderRechercheSimple) {
		Bddictionnairique.contentHeaderRechercheSimple = contentHeaderRechercheSimple;
	}

	/**
	 * @return the contentRechercheSimple
	 */
	public static ContentRechercheSimple getContentRechercheSimple() {
		return contentRechercheSimple;
	}

	/**
	 * @param contentRechercheSimple the contentRechercheSimple to set
	 */
	public static void setContentRechercheSimple(
			ContentRechercheSimple contentRechercheSimple) {
		Bddictionnairique.contentRechercheSimple = contentRechercheSimple;
	}

	/**
	 * @return the contentHeaderEdition
	 */
	public static ContentHeaderEdition getContentHeaderEdition() {
		return contentHeaderEdition;
	}

	/**
	 * @param contentHeaderEdition the contentHeaderEdition to set
	 */
	public static void setContentHeaderEdition(
			ContentHeaderEdition contentHeaderEdition) {
		Bddictionnairique.contentHeaderEdition = contentHeaderEdition;
	}

	/**
	 * @return the contentEdition
	 */
	public static ContentEdition getContentEdition() {
		return contentEdition;
	}

	/**
	 * @param contentEdition the contentEdition to set
	 */
	public static void setContentEdition(ContentEdition contentEdition) {
		Bddictionnairique.contentEdition = contentEdition;
	}

}
