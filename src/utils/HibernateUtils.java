package utils;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtils {

	private static SessionFactory sessionFactoryLocale = null;
	private static SessionFactory sessionFactoryMaster = null;

	private HibernateUtils(){
		;
	}


	public static Session getInstanceLocale() {
		if (sessionFactoryLocale == null) { // Premier appel
			try {
				sessionFactoryLocale = new AnnotationConfiguration().configure("hibernateLocal.cfg.xml").buildSessionFactory();
			} catch (HibernateException ex) {
				//throw new RuntimeException("[ HibernateUtils ] - Problème de configuration Local : " + ex.getMessage(), ex);
			}
		}
		return sessionFactoryLocale.openSession();
	}


	public static Session getInstanceMaster() throws DatabaseOffException {
		if (sessionFactoryMaster == null) { // Premier appel
			try {
				sessionFactoryMaster = new AnnotationConfiguration().configure("hibernateMaster.cfg.xml").buildSessionFactory();
			} catch (HibernateException ex) {
				throw new DatabaseOffException("[ HibernateUtils ] - Problème de configuration Master : " + ex.getMessage(), ex);
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