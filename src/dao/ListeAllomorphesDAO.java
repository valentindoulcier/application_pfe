package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;


/**
 * Home object for domain model class ListeAllomorphes.
 * @see .ListeAllomorphes
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeAllomorphesDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeAllomorphes";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(ListeAllomorphesDAO.class);
	
	public ListeAllomorphesDAO() {}
	
	public ListeAllomorphesDAO(String type) {
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
     * @param listeAllomorphes
     */
    public void create(ListeAllomorphes listeAllomorphes) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeAllomorphes);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeAllomorphes
     */
    public void delete(ListeAllomorphes listeAllomorphes) throws DataAccessLayerException {
        super.delete(session, listeAllomorphes);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeAllomorphes find(Long id) throws DataAccessLayerException {
        return (ListeAllomorphes) super.find(session, ListeAllomorphes.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeAllomorphes listeAllomorphes) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeAllomorphes);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(session, ListeAllomorphes.class);
    }
}
