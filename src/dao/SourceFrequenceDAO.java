package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class SourceFrequence.
 * @see .SourceFrequence
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class SourceFrequenceDAO extends AbstractDAO {

	public static String NOM_TABLE="SourceFrequence";
	
	private static Logger logger = Logger.getLogger(SourceFrequenceDAO.class);
	
	public SourceFrequenceDAO() {
        super();
    }
	
	public SourceFrequenceDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param sourceFrequence
     */
    public void create(SourceFrequence sourceFrequence) throws DataAccessLayerException {
        super.saveOrUpdate(sourceFrequence);
    }


    /**
     * Delete a detached Event from the database.
     * @param sourceFrequence
     */
    public void delete(SourceFrequence sourceFrequence) throws DataAccessLayerException {
        super.delete(sourceFrequence);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public SourceFrequence find(Long id) throws DataAccessLayerException {
        return (SourceFrequence) super.find(SourceFrequence.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(SourceFrequence sourceFrequence) throws DataAccessLayerException {
        super.saveOrUpdate(sourceFrequence);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(SourceFrequence.class);
    }
}
