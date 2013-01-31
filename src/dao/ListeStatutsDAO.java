package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class ListeStatuts.
 * @see .ListeStatuts
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeStatutsDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeStatuts";
	
	private static Logger logger = Logger.getLogger(ListeStatutsDAO.class);
	
	public ListeStatutsDAO() {
        super();
    }

	public ListeStatutsDAO(String type) {
		super(type);
	}
	

	/**
     * Insert a new Event into the database.
     * @param listeStatuts
     */
    public void create(ListeStatuts listeStatuts) throws DataAccessLayerException {
        super.saveOrUpdate(listeStatuts);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeStatuts
     */
    public void delete(ListeStatuts listeStatuts) throws DataAccessLayerException {
        super.delete(listeStatuts);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeStatuts find(Long id) throws DataAccessLayerException {
        return (ListeStatuts) super.find(ListeStatuts.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeStatuts listeStatuts) throws DataAccessLayerException {
        super.saveOrUpdate(listeStatuts);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(ListeStatuts.class);
    }
}
