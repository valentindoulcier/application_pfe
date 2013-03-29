package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.criterion.*;

import utils.HibernateUtils;

/**
 * Home object for domain model class Headword.
 * @see dao.Headword
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class HeadwordDAO extends AbstractDAO {

	public static String NOM_TABLE="Headword";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(HeadwordDAO.class);
	
	public HeadwordDAO() {}
	
	public HeadwordDAO(String type) {
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
     * @param headword
     */
    public void create(Headword headword) throws DataAccessLayerException {
        super.saveOrUpdate(session, headword);
    }


    /**
     * Delete a detached Event from the database.
     * @param headword
     */
    public void delete(Headword headword) throws DataAccessLayerException {
        super.delete(session, headword);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public Headword find(Long id) throws DataAccessLayerException {
        return (Headword) super.find(session, Headword.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(Headword headword) throws DataAccessLayerException {
        super.saveOrUpdate(session, headword);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, Headword.class);
    }
    

	public List<?> findExactly(String mot, String dictionnaire) {
    	Criteria criteria = session.createCriteria(Headword.class)
    			.add(Restrictions.like("mot", mot))
    			.createCriteria("dictionnaires", "dico")
    			.add(Restrictions.eq("dico.nomDictionnaire", dictionnaire));

    	
    	return criteria.list();
	}
}
