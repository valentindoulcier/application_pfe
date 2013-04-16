package dao;

// Generated 06 april 2013 15:28:49 by Valentin DOULCIER


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.PersistentClass;

import sections.synchronisation.Synchronisation;
import utils.HibernateUtils;

/**
 * Home object for domain model class Synchronisation.
 * @see dao.Synchronisation
 * @author Valentin DOULCIER
 */
@SuppressWarnings("unused")
public class OptionsDAO {

	private Session session;
	private Transaction tx;

	private static Logger logger = Logger.getLogger(SensDAO.class);

	public OptionsDAO() {}

	public OptionsDAO(String type) {
		if("local".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceLocale();
		}
		else if ("master".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceMaster();
		}
		tx = session.beginTransaction();
	}
	
	/*
	public boolean connectToDatabase() {
		return session.createSQLQuery(""); //.createSQLQuery("").executeUpdate();
	}
	*/
}
