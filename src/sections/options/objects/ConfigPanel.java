/**
 * 
 */
package sections.options.objects;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import principal.Application;
import sections.options.Options;
import utils.ConnexionTemporaire;
import utils.HibernateUtils;

/**
 * @author Valentin DOULCIER
 *
 */
public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = -7072796036596986133L;

	private static Logger logger = Logger.getLogger(ConfigPanel.class);

	private JLabel lblConfigtitre;

	private JLabel lblEtat;
	private JLabel lblDriver;
	private JLabel lblAdresse;
	private JLabel lblUtilisateur;
	private JLabel lblPassword;
	private JLabel lblSesouvenir;

	private JTextField textFieldDriver;
	private JTextField textFieldAdresse;
	private JTextField textFieldUtilisateur;
	private JPasswordField passwordField;
	private JCheckBox chckbxSesouvenir;

	private JButton btnUpdate;
	private JButton btnValider;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblPasswordvisible;


	private Properties properties;

	private String source;
	private String fichier;



	/**
	 * Create the panel.
	 */
	public ConfigPanel(final Application application) {

		source = Options.getInstance(application).getSource();
		if("local".equalsIgnoreCase(source)) {
			fichier = "hibernateLocal.properties";
		}
		else if("master".equalsIgnoreCase(source)) {
			fichier = "hibernateMaster.properties";
		}
		else {
			logger.fatal("Erreur initialisation ConfigPanel - Source inconnue");
		}

		initComponents(application);
		initValue();



		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if("Update".equalsIgnoreCase(btnUpdate.getText())) {
					enableData();
					btnUpdate.setText("Annuler");
				}
				else if("Annuler".equalsIgnoreCase(btnUpdate.getText())) {
					initValue();
					disableData();
					btnUpdate.setText("Update");
				}
			}
		});


		btnValider.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(chckbxSesouvenir.isSelected()) {
					try {
						updateProperties();
						if("local".equalsIgnoreCase(source)) {
							HibernateUtils.deconnectionLocale();
							HibernateUtils.getInstanceLocale();
						}
						else {
							HibernateUtils.deconnectionMaster();
							HibernateUtils.getInstanceMaster();
						}
					} catch (IOException e1) {
						logger.fatal("Problème de mise à jour du fichier properties : " + e1.getMessage());
					}
				}
				else {
					HibernateUtils.changeInstanceLocale(chargerProperties());
				}

				/*
				if(HibernateUtils.isConnecteLocal()){
					configParamSqlLocal.getConfigLabelImage().setIcon(configParamSqlLocal.getValide());
				}
				else {
					configParamSqlLocal.getConfigLabelImage().setIcon(configParamSqlLocal.getInvalide());
				}
				 */

				disableData();
				
				btnUpdate.setText("Update");
				
				afficherInfos();
			}
		});
		
		lblPasswordvisible.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				passwordField.setEchoChar('*');
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				passwordField.setEchoChar((char) 0);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});

	}

	public void initComponents(Application application) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 150, 30, 0, 0, 0, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblConfigtitre = new JLabel("Configuration Base de Données");
		lblConfigtitre.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		GridBagConstraints gbc_lblConfigtitre = new GridBagConstraints();
		gbc_lblConfigtitre.gridwidth = 5;
		gbc_lblConfigtitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfigtitre.gridx = 1;
		gbc_lblConfigtitre.gridy = 1;
		add(lblConfigtitre, gbc_lblConfigtitre);

		lblEtat = new JLabel("Etat");
		GridBagConstraints gbc_lblEtat = new GridBagConstraints();
		gbc_lblEtat.insets = new Insets(0, 0, 5, 5);
		gbc_lblEtat.gridx = 6;
		gbc_lblEtat.gridy = 1;
		add(lblEtat, gbc_lblEtat);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridwidth = 6;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 3;
		add(tabbedPane, gbc_tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab(Options.getInstance(application).getSource(), null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{20, 0, 25, 0, 0, 0, 20, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		lblDriver = new JLabel("Driver");
		GridBagConstraints gbc_lblDriver = new GridBagConstraints();
		gbc_lblDriver.insets = new Insets(0, 0, 5, 5);
		gbc_lblDriver.gridx = 1;
		gbc_lblDriver.gridy = 1;
		panel.add(lblDriver, gbc_lblDriver);

		textFieldDriver = new JTextField();
		GridBagConstraints gbc_textFieldDriver = new GridBagConstraints();
		gbc_textFieldDriver.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDriver.gridwidth = 3;
		gbc_textFieldDriver.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDriver.gridx = 3;
		gbc_textFieldDriver.gridy = 1;
		panel.add(textFieldDriver, gbc_textFieldDriver);
		textFieldDriver.setColumns(10);

		lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 3;
		panel.add(lblAdresse, gbc_lblAdresse);

		textFieldAdresse = new JTextField();
		GridBagConstraints gbc_textFieldAdresse = new GridBagConstraints();
		gbc_textFieldAdresse.gridwidth = 3;
		gbc_textFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse.gridx = 3;
		gbc_textFieldAdresse.gridy = 3;
		panel.add(textFieldAdresse, gbc_textFieldAdresse);
		textFieldAdresse.setColumns(10);

		lblUtilisateur = new JLabel("Utilisateur");
		GridBagConstraints gbc_lblUtilisateur = new GridBagConstraints();
		gbc_lblUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtilisateur.gridx = 1;
		gbc_lblUtilisateur.gridy = 5;
		panel.add(lblUtilisateur, gbc_lblUtilisateur);

		textFieldUtilisateur = new JTextField();
		GridBagConstraints gbc_textFieldUtilisateur = new GridBagConstraints();
		gbc_textFieldUtilisateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUtilisateur.gridx = 3;
		gbc_textFieldUtilisateur.gridy = 5;
		panel.add(textFieldUtilisateur, gbc_textFieldUtilisateur);
		textFieldUtilisateur.setColumns(10);

		lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 7;
		panel.add(lblPassword, gbc_lblPassword);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 7;
		panel.add(passwordField, gbc_passwordField);

		lblPasswordvisible = new JLabel(new ImageIcon(this.getClass().getResource("/sections/options/images/oeil.png")));
		lblPasswordvisible.setMaximumSize(new Dimension(20, 20));
		GridBagConstraints gbc_lblPasswordvisible = new GridBagConstraints();
		gbc_lblPasswordvisible.anchor = GridBagConstraints.WEST;
		gbc_lblPasswordvisible.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswordvisible.gridx = 4;
		gbc_lblPasswordvisible.gridy = 7;
		panel.add(lblPasswordvisible, gbc_lblPasswordvisible);

		lblSesouvenir = new JLabel("Se Souvenir");
		GridBagConstraints gbc_lblSesouvenir = new GridBagConstraints();
		gbc_lblSesouvenir.insets = new Insets(0, 0, 5, 5);
		gbc_lblSesouvenir.gridx = 1;
		gbc_lblSesouvenir.gridy = 9;
		panel.add(lblSesouvenir, gbc_lblSesouvenir);

		chckbxSesouvenir = new JCheckBox("");
		GridBagConstraints gbc_chckbxSesouvenir = new GridBagConstraints();
		gbc_chckbxSesouvenir.anchor = GridBagConstraints.WEST;
		gbc_chckbxSesouvenir.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSesouvenir.gridx = 3;
		gbc_chckbxSesouvenir.gridy = 9;
		panel.add(chckbxSesouvenir, gbc_chckbxSesouvenir);
		chckbxSesouvenir.setSelected(true);

		btnUpdate = new JButton("Update");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdate.gridx = 4;
		gbc_btnUpdate.gridy = 11;
		panel.add(btnUpdate, gbc_btnUpdate);

		btnValider = new JButton("Valider");
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 0, 5);
		gbc_btnValider.gridx = 5;
		gbc_btnValider.gridy = 11;
		panel.add(btnValider, gbc_btnValider);
	}



	public void initValue() {

		disableData();
		if("local".equalsIgnoreCase(source)) {
			textFieldDriver.setText(ConnexionTemporaire.getInstance().getLocalDriver());
			textFieldAdresse.setText(ConnexionTemporaire.getInstance().getLocalAdresse());
			textFieldUtilisateur.setText(ConnexionTemporaire.getInstance().getLocalUtilisateur());
			passwordField.setText(ConnexionTemporaire.getInstance().getLocalPassword());
		}
		else if("master".equalsIgnoreCase(source)) {
			textFieldDriver.setText(ConnexionTemporaire.getInstance().getMasterDriver());
			textFieldAdresse.setText(ConnexionTemporaire.getInstance().getMasterAdresse());
			textFieldUtilisateur.setText(ConnexionTemporaire.getInstance().getMasterUtilisateur());
			passwordField.setText(ConnexionTemporaire.getInstance().getMasterPassword());
		}
		else {
			logger.error("Source non connue");
		}

		textFieldDriver.setCaretPosition(0);
		textFieldAdresse.setCaretPosition(0);
		textFieldUtilisateur.setCaretPosition(0);
		passwordField.setCaretPosition(0);

		/*
		if(HibernateUtils.isConnecteLocal()){
			configParamSqlLocal.getConfigLabelImage().setIcon(configParamSqlLocal.getValide());
		}
		else {
			configParamSqlLocal.getConfigLabelImage().setIcon(configParamSqlLocal.getInvalide());
		}
		 */
	}


	public Properties chargerProperties() {
		
		if("local".equalsIgnoreCase(source)) {
			ConnexionTemporaire.getInstance().setLocalDriver(textFieldDriver.getText());
			ConnexionTemporaire.getInstance().setLocalAdresse(textFieldAdresse.getText());
			ConnexionTemporaire.getInstance().setLocalUtilisateur(textFieldUtilisateur.getText());
			ConnexionTemporaire.getInstance().setLocalPassword(new String(passwordField.getPassword()));
		}
		else if("master".equalsIgnoreCase(source)) {
			ConnexionTemporaire.getInstance().setMasterDriver(textFieldDriver.getText());
			ConnexionTemporaire.getInstance().setMasterAdresse(textFieldAdresse.getText());
			ConnexionTemporaire.getInstance().setMasterUtilisateur(textFieldUtilisateur.getText());
			ConnexionTemporaire.getInstance().setMasterPassword(new String(passwordField.getPassword()));
		}
		else {
			logger.error("Source non connue");
		}
		
		properties = new Properties();

		properties.setProperty("hibernate.connection.driver_class", textFieldDriver.getText());
		properties.setProperty("hibernate.connection.url", textFieldAdresse.getText());
		properties.setProperty("hibernate.connection.username", textFieldUtilisateur.getText());
		properties.setProperty("hibernate.connection.password", new String(passwordField.getPassword()));

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.connection.pool_size", "10");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");

		return properties;
	}


	public void updateProperties() throws IOException {
		
		if("local".equalsIgnoreCase(source)) {
			ConnexionTemporaire.getInstance().setLocalDriver(textFieldDriver.getText());
			ConnexionTemporaire.getInstance().setLocalAdresse(textFieldAdresse.getText());
			ConnexionTemporaire.getInstance().setLocalUtilisateur(textFieldUtilisateur.getText());
			ConnexionTemporaire.getInstance().setLocalPassword(new String(passwordField.getPassword()));
		}
		else if("master".equalsIgnoreCase(source)) {
			ConnexionTemporaire.getInstance().setMasterDriver(textFieldDriver.getText());
			ConnexionTemporaire.getInstance().setMasterAdresse(textFieldAdresse.getText());
			ConnexionTemporaire.getInstance().setMasterUtilisateur(textFieldUtilisateur.getText());
			ConnexionTemporaire.getInstance().setMasterPassword(new String(passwordField.getPassword()));
		}
		else {
			logger.error("Source non connue");
		}

		properties = new Properties();

		properties.setProperty("hibernate.connection.driver_class", textFieldDriver.getText());
		properties.setProperty("hibernate.connection.url", textFieldAdresse.getText());
		properties.setProperty("hibernate.connection.username", textFieldUtilisateur.getText());
		properties.setProperty("hibernate.connection.password", new String(passwordField.getPassword()));

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.connection.pool_size", "10");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");

		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/" + fichier)));
		} catch (FileNotFoundException ex) {
			logger.error("Problème d'écriture dans le fichier de propriétés");
		}

		properties.store(out, "");

		out.close();
	}




	public void enableData() {
		textFieldDriver.setEnabled(true);
		textFieldAdresse.setEnabled(true);
		textFieldUtilisateur.setEnabled(true);
		passwordField.setEnabled(true);
		lblPasswordvisible.setEnabled(true);
		chckbxSesouvenir.setEnabled(true);
		btnValider.setEnabled(true);
	}

	public void disableData() {
		textFieldDriver.setEnabled(false);
		textFieldAdresse.setEnabled(false);
		textFieldUtilisateur.setEnabled(false);
		passwordField.setEnabled(false);
		lblPasswordvisible.setEnabled(false);
		chckbxSesouvenir.setEnabled(false);
		btnValider.setEnabled(false);
	}
	
	
	public void afficherInfos() {
		System.out.println("\n\n-----------------------------");
		System.out.println("\tL - Driver : *" + ConnexionTemporaire.getInstance().getLocalDriver() + "*");
		System.out.println("\tL - Adresse : *" + ConnexionTemporaire.getInstance().getLocalAdresse() + "*");
		System.out.println("\tL - User : *" + ConnexionTemporaire.getInstance().getLocalUtilisateur() + "*");
		System.out.println("\tL - Pass : *" + ConnexionTemporaire.getInstance().getLocalPassword() + "*");
		System.out.println();
		System.out.println("\tM - Driver : *" + ConnexionTemporaire.getInstance().getMasterDriver() + "*");
		System.out.println("\tM - Adresse : *" + ConnexionTemporaire.getInstance().getMasterAdresse() + "*");
		System.out.println("\tM - User : *" + ConnexionTemporaire.getInstance().getMasterUtilisateur() + "*");
		System.out.println("\tM - Pass : *" + ConnexionTemporaire.getInstance().getMasterPassword() + "*");
		System.out.println("-----------------------------\n\n");
	}
}
