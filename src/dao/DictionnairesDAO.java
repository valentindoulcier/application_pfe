package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import utils.HibernateUtils;

/**
 * Home object for domain model class Dictionnaires.
 * @see dao.Dictionnaires
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class DictionnairesDAO extends AbstractDAO {

	public static String NOM_TABLE="Dictionnaires";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(DictionnairesDAO.class);	

	public DictionnairesDAO() {}
	
	public DictionnairesDAO(String type) {
		if("local".equalsIgnoreCase(type)) {
			try {
				//logger.debug("5 - Je vais récupérer l'instance");
				this.session = HibernateUtils.getInstanceLocale();
				//logger.debug("6 - J'ai la session");
			} catch(Throwable ex) {
				//logger.debug("56 - La session est foireuse");
				JOptionPane.showMessageDialog(null, "Connexion fermée !");
			}
		}
		else if ("master".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceMaster();
		}

		//logger.debug("7 - Je vais tester la session");
		if(session != null) {
			//logger.debug("8 - La session n'est pas nulle - beginTransaction");
			tx = session.beginTransaction();
		}
		else {
			//logger.debug("9 - La session est nulle");
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
    
    public Dictionnaires findExactly(int id) {
    	Criteria criteria = session.createCriteria(Dictionnaires.class)
    			.add(Restrictions.like("idDictionnaire", id));
    	
    	return (Dictionnaires) criteria.uniqueResult();
	}

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
}
