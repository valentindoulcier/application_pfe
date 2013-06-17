/**
 * 
 */
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author Valentin DOULCIER
 *
 */
public class ConnexionTemporaire {
	
	private static ConnexionTemporaire instance = null;
	
	private static String localDriver;
	private static String localAdresse;
	private static String localUtilisateur;
	private static String localPassword;
	
	private static String masterDriver;
	private static String masterAdresse;
	private static String masterUtilisateur;
	private static String masterPassword;

	
	private ConnexionTemporaire() {
		;
	}

	public static ConnexionTemporaire getInstance() {
		if (instance == null) {
			synchronized(ConnexionTemporaire.class) {
				ConnexionTemporaire.instance = new ConnexionTemporaire();
				initValue();
			}
		}
		return instance;
	}
	
	
	
	public static void initValue() {

		Properties properties = new Properties();

		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernateLocal.properties");
			properties.load(is);
		} catch (IOException ex) {
			;
		}

		localDriver = properties.getProperty("hibernate.connection.driver_class");
		localAdresse = properties.getProperty("hibernate.connection.url");
		localUtilisateur = properties.getProperty("hibernate.connection.username");
		localPassword = properties.getProperty("hibernate.connection.password");
		
		
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernateMaster.properties");
			properties.load(is);
		} catch (IOException ex) {
			;
		}

		masterDriver = properties.getProperty("hibernate.connection.driver_class");
		masterAdresse = properties.getProperty("hibernate.connection.url");
		masterUtilisateur = properties.getProperty("hibernate.connection.username");
		masterPassword = properties.getProperty("hibernate.connection.password");
		
		
	}

	/**
	 * @return the localDriver
	 */
	public String getLocalDriver() {
		return localDriver;
	}

	/**
	 * @param localDriver the localDriver to set
	 */
	public void setLocalDriver(String localDriver) {
		ConnexionTemporaire.localDriver = localDriver;
	}

	/**
	 * @return the localAdresse
	 */
	public String getLocalAdresse() {
		return localAdresse;
	}

	/**
	 * @param localAdresse the localAdresse to set
	 */
	public void setLocalAdresse(String localAdresse) {
		ConnexionTemporaire.localAdresse = localAdresse;
	}

	/**
	 * @return the localUtilisateur
	 */
	public String getLocalUtilisateur() {
		return localUtilisateur;
	}

	/**
	 * @param localUtilisateur the localUtilisateur to set
	 */
	public void setLocalUtilisateur(String localUtilisateur) {
		ConnexionTemporaire.localUtilisateur = localUtilisateur;
	}

	/**
	 * @return the localPassword
	 */
	public String getLocalPassword() {
		return localPassword;
	}

	/**
	 * @param localPassword the localPassword to set
	 */
	public void setLocalPassword(String localPassword) {
		ConnexionTemporaire.localPassword = localPassword;
	}

	/**
	 * @return the masterDriver
	 */
	public String getMasterDriver() {
		return masterDriver;
	}

	/**
	 * @param masterDriver the masterDriver to set
	 */
	public void setMasterDriver(String masterDriver) {
		ConnexionTemporaire.masterDriver = masterDriver;
	}

	/**
	 * @return the masterAdresse
	 */
	public String getMasterAdresse() {
		return masterAdresse;
	}

	/**
	 * @param masterAdresse the masterAdresse to set
	 */
	public void setMasterAdresse(String masterAdresse) {
		ConnexionTemporaire.masterAdresse = masterAdresse;
	}

	/**
	 * @return the masterUtilisateur
	 */
	public String getMasterUtilisateur() {
		return masterUtilisateur;
	}

	/**
	 * @param masterUtilisateur the masterUtilisateur to set
	 */
	public void setMasterUtilisateur(String masterUtilisateur) {
		ConnexionTemporaire.masterUtilisateur = masterUtilisateur;
	}

	/**
	 * @return the masterPassword
	 */
	public String getMasterPassword() {
		return masterPassword;
	}

	/**
	 * @param masterPassword the masterPassword to set
	 */
	public void setMasterPassword(String masterPassword) {
		ConnexionTemporaire.masterPassword = masterPassword;
	}
	
}