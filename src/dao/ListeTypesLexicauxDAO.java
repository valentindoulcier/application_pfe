package dao;
import database.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;


/**
 * Home object for domain model class ListeTypesLexicaux.
 * @see .ListeTypesLexicaux
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ListeTypesLexicauxDAO extends AbstractDAO {

	public static String NOM_TABLE="ListeTypesLexicaux";

	private Session session;
	private Transaction tx;
	
	private static Logger logger = Logger.getLogger(ListeTypesLexicauxDAO.class);
	
	public ListeTypesLexicauxDAO() {}
	
	public ListeTypesLexicauxDAO(String type) {
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
     * @param listeTypesLexicaux
     */
    public void create(ListeTypesLexicaux listeTypesLexicaux) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeTypesLexicaux);
    }


    /**
     * Delete a detached Event from the database.
     * @param listeTypesLexicaux
     */
    public void delete(ListeTypesLexicaux listeTypesLexicaux) throws DataAccessLayerException {
        super.delete(session, listeTypesLexicaux);
    }

    /**
     * Find an Event by its primary key.
     * @param id
     * @return
     */
    public ListeTypesLexicaux find(Long id) throws DataAccessLayerException {
        return (ListeTypesLexicaux) super.find(session, ListeTypesLexicaux.class, id);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param event
     */
    public void update(ListeTypesLexicaux listeTypesLexicaux) throws DataAccessLayerException {
        super.saveOrUpdate(session, listeTypesLexicaux);
    }

    /**
     * Finds all Events in the database.
     * @return
     */
    public List<?> findAll() throws DataAccessLayerException{
        return super.findAll(session, ListeTypesLexicaux.class);
    }
}
