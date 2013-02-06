package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class Syllabes.
 * @see .Syllabes
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class SyllabesDAO extends AbstractDAO {

	public static String NOM_TABLE="Syllabes";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(SyllabesDAO.class);
	
	public SyllabesDAO() {}
	
	public SyllabesDAO(String type) {
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
     * @param syllabes
     */
    public void create(Syllabes syllabes) throws DataAccessLayerException {
        super.saveOrUpdate(session, syllabes);
    }


    /**
     * Delete a detached Event from the database.
     * @param syllabes
     */
    public void delete(Syllabes syllabes) throws DataAccessLayerException {
        super.delete(session, syllabes);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Syllabes find(Long id) throws DataAccessLayerException {
        return (Syllabes) super.find(session, Syllabes.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Syllabes syllabes) throws DataAccessLayerException {
        super.saveOrUpdate(session, syllabes);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, Syllabes.class);
    }
}
