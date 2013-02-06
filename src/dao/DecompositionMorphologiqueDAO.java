package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class DecompositionMorphologique.
 * @see .DecompositionMorphologique
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class DecompositionMorphologiqueDAO extends AbstractDAO {

	public static String NOM_TABLE="DecompositionMorphologique";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(DecompositionMorphologiqueDAO.class);

	public DecompositionMorphologiqueDAO() {}
	
	public DecompositionMorphologiqueDAO(String type) {
		if("local".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceLocale();
		}
		else if ("master".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceMaster();
		}
		tx = session.beginTransaction();
    }

    /**
     * Insert a new Event into the database.
     * @param decompositionMorphologique
     */
    public void create(DecompositionMorphologique decompositionMorphologique) throws DataAccessLayerException {
        super.saveOrUpdate(session, decompositionMorphologique);
    }


    /**
     * Delete a detached Event from the database.
     * @param decompositionMorphologique
     */
    public void delete(DecompositionMorphologique decompositionMorphologique) throws DataAccessLayerException {
        super.delete(session, decompositionMorphologique);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public DecompositionMorphologique find(Long id) throws DataAccessLayerException {
        return (DecompositionMorphologique) super.find(session, DecompositionMorphologique.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(DecompositionMorphologique decompositionMorphologique) throws DataAccessLayerException {
        super.saveOrUpdate(session, decompositionMorphologique);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, DecompositionMorphologique.class);
    }
}
