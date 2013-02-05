package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class Notes.
 * @see .Notes
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class NotesDAO extends AbstractDAO {

	public static String NOM_TABLE="Notes";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(NotesDAO.class);
	
	public NotesDAO() {}
	
	public NotesDAO(String type) {
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
     * @param notes
     */
    public void create(Notes notes) throws DataAccessLayerException {
        super.saveOrUpdate(session, notes);
    }


    /**
     * Delete a detached Event from the database.
     * @param notes
     */
    public void delete(Notes notes) throws DataAccessLayerException {
        super.delete(session, notes);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Notes find(Long id) throws DataAccessLayerException {
        return (Notes) super.find(session, Notes.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Notes notes) throws DataAccessLayerException {
        super.saveOrUpdate(session, notes);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(session, Notes.class);
    }
}
