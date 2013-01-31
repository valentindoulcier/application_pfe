package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class LiensDict.
 * @see .LiensDict
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class LiensDictDAO extends AbstractDAO {

	public static String NOM_TABLE="LiensDict";
	
	private static Logger logger = Logger.getLogger(LiensDictDAO.class);
	
	public LiensDictDAO() {
        super();
    }

	public LiensDictDAO(String type) {
        super(type);
    }
	
    /**
     * Insert a new Event into the database.
     * @param liensDict
     */
    public void create(LiensDict liensDict) throws DataAccessLayerException {
        super.saveOrUpdate(liensDict);
    }


    /**
     * Delete a detached Event from the database.
     * @param liensDict
     */
    public void delete(LiensDict liensDict) throws DataAccessLayerException {
        super.delete(liensDict);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public LiensDict find(Long id) throws DataAccessLayerException {
        return (LiensDict) super.find(LiensDict.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(LiensDict liensDict) throws DataAccessLayerException {
        super.saveOrUpdate(liensDict);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(LiensDict.class);
    }
}
