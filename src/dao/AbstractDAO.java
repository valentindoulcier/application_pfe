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
@SuppressWarnings("unused")
public class AbstractDAO {

	private static Logger logger = Logger.getLogger(AbstractDAO.class);

	private Session session;
	private Transaction tx;

	public AbstractDAO() {}

	public AbstractDAO(String typeBdd) {
		if("local".equalsIgnoreCase(typeBdd)) {
			this.session = HibernateUtils.getInstanceLocale();
		}
		else if ("master".equalsIgnoreCase(typeBdd)) {
			this.session = HibernateUtils.getInstanceMaster();
		}
	}

	public AbstractDAO(String typeBdd, Transaction tx) {
		if("local".equalsIgnoreCase(typeBdd)) {
			this.session = HibernateUtils.getInstanceLocale();
		}
		else if ("master".equalsIgnoreCase(typeBdd)) {
			this.session = HibernateUtils.getInstanceMaster();
		}
		this.tx = tx;
	}

	protected void create(Object obj) {
		try {
			startOperation();
			session.save(obj);
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtils.getInstanceLocale().close();
		}
	}

	protected void update(Object obj) {
		try {
			startOperation();
			session.update(obj);
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtils.getInstanceLocale().close();
		}
	}

	protected void saveOrUpdate(Object obj) {
		try {
			startOperation();
			session.saveOrUpdate(obj);
			tx.commit();

			System.out.println("Terminé");
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtils.getInstanceLocale().close();
		}
	}

	protected void delete(Object obj) {
		try {
			startOperation();
			session.delete(obj);
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtils.getInstanceLocale().close();
		}
	}

	protected Object find(Class clazz, Long id) {
		Object obj = null;
		try {
			startOperation();
			obj = session.load(clazz, id);
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtils.getInstanceLocale().close();
		}
		return obj;
	}

	protected List findAll(Class clazz) {
		List objects = null;
		try {
			startOperation();
			Query query = session.createQuery("from " + clazz.getName());
			objects = query.list();
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateUtils.getInstanceLocale().close();
		}
		return objects;
	}

	protected void handleException(HibernateException e) throws DataAccessLayerException {
		HibernateUtils.rollback(tx);
		throw new DataAccessLayerException(e);
	}

	protected void startOperation() throws HibernateException {
		tx = session.beginTransaction();
	}

}
