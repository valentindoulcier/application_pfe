package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class Sens.
 * @see dao.Sens
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class SensDAO extends AbstractDAO {

	public static String NOM_TABLE="Sens";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(SensDAO.class);
	
	public SensDAO() {}
	
	public SensDAO(String type) {
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
     * @param sens
     */
    public void create(Sens sens) throws DataAccessLayerException {
        super.saveOrUpdate(session, sens);
    }


    /**
     * Delete a detached Event from the database.
     * @param sens
     */
    public void delete(Sens sens) throws DataAccessLayerException {
        super.delete(session, sens);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Sens find(Long id) throws DataAccessLayerException {
        return (Sens) super.find(session, Sens.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Sens sens) throws DataAccessLayerException {
        super.saveOrUpdate(session, sens);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, Sens.class);
    }
}
