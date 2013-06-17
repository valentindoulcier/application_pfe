package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class TypesConstruction.
 * @see dao.TypesConstruction
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class TypesConstructionDAO extends AbstractDAO {

	public static String NOM_TABLE="TypesConstruction";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(TypesConstructionDAO.class);
	
	public TypesConstructionDAO() {}
	
	public TypesConstructionDAO(String type) {
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
     * @param typesConstruction
     */
    public void create(TypesConstruction typesConstruction) throws DataAccessLayerException {
        super.saveOrUpdate(session, typesConstruction);
    }


    /**
     * Delete a detached Event from the database.
     * @param typesConstruction
     */
    public void delete(TypesConstruction typesConstruction) throws DataAccessLayerException {
        super.delete(session, typesConstruction);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public TypesConstruction find(Long id) throws DataAccessLayerException {
        return (TypesConstruction) super.find(session, TypesConstruction.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(TypesConstruction typesConstruction) throws DataAccessLayerException {
        super.saveOrUpdate(session, typesConstruction);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, TypesConstruction.class);
    }
}
