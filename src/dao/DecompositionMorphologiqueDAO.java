package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class DecompositionMorphologique.
 * @see .DecompositionMorphologique
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class DecompositionMorphologiqueDAO extends AbstractDAO {

	public static String NOM_TABLE="DecompositionMorphologique";
	
	private static Logger logger = Logger.getLogger(DecompositionMorphologiqueDAO.class);

	public DecompositionMorphologiqueDAO() {
        super();
    }
	
	public DecompositionMorphologiqueDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param decompositionMorphologique
     */
    public void create(DecompositionMorphologique decompositionMorphologique) throws DataAccessLayerException {
        super.saveOrUpdate(decompositionMorphologique);
    }


    /**
     * Delete a detached Event from the database.
     * @param decompositionMorphologique
     */
    public void delete(DecompositionMorphologique decompositionMorphologique) throws DataAccessLayerException {
        super.delete(decompositionMorphologique);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public DecompositionMorphologique find(Long id) throws DataAccessLayerException {
        return (DecompositionMorphologique) super.find(DecompositionMorphologique.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(DecompositionMorphologique decompositionMorphologique) throws DataAccessLayerException {
        super.saveOrUpdate(decompositionMorphologique);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(DecompositionMorphologique.class);
    }
}
