package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class ListeCategories.
 * @see .ListeCategories
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeCategoriesDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeCategories";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(ListeCategoriesDAO.class);
	
	public ListeCategoriesDAO() {}
	
	public ListeCategoriesDAO(String type) {
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
     * @param listeCategories
     */
    public void create(ListeCategories listeCategories) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeCategories);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeCategories
     */
    public void delete(ListeCategories listeCategories) throws DataAccessLayerException {
        super.delete(session, listeCategories);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeCategories find(Long id) throws DataAccessLayerException {
        return (ListeCategories) super.find(session, ListeCategories.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeCategories listeCategories) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeCategories);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, ListeCategories.class);
    }
}
