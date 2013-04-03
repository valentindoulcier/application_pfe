/**
 * 
 */
package sections.bddictionnairique;

import java.io.Serializable;

import org.apache.log4j.Logger;

import principal.Application;

import sections.bddictionnairique.ui.contents.ContentEdition;
import sections.bddictionnairique.ui.contents.ContentFooterEdition;
import sections.bddictionnairique.ui.contents.ContentFooterRecherche;
import sections.bddictionnairique.ui.contents.ContentHeaderEdition;
import sections.bddictionnairique.ui.contents.ContentHeaderHistorique;
import sections.bddictionnairique.ui.contents.ContentHeaderRechercheAvancee;
import sections.bddictionnairique.ui.contents.ContentHeaderRechercheSimple;
import sections.bddictionnairique.ui.contents.ContentHistorique;
import sections.bddictionnairique.ui.contents.ContentRechercheAvancee;
import sections.bddictionnairique.ui.contents.ContentRechercheSimple;

import sections.bddictionnairique.ui.volets.VoletEdition;
import sections.bddictionnairique.ui.volets.VoletFooterRecherche;
import sections.bddictionnairique.ui.volets.VoletHeaderEdition;
import sections.bddictionnairique.ui.volets.VoletHeaderHistorique;
import sections.bddictionnairique.ui.volets.VoletHeaderRechercheAvancee;
import sections.bddictionnairique.ui.volets.VoletHeaderRechercheSimple;
import sections.bddictionnairique.ui.volets.VoletHistorique;
import sections.bddictionnairique.ui.volets.VoletRechercheAvancee;
import sections.bddictionnairique.ui.volets.VoletRechercheSimple;

/**
 * @author Valentin DOULCIER
 *
 */
public class Bddictionnairique implements Serializable {

	private static final long serialVersionUID = -7401966041439268919L;
	
	private static Logger logger = Logger.getLogger(Bddictionnairique.class);

	private static Bddictionnairique instance = null;

	// 1 - Recherche Simple
	// 2 - Recherche Avancée
	// 3 - Historique
	private int jeViensDe = 1;

	// Recherche

	// Volet
	private static VoletHeaderEdition voletHeaderEdition = null;
	private static VoletEdition voletEdition = null;

	private static VoletFooterRecherche voletFooterRecherche = null;

	private static VoletHeaderRechercheSimple voletHeaderRechercheSimple = null;
	private static VoletRechercheSimple voletRechercheSimple = null;

	private static VoletHeaderRechercheAvancee voletHeaderRechercheAvancee = null;
	private static VoletRechercheAvancee voletRechercheAvancee = null;

	private static VoletHeaderHistorique voletHeaderHistorique = null;
	private static VoletHistorique voletHistorique = null;

	// Content
	private static ContentHeaderEdition contentHeaderEdition = null;
	private static ContentEdition contentEdition = null;
	private static ContentFooterEdition contentFooterEdition = null;

	private static ContentFooterRecherche contentFooterRecherche = null;

	private static ContentHeaderRechercheSimple contentHeaderRechercheSimple = null;
	private static ContentRechercheSimple contentRechercheSimple = null;

	private static ContentHeaderRechercheAvancee contentHeaderRechercheAvancee = null;
	private static ContentRechercheAvancee contentRechercheAvancee = null;

	private static ContentHeaderHistorique contentHeaderHistorique = null;
	private static ContentHistorique contentHistorique = null;


	// Application
	private static Application application = null;

	private Bddictionnairique() {
		;
	}

	public static Bddictionnairique getInstance(Application application) {
		if (instance == null) {
			logger.warn("***************************************************");
			logger.warn("**              Bddictionnairique                **");
			logger.warn("***************************************************\n");
			
			synchronized(Bddictionnairique.class) {
				Bddictionnairique.instance = new Bddictionnairique();

				Bddictionnairique.application = application;
			}
			logger.warn("Création de l'instance unique - OK\n");
		}
		return instance;
	}


	public void chargerBddictionnairique() {
		Bddictionnairique.voletFooterRecherche = new VoletFooterRecherche(application);
		Bddictionnairique.application.getvFooter().add(voletFooterRecherche, "voletFooterRecherche");

		Bddictionnairique.contentFooterRecherche = new ContentFooterRecherche();
		Bddictionnairique.application.getcFooter().add(contentFooterRecherche, "contentFooterRecherche");

		
		Bddictionnairique.application.getVoletFooter().show(application.getvFooter(), "voletFooterRecherche");
		Bddictionnairique.application.getContentFooter().show(application.getcFooter(), "contentFooterRecherche");

		ouvrirOnglet(1);
		
		//
		Bddictionnairique.application.OuvrirVolet();

		logger.warn("Application chargée");
	}

	public void dechargerBddictionnairique() {
		Bddictionnairique.application.getContentHeader().show(application.getcHeader(), "ContentHeaderHome");
		Bddictionnairique.application.getContentPanel().show(application.getcPanel(), "ContentHome");
		Bddictionnairique.application.getContentFooter().show(application.getcFooter(), "ContentFooterHome");

		Bddictionnairique.application.FermerVolet();

		Bddictionnairique.application.getcFooter().remove(contentFooterRecherche);
		Bddictionnairique.application.getvFooter().remove(voletFooterRecherche);

		fermerCurrentOnglet();

		logger.warn("Application déchargée");
	}

	public void fermerCurrentOnglet() {
		if(jeViensDe == 1) {
			Bddictionnairique.application.getvHeader().remove(voletHeaderRechercheSimple);
			Bddictionnairique.application.getvPanel().remove(voletRechercheSimple);

			Bddictionnairique.application.getcHeader().remove(contentHeaderRechercheSimple);
			Bddictionnairique.application.getcPanel().remove(contentRechercheSimple);

			logger.warn("Onglet Recherche Simple FERME");

		}
		else if(jeViensDe == 2) {
			Bddictionnairique.application.getvHeader().remove(voletHeaderRechercheAvancee);
			Bddictionnairique.application.getvPanel().remove(voletRechercheAvancee);

			Bddictionnairique.application.getcHeader().remove(contentHeaderRechercheAvancee);
			Bddictionnairique.application.getcPanel().remove(contentRechercheAvancee);

			logger.warn("Onglet Recherche Avancee FERME");
			
		}
		else if(jeViensDe == 3) {
			Bddictionnairique.application.getvHeader().remove(voletHeaderHistorique);
			Bddictionnairique.application.getvPanel().remove(voletHistorique);

			Bddictionnairique.application.getcHeader().remove(contentHeaderHistorique);
			Bddictionnairique.application.getcPanel().remove(contentHistorique);
			
			logger.warn("Onglet Historique FERME");

		}
		else if(jeViensDe == 4) {
			Bddictionnairique.application.getvHeader().remove(voletHeaderEdition);
			Bddictionnairique.application.getvPanel().remove(voletEdition);

			Bddictionnairique.application.getcHeader().remove(contentHeaderEdition);
			Bddictionnairique.application.getcPanel().remove(contentEdition);
			Bddictionnairique.application.getcFooter().remove(contentFooterEdition);
			
			logger.warn("Onglet Edition FERME");
		}
	}

	public void ouvrirOnglet(int jeVaisSur) {
		if(jeVaisSur == 1) {
			Bddictionnairique.voletHeaderRechercheSimple = new VoletHeaderRechercheSimple();
			Bddictionnairique.voletRechercheSimple = new VoletRechercheSimple(application);

			Bddictionnairique.application.getvHeader().add(voletHeaderRechercheSimple, "voletHeaderRechercheSimple");
			Bddictionnairique.application.getvPanel().add(voletRechercheSimple, "voletRechercheSimple");

			Bddictionnairique.contentHeaderRechercheSimple = new ContentHeaderRechercheSimple(application);
			Bddictionnairique.contentRechercheSimple = new ContentRechercheSimple(application);

			Bddictionnairique.application.getcHeader().add(contentHeaderRechercheSimple, "contentHeaderRechercheSimple");
			Bddictionnairique.application.getcPanel().add(contentRechercheSimple, "contentRechercheSimple");
			
			Bddictionnairique.application.getVoletHeader().show(application.getvHeader(), "voletHeaderRechercheSimple");
			Bddictionnairique.application.getVoletPanel().show(application.getvPanel(), "voletRechercheSimple");
			
			Bddictionnairique.application.getContentHeader().show(application.getcHeader(), "contentHeaderRechercheSimple");
			Bddictionnairique.application.getContentPanel().show(application.getcPanel(), "contentRechercheSimple");
			
			jeViensDe = 1;
			
			logger.warn("Onglet Recherche Simple OUVERT");

		}
		else if(jeVaisSur == 2) {
			Bddictionnairique.voletHeaderRechercheAvancee = new VoletHeaderRechercheAvancee();
			Bddictionnairique.voletRechercheAvancee = new VoletRechercheAvancee(application);

			Bddictionnairique.application.getvHeader().add(voletHeaderRechercheAvancee, "voletHeaderRechercheAvancee");
			Bddictionnairique.application.getvPanel().add(voletRechercheAvancee, "voletRechercheAvancee");

			Bddictionnairique.contentHeaderRechercheAvancee = new ContentHeaderRechercheAvancee(application);
			Bddictionnairique.contentRechercheAvancee = new ContentRechercheAvancee(application);

			Bddictionnairique.application.getcHeader().add(contentHeaderRechercheAvancee, "contentHeaderRechercheAvancee");
			Bddictionnairique.application.getcPanel().add(contentRechercheAvancee, "contentRechercheAvancee");
			
			Bddictionnairique.application.getVoletHeader().show(application.getvHeader(), "voletHeaderRechercheAvancee");
			Bddictionnairique.application.getVoletPanel().show(application.getvPanel(), "voletRechercheAvancee");
			
			Bddictionnairique.application.getContentHeader().show(application.getcHeader(), "contentHeaderRechercheAvancee");
			Bddictionnairique.application.getContentPanel().show(application.getcPanel(), "contentRechercheAvancee");
			
			jeViensDe = 2;

			logger.warn("Onglet Recherche Avancee OUVERT");
			
		}
		else if(jeVaisSur == 3) {
			Bddictionnairique.voletHeaderHistorique = new VoletHeaderHistorique();
			Bddictionnairique.voletHistorique = new VoletHistorique(application);
			
			Bddictionnairique.application.getvHeader().add(voletHeaderHistorique, "voletHeaderHistorique");
			Bddictionnairique.application.getvPanel().add(voletHistorique, "voletHistorique");
			
			Bddictionnairique.contentHeaderHistorique = new ContentHeaderHistorique(application);
			Bddictionnairique.contentHistorique = new ContentHistorique(application);
			
			Bddictionnairique.application.getcHeader().add(contentHeaderHistorique, "contentHeaderHistorique");
			Bddictionnairique.application.getcPanel().add(contentHistorique, "contentHistorique");
			
			Bddictionnairique.application.getVoletHeader().show(application.getvHeader(), "voletHeaderHistorique");
			Bddictionnairique.application.getVoletPanel().show(application.getvPanel(), "voletHistorique");
			
			Bddictionnairique.application.getContentHeader().show(application.getcHeader(), "contentHeaderHistorique");
			Bddictionnairique.application.getContentPanel().show(application.getcPanel(), "contentHistorique");
			
			jeViensDe = 3;
			
			logger.warn("Onglet Historique OUVERT");

		}
		else if(jeVaisSur == 4) {
			Bddictionnairique.voletHeaderEdition = new VoletHeaderEdition();
			Bddictionnairique.voletEdition = new VoletEdition(application);

			Bddictionnairique.application.getvHeader().add(voletHeaderEdition, "voletHeaderEdition");
			Bddictionnairique.application.getvPanel().add(voletEdition, "voletEdition");
			

			Bddictionnairique.contentHeaderEdition = new ContentHeaderEdition(application);
			Bddictionnairique.contentEdition = new ContentEdition();
			Bddictionnairique.contentFooterEdition = new ContentFooterEdition();

			Bddictionnairique.application.getcHeader().add(contentHeaderEdition, "contentHeaderEdition");
			Bddictionnairique.application.getcPanel().add(contentEdition, "contentEdition");
			Bddictionnairique.application.getcFooter().add(contentFooterEdition, "contentFooterEdition");
			
			Bddictionnairique.application.getVoletHeader().show(application.getvHeader(), "voletHeaderEdition");
			Bddictionnairique.application.getVoletPanel().show(application.getvPanel(), "voletEdition");
			
			Bddictionnairique.application.getContentHeader().show(application.getcHeader(), "contentHeaderEdition");
			Bddictionnairique.application.getContentPanel().show(application.getcPanel(), "contentEdition");
			Bddictionnairique.application.getContentFooter().show(application.getcFooter(), "contentFooterEdition");
			
			jeViensDe = 4;
			
			logger.warn("Onglet Edition OUVERT");
		}
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
	 * @return the voletHeaderEdition
	 */
	public VoletHeaderEdition getVoletHeaderEdition() {
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
	public VoletEdition getVoletEdition() {
		return voletEdition;
	}

	/**
	 * @param voletEdition the voletEdition to set
	 */
	public static void setVoletEdition(VoletEdition voletEdition) {
		Bddictionnairique.voletEdition = voletEdition;
	}

	/**
	 * @return the voletFooterRecherche
	 */
	public VoletFooterRecherche getVoletFooterRecherche() {
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
	 * @return the voletHeaderRechercheSimple
	 */
	public VoletHeaderRechercheSimple getVoletHeaderRechercheSimple() {
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
	 * @return the voletHeaderRechercheAvancee
	 */
	public VoletHeaderRechercheAvancee getVoletHeaderRechercheAvancee() {
		return voletHeaderRechercheAvancee;
	}

	/**
	 * @param voletHeaderRechercheAvancee the voletHeaderRechercheAvancee to set
	 */
	public static void setVoletHeaderRechercheAvancee(
			VoletHeaderRechercheAvancee voletHeaderRechercheAvancee) {
		Bddictionnairique.voletHeaderRechercheAvancee = voletHeaderRechercheAvancee;
	}

	/**
	 * @return the voletRechercheAvancee
	 */
	public VoletRechercheAvancee getVoletRechercheAvancee() {
		return voletRechercheAvancee;
	}

	/**
	 * @param voletRechercheAvancee the voletRechercheAvancee to set
	 */
	public static void setVoletRechercheAvancee(
			VoletRechercheAvancee voletRechercheAvancee) {
		Bddictionnairique.voletRechercheAvancee = voletRechercheAvancee;
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
		Bddictionnairique.voletHeaderHistorique = voletHeaderHistorique;
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
		Bddictionnairique.voletHistorique = voletHistorique;
	}

	/**
	 * @return the contentHeaderEdition
	 */
	public ContentHeaderEdition getContentHeaderEdition() {
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
	public ContentEdition getContentEdition() {
		return contentEdition;
	}

	/**
	 * @param contentEdition the contentEdition to set
	 */
	public static void setContentEdition(ContentEdition contentEdition) {
		Bddictionnairique.contentEdition = contentEdition;
	}

	/**
	 * @return the contentFooterEdition
	 */
	public ContentFooterEdition getContentFooterEdition() {
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
	 * @return the contentFooterRecherche
	 */
	public ContentFooterRecherche getContentFooterRecherche() {
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
	 * @return the contentHeaderRechercheSimple
	 */
	public ContentHeaderRechercheSimple getContentHeaderRechercheSimple() {
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
	public ContentRechercheSimple getContentRechercheSimple() {
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
	 * @return the contentHeaderRechercheAvancee
	 */
	public ContentHeaderRechercheAvancee getContentHeaderRechercheAvancee() {
		return contentHeaderRechercheAvancee;
	}

	/**
	 * @param contentHeaderRechercheAvancee the contentHeaderRechercheAvancee to set
	 */
	public static void setContentHeaderRechercheAvancee(
			ContentHeaderRechercheAvancee contentHeaderRechercheAvancee) {
		Bddictionnairique.contentHeaderRechercheAvancee = contentHeaderRechercheAvancee;
	}

	/**
	 * @return the contentRechercheAvancee
	 */
	public ContentRechercheAvancee getContentRechercheAvancee() {
		return contentRechercheAvancee;
	}

	/**
	 * @param contentRechercheAvancee the contentRechercheAvancee to set
	 */
	public static void setContentRechercheAvancee(
			ContentRechercheAvancee contentRechercheAvancee) {
		Bddictionnairique.contentRechercheAvancee = contentRechercheAvancee;
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
		Bddictionnairique.contentHeaderHistorique = contentHeaderHistorique;
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
		Bddictionnairique.contentHistorique = contentHistorique;
	}
}
