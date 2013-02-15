package dao;
import database.*;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class Dictionnaires.
 * @see .Dictionnaires
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class DictionnairesDAO extends AbstractDAO {

	public static String NOM_TABLE="Dictionnaires";

	private Session session;
	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(DictionnairesDAO.class);	

	public DictionnairesDAO() {}
	
	public DictionnairesDAO(String type) {
		if("local".equalsIgnoreCase(type)) {
			try {
				logger.debug("5 - Je vais récupérer l'instance");
				this.session = HibernateUtils.getInstanceLocale();
				logger.debug("6 - J'ai la session");
			} catch(Throwable ex) {
				logger.debug("56 - La session est foireuse");
				JOptionPane.showMessageDialog(null, "Connexion fermée !");
			}
		}
		else if ("master".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceMaster();
		}

		logger.debug("7 - Je vais tester la session");
		if(session != null) {
			logger.debug("8 - La session n'est pas nulle - beginTransaction");
			tx = session.beginTransaction();
		}
		else {
			logger.debug("9 - La session est nulle");
			JOptionPane.showMessageDialog(null, "Transaction !");
		}
    }

    /**
     * Insert a new Event into the database.
     * @param dictionnaires
     */
    public void create(Dictionnaires dictionnaires) throws DataAccessLayerException {
        super.saveOrUpdate(session, dictionnaires);
    }


    /**
     * Delete a detached Event from the database.
     * @param dictionnaires
     */
    public void delete(Dictionnaires dictionnaires) throws DataAccessLayerException {
        super.delete(session, dictionnaires);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Dictionnaires find(Long id) throws DataAccessLayerException {
        return (Dictionnaires) super.find(session, Dictionnaires.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Dictionnaires dictionnaires) throws DataAccessLayerException {
        super.saveOrUpdate(session, dictionnaires);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, Dictionnaires.class);
    }
}
