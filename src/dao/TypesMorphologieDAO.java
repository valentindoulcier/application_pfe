package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class TypesMorphologie.
 * @see .TypesMorphologie
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class TypesMorphologieDAO extends AbstractDAO {

	public static String NOM_TABLE="TypesMorphologie";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(TypesMorphologieDAO.class);
	
	public TypesMorphologieDAO() {}
	
	public TypesMorphologieDAO(String type) {
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
     * @param typesMorphologie
     */
    public void create(TypesMorphologie typesMorphologie) throws DataAccessLayerException {
        super.saveOrUpdate(session, typesMorphologie);
    }


    /**
     * Delete a detached Event from the database.
     * @param typesMorphologie
     */
    public void delete(TypesMorphologie typesMorphologie) throws DataAccessLayerException {
        super.delete(session, typesMorphologie);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public TypesMorphologie find(Long id) throws DataAccessLayerException {
        return (TypesMorphologie) super.find(session, TypesMorphologie.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(TypesMorphologie typesMorphologie) throws DataAccessLayerException {
        super.saveOrUpdate(session, typesMorphologie);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(session, TypesMorphologie.class);
    }
}
