package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import utils.HibernateUtils;

/**
 * Home object for domain model class ListeStatuts.
 * @see dao.ListeStatuts
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeStatutsDAO extends AbstractDAO {

	public static String NOM_TABLE="liste_statuts";
	
	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(ListeStatutsDAO.class);
	
	public ListeStatutsDAO() {}

	public ListeStatutsDAO(String type) {
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
     * @param listeStatuts
     */
    public void create(ListeStatuts listeStatuts) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeStatuts);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeStatuts
     */
    public void delete(ListeStatuts listeStatuts) throws DataAccessLayerException {
        super.delete(session, listeStatuts);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeStatuts find(Long id) throws DataAccessLayerException {
        return (ListeStatuts) super.find(session, ListeStatuts.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeStatuts listeStatuts) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeStatuts);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, ListeStatuts.class);
    }
    
    
    public ListeStatuts findTheStatut(int idStatut) {
    	Criteria criteria = session.createCriteria(ListeStatuts.class)
    			.add(Restrictions.like("idStatut", idStatut));
    	
    	return (ListeStatuts) criteria.uniqueResult();
	}
}
