package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Syllabes.
 * @see .Syllabes
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class SyllabesDAO extends AbstractDAO {

	public static String NOM_TABLE="Syllabes";
	
	private static Logger logger = Logger.getLogger(SyllabesDAO.class);
	
	public SyllabesDAO() {
        super();
    }
	
	public SyllabesDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param syllabes
     */
    public void create(Syllabes syllabes) throws DataAccessLayerException {
        super.saveOrUpdate(syllabes);
    }


    /**
     * Delete a detached Event from the database.
     * @param syllabes
     */
    public void delete(Syllabes syllabes) throws DataAccessLayerException {
        super.delete(syllabes);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Syllabes find(Long id) throws DataAccessLayerException {
        return (Syllabes) super.find(Syllabes.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Syllabes syllabes) throws DataAccessLayerException {
        super.saveOrUpdate(syllabes);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(Syllabes.class);
    }
}
