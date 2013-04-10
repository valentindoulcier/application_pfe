package sections.updateBDD;

import principal.Application;

import sections.updateBDD.ui.contents.ContentFooterUpdate;
import sections.updateBDD.ui.contents.ContentHeaderUpdate;
import sections.updateBDD.ui.contents.ContentUpdate;

import sections.updateBDD.ui.volets.VoletFooterUpdate;
import sections.updateBDD.ui.volets.VoletHeaderUpdate;
import sections.updateBDD.ui.volets.VoletUpdate;
import java.io.Serializable;

/**
 * @author Valentin DOULCIER
 *
 */
public class UpdateBDD implements Serializable {

	private static final long serialVersionUID = 7666561320641678776L;

	private static UpdateBDD instance = null;

	// Update
	private static VoletHeaderUpdate voletHeaderUpdate = null;
	private static VoletUpdate voletUpdate = null;
	private static VoletFooterUpdate voletFooterUpdate = null;

	private static ContentHeaderUpdate contentHeaderUpdate = null;
	private static ContentUpdate contentUpdate = null;
	private static ContentFooterUpdate contentFooterUpdate = null;

	// Application
	private static Application application = null;

	private UpdateBDD() {
		;
	}

	public static UpdateBDD getInstance(Application application) {
		if (instance == null) {
			synchronized(UpdateBDD.class) {
				UpdateBDD.instance = new UpdateBDD();

				UpdateBDD.application = application;

				UpdateBDD.voletHeaderUpdate = new VoletHeaderUpdate();
				UpdateBDD.voletUpdate = new VoletUpdate(application);
				UpdateBDD.voletFooterUpdate = new VoletFooterUpdate(application);

				UpdateBDD.contentHeaderUpdate = new ContentHeaderUpdate(application);
				UpdateBDD.contentUpdate = new ContentUpdate(application);
				UpdateBDD.contentFooterUpdate = new ContentFooterUpdate(application);
			}
		}
		return instance;
	}


	public void chargerSynchronisation() {
		// Volets
		UpdateBDD.application.getvHeader().add(voletHeaderUpdate, "voletHeaderUpdate");
		UpdateBDD.application.getvPanel().add(voletUpdate, "voletUpdate");
		UpdateBDD.application.getvFooter().add(voletFooterUpdate, "voletFooterUpdate");

		UpdateBDD.application.getVoletHeader().show(application.getvHeader(), "voletHeaderUpdate");
		UpdateBDD.application.getVoletPanel().show(application.getvPanel(), "voletUpdate");
		UpdateBDD.application.getVoletFooter().show(application.getvFooter(), "voletFooterUpdate");

		// Content
		UpdateBDD.application.getcHeader().add(contentHeaderUpdate, "contentHeaderUpdate");
		UpdateBDD.application.getcPanel().add(contentUpdate, "contentUpdate");
		UpdateBDD.application.getcFooter().add(contentFooterUpdate, "contentFooterUpdate");

		UpdateBDD.application.getContentHeader().show(application.getcHeader(), "contentHeaderUpdate");
		UpdateBDD.application.getContentPanel().show(application.getcPanel(), "contentUpdate");
		UpdateBDD.application.getContentFooter().show(application.getcFooter(), "contentFooterUpdate");

		//
		getVoletUpdate().chargerHistorique(application);
		UpdateBDD.application.OuvrirVolet();
	}

	public void dechargerSynchronisation() {
		UpdateBDD.application.getContentHeader().show(application.getcHeader(), "contentHeaderAdministration");
		UpdateBDD.application.getContentPanel().show(application.getcPanel(), "contentAdministration");
		UpdateBDD.application.getContentFooter().show(application.getcFooter(), "contentFooterAdministration");

		UpdateBDD.application.FermerVolet();

		UpdateBDD.application.getcHeader().remove(getContentHeaderUpdate());
		UpdateBDD.application.getcPanel().remove(getContentUpdate());
		UpdateBDD.application.getcFooter().remove(getContentFooterUpdate());

		UpdateBDD.application.getvHeader().remove(getVoletHeaderUpdate());
		UpdateBDD.application.getvPanel().remove(getVoletUpdate());
		UpdateBDD.application.getvFooter().remove(getVoletFooterUpdate());
	}

	/**
	 * @return the voletHeaderUpdate
	 */
	public VoletHeaderUpdate getVoletHeaderUpdate() {
		return voletHeaderUpdate;
	}

	/**
	 * @param voletHeaderUpdate the voletHeaderUpdate to set
	 */
	public static void setVoletHeaderUpdate(VoletHeaderUpdate voletHeaderUpdate) {
		UpdateBDD.voletHeaderUpdate = voletHeaderUpdate;
	}

	/**
	 * @return the voletUpdate
	 */
	public VoletUpdate getVoletUpdate() {
		return voletUpdate;
	}

	/**
	 * @param voletUpdate the voletUpdate to set
	 */
	public static void setVoletUpdate(VoletUpdate voletUpdate) {
		UpdateBDD.voletUpdate = voletUpdate;
	}

	/**
	 * @return the voletFooterUpdate
	 */
	public VoletFooterUpdate getVoletFooterUpdate() {
		return voletFooterUpdate;
	}

	/**
	 * @param voletFooterUpdate the voletFooterUpdate to set
	 */
	public static void setVoletFooterUpdate(VoletFooterUpdate voletFooterUpdate) {
		UpdateBDD.voletFooterUpdate = voletFooterUpdate;
	}

	/**
	 * @return the contentHeaderUpdate
	 */
	public ContentHeaderUpdate getContentHeaderUpdate() {
		return contentHeaderUpdate;
	}

	/**
	 * @param contentHeaderUpdate the contentHeaderUpdate to set
	 */
	public void setContentHeaderUpdate(
			ContentHeaderUpdate contentHeaderUpdate) {
		UpdateBDD.contentHeaderUpdate = contentHeaderUpdate;
	}

	/**
	 * @return the contentUpdate
	 */
	public ContentUpdate getContentUpdate() {
		return contentUpdate;
	}

	/**
	 * @param contentUpdate the contentUpdate to set
	 */
	public void setContentUpdate(ContentUpdate contentUpdate) {
		UpdateBDD.contentUpdate = contentUpdate;
	}

	/**
	 * @return the contentFooterUpdate
	 */
	public ContentFooterUpdate getContentFooterUpdate() {
		return contentFooterUpdate;
	}

	/**
	 * @param contentFooterUpdate the contentFooterUpdate to set
	 */
	public static void setContentFooterUpdate(
			ContentFooterUpdate contentFooterUpdate) {
		UpdateBDD.contentFooterUpdate = contentFooterUpdate;
	}
}
