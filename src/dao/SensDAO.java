package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Sens.
 * @see .Sens
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class SensDAO extends AbstractDAO {

	public static String NOM_TABLE="Sens";
	
	private static Logger logger = Logger.getLogger(SensDAO.class);
	
	public SensDAO() {
        super();
    }
	
	public SensDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param sens
     */
    public void create(Sens sens) throws DataAccessLayerException {
        super.saveOrUpdate(sens);
    }


    /**
     * Delete a detached Event from the database.
     * @param sens
     */
    public void delete(Sens sens) throws DataAccessLayerException {
        super.delete(sens);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Sens find(Long id) throws DataAccessLayerException {
        return (Sens) super.find(Sens.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Sens sens) throws DataAccessLayerException {
        super.saveOrUpdate(sens);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Sens.class);
    }
}
