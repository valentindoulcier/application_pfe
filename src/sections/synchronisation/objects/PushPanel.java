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
public class PushPanel extends JPanel {

	private static final long serialVersionUID = -4448168739092751278L;

	/**
	 * Create the panel.
	 */
	public PushPanel() {
		
		initComponents();

	}
	
	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitre = new JLabel("Valider mes modifications");
		lblTitre.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre.gridx = 1;
		gbc_lblTitre.gridy = 1;
		add(lblTitre, gbc_lblTitre);
	}

}
