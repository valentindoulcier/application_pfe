package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class SourceFrequence.
 * @see .SourceFrequence
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class SourceFrequenceDAO extends AbstractDAO {

	public static String NOM_TABLE="SourceFrequence";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(SourceFrequenceDAO.class);
	
	public SourceFrequenceDAO() {}
	
	public SourceFrequenceDAO(String type) {
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
     * @param sourceFrequence
     */
    public void create(SourceFrequence sourceFrequence) throws DataAccessLayerException {
        super.saveOrUpdate(session, sourceFrequence);
    }


    /**
     * Delete a detached Event from the database.
     * @param sourceFrequence
     */
    public void delete(SourceFrequence sourceFrequence) throws DataAccessLayerException {
        super.delete(session, sourceFrequence);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public SourceFrequence find(Long id) throws DataAccessLayerException {
        return (SourceFrequence) super.find(session, SourceFrequence.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(SourceFrequence sourceFrequence) throws DataAccessLayerException {
        super.saveOrUpdate(session, sourceFrequence);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, SourceFrequence.class);
    }
}
