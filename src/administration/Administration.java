/**
 * 
 */
package administration;

import java.io.Serializable;
import java.util.ArrayList;

import database.Utilisateur;

import administration.objects.Fichier;
import administration.ui.contents.ContentHeaderLogin;
import administration.ui.contents.ContentLogin;
import administration.ui.contents.ContentFooterLogin;

import administration.ui.contents.ContentHeaderAdministration;
import administration.ui.contents.ContentAdministration;
import administration.ui.contents.ContentFooterAdministration;

import principal.Application;

/**
 * @author Valentin DOULCIER
 *
 */
public class Administration implements Serializable {

	private static final long serialVersionUID = -8346438792703635327L;
	
	private static Administration instance = null;
	
	private static ArrayList<Fichier> mesFichiers;
	
	private static Utilisateur user = null;
	
	// Login
	private static ContentHeaderLogin contentHeaderLogin = null;
	private static ContentLogin contentLogin = null;
	private static ContentFooterLogin contentFooterLogin = null;
	
	// Administration
	private static ContentHeaderAdministration contentHeaderAdministration = null;
	private static ContentAdministration contentAdministration = null;
	private static ContentFooterAdministration contentFooterAdministration = null;
	
	// Application
	private static Application application = null;
	
	private Administration() {
		;
	}

	public static Administration getInstance(Application application) {
		if (instance == null) { 	
			synchronized(Administration.class) {
				Administration.instance = new Administration();

				Administration.application = application;
				
				setMesFichiers(new ArrayList<Fichier>());
			}
		}
		return instance;
	}
	
	public void chargerLogin() {
		contentHeaderLogin = new ContentHeaderLogin();
		contentLogin = new ContentLogin(application);
		contentFooterLogin = new ContentFooterLogin();
		
		// TEMPO
		contentLogin.getTextFieldEmail().setText("valentin.doulcier");
		contentLogin.getPasswordField().setText("azerty");
		// FIN TEMPO
		
		Administration.application.getcHeader().add(contentHeaderLogin, "contentHeaderLogin");
		Administration.application.getcPanel().add(contentLogin, "contentLogin");
		Administration.application.getcFooter().add(contentFooterLogin, "contentFooterLogin");
		
		Administration.application.getContentHeader().show(application.getcHeader(), "contentHeaderLogin");
		Administration.application.getContentPanel().show(application.getcPanel(), "contentLogin");
		Administration.application.getContentFooter().show(application.getcFooter(), "contentFooterLogin");
	}
	
	public void dechargerLogin() {
		Administration.application.getContentHeader().show(application.getcHeader(), "ContentHeaderHome");
		Administration.application.getContentPanel().show(application.getcPanel(), "ContentHome");
		Administration.application.getContentFooter().show(application.getcFooter(), "ContentFooterHome");
		
		Administration.application.getcHeader().remove(contentHeaderLogin);
		Administration.application.getcPanel().remove(contentLogin);
		Administration.application.getcFooter().remove(contentFooterLogin);
	}
	
	public void chargerAdministration() {
		dechargerLogin();
		
		contentHeaderAdministration = new ContentHeaderAdministration(application);
		contentAdministration = new ContentAdministration(application);
		contentFooterAdministration = new ContentFooterAdministration();
		
		Administration.application.getcHeader().add(contentHeaderAdministration, "contentHeaderAdministration");
		Administration.application.getcPanel().add(contentAdministration, "contentAdministration");
		Administration.application.getcFooter().add(contentFooterAdministration, "contentFooterAdministration");
		
		Administration.application.getContentHeader().show(application.getcHeader(), "contentHeaderAdministration");
		Administration.application.getContentPanel().show(application.getcPanel(), "contentAdministration");
		Administration.application.getContentFooter().show(application.getcFooter(), "contentFooterAdministration");
	}
	
	public void dechargerAdministration() {
		Administration.application.getContentHeader().show(application.getcHeader(), "ContentHeaderHome");
		Administration.application.getContentPanel().show(application.getcPanel(), "ContentHome");
		Administration.application.getContentFooter().show(application.getcFooter(), "ContentFooterHome");
		
		Administration.application.getcHeader().remove(contentHeaderAdministration);
		Administration.application.getcPanel().remove(contentAdministration);
		Administration.application.getcFooter().remove(contentFooterAdministration);
	}

	
	/**
	 * @return the mesFichiers
	 */
	public static ArrayList<Fichier> getMesFichiers() {
		return mesFichiers;
	}

	/**
	 * @param mesFichiers the mesFichiers to set
	 */
	public static void setMesFichiers(ArrayList<Fichier> mesFichiers) {
		Administration.mesFichiers = mesFichiers;
	}

	/**
	 * @return the user
	 */
	public static Utilisateur getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public static void setUser(Utilisateur user) {
		Administration.user = user;
	}

	/**
	 * @return the contentHeaderLogin
	 */
	public static ContentHeaderLogin getContentHeaderLogin() {
		return contentHeaderLogin;
	}

	/**
	 * @param contentHeaderLogin the contentHeaderLogin to set
	 */
	public static void setContentHeaderLogin(ContentHeaderLogin contentHeaderLogin) {
		Administration.contentHeaderLogin = contentHeaderLogin;
	}

	/**
	 * @return the contentLogin
	 */
	public static ContentLogin getContentLogin() {
		return contentLogin;
	}

	/**
	 * @param contentLogin the contentLogin to set
	 */
	public static void setContentLogin(ContentLogin contentLogin) {
		Administration.contentLogin = contentLogin;
	}

	/**
	 * @return the contentFooterLogin
	 */
	public static ContentFooterLogin getContentFooterLogin() {
		return contentFooterLogin;
	}

	/**
	 * @param contentFooterLogin the contentFooterLogin to set
	 */
	public static void setContentFooterLogin(ContentFooterLogin contentFooterLogin) {
		Administration.contentFooterLogin = contentFooterLogin;
	}

	/**
	 * @return the contentHeaderAdministration
	 */
	public static ContentHeaderAdministration getContentHeaderAdministration() {
		return contentHeaderAdministration;
	}

	/**
	 * @param contentHeaderAdministration the contentHeaderAdministration to set
	 */
	public static void setContentHeaderAdministration(
			ContentHeaderAdministration contentHeaderAdministration) {
		Administration.contentHeaderAdministration = contentHeaderAdministration;
	}

	/**
	 * @return the contentAdministration
	 */
	public static ContentAdministration getContentAdministration() {
		return contentAdministration;
	}

	/**
	 * @param contentAdministration the contentAdministration to set
	 */
	public static void setContentAdministration(
			ContentAdministration contentAdministration) {
		Administration.contentAdministration = contentAdministration;
	}

	/**
	 * @return the contentFooterAdministration
	 */
	public static ContentFooterAdministration getContentFooterAdministration() {
		return contentFooterAdministration;
	}

	/**
	 * @param contentFooterAdministration the contentFooterAdministration to set
	 */
	public static void setContentFooterAdministration(
			ContentFooterAdministration contentFooterAdministration) {
		Administration.contentFooterAdministration = contentFooterAdministration;
	}
	
	
	

}
