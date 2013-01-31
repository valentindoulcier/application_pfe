package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class ListeCategories.
 * @see .ListeCategories
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeCategoriesDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeCategories";
	
	private static Logger logger = Logger.getLogger(ListeCategoriesDAO.class);
	
	public ListeCategoriesDAO() {
        super();
    }
	
	public ListeCategoriesDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param listeCategories
     */
    public void create(ListeCategories listeCategories) throws DataAccessLayerException {
        super.saveOrUpdate(listeCategories);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeCategories
     */
    public void delete(ListeCategories listeCategories) throws DataAccessLayerException {
        super.delete(listeCategories);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeCategories find(Long id) throws DataAccessLayerException {
        return (ListeCategories) super.find(ListeCategories.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeCategories listeCategories) throws DataAccessLayerException {
        super.saveOrUpdate(listeCategories);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(ListeCategories.class);
    }
}
