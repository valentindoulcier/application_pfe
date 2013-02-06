package utils;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Valentin
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
					//InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("src/hibernateLocal.properties");
					Properties propertiesLocales = new Properties();
					propertiesLocales.load(new FileReader("src/hibernateLocal.properties"));
					configurationLocale.addProperties(propertiesLocales);
				} catch (Exception e) {
					connecteLocal = false;
					System.out.println("Erreur lecture fichier properties Locales" + e.toString());
				}

				try {
					sessionFactoryLocale = configurationLocale.buildSessionFactory();
				} catch (HibernateException e) {
					//TODO
					System.out.println("getInstanceLocale ligne 64" + e.getMessage());
					//throw new DataAccessLayerException(e);
				}
			} catch (Throwable ex) {
				connecteLocal = false;
				System.out.println("Erreur creation de la SessionFactory" + ex.toString());
			}
		}
		return sessionFactoryLocale.openSession();
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
				System.out.println("changeInstanceLocale : Erreur dans le Properties" + e.toString());
			}

			try {
				sessionFactoryLocale = configurationLocale.buildSessionFactory();
			} catch (HibernateException e) {
				//TODO
				System.out.println("changeInstanceLocale ligne 96" + e.getMessage());
				//throw new DataAccessLayerException(e);
			}
		} catch (Throwable ex) {
			connecteLocal = false;
			System.out.println("Erreur creation de la SessionFactory" + ex.toString());
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
					//InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("src/hibernateMaster.properties");
					Properties propertiesMaster = new Properties();
					propertiesMaster.load(new FileReader("src/hibernateMaster.properties"));
					configurationMaster.addProperties(propertiesMaster);
				} catch (Exception e) {
					setConnecteMaster(false);
					System.out.println("Erreur lecture fichier properties Master" + e.toString());
				}

				try {
					sessionFactoryMaster = configurationMaster.buildSessionFactory();
				} catch (HibernateException e) {
					//TODO
					System.out.println("getInstanceMaster ligne 127" + e.getMessage());
					//throw new DataAccessLayerException(e);
				}

			} catch (Throwable ex) {
				setConnecteMaster(false);
				System.out.println("Erreur creation de la SessionFactory" + ex.toString());
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
				System.out.println("changeInstanceMaster : Erreur dans le Properties" + e.toString());
			}

			try {
				sessionFactoryMaster = configurationMaster.buildSessionFactory();
			} catch (HibernateException e) {
				//TODO
				System.out.println("changeInstanceMaster ligne 159" + e.getMessage());
				//throw new DataAccessLayerException(e);
			}
		} catch (Throwable ex) {
			System.out.println("Erreur creation de la SessionFactory" + ex.toString());
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