package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * Home object for domain model class ListeAllomorphes.
 * @see .ListeAllomorphes
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeAllomorphesDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeAllomorphes";
	
	private static Logger logger = Logger.getLogger(ListeAllomorphesDAO.class);
	
	public ListeAllomorphesDAO() {
        super();
    }
	
	public ListeAllomorphesDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param listeAllomorphes
     */
    public void create(ListeAllomorphes listeAllomorphes) throws DataAccessLayerException {
        super.saveOrUpdate(listeAllomorphes);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeAllomorphes
     */
    public void delete(ListeAllomorphes listeAllomorphes) throws DataAccessLayerException {
        super.delete(listeAllomorphes);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeAllomorphes find(Long id) throws DataAccessLayerException {
        return (ListeAllomorphes) super.find(ListeAllomorphes.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeAllomorphes listeAllomorphes) throws DataAccessLayerException {
        super.saveOrUpdate(listeAllomorphes);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(ListeAllomorphes.class);
    }
}
