package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import utils.HibernateUtils;

/**
 * Home object for domain model class Utilisateurs.
 * @see dao.Utilisateurs
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class UtilisateurDAO extends AbstractDAO {

	public static String NOM_TABLE="Utilisateur";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(UtilisateurDAO.class);
	
	public UtilisateurDAO() {}
	
	public UtilisateurDAO(String type) {
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
     * @param utilisateur
     */
    public void create(Utilisateur utilisateur) throws DataAccessLayerException {
        super.saveOrUpdate(session, utilisateur);
    }


    /**
     * Delete a detached Event from the database.
     * @param utilisateur
     */
    public void delete(Utilisateur utilisateur) throws DataAccessLayerException {
        super.delete(session, utilisateur);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Utilisateur find(Long id) throws DataAccessLayerException {
        return (Utilisateur) super.find(session, Utilisateur.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Utilisateur utilisateur) throws DataAccessLayerException {
        super.saveOrUpdate(session, utilisateur);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, Utilisateur.class);
    }
    
    public Utilisateur findExactly(String login) {
    	Criteria criteria = session.createCriteria(Utilisateur.class)
    			.add(Restrictions.like("login", login));
    	
    	return (Utilisateur) criteria.uniqueResult();
    }
}
