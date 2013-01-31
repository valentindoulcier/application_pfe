package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class AvoirPourCategorieHeadword.
 * @see .AvoirPourCategorieHeadword
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class AvoirPourCategorieHeadwordDAO extends AbstractDAO {
	
	public static String NOM_TABLE="AvoirPourCategorieHeadword";
	
	private static Logger logger = Logger.getLogger(AvoirPourCategorieHeadwordDAO.class);
	
	public AvoirPourCategorieHeadwordDAO() {
        super();
    }
	
	public AvoirPourCategorieHeadwordDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param avoirPourCategorieHeadword
     */
    public void create(AvoirPourCategorieHeadword avoirPourCategorieHeadword) throws DataAccessLayerException {
        super.saveOrUpdate(avoirPourCategorieHeadword);
    }


    /**
     * Delete a detached Event from the database.
     * @param avoirPourCategorieHeadword
     */
    public void delete(AvoirPourCategorieHeadword avoirPourCategorieHeadword) throws DataAccessLayerException {
        super.delete(avoirPourCategorieHeadword);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public AvoirPourCategorieHeadword find(Long id) throws DataAccessLayerException {
        return (AvoirPourCategorieHeadword) super.find(AvoirPourCategorieHeadword.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(AvoirPourCategorieHeadword avoirPourCategorieHeadword) throws DataAccessLayerException {
        super.saveOrUpdate(avoirPourCategorieHeadword);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(AvoirPourCategorieHeadword.class);
    }
}
