package utils;

import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Valentin DOULCIER
 * @version 1.0
 * 
 * Cet objet est un singleton, et est utilisé lors de l'appelle à une fonction DAO.
 * Son but est de récupérer la connexion, en la créant si besoin.
 *
 */
public class HibernateUtils {

	private static Logger logger = Logger.getLogger(HibernateUtils.class);

	private static SessionFactory sessionFactoryLocale = null;
	private static SessionFactory sessionFactoryMaster = null;

	private static boolean connecteLocal;
	private static boolean connecteMaster;

	private HibernateUtils(){
		;
	}

	public static void deconnectionLocale() {
		HibernateUtils.getInstanceLocale().close();
		sessionFactoryLocale.close();
	}

	public static void deconnectionMaster() {
		HibernateUtils.getInstanceMaster().close();
		sessionFactoryMaster.close();
	}


	public static Session getInstanceLocale() {
		connecteLocal = true;
		if (sessionFactoryLocale == null) { // Premier appel
			try {
				Configuration configurationLocale = new Configuration();
				configurationLocale.configure("hibernateLocal.cfg.xml");

				try {
					InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernateLocal.properties");
					Properties propertiesLocales = new Properties();
					propertiesLocales.load(is);
					//propertiesLocales.load(new FileReader("./hibernateLocal.properties"));
					configurationLocale.addProperties(propertiesLocales);
				} catch (Exception e) {
					connecteLocal = false;
					logger.fatal("Erreur lecture fichier properties Locales : " + e.toString());
				}

				try {
					sessionFactoryLocale = configurationLocale.buildSessionFactory();
		        } catch (Throwable ex) {
		            // Make sure you log the exception, as it might be swallowed
		        	logger.fatal("Erreur lecture fichier properties Locales : " + ex.getMessage());
		        	JOptionPane.showMessageDialog(null, "Connexion fermée 1!");
		            throw new ExceptionInInitializerError(ex);
		        } /*catch (HibernateException e) {
					//TODO
					logger.fatal("getInstanceLocale ligne 64" + e.getMessage());
					//throw new DataAccessLayerException(e);
				}*/
			} catch (Throwable ex) {
				logger.fatal("Erreur lecture fichier properties Locales : " + ex.getMessage());
				JOptionPane.showMessageDialog(null, "Connexion fermée 2!");
				//connecteLocal = false;
			}
		}
		Session test = null;
		
		try {
			test = sessionFactoryLocale.openSession();
		} catch(HibernateException e) {
			logger.fatal("Erreur ouverture de session");
			JOptionPane.showMessageDialog(null, "Session");
		}
		
		return test;
	}

	public static Session changeInstanceLocale(Properties properties) {

		deconnectionLocale();
		connecteLocal = true;

		try {

			Configuration configurationLocale = new Configuration();
			configurationLocale.configure("hibernateLocal.cfg.xml");

			try {
				//InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("src/hibernateLocal.properties");
				configurationLocale.addProperties(properties);
			} catch (Exception e) {
				connecteLocal = false;
				logger.fatal("Erreur dans le Properties Local on Update : " + e.toString());
			}

			try {
				sessionFactoryLocale = configurationLocale.buildSessionFactory();
			} catch (HibernateException e) {
				//TODO
				//throw new DataAccessLayerException(e);
			}
		} catch (Throwable ex) {
			connecteLocal = false;
		}
		return sessionFactoryLocale.openSession();
	}

	public static Session getInstanceMaster() {
		setConnecteMaster(true);
		if (sessionFactoryMaster == null) { // Premier appel
			try {

				Configuration configurationMaster = new Configuration();
				configurationMaster.configure("hibernateMaster.cfg.xml");

				try {
					InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("src/hibernateMaster.properties");
					Properties propertiesMaster = new Properties();
					propertiesMaster.load(is);
					//propertiesMaster.load(new FileReader("src/hibernateMaster.properties"));
					configurationMaster.addProperties(propertiesMaster);
				} catch (Exception e) {
					setConnecteMaster(false);
					logger.fatal("Erreur lecture fichier properties Master : " + e.toString());
				}

				try {
					sessionFactoryMaster = configurationMaster.buildSessionFactory();
				} catch (HibernateException e) {
					//TODO
					//throw new DataAccessLayerException(e);
				}

			} catch (Throwable ex) {
				setConnecteMaster(false);
			}
		}
		return sessionFactoryMaster.openSession();
	}

	public static Session changeInstanceMaster(Properties properties) {

		deconnectionMaster();
		connecteMaster = true;

		try {

			Configuration configurationMaster = new Configuration();
			configurationMaster.configure("hibernateMaster.cfg.xml");

			try {
				//InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("src/hibernateLocal.properties");
				configurationMaster.addProperties(properties);
			} catch (Exception e) {
				//TODO
			}

			try {
				sessionFactoryMaster = configurationMaster.buildSessionFactory();
			} catch (HibernateException e) {
				//TODO
				//throw new DataAccessLayerException(e);
			}
		} catch (Throwable ex) {
			//TODO
		}
		return sessionFactoryMaster.openSession();
	}


	public static boolean isConnecteLocal() {
		return connecteLocal;
	}

	public static void setConnecteLocal(boolean connecteLocal) {
		HibernateUtils.connecteLocal = connecteLocal;
	}

	public static boolean isConnecteMaster() {
		return connecteMaster;
	}

	public static void setConnecteMaster(boolean connecteMaster) {
		HibernateUtils.connecteMaster = connecteMaster;
	}

	public static void rollback(Transaction tx) {
		try {
			if (tx != null) {
				tx.rollback();
			}
		} catch (HibernateException ignored) {
			logger.error("Couldn't rollback Transaction", ignored);
		}
	}
}















/*
public class HibernateUtils {

	private static final SessionFactory sessionFactory1;
	private static final SessionFactory sessionFactory2;

	static {
		try {

			URL configFileURL1 = HibernateUtils.class.getResource("hibernate1.cfg.xml");
			sessionFactory1 = new Configuration().configure(configFileURL1).buildSessionFactory();

			URL configFileURL2 = HibernateUtils.class.getResource("hibernate2.cfg.xml");
			sessionFactory2 = new Configuration().configure(configFileURL2).buildSessionFactory();

		} catch (HibernateException ex) {
			throw new RuntimeException("Exception building SessionFactory: " + ex.getMessage(), ex);
		}
	}

	public static final ThreadLocal session1 = new ThreadLocal();
	public static final ThreadLocal session2 = new ThreadLocal();

	public static Session getSession1() throws HibernateException {
		Session s = (Session) session1.get();
		// Open a new Session, if this Thread has none yet
		if (s == null) {
			System.out.println("[ OUVERTURE DE LA CONNEXION A LA BASE DE DONNEES 1 ]");
			s = sessionFactory1.openSession();
			session1.set(s);
		}
		return s;
	}

	public static void closeSession1() throws HibernateException {
		Session s = (Session) session1.get();
		session1.set(null);
		if (s != null){
			s.close();
			System.out.println("[ FERMETURE DE LA CONNEXION A LA BASE DE DONNEES 1]");
		}
	}

	public static Session getSession2() throws HibernateException {
		Session s = (Session) session2.get();
		// Open a new Session, if this Thread has none yet
		if (s == null) {
			System.out.println("[ OUVERTURE DE LA CONNEXION A LA BASE DE DONNEES 2 ]");
			s = sessionFactory2.openSession();
			session2.set(s);
		}
		return s;
	}

	public static void closeSession2() throws HibernateException {
		Session s = (Session) session2.get();
		session2.set(null);
		if (s != null){
			s.close();
			System.out.println("[ FERMETURE DE LA CONNEXION A LA BASE DE DONNEES 2 ]");
		}
	}
}
 */


/*
public class HibernateUtils {

	private static SessionFactory sessionFactory;

	private HibernateUtils(){
		 ;
	 }

	 public static Session getInstance() {
	     if (sessionFactory == null) { // Premier appel
	    	 try {
	 			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	 		} catch (HibernateException ex) {
	 			throw new RuntimeException("Problème de configuration : " + ex.getMessage(), ex);
	 		}
	     }
	     return sessionFactory.openSession();
	 }

}
 */

/*
public class HibernateUtils {

	private static final SessionFactory sessionFactory;

	// Crée une unique instance de la SessionFactory à partir de hibernate.cfg.xml
	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException ex) {
			throw new RuntimeException("Problème de configuration : " + ex.getMessage(), ex);
		}
	}

	// Renvoie une session Hibernate
	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}
 */