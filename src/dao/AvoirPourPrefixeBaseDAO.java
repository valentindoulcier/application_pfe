package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class AvoirPourPrefixeBase.
 * @see .AvoirPourPrefixeBase
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class AvoirPourPrefixeBaseDAO extends AbstractDAO{

	public static String NOM_TABLE="AvoirPourPrefixeBase";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(AvoirPourPrefixeBaseDAO.class);
	
	public AvoirPourPrefixeBaseDAO() {}
	
	public AvoirPourPrefixeBaseDAO(String type) {
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
     * @param avoirPourPrefixeBase
     */
    public void create(AvoirPourPrefixeBase avoirPourPrefixeBase) throws DataAccessLayerException {
        super.saveOrUpdate(session, avoirPourPrefixeBase);
    }


    /**
     * Delete a detached Event from the database.
     * @param avoirPourPrefixeBase
     */
    public void delete(AvoirPourPrefixeBase avoirPourPrefixeBase) throws DataAccessLayerException {
        super.delete(session, avoirPourPrefixeBase);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public AvoirPourPrefixeBase find(Long id) throws DataAccessLayerException {
        return (AvoirPourPrefixeBase) super.find(session, AvoirPourPrefixeBase.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(AvoirPourPrefixeBase avoirPourPrefixeBase) throws DataAccessLayerException {
        super.saveOrUpdate(session, avoirPourPrefixeBase);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, AvoirPourPrefixeBase.class);
    }
}
