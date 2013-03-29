package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class Composes.
 * @see dao.Composes
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ComposesDAO extends AbstractDAO {

	public static String NOM_TABLE="Composes";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(ComposesDAO.class);

	public ComposesDAO() {}
	
	public ComposesDAO(String type) {
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
     * @param composes
     */
    public void create(Composes composes) throws DataAccessLayerException {
        super.saveOrUpdate(session, composes);
    }


    /**
     * Delete a detached Event from the database.
     * @param composes
     */
    public void delete(Composes composes) throws DataAccessLayerException {
        super.delete(session, composes);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Composes find(Long id) throws DataAccessLayerException {
        return (Composes) super.find(session, Composes.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Composes composes) throws DataAccessLayerException {
        super.saveOrUpdate(session, composes);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, Composes.class);
    }
}
