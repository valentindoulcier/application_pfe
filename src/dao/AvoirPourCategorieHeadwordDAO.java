package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class AvoirPourCategorieHeadword.
 * @see dao.AvoirPourCategorieHeadword
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class AvoirPourCategorieHeadwordDAO extends AbstractDAO {

public static String NOM_TABLE="AvoirPourCategorieHeadword";
	
	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(AvoirPourCategorieHeadwordDAO.class);
	
	public AvoirPourCategorieHeadwordDAO() {}
	
	public AvoirPourCategorieHeadwordDAO(String type) {
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
     * @param avoirPourCategorieHeadword
     */
    public void create(AvoirPourCategorieHeadword avoirPourCategorieHeadword) throws DataAccessLayerException {
        super.saveOrUpdate(session, avoirPourCategorieHeadword);
    }


    /**
     * Delete a detached Event from the database.
     * @param avoirPourCategorieHeadword
     */
    public void delete(AvoirPourCategorieHeadword avoirPourCategorieHeadword) throws DataAccessLayerException {
        super.delete(session, avoirPourCategorieHeadword);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public AvoirPourCategorieHeadword find(Long id) throws DataAccessLayerException {
        return (AvoirPourCategorieHeadword) super.find(session, AvoirPourCategorieHeadword.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(AvoirPourCategorieHeadword avoirPourCategorieHeadword) throws DataAccessLayerException {
        super.saveOrUpdate(session, avoirPourCategorieHeadword);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, AvoirPourCategorieHeadword.class);
    }
}
