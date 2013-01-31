package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class TypesMorphologie.
 * @see .TypesMorphologie
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class TypesMorphologieDAO extends AbstractDAO {

	public static String NOM_TABLE="TypesMorphologie";
	
	private static Logger logger = Logger.getLogger(TypesMorphologieDAO.class);
	
	public TypesMorphologieDAO() {
        super();
    }
	
	public TypesMorphologieDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param typesMorphologie
     */
    public void create(TypesMorphologie typesMorphologie) throws DataAccessLayerException {
        super.saveOrUpdate(typesMorphologie);
    }


    /**
     * Delete a detached Event from the database.
     * @param typesMorphologie
     */
    public void delete(TypesMorphologie typesMorphologie) throws DataAccessLayerException {
        super.delete(typesMorphologie);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public TypesMorphologie find(Long id) throws DataAccessLayerException {
        return (TypesMorphologie) super.find(TypesMorphologie.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(TypesMorphologie typesMorphologie) throws DataAccessLayerException {
        super.saveOrUpdate(typesMorphologie);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(TypesMorphologie.class);
    }
}
