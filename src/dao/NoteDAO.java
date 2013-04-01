package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class Note.
 * @see dao.Note
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class NoteDAO extends AbstractDAO {

	public static String NOM_TABLE="Note";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(NoteDAO.class);
	
	public NoteDAO() {}
	
	public NoteDAO(String type) {
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
     * @param note
     */
    public void create(Note note) throws DataAccessLayerException {
        super.saveOrUpdate(session, note);
    }


    /**
     * Delete a detached Event from the database.
     * @param note
     */
    public void delete(Note note) throws DataAccessLayerException {
        super.delete(session, note);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Note find(Long id) throws DataAccessLayerException {
        return (Note) super.find(session, Note.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Note note) throws DataAccessLayerException {
        super.saveOrUpdate(session, note);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, Note.class);
    }
}
