package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class ListeUsages.
 * @see .ListeUsages
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeUsagesDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeUsages";
	
	private static Logger logger = Logger.getLogger(ListeUsagesDAO.class);
	
	public ListeUsagesDAO() {
        super();
    }
	
	public ListeUsagesDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param listeUsages
     */
    public void create(ListeUsages listeUsages) throws DataAccessLayerException {
        super.saveOrUpdate(listeUsages);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeUsages
     */
    public void delete(ListeUsages listeUsages) throws DataAccessLayerException {
        super.delete(listeUsages);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeUsages find(Long id) throws DataAccessLayerException {
        return (ListeUsages) super.find(ListeUsages.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeUsages listeUsages) throws DataAccessLayerException {
        super.saveOrUpdate(listeUsages);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(ListeUsages.class);
    }
}
