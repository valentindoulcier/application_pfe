package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Headword.
 * @see .Headword
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class HeadwordDAO extends AbstractDAO {

	public static String NOM_TABLE="Headword";
	
	private static Logger logger = Logger.getLogger(HeadwordDAO.class);
	
	public HeadwordDAO() {
        super();
    }
	
	public HeadwordDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param headword
     */
    public void create(Headword headword) throws DataAccessLayerException {
        super.saveOrUpdate(headword);
    }


    /**
     * Delete a detached Event from the database.
     * @param headword
     */
    public void delete(Headword headword) throws DataAccessLayerException {
        super.delete(headword);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Headword find(Long id) throws DataAccessLayerException {
        return (Headword) super.find(Headword.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Headword headword) throws DataAccessLayerException {
        super.saveOrUpdate(headword);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Headword.class);
    }
}
