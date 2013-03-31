package sections.options.components;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */
public class ConfigParamSql extends JPanel {

	private static final long serialVersionUID = -4182978053014203936L;
	
	//private static Logger logger = Logger.getLogger(ConfigParamSql.class);

	private GridBagLayout gridBagLayout;
	
	private JLabel configLabelDriver;
	private JLabel configLabelURL;
	private JLabel configLabelUser;
	private JLabel configLabelPassword;
	private JLabel configLabelEtat;
	private JLabel configLabelImage;

	private ImageIcon valide = new ImageIcon("src/ui/pictures/ok.png");
	private ImageIcon invalide = new ImageIcon("src/ui/pictures/ko.png");

	private JTextField configFieldDriver;
	private JTextField configFieldURL;
	private JTextField configFieldUser;
	private JPasswordField configFieldPassword;
	
	private JButton configButtonUpdate;
	private JButton configButtonValider;
	

	/**
	 * Create the panel.
	 */
	public ConfigParamSql() {
		
		setSize(445, 368);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 75, 27, 100, 50, 50, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 20, 0, 20, 0, 20, 25, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		configLabelDriver = new JLabel("Driver");
		GridBagConstraints gbc_lblDriver = new GridBagConstraints();
		gbc_lblDriver.anchor = GridBagConstraints.WEST;
		gbc_lblDriver.insets = new Insets(0, 0, 5, 5);
		gbc_lblDriver.gridx = 1;
		gbc_lblDriver.gridy = 1;
		add(configLabelDriver, gbc_lblDriver);
		
		configFieldDriver = new JTextField();
		GridBagConstraints gbc_fieldDriver = new GridBagConstraints();
		gbc_fieldDriver.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldDriver.gridwidth = 3;
		gbc_fieldDriver.insets = new Insets(0, 0, 5, 5);
		gbc_fieldDriver.gridx = 3;
		gbc_fieldDriver.gridy = 1;
		add(configFieldDriver, gbc_fieldDriver);
		configFieldDriver.setColumns(10);
		
		configLabelURL = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.WEST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 3;
		add(configLabelURL, gbc_lblAdresse);
		
		configFieldURL = new JTextField();
		GridBagConstraints gbc_fieldAdresse = new GridBagConstraints();
		gbc_fieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldAdresse.gridwidth = 3;
		gbc_fieldAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_fieldAdresse.gridx = 3;
		gbc_fieldAdresse.gridy = 3;
		add(configFieldURL, gbc_fieldAdresse);
		configFieldURL.setColumns(10);
		
		configLabelUser = new JLabel("Utilisateur");
		GridBagConstraints gbc_lblUser1 = new GridBagConstraints();
		gbc_lblUser1.anchor = GridBagConstraints.WEST;
		gbc_lblUser1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser1.gridx = 1;
		gbc_lblUser1.gridy = 5;
		add(configLabelUser, gbc_lblUser1);
		
		configFieldUser = new JTextField();
		GridBagConstraints gbc_fieldUser = new GridBagConstraints();
		gbc_fieldUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldUser.gridwidth = 2;
		gbc_fieldUser.insets = new Insets(0, 0, 5, 5);
		gbc_fieldUser.gridx = 3;
		gbc_fieldUser.gridy = 5;
		add(configFieldUser, gbc_fieldUser);
		configFieldUser.setColumns(10);
		
		configLabelPassword = new JLabel("Mot de passe");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 7;
		add(configLabelPassword, gbc_lblPassword);
		
		configFieldPassword = new JPasswordField();
		GridBagConstraints gbc_fieldPassword = new GridBagConstraints();
		gbc_fieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPassword.gridwidth = 2;
		gbc_fieldPassword.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPassword.gridx = 3;
		gbc_fieldPassword.gridy = 7;
		add(configFieldPassword, gbc_fieldPassword);
		configFieldPassword.setColumns(10);
		
		configLabelEtat = new JLabel("Etat");
		GridBagConstraints gbc_lblEtat = new GridBagConstraints();
		gbc_lblEtat.anchor = GridBagConstraints.WEST;
		gbc_lblEtat.insets = new Insets(0, 0, 5, 5);
		gbc_lblEtat.gridx = 1;
		gbc_lblEtat.gridy = 9;
		add(configLabelEtat, gbc_lblEtat);
		
		configLabelImage = new JLabel();
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 2;
		gbc_lblImage.gridy = 9;
		add(configLabelImage, gbc_lblImage);
		
		configButtonUpdate = new JButton("Update");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 4;
		gbc_btnUpdate.gridy = 10;
		add(configButtonUpdate, gbc_btnUpdate);
		
		configButtonValider = new JButton("Valider");
		configButtonValider.setEnabled(false);
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 5;
		gbc_btnValider.gridy = 10;
		add(configButtonValider, gbc_btnValider);

	}

	/**
	 * @return the gridBagLayout
	 */
	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	/**
	 * @param gridBagLayout the gridBagLayout to set
	 */
	public void setGridBagLayout(GridBagLayout gridBagLayout) {
		this.gridBagLayout = gridBagLayout;
	}

	/**
	 * @return the configLabelDriver
	 */
	public JLabel getConfigLabelDriver() {
		return configLabelDriver;
	}

	/**
	 * @param configLabelDriver the configLabelDriver to set
	 */
	public void setConfigLabelDriver(JLabel configLabelDriver) {
		this.configLabelDriver = configLabelDriver;
	}

	/**
	 * @return the configLabelURL
	 */
	public JLabel getConfigLabelURL() {
		return configLabelURL;
	}

	/**
	 * @param configLabelURL the configLabelURL to set
	 */
	public void setConfigLabelURL(JLabel configLabelURL) {
		this.configLabelURL = configLabelURL;
	}

	/**
	 * @return the configLabelUser
	 */
	public JLabel getConfigLabelUser() {
		return configLabelUser;
	}

	/**
	 * @param configLabelUser the configLabelUser to set
	 */
	public void setConfigLabelUser(JLabel configLabelUser) {
		this.configLabelUser = configLabelUser;
	}

	/**
	 * @return the configLabelPassword
	 */
	public JLabel getConfigLabelPassword() {
		return configLabelPassword;
	}

	/**
	 * @param configLabelPassword the configLabelPassword to set
	 */
	public void setConfigLabelPassword(JLabel configLabelPassword) {
		this.configLabelPassword = configLabelPassword;
	}
	
	/**
	 * @return the configLabelImage
	 */
	public JLabel getConfigLabelImage() {
		return configLabelImage;
	}

	/**
	 * @param configLabelImage the configLabelImage to set
	 */
	public void setConfigLabelImage(JLabel configLabelImage) {
		this.configLabelImage = configLabelImage;
	}

	/**
	 * @return the configFieldDriver
	 */
	public JTextField getConfigFieldDriver() {
		return configFieldDriver;
	}

	/**
	 * @param configFieldDriver the configFieldDriver to set
	 */
	public void setConfigFieldDriver(JTextField configFieldDriver) {
		this.configFieldDriver = configFieldDriver;
	}

	/**
	 * @return the configFieldURL
	 */
	public JTextField getConfigFieldURL() {
		return configFieldURL;
	}

	/**
	 * @param configFieldURL the configFieldURL to set
	 */
	public void setConfigFieldURL(JTextField configFieldURL) {
		this.configFieldURL = configFieldURL;
	}

	/**
	 * @return the configFieldUser
	 */
	public JTextField getConfigFieldUser() {
		return configFieldUser;
	}

	/**
	 * @param configFieldUser the configFieldUser to set
	 */
	public void setConfigFieldUser(JTextField configFieldUser) {
		this.configFieldUser = configFieldUser;
	}

	/**
	 * @return the configFieldPassword
	 */
	public JTextField getConfigFieldPassword() {
		return configFieldPassword;
	}

	/**
	 * @param configFieldPassword the configFieldPassword to set
	 */
	public void setConfigFieldPassword(JPasswordField configFieldPassword) {
		this.configFieldPassword = configFieldPassword;
	}

	/**
	 * @return the configButtonUpdate
	 */
	public JButton getConfigButtonUpdate() {
		return configButtonUpdate;
	}

	/**
	 * @param configButtonUpdate the configButtonUpdate to set
	 */
	public void setConfigButtonUpdate(JButton configButtonUpdate) {
		this.configButtonUpdate = configButtonUpdate;
	}

	/**
	 * @return the configButtonValider
	 */
	public JButton getConfigButtonValider() {
		return configButtonValider;
	}

	/**
	 * @param configButtonValider the configButtonValider to set
	 */
	public void setConfigButtonValider(JButton configButtonValider) {
		this.configButtonValider = configButtonValider;
	}

	public ImageIcon getValide() {
		return valide;
	}

	public void setValide(ImageIcon valide) {
		this.valide = valide;
	}

	public ImageIcon getInvalide() {
		return invalide;
	}

	public void setInvalide(ImageIcon invalide) {
		this.invalide = invalide;
	}

}
