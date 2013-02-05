package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class ListeMorphemesPrefsuffbase.
 * @see .ListeMorphemesPrefsuffbase
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeMorphemesPrefsuffbaseDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeMorphemesPrefsuffbase";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(ListeMorphemesPrefsuffbaseDAO.class);
	
	public ListeMorphemesPrefsuffbaseDAO() {}
	
	public ListeMorphemesPrefsuffbaseDAO(String type) {
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
     * @param listeMorphemesPrefsuffbase
     */
    public void create(ListeMorphemesPrefsuffbase listeMorphemesPrefsuffbase) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeMorphemesPrefsuffbase);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeMorphemesPrefsuffbase
     */
    public void delete(ListeMorphemesPrefsuffbase listeMorphemesPrefsuffbase) throws DataAccessLayerException {
        super.delete(session, listeMorphemesPrefsuffbase);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeMorphemesPrefsuffbase find(Long id) throws DataAccessLayerException {
        return (ListeMorphemesPrefsuffbase) super.find(session, ListeMorphemesPrefsuffbase.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeMorphemesPrefsuffbase listeMorphemesPrefsuffbase) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeMorphemesPrefsuffbase);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(session, ListeMorphemesPrefsuffbase.class);
    }
}
