package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

/**
 * Home object for domain model class LabellisationMorphologique.
 * @see .LabellisationMorphologique
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class LabellisationMorphologiqueDAO extends AbstractDAO {

	public static String NOM_TABLE="LabellisationMorphologique";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(LabellisationMorphologiqueDAO.class);
	
	public LabellisationMorphologiqueDAO() {}
	
	public LabellisationMorphologiqueDAO(String type) {
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
     * @param labellisationMorphologique
     */
    public void create(LabellisationMorphologique labellisationMorphologique) throws DataAccessLayerException {
        super.saveOrUpdate(session, labellisationMorphologique);
    }


    /**
     * Delete a detached Event from the database.
     * @param labellisationMorphologique
     */
    public void delete(LabellisationMorphologique labellisationMorphologique) throws DataAccessLayerException {
        super.delete(session, labellisationMorphologique);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public LabellisationMorphologique find(Long id) throws DataAccessLayerException {
        return (LabellisationMorphologique) super.find(session, LabellisationMorphologique.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(LabellisationMorphologique labellisationMorphologique) throws DataAccessLayerException {
        super.saveOrUpdate(session, labellisationMorphologique);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, LabellisationMorphologique.class);
    }
}
