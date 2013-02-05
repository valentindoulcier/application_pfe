package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class AvoirPourSuffixes.
 * @see .AvoirPourSuffixes
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class AvoirPourSuffixesDAO extends AbstractDAO{

	public static String NOM_TABLE="AvoirPourSuffixes";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(AvoirPourSuffixesDAO.class);
	
	public AvoirPourSuffixesDAO() {}
	
	public AvoirPourSuffixesDAO(String type) {
		if("local".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceLocale();
		}
		else if ("master".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceMaster();
		}
		tx = session.beginTransaction();    }

    /**
     * Insert a new Event into the database.
     * @param avoirPourSuffixes
     */
    public void create(AvoirPourSuffixes avoirPourSuffixes) throws DataAccessLayerException {
        super.saveOrUpdate(session, avoirPourSuffixes);
    }


    /**
     * Delete a detached Event from the database.
     * @param avoirPourSuffixes
     */
    public void delete(AvoirPourSuffixes avoirPourSuffixes) throws DataAccessLayerException {
        super.delete(session, avoirPourSuffixes);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public AvoirPourSuffixes find(Long id) throws DataAccessLayerException {
        return (AvoirPourSuffixes) super.find(session, AvoirPourSuffixes.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(AvoirPourSuffixes avoirPourSuffixes) throws DataAccessLayerException {
        super.saveOrUpdate(session, avoirPourSuffixes);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(session, AvoirPourSuffixes.class);
    }


}
