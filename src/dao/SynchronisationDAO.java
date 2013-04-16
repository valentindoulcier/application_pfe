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

import utils.HibernateUtils;

/**
 * Home object for domain model class Synchronisation.
 * @see dao.Synchronisation
 * @author Valentin DOULCIER
 */
@SuppressWarnings("unused")
public class SynchronisationDAO {

	private Session session;
	private Transaction tx;

	private static Logger logger = Logger.getLogger(SensDAO.class);

	public SynchronisationDAO() {}

	public SynchronisationDAO(String type) {
		if("local".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceLocale();
		}
		else if ("master".equalsIgnoreCase(type)) {
			this.session = HibernateUtils.getInstanceMaster();
		}
		tx = session.beginTransaction();
	}
	
	public boolean isGoodSchema() {
		return getSchemaDatabase().equals(getSchemaReference());
	}

	public boolean isGoodDatabase() {
		if(isGoodSchema()) {
			return CollectionUtils.disjunction(getTablesDatabase(), getTablesReference()).isEmpty();
		}
		else {
			return false;
		}
	}
	
	public ArrayList<String> getTablesDatabase() {
		ArrayList<String> listeTablesDatabase = new ArrayList<String>();
		
		List<?> tables = session.createSQLQuery("SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE();").list();

		for(Object table : tables) {
			listeTablesDatabase.add((String) table);
		}
		
		return listeTablesDatabase;
	}
	
	public ArrayList<String> getTablesReference() {
		ArrayList<String> listeTablesReferences = new ArrayList<String>();
		
		SAXReader reader =  new SAXReader();
		reader.setEncoding("UTF-8");
		
		Document doc;
		try {
			File f = new File("src/hibernateLocal.reveng.xml");
			System.out.println(f.getAbsolutePath());
			doc = reader.read(f);
			Element root = doc.getRootElement();
			for (Iterator<?> i = root.elementIterator(); i.hasNext(); ) {
				Element itemObject = (Element) i.next();
				if (itemObject.getName().equals("table-filter")) {
					listeTablesReferences.add(itemObject.attribute("match-name").getText());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return listeTablesReferences;
	}
	
	public String getSchemaDatabase() {
		List<?> schemas = session.createSQLQuery("SELECT TABLE_SCHEMA FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE()").list();
		for(Object schema : schemas) {
			return (String) schema;
		}
		return null;
	}
	
	public String getSchemaReference() {
		SAXReader reader =  new SAXReader();
		reader.setEncoding("UTF-8");

		Document doc;
		try {
			doc = reader.read(new File("src/hibernateLocal.reveng.xml"));
			Element root = doc.getRootElement();
			for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
				Element itemObject = (Element) i.next();
				if (itemObject.getName().equals("table-filter")) {
					return itemObject.attribute("match-catalog").getText();
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void executerRequete(String requete) {
		session.createSQLQuery(requete).executeUpdate();
	}
}
