package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class ListeUsages.
 * @see dao.ListeUsages
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeUsagesDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeUsages";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(ListeUsagesDAO.class);
	
	public ListeUsagesDAO() {}
	
	public ListeUsagesDAO(String type) {
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
     * @param listeUsages
     */
    public void create(ListeUsages listeUsages) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeUsages);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeUsages
     */
    public void delete(ListeUsages listeUsages) throws DataAccessLayerException {
        super.delete(session, listeUsages);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeUsages find(Long id) throws DataAccessLayerException {
        return (ListeUsages) super.find(session, ListeUsages.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeUsages listeUsages) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeUsages);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, ListeUsages.class);
    }
}
