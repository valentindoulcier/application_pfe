package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Dictionnaires.
 * @see .Dictionnaires
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class DictionnairesDAO extends AbstractDAO {

	public static String NOM_TABLE="Dictionnaires";
	
	private static Logger logger = Logger.getLogger(DictionnairesDAO.class);	

	public DictionnairesDAO() {
        super();
    }
	
	public DictionnairesDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param dictionnaires
     */
    public void create(Dictionnaires dictionnaires) throws DataAccessLayerException {
        super.saveOrUpdate(dictionnaires);
    }


    /**
     * Delete a detached Event from the database.
     * @param dictionnaires
     */
    public void delete(Dictionnaires dictionnaires) throws DataAccessLayerException {
        super.delete(dictionnaires);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Dictionnaires find(Long id) throws DataAccessLayerException {
        return (Dictionnaires) super.find(Dictionnaires.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Dictionnaires dictionnaires) throws DataAccessLayerException {
        super.saveOrUpdate(dictionnaires);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Dictionnaires.class);
    }
}
