package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class UsageLien.
 * @see .UsageLien
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class UsageLienDAO extends AbstractDAO {

	public static String NOM_TABLE="UsageLien";
	
	private static Logger logger = Logger.getLogger(UsageLienDAO.class);
	
	public UsageLienDAO() {
        super();
    }
	
	public UsageLienDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param usageLien
     */
    public void create(UsageLien usageLien) throws DataAccessLayerException {
        super.saveOrUpdate(usageLien);
    }


    /**
     * Delete a detached Event from the database.
     * @param usageLien
     */
    public void delete(UsageLien usageLien) throws DataAccessLayerException {
        super.delete(usageLien);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public UsageLien find(Long id) throws DataAccessLayerException {
        return (UsageLien) super.find(UsageLien.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(UsageLien usageLien) throws DataAccessLayerException {
        super.saveOrUpdate(usageLien);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(UsageLien.class);
    }
}
