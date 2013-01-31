package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Frequence.
 * @see .Frequence
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class FrequenceDAO extends AbstractDAO {

	public static String NOM_TABLE="Frequence";
	
	private static Logger logger = Logger.getLogger(FrequenceDAO.class);
	
	public FrequenceDAO() {
        super();
    }
	
	public FrequenceDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param frequence
     */
    public void create(Frequence frequence) throws DataAccessLayerException {
        super.saveOrUpdate(frequence);
    }


    /**
     * Delete a detached Event from the database.
     * @param frequence
     */
    public void delete(Frequence frequence) throws DataAccessLayerException {
        super.delete(frequence);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Frequence find(Long id) throws DataAccessLayerException {
        return (Frequence) super.find(Frequence.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Frequence frequence) throws DataAccessLayerException {
        super.saveOrUpdate(frequence);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Frequence.class);
    }
}