package utils;

import java.io.FileReader;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

	private static SessionFactory sessionFactoryLocale = null;
	private static SessionFactory sessionFactoryMaster = null;

	private HibernateUtils(){
		;
	}


	public static Session getInstanceLocale() {
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
					System.out.println("Erreur lecture fichier properties Locales" + e.toString());
				}

				sessionFactoryLocale = configurationLocale.buildSessionFactory();
			} catch (Throwable ex) {
				System.out.println("Erreur creation de la SessionFactory" + ex.toString());
			}
		}
		return sessionFactoryLocale.openSession();
	}

	public static Session getInstanceMaster() {
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
					System.out.println("Erreur lecture fichier properties Master" + e.toString());
				}

				sessionFactoryMaster = configurationMaster.buildSessionFactory();
			} catch (Throwable ex) {
				System.out.println("Erreur creation de la SessionFactory" + ex.toString());
			}
		}
		return sessionFactoryMaster.openSession();
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