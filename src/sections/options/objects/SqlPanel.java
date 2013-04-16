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
public class SqlPanel extends JPanel {

	private static final long serialVersionUID = 3464789232583692787L;

	/**
	 * Create the panel.
	 */
	public SqlPanel() {

		initComponents();
		
	}
	
	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblSqltitre = new JLabel("Requêtes SQL");
		lblSqltitre.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		GridBagConstraints gbc_lblSqltitre = new GridBagConstraints();
		gbc_lblSqltitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblSqltitre.gridx = 1;
		gbc_lblSqltitre.gridy = 1;
		add(lblSqltitre, gbc_lblSqltitre);
	}

}
