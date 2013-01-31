package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class AvoirPourPrefixeBase.
 * @see .AvoirPourPrefixeBase
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class AvoirPourPrefixeBaseDAO extends AbstractDAO{

	public static String NOM_TABLE="AvoirPourPrefixeBase";
	
	private static Logger logger = Logger.getLogger(AvoirPourPrefixeBaseDAO.class);
	
	public AvoirPourPrefixeBaseDAO() {
        super();
    }
	
	public AvoirPourPrefixeBaseDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param avoirPourPrefixeBase
     */
    public void create(AvoirPourPrefixeBase avoirPourPrefixeBase) throws DataAccessLayerException {
        super.saveOrUpdate(avoirPourPrefixeBase);
    }


    /**
     * Delete a detached Event from the database.
     * @param avoirPourPrefixeBase
     */
    public void delete(AvoirPourPrefixeBase avoirPourPrefixeBase) throws DataAccessLayerException {
        super.delete(avoirPourPrefixeBase);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public AvoirPourPrefixeBase find(Long id) throws DataAccessLayerException {
        return (AvoirPourPrefixeBase) super.find(AvoirPourPrefixeBase.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(AvoirPourPrefixeBase avoirPourPrefixeBase) throws DataAccessLayerException {
        super.saveOrUpdate(avoirPourPrefixeBase);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(AvoirPourPrefixeBase.class);
    }
}
