/**
 * 
 */
package principal.ui.contents;

import principal.Application;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import sections.bddictionnairique.Bddictionnairique;

import sections.options.Options;
import sections.synchronisation.Synchronisation;


/**
 * @author Valentin DOULCIER
 *
 */
public class ContentHome extends JPanel {

	private static final long serialVersionUID = 8023381629976468353L;

	private JLabel lblApplication;

	private JLabel lblDescription;

	private JButton btnRecherche;
	private JButton btnOptions;
	private JButton btnSynchronisation;
	private JLabel lblLogo;
	

	/**
	 * Create the panel.
	 */
	public ContentHome(final Application application) {
		
		initComponents();

		btnSynchronisation.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour synchroniser votre base de données");
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Synchronisation.getInstance(application).chargerSynchronisation();
			}
		});
		
		
		btnRecherche.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				//if(new SynchronisationDAO("local").isGoodDatabase()) {
				Bddictionnairique.getInstance(application).chargerBddictionnairique();
				//}
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

	public void initComponents() {

		setBackground(Color.LIGHT_GRAY);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 120, 30, 120, 30, 120, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 56, 45, 30, 10, 100, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 2.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblApplication = new JLabel("Laboratoire Ligérien de Linguistique");
		lblApplication.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		GridBagConstraints gbc_lblApplication = new GridBagConstraints();
		gbc_lblApplication.gridwidth = 5;
		gbc_lblApplication.insets = new Insets(0, 0, 5, 5);
		gbc_lblApplication.gridx = 2;
		gbc_lblApplication.gridy = 1;
		add(lblApplication, gbc_lblApplication);
		
		lblLogo = new JLabel(new ImageIcon("src/principal/images/logo.png"));
		lblLogo.setMaximumSize(new Dimension(120, 120));
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogo.gridx = 4;
		gbc_lblLogo.gridy = 2;
		add(lblLogo, gbc_lblLogo);

		lblDescription = new JLabel("");
		lblDescription.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.gridwidth = 5;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 2;
		gbc_lblDescription.gridy = 3;
		add(lblDescription, gbc_lblDescription);

		btnSynchronisation = new JButton("Synchro");
		GridBagConstraints gbc_btnSynchronisation = new GridBagConstraints();
		gbc_btnSynchronisation.fill = GridBagConstraints.BOTH;
		gbc_btnSynchronisation.insets = new Insets(0, 0, 5, 5);
		gbc_btnSynchronisation.gridx = 2;
		gbc_btnSynchronisation.gridy = 5;
		add(btnSynchronisation, gbc_btnSynchronisation);

		btnRecherche = new JButton("Recherche");
		btnRecherche.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnRecherche = new GridBagConstraints();
		gbc_btnRecherche.fill = GridBagConstraints.BOTH;
		gbc_btnRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecherche.gridx = 4;
		gbc_btnRecherche.gridy = 5;
		add(btnRecherche, gbc_btnRecherche);

		btnOptions = new JButton("Options");
		btnOptions.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnOptions = new GridBagConstraints();
		gbc_btnOptions.fill = GridBagConstraints.BOTH;
		gbc_btnOptions.insets = new Insets(0, 0, 5, 5);
		gbc_btnOptions.gridx = 6;
		gbc_btnOptions.gridy = 5;
		add(btnOptions, gbc_btnOptions);
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
	 * @return the btnSynchronisation
	 */
	public JButton getBtnSynchronisation() {
		return btnSynchronisation;
	}

	/**
	 * @param btnSynchronisation the btnSynchronisation to set
	 */
	public void setBtnSynchronisation(JButton btnSynchronisation) {
		this.btnSynchronisation = btnSynchronisation;
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