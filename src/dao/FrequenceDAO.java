package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class Frequence.
 * @see dao.Frequence
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class FrequenceDAO extends AbstractDAO {

	public static String NOM_TABLE="Frequence";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(FrequenceDAO.class);
	
	public FrequenceDAO() {}
	
	public FrequenceDAO(String type) {
		if("local".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceLocale();
		}
		else if ("master".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceMaster();
		}
		tx = session.beginTransaction();
    }

    /**
     * Insert a new Event into the database.
     * @param frequence
     */
    public void create(Frequence frequence) throws DataAccessLayerException {
        super.saveOrUpdate(session, frequence);
    }


    /**
     * Delete a detached Event from the database.
     * @param frequence
     */
    public void delete(Frequence frequence) throws DataAccessLayerException {
        super.delete(session, frequence);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Frequence find(Long id) throws DataAccessLayerException {
        return (Frequence) super.find(session, Frequence.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Frequence frequence) throws DataAccessLayerException {
        super.saveOrUpdate(session, frequence);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, Frequence.class);
    }
}