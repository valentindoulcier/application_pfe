/**
 * 
 */
package principal.ui.contents;

import principal.Application;
import principal.objects.Login;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import sections.bddictionnairique.Bddictionnairique;

import sections.options.Options;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;


/**
 * @author Valentin DOULCIER
 *
 */
public class ContentHome extends JPanel {

	private static final long serialVersionUID = 8023381629976468353L;

	private JLayeredPane layeredPane;

	private JPanel panelApplication;

	private Login panelLogin;

	private JLabel lblApplication;

	private JLabel lblDescription;

	private JButton btnRecherche;

	private JButton btnOptions;



	/**
	 * Create the panel.
	 */
	public ContentHome(final Application application) {

		setBackground(Color.LIGHT_GRAY);

		initComponents(application);


		btnRecherche.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelLogin.masquerLogin();
				Bddictionnairique.getInstance(application).chargerBddictionnairique();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour effectuer une nouvelle recherche");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});


		btnOptions.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelLogin.masquerLogin();
				Options.getInstance(application).chargerOptions();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour accéder aux options");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void initComponents(final Application application) {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 120, 30, 120, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{240, 50, 20, 100, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		

		layeredPane = new JLayeredPane();
		GridBagConstraints gbc_layeredPane = new GridBagConstraints();
		gbc_layeredPane.gridwidth = 7;
		gbc_layeredPane.insets = new Insets(0, 0, 5, 0);
		gbc_layeredPane.fill = GridBagConstraints.BOTH;
		gbc_layeredPane.gridx = 0;
		gbc_layeredPane.gridy = 0;
		add(layeredPane, gbc_layeredPane);

		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWidths = new int[]{680, 0};
		gbl_layeredPane.rowHeights = new int[]{40, 100, 0};
		gbl_layeredPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_layeredPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		layeredPane.setLayout(gbl_layeredPane);

		panelLogin = new Login(application);
		panelLogin.setBorder(new LineBorder(new Color(67, 125, 212), 2, true));
		panelLogin.setVisible(false);
		panelLogin.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panelLogin = new GridBagConstraints();
		gbc_panelLogin.anchor = GridBagConstraints.NORTH;
		gbc_panelLogin.gridheight = 2;
		gbc_panelLogin.gridx = 0;
		gbc_panelLogin.gridy = 0;
		layeredPane.add(panelLogin, gbc_panelLogin);

		panelApplication = new JPanel();
		panelApplication.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panelApplication = new GridBagConstraints();
		gbc_panelApplication.gridheight = 2;
		gbc_panelApplication.fill = GridBagConstraints.BOTH;
		gbc_panelApplication.gridx = 0;
		gbc_panelApplication.gridy = 0;
		layeredPane.add(panelApplication, gbc_panelApplication);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panel.rowHeights = new int[]{30, 100, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelApplication.setLayout(gbl_panel);

		lblApplication = new JLabel("Laboratoire Ligérien de Linguistique");
		GridBagConstraints gbc_lblApplication = new GridBagConstraints();
		gbc_lblApplication.insets = new Insets(0, 0, 0, 5);
		gbc_lblApplication.gridx = 1;
		gbc_lblApplication.gridy = 1;
		panelApplication.add(lblApplication, gbc_lblApplication);
		lblApplication.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));

		lblDescription = new JLabel("");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.gridwidth = 3;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 2;
		gbc_lblDescription.gridy = 1;
		add(lblDescription, gbc_lblDescription);
		lblDescription.setFont(new Font("Lucida Grande", Font.ITALIC, 12));

		
		btnRecherche = new JButton("Recherche");
		btnRecherche.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnRecherche = new GridBagConstraints();
		gbc_btnRecherche.fill = GridBagConstraints.BOTH;
		gbc_btnRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecherche.gridx = 2;
		gbc_btnRecherche.gridy = 3;
		add(btnRecherche, gbc_btnRecherche);

		btnOptions = new JButton("Options");
		btnOptions.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnOptions = new GridBagConstraints();
		gbc_btnOptions.fill = GridBagConstraints.BOTH;
		gbc_btnOptions.insets = new Insets(0, 0, 5, 5);
		gbc_btnOptions.gridx = 4;
		gbc_btnOptions.gridy = 3;
		add(btnOptions, gbc_btnOptions);
	}

	/**
	 * @return the layeredPane
	 */
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	/**
	 * @param layeredPane the layeredPane to set
	 */
	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	/**
	 * @return the panelApplication
	 */
	public JPanel getPanelApplication() {
		return panelApplication;
	}

	/**
	 * @param panelApplication the panelApplication to set
	 */
	public void setPanelApplication(JPanel panelApplication) {
		this.panelApplication = panelApplication;
	}

	/**
	 * @return the panelLogin
	 */
	public Login getPanelLogin() {
		return panelLogin;
	}

	/**
	 * @param panelLogin the panelLogin to set
	 */
	public void setPanelLogin(Login panelLogin) {
		this.panelLogin = panelLogin;
	}

	/**
	 * @return the lblApplication
	 */
	public JLabel getLblApplication() {
		return lblApplication;
	}

	/**
	 * @param lblApplication the lblApplication to set
	 */
	public void setLblApplication(JLabel lblApplication) {
		this.lblApplication = lblApplication;
	}

	/**
	 * @return the lblDescription
	 */
	public JLabel getLblDescription() {
		return lblDescription;
	}

	/**
	 * @param lblDescription the lblDescription to set
	 */
	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}

	/**
	 * @return the btnRecherche
	 */
	public JButton getBtnRecherche() {
		return btnRecherche;
	}

	/**
	 * @param btnRecherche the btnRecherche to set
	 */
	public void setBtnRecherche(JButton btnRecherche) {
		this.btnRecherche = btnRecherche;
	}

	/**
	 * @return the btnOptions
	 */
	public JButton getBtnOptions() {
		return btnOptions;
	}

	/**
	 * @param btnOptions the btnOptions to set
	 */
	public void setBtnOptions(JButton btnOptions) {
		this.btnOptions = btnOptions;
	}
}
