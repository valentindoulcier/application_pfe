package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class Utilisateurs.
 * @see dao.Utilisateurs
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class UtilisateursDAO extends AbstractDAO {

	public static String NOM_TABLE="Utilisateurs";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(UtilisateursDAO.class);
	
	public UtilisateursDAO() {}
	
	public UtilisateursDAO(String type) {
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
     * @param utilisateurs
     */
    public void create(Utilisateurs utilisateurs) throws DataAccessLayerException {
        super.saveOrUpdate(session, utilisateurs);
    }


    /**
     * Delete a detached Event from the database.
     * @param utilisateurs
     */
    public void delete(Utilisateurs utilisateurs) throws DataAccessLayerException {
        super.delete(session, utilisateurs);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Utilisateurs find(Long id) throws DataAccessLayerException {
        return (Utilisateurs) super.find(session, Utilisateurs.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Utilisateurs utilisateurs) throws DataAccessLayerException {
        super.saveOrUpdate(session, utilisateurs);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, Utilisateurs.class);
    }
}
