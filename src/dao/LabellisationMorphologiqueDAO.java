package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class LabellisationMorphologique.
 * @see .LabellisationMorphologique
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class LabellisationMorphologiqueDAO extends AbstractDAO {

	public static String NOM_TABLE="LabellisationMorphologique";
	
	private static Logger logger = Logger.getLogger(LabellisationMorphologiqueDAO.class);
	
	public LabellisationMorphologiqueDAO() {
        super();
    }
	
	public LabellisationMorphologiqueDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param labellisationMorphologique
     */
    public void create(LabellisationMorphologique labellisationMorphologique) throws DataAccessLayerException {
        super.saveOrUpdate(labellisationMorphologique);
    }


    /**
     * Delete a detached Event from the database.
     * @param labellisationMorphologique
     */
    public void delete(LabellisationMorphologique labellisationMorphologique) throws DataAccessLayerException {
        super.delete(labellisationMorphologique);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public LabellisationMorphologique find(Long id) throws DataAccessLayerException {
        return (LabellisationMorphologique) super.find(LabellisationMorphologique.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(LabellisationMorphologique labellisationMorphologique) throws DataAccessLayerException {
        super.saveOrUpdate(labellisationMorphologique);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(LabellisationMorphologique.class);
    }
}
