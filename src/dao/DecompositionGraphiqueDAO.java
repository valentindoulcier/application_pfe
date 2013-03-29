package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class DecompositionGraphique.
 * @see dao.DecompositionGraphique
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class DecompositionGraphiqueDAO extends AbstractDAO {

	public static String NOM_TABLE="DecompositionGraphique";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(DecompositionGraphiqueDAO.class);
	
	public DecompositionGraphiqueDAO() {}
	
	public DecompositionGraphiqueDAO(String type) {
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
     * @param decompositionGraphique
     */
    public void create(DecompositionGraphique decompositionGraphique) throws DataAccessLayerException {
        super.saveOrUpdate(session, decompositionGraphique);
    }


    /**
     * Delete a detached Event from the database.
     * @param decompositionGraphique
     */
    public void delete(DecompositionGraphique decompositionGraphique) throws DataAccessLayerException {
        super.delete(session, decompositionGraphique);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public DecompositionGraphique find(Long id) throws DataAccessLayerException {
        return (DecompositionGraphique) super.find(session, DecompositionGraphique.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(DecompositionGraphique decompositionGraphique) throws DataAccessLayerException {
        super.saveOrUpdate(session, decompositionGraphique);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, DecompositionGraphique.class);
    }
}
