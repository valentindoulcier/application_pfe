package dao;

import utils.*;

import java.util.List;

import org.apache.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;


/**
 * @author Valentin
 *
 */
public class AbstractDAO {

	private static Logger logger = Logger.getLogger(AbstractDAO.class);

	private Transaction tx;

	public AbstractDAO() {}


	protected void create(Session session, Object obj) {
		try {
			this.tx = session.beginTransaction();
			
			session.save(obj);
			tx.commit();
		} catch (HibernateException e) {
			logger.fatal("TESSST");
			handleException(e);
		} finally {
			session.close();
		}
	}

	protected void update(Session session, Object obj) {
		try {
			this.tx = session.beginTransaction();

			session.update(obj);
			tx.commit();
		} catch (HibernateException e) {
			logger.fatal("TESSST");
			handleException(e);
		} finally {
			session.close();
		}
	}

	protected void saveOrUpdate(Session session, Object obj) {
		try {
			this.tx = session.beginTransaction();
			
			session.saveOrUpdate(obj);
			tx.commit();
		} catch (HibernateException e) {
			logger.fatal("TESSST");
			handleException(e);
		} finally {
			session.close();
		}
	}

	protected void delete(Session session, Object obj) {
		try {
			this.tx = session.beginTransaction();
			
			session.delete(obj);
			tx.commit();
		} catch (HibernateException e) {
			logger.fatal("TESSST");
			handleException(e);
		} finally {
			session.close();
		}
	}

	protected Object find(Session session, Class<?> clazz, Long id) {
		Object obj = null;
		try {
			this.tx = session.beginTransaction();
			
			obj = session.load(clazz, id);
			tx.commit();
		} catch (HibernateException e) {
			logger.fatal("TESSST");
			handleException(e);
		} finally {
			session.close();
		}
		return obj;
	}

	protected List<?> findAll(Session session, Class<?> clazz) {
		List<?> objects = null;
		try {
			this.tx = session.beginTransaction();
			
			Query query = session.createQuery("from " + clazz.getName());
			objects = query.list();
			tx.commit();
		} catch (HibernateException e) {
			logger.fatal("TESSST");
			handleException(e);
		} finally {
			session.close();
		}
		return objects;
	}

	protected void handleException(HibernateException e) throws DataAccessLayerException {
		HibernateUtils.rollback(tx);
		throw new DataAccessLayerException(e);
	}

}
