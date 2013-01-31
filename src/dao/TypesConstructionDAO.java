package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class TypesConstruction.
 * @see .TypesConstruction
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class TypesConstructionDAO extends AbstractDAO {

	public static String NOM_TABLE="TypesConstruction";
	
	private static Logger logger = Logger.getLogger(TypesConstructionDAO.class);
	
	public TypesConstructionDAO() {
        super();
    }
	
	public TypesConstructionDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param typesConstruction
     */
    public void create(TypesConstruction typesConstruction) throws DataAccessLayerException {
        super.saveOrUpdate(typesConstruction);
    }


    /**
     * Delete a detached Event from the database.
     * @param typesConstruction
     */
    public void delete(TypesConstruction typesConstruction) throws DataAccessLayerException {
        super.delete(typesConstruction);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public TypesConstruction find(Long id) throws DataAccessLayerException {
        return (TypesConstruction) super.find(TypesConstruction.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(TypesConstruction typesConstruction) throws DataAccessLayerException {
        super.saveOrUpdate(typesConstruction);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(TypesConstruction.class);
    }
}
