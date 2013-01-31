package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Lexique.
 * @see .Lexique
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class LexiqueDAO extends AbstractDAO {

	public static String NOM_TABLE="Lexique";
	
	private static Logger logger = Logger.getLogger(LexiqueDAO.class);
	
	public LexiqueDAO() {
        super();
    }
	
	public LexiqueDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param lexique
     */
    public void create(Lexique lexique) throws DataAccessLayerException {
        super.saveOrUpdate(lexique);
    }


    /**
     * Delete a detached Event from the database.
     * @param lexique
     */
    public void delete(Lexique lexique) throws DataAccessLayerException {
        super.delete(lexique);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Lexique find(Long id) throws DataAccessLayerException {
        return (Lexique) super.find(Lexique.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Lexique lexique) throws DataAccessLayerException {
        super.saveOrUpdate(lexique);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Lexique.class);
    }
}
