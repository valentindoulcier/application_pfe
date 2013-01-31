package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Notes.
 * @see .Notes
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class NotesDAO extends AbstractDAO {

	public static String NOM_TABLE="Notes";
	
	private static Logger logger = Logger.getLogger(NotesDAO.class);
	
	public NotesDAO() {
        super();
    }
	
	public NotesDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param notes
     */
    public void create(Notes notes) throws DataAccessLayerException {
        super.saveOrUpdate(notes);
    }


    /**
     * Delete a detached Event from the database.
     * @param notes
     */
    public void delete(Notes notes) throws DataAccessLayerException {
        super.delete(notes);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Notes find(Long id) throws DataAccessLayerException {
        return (Notes) super.find(Notes.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Notes notes) throws DataAccessLayerException {
        super.saveOrUpdate(notes);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Notes.class);
    }
}
