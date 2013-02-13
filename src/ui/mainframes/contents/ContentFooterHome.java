/**
 * 
 */
package ui.mainframes.contents;

import javax.swing.JPanel;

import principal.Application;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JProgressBar;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

/**
 * @author Valentin
 *
 */
public class ContentFooterHome extends JPanel {

	private static final long serialVersionUID = -8539195195154159463L;
	
	public ContentFooterHome(final Application application) {
		setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 20, 50, 20, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblChargement = new JLabel("Chargement ...");
		GridBagConstraints gbc_lblChargement = new GridBagConstraints();
		gbc_lblChargement.anchor = GridBagConstraints.EAST;
		gbc_lblChargement.insets = new Insets(0, 0, 0, 5);
		gbc_lblChargement.gridx = 1;
		gbc_lblChargement.gridy = 0;
		add(lblChargement, gbc_lblChargement);
		
		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.insets = new Insets(0, 0, 0, 5);
		gbc_progressBar.gridx = 3;
		gbc_progressBar.gridy = 0;
		add(progressBar, gbc_progressBar);
	}

}
