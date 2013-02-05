package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class Lexique.
 * @see .Lexique
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class LexiqueDAO extends AbstractDAO {

	public static String NOM_TABLE="Lexique";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(LexiqueDAO.class);
	
	public LexiqueDAO() {}
	
	public LexiqueDAO(String type) {
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
     * @param lexique
     */
    public void create(Lexique lexique) throws DataAccessLayerException {
        super.saveOrUpdate(session, lexique);
    }


    /**
     * Delete a detached Event from the database.
     * @param lexique
     */
    public void delete(Lexique lexique) throws DataAccessLayerException {
        super.delete(session, lexique);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Lexique find(Long id) throws DataAccessLayerException {
        return (Lexique) super.find(session, Lexique.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Lexique lexique) throws DataAccessLayerException {
        super.saveOrUpdate(session, lexique);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() throws DataAccessLayerException{
        return super.findAll(session, Lexique.class);
    }
}
