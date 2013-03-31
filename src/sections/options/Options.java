/**
 * 
 */
package sections.options;

import principal.Application;

import java.io.Serializable;

import sections.options.ui.contents.ContentFooterOptions;
import sections.options.ui.contents.ContentHeaderOptions;
import sections.options.ui.contents.ContentOptions;

import sections.options.ui.volets.VoletFooterOptions;
import sections.options.ui.volets.VoletHeaderOptions;
import sections.options.ui.volets.VoletOptions;

/**
 * @author Valentin DOULCIER
 *
 */
public class Options implements Serializable {

	private static final long serialVersionUID = 7666561320641678776L;

	private static Options instance = null;

	// Options
	private static VoletHeaderOptions voletHeaderOptions = null;
	private static VoletOptions voletOptions = null;
	private static VoletFooterOptions voletFooterOptions = null;

	private static ContentHeaderOptions contentHeaderOptions = null;
	private static ContentOptions contentOptions = null;
	private static ContentFooterOptions contentFooterOptions = null;

	// Application
	private static Application application = null;

	private Options() {
		;
	}

	public static Options getInstance(Application application) {
		if (instance == null) {
			synchronized(Options.class) {
				Options.instance = new Options();

				Options.application = application;

				Options.voletHeaderOptions = new VoletHeaderOptions();
				Options.voletOptions = new VoletOptions();
				Options.voletFooterOptions = new VoletFooterOptions();

				Options.contentHeaderOptions = new ContentHeaderOptions(application);
				Options.contentOptions = new ContentOptions();
				Options.contentFooterOptions = new ContentFooterOptions();
			}
		}
		return instance;
	}


	public void chargerOptions() {
		// Volets
		Options.application.getvHeader().add(voletHeaderOptions, "voletHeaderOptions");
		Options.application.getvPanel().add(voletOptions, "voletOptions");
		Options.application.getvFooter().add(voletFooterOptions, "voletFooterOptions");

		Options.application.getVoletHeader().show(application.getvHeader(), "voletHeaderOptions");
		Options.application.getVoletPanel().show(application.getvPanel(), "voletOptions");
		Options.application.getVoletFooter().show(application.getvFooter(), "voletFooterOptions");

		// Content
		Options.application.getcHeader().add(contentHeaderOptions, "contentHeaderOptions");
		Options.application.getcPanel().add(contentOptions, "contentOptions");
		Options.application.getcFooter().add(contentFooterOptions, "contentFooterOptions");

		Options.application.getContentHeader().show(application.getcHeader(), "contentHeaderOptions");
		Options.application.getContentPanel().show(application.getcPanel(), "contentOptions");
		Options.application.getContentFooter().show(application.getcFooter(), "contentFooterOptions");

		//
		Options.application.OuvrirVolet();
	}

	public void dechargerOptions() {
		Options.application.getContentHeader().show(application.getcHeader(), "ContentHeaderHome");
		Options.application.getContentPanel().show(application.getcPanel(), "ContentHome");
		Options.application.getContentFooter().show(application.getcFooter(), "ContentFooterHome");

		Options.application.FermerVolet();

		Options.application.getcHeader().remove(getContentHeaderOptions());
		Options.application.getcPanel().remove(getContentOptions());
		Options.application.getcFooter().remove(getContentFooterOptions());

		Options.application.getvHeader().remove(getVoletHeaderOptions());
		Options.application.getvPanel().remove(getVoletOptions());
		Options.application.getvFooter().remove(getVoletFooterOptions());
	}

	/**
	 * @return the voletHeaderOptions
	 */
	public static VoletHeaderOptions getVoletHeaderOptions() {
		return voletHeaderOptions;
	}

	/**
	 * @param voletHeaderOptions the voletHeaderOptions to set
	 */
	public static void setVoletHeaderOptions(VoletHeaderOptions voletHeaderOptions) {
		Options.voletHeaderOptions = voletHeaderOptions;
	}

	/**
	 * @return the voletOptions
	 */
	public static VoletOptions getVoletOptions() {
		return voletOptions;
	}

	/**
	 * @param voletOptions the voletOptions to set
	 */
	public static void setVoletOptions(VoletOptions voletOptions) {
		Options.voletOptions = voletOptions;
	}

	/**
	 * @return the voletFooterOptions
	 */
	public static VoletFooterOptions getVoletFooterOptions() {
		return voletFooterOptions;
	}

	/**
	 * @param voletFooterOptions the voletFooterOptions to set
	 */
	public static void setVoletFooterOptions(VoletFooterOptions voletFooterOptions) {
		Options.voletFooterOptions = voletFooterOptions;
	}

	/**
	 * @return the contentHeaderOptions
	 */
	public static ContentHeaderOptions getContentHeaderOptions() {
		return contentHeaderOptions;
	}

	/**
	 * @param contentHeaderOptions the contentHeaderOptions to set
	 */
	public static void setContentHeaderOptions(
			ContentHeaderOptions contentHeaderOptions) {
		Options.contentHeaderOptions = contentHeaderOptions;
	}

	/**
	 * @return the contentOptions
	 */
	public static ContentOptions getContentOptions() {
		return contentOptions;
	}

	/**
	 * @param contentOptions the contentOptions to set
	 */
	public static void setContentOptions(ContentOptions contentOptions) {
		Options.contentOptions = contentOptions;
	}

	/**
	 * @return the contentFooterOptions
	 */
	public static ContentFooterOptions getContentFooterOptions() {
		return contentFooterOptions;
	}

	/**
	 * @param contentFooterOptions the contentFooterOptions to set
	 */
	public static void setContentFooterOptions(
			ContentFooterOptions contentFooterOptions) {
		Options.contentFooterOptions = contentFooterOptions;
	}
}
