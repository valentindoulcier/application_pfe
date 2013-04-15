/**
 * 
 */
package sections.bddictionnairique.objects;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

/**
 * @author Valentin DOULCIER
 *
 */
public class EditionVolet_1 extends JPanel {

	private static final long serialVersionUID = -8715878684974838379L;
	
	private JLabel lblMot;

	/**
	 * Create the panel.
	 */
	public EditionVolet_1() {

		initComponents();
		
	}
	
	public void initComponents() {
		this.setBackground(Color.ORANGE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblMot = new JLabel("mot");
		GridBagConstraints gbc_lblMot = new GridBagConstraints();
		gbc_lblMot.gridx = 1;
		gbc_lblMot.gridy = 1;
		add(lblMot, gbc_lblMot);
	}

	/**
	 * @return the lblMot
	 */
	public JLabel getLblMot() {
		return lblMot;
	}

	/**
	 * @param lblMot the lblMot to set
	 */
	public void setLblMot(JLabel lblMot) {
		this.lblMot = lblMot;
	}

}
