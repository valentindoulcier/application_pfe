/**
 * 
 */
package principal.ui.contents;

import principal.Application;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import administration.Administration;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentFooterHome extends JPanel {

	private static final long serialVersionUID = -8539195195154159463L;
	
	private GridBagLayout gridBagLayout;
	
	private JButton btnAdministration;
	
	public ContentFooterHome(final Application application) {
		
		initComponents();
		
		btnAdministration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				application.dechargerApplication();
				Administration.getInstance(application).chargerLogin();
			}
		});
		
	}
	
	public void initComponents() {
		setBackground(Color.GRAY);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnAdministration = new JButton("Administration");
		GridBagConstraints gbc_btnAdministration = new GridBagConstraints();
		gbc_btnAdministration.anchor = GridBagConstraints.EAST;
		gbc_btnAdministration.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdministration.gridx = 1;
		gbc_btnAdministration.gridy = 0;
		add(btnAdministration, gbc_btnAdministration);
	}

	/**
	 * @return the btnAdministration
	 */
	public JButton getBtnAdministration() {
		return btnAdministration;
	}

	/**
	 * @param btnAdministration the btnAdministration to set
	 */
	public void setBtnAdministration(JButton btnAdministration) {
		this.btnAdministration = btnAdministration;
	}

}
