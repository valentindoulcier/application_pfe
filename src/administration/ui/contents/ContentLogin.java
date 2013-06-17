/**
 * 
 */
package administration.ui.contents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utils.MD5Password;
import dao.UtilisateurDAO;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import principal.Application;

import administration.Administration;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentLogin extends JPanel {

	private static final long serialVersionUID = 681705715507029512L;
	
	private GridBagLayout gridBagLayout;
	
	private JLabel lblTitre;
	
	private JLabel lblinfoMessage;
	
	private JLabel lblEmail;
	
	private JTextField textFieldEmail;
	
	private JLabel lblPassword;
	
	private JPasswordField passwordField;
	
	private JButton btnAnnuler;
	
	private JButton btnValider;
	private JPanel panel;

	public ContentLogin(final Application application) {
		
		initComponents();
		
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Administration.getInstance(application).dechargerLogin();
				application.dechargerApplication();
				application.chargerApplicationHome();
			}
		});
		
		btnValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblinfoMessage.setVisible(false);
				
				try {
					if(verifierUser(application)) {
						Administration.getInstance(application).chargerApplicationAdministration();
					}
					else {
						// BLOQUER INTRUSION INFRUCTUEUSE
					}
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 450, 30, 0};
		gridBagLayout.rowHeights = new int[]{20, 195, 15, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 40, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 40, 0, 10, 0, 15, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblTitre = new JLabel("Accès Administrateur");
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.gridwidth = 4;
		gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre.gridx = 1;
		gbc_lblTitre.gridy = 1;
		panel.add(lblTitre, gbc_lblTitre);
		lblTitre.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		
		lblinfoMessage = new JLabel("");
		GridBagConstraints gbc_lblinfoMessage = new GridBagConstraints();
		gbc_lblinfoMessage.gridwidth = 4;
		gbc_lblinfoMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblinfoMessage.gridx = 1;
		gbc_lblinfoMessage.gridy = 2;
		panel.add(lblinfoMessage, gbc_lblinfoMessage);
		lblinfoMessage.setVisible(false);
		
		lblEmail = new JLabel("Login");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 3;
		panel.add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridwidth = 2;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 3;
		gbc_textFieldEmail.gridy = 3;
		panel.add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setToolTipText("");
		textFieldEmail.setColumns(10);
		
		lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 5;
		panel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 5;
		panel.add(passwordField, gbc_passwordField);
		
		btnAnnuler = new JButton("Annuler");
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 3;
		gbc_btnAnnuler.gridy = 7;
		panel.add(btnAnnuler, gbc_btnAnnuler);
		
		btnValider = new JButton("Valider");
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 4;
		gbc_btnValider.gridy = 7;
		panel.add(btnValider, gbc_btnValider);
	}
	
	public void reinitialiserLogin() {
		lblinfoMessage.setText("");
		
		lblinfoMessage.setVisible(false);
		
		textFieldEmail.setText("");
		
		passwordField.setText("");
	}
	
	
	public boolean verifierUser(final Application application) throws NoSuchAlgorithmException {		
		Administration.setUser(new UtilisateurDAO("local").findExactly(textFieldEmail.getText()));
		
		if(Administration.getUser() != null) {
			if(MD5Password.testPassword(String.valueOf(passwordField.getPassword()), Administration.getUser().getPassword())) {
				System.out.println("Mot de passe valide");
				if(Administration.getUser().isAdmin()) {					
					reinitialiserLogin();
					Administration.getInstance(application).dechargerLogin();
					return true;
				}
				else {
					lblinfoMessage.setText("ATTENTION : Vous n'avez pas les droits d'admin");
					lblinfoMessage.setForeground(Color.RED);
					lblinfoMessage.setVisible(true);
					
					return false;
				}
			}
			else {
				lblinfoMessage.setText("WARNING : Wrong Password !!");
				lblinfoMessage.setForeground(Color.RED);
				lblinfoMessage.setVisible(true);
				
				return false;
			}
		}
		lblinfoMessage.setText("ERREUR : Authentification impossible");
		lblinfoMessage.setForeground(Color.RED);
		lblinfoMessage.setVisible(true);
		
		return false;
	}

	/**
	 * @return the lblTitre
	 */
	public JLabel getLblTitre() {
		return lblTitre;
	}

	/**
	 * @param lblTitre the lblTitre to set
	 */
	public void setLblTitre(JLabel lblTitre) {
		this.lblTitre = lblTitre;
	}

	/**
	 * @return the lblinfoMessage
	 */
	public JLabel getLblinfoMessage() {
		return lblinfoMessage;
	}

	/**
	 * @param lblinfoMessage the lblinfoMessage to set
	 */
	public void setLblinfoMessage(JLabel lblinfoMessage) {
		this.lblinfoMessage = lblinfoMessage;
	}

	/**
	 * @return the lblEmail
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * @param lblEmail the lblEmail to set
	 */
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	/**
	 * @return the textFieldEmail
	 */
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	/**
	 * @param textFieldEmail the textFieldEmail to set
	 */
	public void setTextFieldEmail(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}

	/**
	 * @return the lblPassword
	 */
	public JLabel getLblPassword() {
		return lblPassword;
	}

	/**
	 * @param lblPassword the lblPassword to set
	 */
	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	/**
	 * @return the passwordField
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	/**
	 * @param passwordField the passwordField to set
	 */
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	/**
	 * @return the btnAnnuler
	 */
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	/**
	 * @param btnAnnuler the btnAnnuler to set
	 */
	public void setBtnAnnuler(JButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	/**
	 * @return the btnValider
	 */
	public JButton getBtnValider() {
		return btnValider;
	}

	/**
	 * @param btnValider the btnValider to set
	 */
	public void setBtnValider(JButton btnValider) {
		this.btnValider = btnValider;
	}
}
