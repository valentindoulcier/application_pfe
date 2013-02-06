package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class LiensDict.
 * @see .LiensDict
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class LiensDictDAO extends AbstractDAO {

	public static String NOM_TABLE="LiensDict";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(LiensDictDAO.class);
	
	public LiensDictDAO() {}

	public LiensDictDAO(String type) {
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
     * @param liensDict
     */
    public void create(LiensDict liensDict) throws DataAccessLayerException {
        super.saveOrUpdate(session, liensDict);
    }


    /**
     * Delete a detached Event from the database.
     * @param liensDict
     */
    public void delete(LiensDict liensDict) throws DataAccessLayerException {
        super.delete(session, liensDict);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public LiensDict find(Long id) throws DataAccessLayerException {
        return (LiensDict) super.find(session, LiensDict.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(LiensDict liensDict) throws DataAccessLayerException {
        super.saveOrUpdate(session, liensDict);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, LiensDict.class);
    }
}
