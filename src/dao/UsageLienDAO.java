package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class UsageLien.
 * @see .UsageLien
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class UsageLienDAO extends AbstractDAO {

	public static String NOM_TABLE="UsageLien";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(UsageLienDAO.class);
	
	public UsageLienDAO() {}
	
	public UsageLienDAO(String type) {
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
     * @param usageLien
     */
    public void create(UsageLien usageLien) throws DataAccessLayerException {
        super.saveOrUpdate(session, usageLien);
    }


    /**
     * Delete a detached Event from the database.
     * @param usageLien
     */
    public void delete(UsageLien usageLien) throws DataAccessLayerException {
        super.delete(session, usageLien);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public UsageLien find(Long id) throws DataAccessLayerException {
        return (UsageLien) super.find(session, UsageLien.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(UsageLien usageLien) throws DataAccessLayerException {
        super.saveOrUpdate(session, usageLien);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, UsageLien.class);
    }
}
