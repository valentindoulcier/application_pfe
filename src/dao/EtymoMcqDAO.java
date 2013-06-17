package dao;
import database.*;

// Generated 29 mars 2013 17:35:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class EtymoMcq.
 * @see dao.EtymoMcq
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class EtymoMcqDAO extends AbstractDAO {

	public static String NOM_TABLE="EtymoMcq";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(EtymoMcqDAO.class);
	
	public EtymoMcqDAO() {}
	
	public EtymoMcqDAO(String type) {
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
     * @param etymoMcq
     */
    public void create(EtymoMcq etymoMcq) throws DataAccessLayerException {
        super.saveOrUpdate(session, etymoMcq);
    }


    /**
     * Delete a detached Event from the database.
     * @param etymoMcq
     */
    public void delete(EtymoMcq etymoMcq) throws DataAccessLayerException {
        super.delete(session, etymoMcq);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public EtymoMcq find(Long id) throws DataAccessLayerException {
        return (EtymoMcq) super.find(session, EtymoMcq.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(EtymoMcq etymoMcq) throws DataAccessLayerException {
        super.saveOrUpdate(session, etymoMcq);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, EtymoMcq.class);
    }
}
