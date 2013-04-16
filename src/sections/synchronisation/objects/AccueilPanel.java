/**
 * 
 */
package sections.synchronisation.objects;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Valentin DOULCIER
 *
 */
public class AccueilPanel extends JPanel {

	private static final long serialVersionUID = 6883145856903420102L;

	/**
	 * Create the panel.
	 */
	public AccueilPanel() {
		
		initComponents();
		
	}
	
	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 50, 0, 0, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitre = new JLabel("Module Synchronisation");
		lblTitre.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre.gridx = 1;
		gbc_lblTitre.gridy = 1;
		add(lblTitre, gbc_lblTitre);
		
		JLabel lblDescription = new JLabel("L'objectif de ce module est de gérer les mises à jour de votre application.");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.WEST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 3;
		add(lblDescription, gbc_lblDescription);
		
		JLabel lblDetail = new JLabel("Sélectionner l'action désirée en utilisant le volet de gauche, puis laissez-vous guider.");
		GridBagConstraints gbc_lblDetail = new GridBagConstraints();
		gbc_lblDetail.anchor = GridBagConstraints.WEST;
		gbc_lblDetail.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetail.gridx = 1;
		gbc_lblDetail.gridy = 4;
		add(lblDetail, gbc_lblDetail);
	}

}
