/**
 * 
 */
package sections.options.objects;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

/**
 * @author Valentin DOULCIER
 *
 */
public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = -7072796036596986133L;
	
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

	/**
	 * Create the panel.
	 */
	public ConfigPanel() {
		
		initComponents();

	}
	
	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 150, 30, 0, 0, 0, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		
		lblDriver = new JLabel("Driver");
		GridBagConstraints gbc_lblDriver = new GridBagConstraints();
		gbc_lblDriver.insets = new Insets(0, 0, 5, 5);
		gbc_lblDriver.gridx = 1;
		gbc_lblDriver.gridy = 4;
		add(lblDriver, gbc_lblDriver);
		
		textFieldDriver = new JTextField();
		GridBagConstraints gbc_textFieldDriver = new GridBagConstraints();
		gbc_textFieldDriver.gridwidth = 4;
		gbc_textFieldDriver.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDriver.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDriver.gridx = 3;
		gbc_textFieldDriver.gridy = 4;
		add(textFieldDriver, gbc_textFieldDriver);
		textFieldDriver.setColumns(10);
		
		lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 6;
		add(lblAdresse, gbc_lblAdresse);
		
		textFieldAdresse = new JTextField();
		GridBagConstraints gbc_textFieldAdresse = new GridBagConstraints();
		gbc_textFieldAdresse.gridwidth = 4;
		gbc_textFieldAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse.gridx = 3;
		gbc_textFieldAdresse.gridy = 6;
		add(textFieldAdresse, gbc_textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		lblUtilisateur = new JLabel("Utilisateur");
		GridBagConstraints gbc_lblUtilisateur = new GridBagConstraints();
		gbc_lblUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtilisateur.gridx = 1;
		gbc_lblUtilisateur.gridy = 8;
		add(lblUtilisateur, gbc_lblUtilisateur);
		
		textFieldUtilisateur = new JTextField();
		GridBagConstraints gbc_textFieldUtilisateur = new GridBagConstraints();
		gbc_textFieldUtilisateur.gridwidth = 2;
		gbc_textFieldUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUtilisateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUtilisateur.gridx = 3;
		gbc_textFieldUtilisateur.gridy = 8;
		add(textFieldUtilisateur, gbc_textFieldUtilisateur);
		textFieldUtilisateur.setColumns(10);
		
		lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 10;
		add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 10;
		add(passwordField, gbc_passwordField);
		
		lblSesouvenir = new JLabel("Se Souvenir");
		GridBagConstraints gbc_lblSesouvenir = new GridBagConstraints();
		gbc_lblSesouvenir.insets = new Insets(0, 0, 5, 5);
		gbc_lblSesouvenir.gridx = 1;
		gbc_lblSesouvenir.gridy = 12;
		add(lblSesouvenir, gbc_lblSesouvenir);
		
		chckbxSesouvenir = new JCheckBox("");
		chckbxSesouvenir.setSelected(true);
		GridBagConstraints gbc_chckbxSesouvenir = new GridBagConstraints();
		gbc_chckbxSesouvenir.anchor = GridBagConstraints.WEST;
		gbc_chckbxSesouvenir.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSesouvenir.gridx = 3;
		gbc_chckbxSesouvenir.gridy = 12;
		add(chckbxSesouvenir, gbc_chckbxSesouvenir);
		
		btnUpdate = new JButton("Update");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 4;
		gbc_btnUpdate.gridy = 14;
		add(btnUpdate, gbc_btnUpdate);
		
		btnValider = new JButton("Valider");
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.gridwidth = 2;
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 5;
		gbc_btnValider.gridy = 14;
		add(btnValider, gbc_btnValider);
	}

}
