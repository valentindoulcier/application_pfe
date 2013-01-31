package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class EtymoMcq.
 * @see .EtymoMcq
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class EtymoMcqDAO extends AbstractDAO {

	public static String NOM_TABLE="EtymoMcq";
	
	private static Logger logger = Logger.getLogger(EtymoMcqDAO.class);
	
	public EtymoMcqDAO() {
        super();
    }
	
	public EtymoMcqDAO(String type) {
        super(type);
    }

    /**
     * Insert a new Event into the database.
     * @param etymoMcq
     */
    public void create(EtymoMcq etymoMcq) throws DataAccessLayerException {
        super.saveOrUpdate(etymoMcq);
    }


    /**
     * Delete a detached Event from the database.
     * @param etymoMcq
     */
    public void delete(EtymoMcq etymoMcq) throws DataAccessLayerException {
        super.delete(etymoMcq);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public EtymoMcq find(Long id) throws DataAccessLayerException {
        return (EtymoMcq) super.find(EtymoMcq.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(EtymoMcq etymoMcq) throws DataAccessLayerException {
        super.saveOrUpdate(etymoMcq);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(EtymoMcq.class);
    }
}
