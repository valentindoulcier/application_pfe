/**
 * 
 */
package administration.ui.contents;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import administration.Administration;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import principal.Application;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentHeaderAdministration extends JPanel {

	private static final long serialVersionUID = -7834873224766040031L;

	private GridBagLayout gridBagLayout;
	
	private JButton btnDeconnexion;
	
	private JLabel lblBienvenue;
	
	public ContentHeaderAdministration(final Application application) {
		
		initComponents();
		
		btnDeconnexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				application.dechargerApplication();
				application.chargerApplicationHome();
				
			}
		});

	}
	
	public void initComponents() {
		setBackground(Color.GRAY);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnDeconnexion = new JButton("Déconnexion");
		GridBagConstraints gbc_btnDeconnexion = new GridBagConstraints();
		gbc_btnDeconnexion.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeconnexion.gridx = 0;
		gbc_btnDeconnexion.gridy = 0;
		add(btnDeconnexion, gbc_btnDeconnexion);
		
		lblBienvenue = new JLabel("Bienvenue " + Administration.getUser().getNom());
		GridBagConstraints gbc_lblBienvenue = new GridBagConstraints();
		gbc_lblBienvenue.gridx = 1;
		gbc_lblBienvenue.gridy = 0;
		add(lblBienvenue, gbc_lblBienvenue);
	}
}
