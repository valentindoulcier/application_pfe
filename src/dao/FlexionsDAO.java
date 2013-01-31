package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Flexions.
 * @see .Flexions
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class FlexionsDAO extends AbstractDAO {

	public static String NOM_TABLE="Flexions";
	
	private static Logger logger = Logger.getLogger(FlexionsDAO.class);
	
	public FlexionsDAO() {
        super();
    }
	
	public FlexionsDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param flexions
     */
    public void create(Flexions flexions) throws DataAccessLayerException {
        super.saveOrUpdate(flexions);
    }


    /**
     * Delete a detached Event from the database.
     * @param flexions
     */
    public void delete(Flexions flexions) throws DataAccessLayerException {
        super.delete(flexions);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Flexions find(Long id) throws DataAccessLayerException {
        return (Flexions) super.find(Flexions.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Flexions flexions) throws DataAccessLayerException {
        super.saveOrUpdate(flexions);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Flexions.class);
    }
}
