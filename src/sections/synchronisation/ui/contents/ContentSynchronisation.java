/**
 * 
 */
package sections.synchronisation.ui.contents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;

import dao.SynchronisationDAO;
import javax.swing.JButton;

import principal.Application;

import sections.synchronisation.Synchronisation;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentSynchronisation extends JPanel {

	private static final long serialVersionUID = -5468061806376610050L;

	private JButton btnReset;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentSynchronisation(final Application application) {

		initComponents();

		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/baseLien";
					String user = "root";
					String pass = "";
					// on commence par se connecter à la base factice
					Connection factice;
					factice = DriverManager.getConnection(url,user,pass);
					// on crée la base et on récupère une Connection
					Connection connection = createMysqlDatabase(factice,user,pass,"bddictionnairique");
					factice.close();

				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				//Synchronisation.getInstance(application).resetDatabase();
			}
		});

		/*
		SynchronisationDAO synchroDAO = new SynchronisationDAO("local");

		synchroDAO.chargerListeTablesDatabase();
		synchroDAO.chargerListeTablesReference();

		if(synchroDAO.isGoodSchema()) {
			System.out.println("CA MATCH LE SCHEMA !!");

			if(synchroDAO.isGoodDatabase()) {
				System.out.println("CA MATCH LES TABLES!!");
			}
			else {
				System.out.println("CA NE MATCH PAS LES TABLES!!");
			}
		}
		else {
			System.out.println("CA NE MATCH PAS LE SCHEMA !!");
		}

		 */
	}

	public static Connection createMysqlDatabase(Connection factice, String user, String pass, String nomBase) throws SQLException{
		Connection connection = null;
		Statement statement = null;
		try{
			statement = factice.createStatement();
			statement.execute("CREATE DATABASE "+nomBase);
			String url = factice.getMetaData().getURL();
			url = url.substring(0,url.lastIndexOf("/"));
			url += "/"+nomBase;
			connection = DriverManager.getConnection(url,user,pass);
		}catch(SQLException e){
			SQLException sqle = new SQLException("Création de la base impossible");
			sqle.setNextException(e);
			throw sqle;
		}finally{
			try{statement.close();}catch(Exception e){}
		}
		return connection;
	}

	public void initComponents() {
		btnReset = new JButton("RESET");
		add(btnReset);
	}

}
