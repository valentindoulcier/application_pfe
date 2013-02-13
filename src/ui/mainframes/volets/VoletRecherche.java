/**
 * 
 */
package ui.mainframes.volets;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

/**
 * @author Valentin
 *
 */
public class VoletRecherche extends JPanel {

	private static final long serialVersionUID = -7929534743664074552L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public VoletRecherche() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);

	}

}
