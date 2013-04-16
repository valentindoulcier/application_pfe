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

/**
 * @author Valentin DOULCIER
 *
 */
public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = -7072796036596986133L;

	/**
	 * Create the panel.
	 */
	public ConfigPanel() {
		
		initComponents();

	}
	
	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblConfigtitre = new JLabel("Configuration Base de Données");
		lblConfigtitre.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		GridBagConstraints gbc_lblConfigtitre = new GridBagConstraints();
		gbc_lblConfigtitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfigtitre.gridx = 1;
		gbc_lblConfigtitre.gridy = 1;
		add(lblConfigtitre, gbc_lblConfigtitre);
	}

}
