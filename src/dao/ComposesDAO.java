package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Composes.
 * @see .Composes
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ComposesDAO extends AbstractDAO {

	public static String NOM_TABLE="Composes";
	
	private static Logger logger = Logger.getLogger(ComposesDAO.class);

	public ComposesDAO() {
        super();
    }
	
	public ComposesDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param composes
     */
    public void create(Composes composes) throws DataAccessLayerException {
        super.saveOrUpdate(composes);
    }


    /**
     * Delete a detached Event from the database.
     * @param composes
     */
    public void delete(Composes composes) throws DataAccessLayerException {
        super.delete(composes);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Composes find(Long id) throws DataAccessLayerException {
        return (Composes) super.find(Composes.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Composes composes) throws DataAccessLayerException {
        super.saveOrUpdate(composes);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Composes.class);
    }
}
