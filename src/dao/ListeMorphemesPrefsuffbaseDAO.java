package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class ListeMorphemesPrefsuffbase.
 * @see .ListeMorphemesPrefsuffbase
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeMorphemesPrefsuffbaseDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeMorphemesPrefsuffbase";
	
	private static Logger logger = Logger.getLogger(ListeMorphemesPrefsuffbaseDAO.class);
	
	public ListeMorphemesPrefsuffbaseDAO() {
        super();
    }
	
	public ListeMorphemesPrefsuffbaseDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param listeMorphemesPrefsuffbase
     */
    public void create(ListeMorphemesPrefsuffbase listeMorphemesPrefsuffbase) throws DataAccessLayerException {
        super.saveOrUpdate(listeMorphemesPrefsuffbase);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeMorphemesPrefsuffbase
     */
    public void delete(ListeMorphemesPrefsuffbase listeMorphemesPrefsuffbase) throws DataAccessLayerException {
        super.delete(listeMorphemesPrefsuffbase);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeMorphemesPrefsuffbase find(Long id) throws DataAccessLayerException {
        return (ListeMorphemesPrefsuffbase) super.find(ListeMorphemesPrefsuffbase.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeMorphemesPrefsuffbase listeMorphemesPrefsuffbase) throws DataAccessLayerException {
        super.saveOrUpdate(listeMorphemesPrefsuffbase);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(ListeMorphemesPrefsuffbase.class);
    }
}
