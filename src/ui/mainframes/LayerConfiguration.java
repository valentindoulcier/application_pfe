package ui.mainframes;



import principal.Application;
import ui.components.ConfigParamSql;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;

//import org.apache.log4j.Logger;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import java.util.Properties;
import utils.HibernateUtils;


/**
 * @author Valentin
 *
 */
public class LayerConfiguration extends JPanel {

	private static final long serialVersionUID = -1316049476783153299L;
	
	//private static Logger logger = Logger.getLogger(LayerConfiguration.class);

	Object[] options = {"Instance unique", "Mettre à jour"};

	private ConfigParamSql configParamSqlLocal = new ConfigParamSql();
	private ConfigParamSql configParamSqlMaster = new ConfigParamSql();
	
	private ConfigSqlEditor configSqlEditorLocal = new ConfigSqlEditor();
	private ConfigSqlEditor configSqlEditorMaster = new ConfigSqlEditor();

	private Properties properties;
	
	private JTabbedPane tabbedPaneConfig;
	private JTabbedPane tabbedPaneRequetes;


	public LayerConfiguration(final Application application) {

		initComponents(application);
		initValueLocal();
		initValueMaster();

		configParamSqlLocal.getConfigButtonUpdate().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if("Update".equalsIgnoreCase(configParamSqlLocal.getConfigButtonUpdate().getText())) {
					enableLocal();
					configParamSqlLocal.getConfigButtonValider().setEnabled(true);
					configParamSqlLocal.getConfigButtonUpdate().setText("Annuler");
				}
				else if("Annuler".equalsIgnoreCase(configParamSqlLocal.getConfigButtonUpdate().getText())) {
					initValueLocal();
					disableLocal();
					configParamSqlLocal.getConfigButtonValider().setEnabled(false);
					configParamSqlLocal.getConfigButtonUpdate().setText("Update");
				}
			}
		});

		configParamSqlMaster.getConfigButtonUpdate().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if("Update".equalsIgnoreCase(configParamSqlMaster.getConfigButtonUpdate().getText())) {
					enableMaster();
					configParamSqlMaster.getConfigButtonValider().setEnabled(true);
					configParamSqlMaster.getConfigButtonUpdate().setText("Annuler");
				}
				else if("Annuler".equalsIgnoreCase(configParamSqlMaster.getConfigButtonUpdate().getText())) {
					initValueMaster();
					disableMaster();
					configParamSqlMaster.getConfigButtonValider().setEnabled(false);
					configParamSqlMaster.getConfigButtonUpdate().setText("Update");
				}
			}
		});



		configParamSqlLocal.getConfigButtonValider().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showOptionDialog(application,
						"Souhaitez-vous modifier les paramètres par défaut où\nutiliser ces paramètres pour cette instance uniquement ?",
						"Modification des paramètres",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE,
						null,     //do not use a custom Icon
						options,  //the titles of buttons
						options[0]); //default button title
				
				disableLocal();
				configParamSqlLocal.getConfigButtonUpdate().setEnabled(false);
				configParamSqlLocal.getConfigButtonValider().setEnabled(false);
				
				if(answer == 0) {
					HibernateUtils.changeInstanceLocale(chargerPropertiesLocal());
				}
				else if (answer == 1) {
					try {
						updatePropertiesLocal();
						HibernateUtils.deconnectionLocale();
						HibernateUtils.getInstanceLocale();
					} catch (IOException e1) {
						System.out.println("Listener Valider Local : " + e1.getMessage());
					}
				}
				
				if(HibernateUtils.isConnecteLocal()){
					configParamSqlLocal.getConfigLabelImage().setIcon(configParamSqlLocal.getValide());
				}
				else {
					configParamSqlLocal.getConfigLabelImage().setIcon(configParamSqlLocal.getInvalide());
				}
				
				configParamSqlLocal.getConfigButtonUpdate().setEnabled(true);
				configParamSqlLocal.getConfigButtonUpdate().setText("Update");
				
			}
		});

		configParamSqlMaster.getConfigButtonValider().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showOptionDialog(application,
						"Souhaitez-vous modifier les paramètres par défaut où\nutiliser ces paramètres pour cette instance uniquement ?",
						"Modification des paramètres",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE,
						null,     //do not use a custom Icon
						options,  //the titles of buttons
						options[0]); //default button title
				
				disableMaster();
				configParamSqlMaster.getConfigButtonUpdate().setEnabled(false);
				configParamSqlMaster.getConfigButtonValider().setEnabled(false);
				
				if(answer == 0) {
					HibernateUtils.changeInstanceMaster(chargerPropertiesMaster());
				}
				else if (answer == 1) {
					try {
						updatePropertiesMaster();
						HibernateUtils.deconnectionMaster();
						HibernateUtils.getInstanceMaster();
					} catch (IOException e1) {
						System.out.println("Listener Valider Master : " + e1.getMessage());
					}
				}
				
				if(HibernateUtils.isConnecteMaster()){
					configParamSqlMaster.getConfigLabelImage().setIcon(configParamSqlMaster.getValide());
				}
				else {
					configParamSqlMaster.getConfigLabelImage().setIcon(configParamSqlMaster.getInvalide());
				}

				configParamSqlMaster.getConfigButtonUpdate().setEnabled(true);
				configParamSqlMaster.getConfigButtonUpdate().setText("Update");
				
			}
		});
	}


	public void initComponents(final Application application) {
		//setBounds(100, 100, 800, 550);

		setPreferredSize(application.getSize());

		setBackground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 350, 20, 309, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 350, 20, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		tabbedPaneConfig = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPaneConfig = new GridBagConstraints();
		gbc_tabbedPaneConfig.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPaneConfig.fill = GridBagConstraints.BOTH;
		gbc_tabbedPaneConfig.gridx = 1;
		gbc_tabbedPaneConfig.gridy = 1;

		tabbedPaneConfig.addTab("Local", configParamSqlLocal);
		tabbedPaneConfig.addTab("Master", configParamSqlMaster);

		add(tabbedPaneConfig, gbc_tabbedPaneConfig);
		
		tabbedPaneRequetes = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPaneRequetes = new GridBagConstraints();
		gbc_tabbedPaneRequetes.gridheight = 3;
		gbc_tabbedPaneRequetes.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPaneRequetes.fill = GridBagConstraints.BOTH;
		gbc_tabbedPaneRequetes.gridx = 3;
		gbc_tabbedPaneRequetes.gridy = 1;
		add(tabbedPaneRequetes, gbc_tabbedPaneRequetes);
		
		tabbedPaneRequetes.addTab("Local", configSqlEditorLocal);
		tabbedPaneRequetes.addTab("Master", configSqlEditorMaster);
		
		add(tabbedPaneRequetes, gbc_tabbedPaneRequetes);
	}
	
	public Properties chargerPropertiesLocal() {
		properties = new Properties();

		properties.setProperty("hibernate.connection.driver_class", configParamSqlLocal.getConfigFieldDriver().getText());
		properties.setProperty("hibernate.connection.url", configParamSqlLocal.getConfigFieldURL().getText());
		properties.setProperty("hibernate.connection.username", configParamSqlLocal.getConfigFieldUser().getText());
		properties.setProperty("hibernate.connection.password", configParamSqlLocal.getConfigFieldPassword().getText());
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.connection.pool_size", "10");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		return properties;
	}
	
	public Properties chargerPropertiesMaster() {
		properties = new Properties();

		properties.setProperty("hibernate.connection.driver_class", configParamSqlMaster.getConfigFieldDriver().getText());
		properties.setProperty("hibernate.connection.url", configParamSqlMaster.getConfigFieldURL().getText());
		properties.setProperty("hibernate.connection.username", configParamSqlMaster.getConfigFieldUser().getText());
		properties.setProperty("hibernate.connection.password", configParamSqlMaster.getConfigFieldPassword().getText());
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.connection.pool_size", "10");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		return properties;
	}

	public void initValueLocal() {

		properties = new Properties();

		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernateLocal.properties");
			//Properties propertiesLocales = new Properties();
			properties.load(is);
			//properties.load(new FileReader("src/hibernateLocal.properties"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "initValueLocal : Fichier de configuration LOCAL introuvable:\n" + ex.getMessage());
		}

		disableLocal();

		configParamSqlLocal.getConfigFieldDriver().setText(properties.getProperty("hibernate.connection.driver_class"));
		configParamSqlLocal.getConfigFieldURL().setText(properties.getProperty("hibernate.connection.url"));
		configParamSqlLocal.getConfigFieldUser().setText(properties.getProperty("hibernate.connection.username"));
		configParamSqlLocal.getConfigFieldPassword().setText(properties.getProperty("hibernate.connection.password"));

		configParamSqlLocal.getConfigFieldDriver().setCaretPosition(0);
		configParamSqlLocal.getConfigFieldURL().setCaretPosition(0);
		configParamSqlLocal.getConfigFieldUser().setCaretPosition(0);
		configParamSqlLocal.getConfigFieldPassword().setCaretPosition(0);
		
		if(HibernateUtils.isConnecteLocal()){
			configParamSqlLocal.getConfigLabelImage().setIcon(configParamSqlLocal.getValide());
		}
		else {
			configParamSqlLocal.getConfigLabelImage().setIcon(configParamSqlLocal.getInvalide());
		}
	}


	public void initValueMaster() {

		properties = new Properties();

		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernateMaster.properties");
			//Properties propertiesLocales = new Properties();
			properties.load(is);
			//properties.load(new FileReader("src/hibernateMaster.properties"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "initValueMaster : Fichier de configuration MASTER introuvable:\n" + ex.getMessage());
		}

		disableMaster();

		configParamSqlMaster.getConfigFieldDriver().setText(properties.getProperty("hibernate.connection.driver_class"));
		configParamSqlMaster.getConfigFieldURL().setText(properties.getProperty("hibernate.connection.url"));
		configParamSqlMaster.getConfigFieldUser().setText(properties.getProperty("hibernate.connection.username"));
		configParamSqlMaster.getConfigFieldPassword().setText(properties.getProperty("hibernate.connection.password"));

		configParamSqlMaster.getConfigFieldDriver().setCaretPosition(0);
		configParamSqlMaster.getConfigFieldURL().setCaretPosition(0);
		configParamSqlMaster.getConfigFieldUser().setCaretPosition(0);
		configParamSqlMaster.getConfigFieldPassword().setCaretPosition(0);
		
		if(HibernateUtils.isConnecteMaster()){
			configParamSqlMaster.getConfigLabelImage().setIcon(configParamSqlMaster.getValide());
		}
		else {
			configParamSqlMaster.getConfigLabelImage().setIcon(configParamSqlMaster.getInvalide());
		}
	}


	public void updatePropertiesLocal() throws IOException {

		properties = new Properties();

		properties.setProperty("hibernate.connection.driver_class", configParamSqlLocal.getConfigFieldDriver().getText());
		properties.setProperty("hibernate.connection.url", configParamSqlLocal.getConfigFieldURL().getText());
		properties.setProperty("hibernate.connection.username", configParamSqlLocal.getConfigFieldUser().getText());
		properties.setProperty("hibernate.connection.password", configParamSqlLocal.getConfigFieldPassword().getText());
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.connection.pool_size", "10");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");

		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/hibernateLocal.properties")));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "updateValueLocal : Fichier de configuration LOCAL introuvable:\n" + ex.getMessage());
		}

		properties.store(out, "");

		out.close();
	}


	public void updatePropertiesMaster() throws IOException {

		properties = new Properties();

		properties.setProperty("hibernate.connection.driver_class", configParamSqlMaster.getConfigFieldDriver().getText());
		properties.setProperty("hibernate.connection.url", configParamSqlMaster.getConfigFieldURL().getText());
		properties.setProperty("hibernate.connection.username", configParamSqlMaster.getConfigFieldUser().getText());
		properties.setProperty("hibernate.connection.password", configParamSqlMaster.getConfigFieldPassword().getText());

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.connection.pool_size", "10");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/hibernateMaster.properties")));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "updateValueMaster : Fichier de configuration MASTER introuvable:\n" + ex.getMessage());
		}

		properties.store(out, "");

		out.close();
	}


	public void enableLocal() {
		configParamSqlLocal.getConfigFieldDriver().setEnabled(true);
		configParamSqlLocal.getConfigFieldURL().setEnabled(true);
		configParamSqlLocal.getConfigFieldUser().setEnabled(true);
		configParamSqlLocal.getConfigFieldPassword().setEnabled(true);
	}

	public void enableMaster() {
		configParamSqlMaster.getConfigFieldDriver().setEnabled(true);
		configParamSqlMaster.getConfigFieldURL().setEnabled(true);
		configParamSqlMaster.getConfigFieldUser().setEnabled(true);
		configParamSqlMaster.getConfigFieldPassword().setEnabled(true);
	}

	public void disableLocal() {
		configParamSqlLocal.getConfigFieldDriver().setEnabled(false);
		configParamSqlLocal.getConfigFieldURL().setEnabled(false);
		configParamSqlLocal.getConfigFieldUser().setEnabled(false);
		configParamSqlLocal.getConfigFieldPassword().setEnabled(false);
	}

	public void disableMaster() {
		configParamSqlMaster.getConfigFieldDriver().setEnabled(false);
		configParamSqlMaster.getConfigFieldURL().setEnabled(false);
		configParamSqlMaster.getConfigFieldUser().setEnabled(false);
		configParamSqlMaster.getConfigFieldPassword().setEnabled(false);
	}
}
