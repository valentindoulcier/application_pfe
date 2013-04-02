/**
 * 
 */
package principal.objects;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import dao.UtilisateurDAO;
import database.Utilisateur;

import principal.Application;
import utils.MD5Password;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

/**
 * @author Valentin DOULCIER
 *
 */
public class Login extends JPanel {

	private static final long serialVersionUID = -8022556526336031307L;

	private GridBagLayout gridBagLayout;
	
	private JLabel lblTitre;
	
	private JLabel lblinfoMessage;
	
	private JLabel lblEmail;
	
	private JTextField textFieldEmail;
	
	private JLabel lblPassword;
	
	private JPasswordField passwordField;
	
	private JButton btnAnnuler;
	
	private JButton btnValider;
	
	public Login(final Application application) {
		
		initComponents();
		
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				masquerLogin();
			}
		});
		
		btnValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblinfoMessage.setVisible(false);
				
				try {
					verifierUser();
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void initComponents() {
		this.setMinimumSize(new Dimension(450, 230));
		this.setPreferredSize(new Dimension(450, 230));
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 40, 0, 50, 0, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{20, 40, 30, 0, 10, 0, 15, 0, 15, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblTitre = new JLabel("Connexion");
		lblTitre.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.gridwidth = 5;
		gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre.gridx = 1;
		gbc_lblTitre.gridy = 1;
		add(lblTitre, gbc_lblTitre);
		
		lblinfoMessage = new JLabel("");
		lblinfoMessage.setVisible(false);
		GridBagConstraints gbc_lblinfoMessage = new GridBagConstraints();
		gbc_lblinfoMessage.gridwidth = 4;
		gbc_lblinfoMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblinfoMessage.gridx = 2;
		gbc_lblinfoMessage.gridy = 2;
		add(lblinfoMessage, gbc_lblinfoMessage);
		
		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 3;
		add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("");
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.gridwidth = 2;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 4;
		gbc_textFieldEmail.gridy = 3;
		add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 5;
		add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 5;
		add(passwordField, gbc_passwordField);
		
		btnAnnuler = new JButton("Annuler");
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 4;
		gbc_btnAnnuler.gridy = 7;
		add(btnAnnuler, gbc_btnAnnuler);
		
		btnValider = new JButton("Valider");
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 5;
		gbc_btnValider.gridy = 7;
		add(btnValider, gbc_btnValider);
	}
	
	public void afficherLogin() {
		this.setVisible(true);
		
		textFieldEmail.setText("valentin.doulcier@gmail.com");
		
		passwordField.setText("valentin");
	}
	
	public void masquerLogin() {
		this.setVisible(false);
		
		lblinfoMessage.setVisible(false);
		
		textFieldEmail.setText("");
		
		passwordField.setText("");
	}
	
	
	public boolean verifierUser() throws NoSuchAlgorithmException {		
		Utilisateur user = new UtilisateurDAO("local").findExactly(textFieldEmail.getText());
		
		if(user != null) {
			if(MD5Password.testPassword(String.valueOf(passwordField.getPassword()), user.getPassword())) {
				System.out.println("Mot de passe valide");
				if(user.isAdmin()) {
					lblinfoMessage.setText("WAHOUU : Good job !!");
					lblinfoMessage.setForeground(Color.BLUE);
					lblinfoMessage.setVisible(true);
					
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

}
