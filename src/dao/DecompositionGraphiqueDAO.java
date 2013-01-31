package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class DecompositionGraphique.
 * @see .DecompositionGraphique
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class DecompositionGraphiqueDAO extends AbstractDAO {

	public static String NOM_TABLE="DecompositionGraphique";
	
	private static Logger logger = Logger.getLogger(DecompositionGraphiqueDAO.class);
	
	public DecompositionGraphiqueDAO() {
        super();
    }
	
	public DecompositionGraphiqueDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param decompositionGraphique
     */
    public void create(DecompositionGraphique decompositionGraphique) throws DataAccessLayerException {
        super.saveOrUpdate(decompositionGraphique);
    }


    /**
     * Delete a detached Event from the database.
     * @param decompositionGraphique
     */
    public void delete(DecompositionGraphique decompositionGraphique) throws DataAccessLayerException {
        super.delete(decompositionGraphique);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public DecompositionGraphique find(Long id) throws DataAccessLayerException {
        return (DecompositionGraphique) super.find(DecompositionGraphique.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(DecompositionGraphique decompositionGraphique) throws DataAccessLayerException {
        super.saveOrUpdate(decompositionGraphique);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(DecompositionGraphique.class);
    }
}
