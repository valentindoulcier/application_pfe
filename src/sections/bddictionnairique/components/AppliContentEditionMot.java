/*package sections.bddictionnairique.components;

import ui.mainframes.*;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;

*//**
 * @author Valentin
 *
 *//*
public class AppliContentEditionMot extends JPanel {

	private static final long serialVersionUID = 910554020450742573L;
	
	private JTabbedPane tabbedPaneEdition;
	
	private AppliContentEditionMotVolet_1 volet_1 = new AppliContentEditionMotVolet_1();

	*//**
	 * @return the volet_1
	 *//*
	public AppliContentEditionMotVolet_1 getVolet_1() {
		return volet_1;
	}


	*//**
	 * @param volet_1 the volet_1 to set
	 *//*
	public void setVolet_1(AppliContentEditionMotVolet_1 volet_1) {
		this.volet_1 = volet_1;
	}


	*//**
	 * Create the panel.
	 *//*
	public AppliContentEditionMot() {
		initComponents();
	}
	
	
	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		
		setLayout(gridBagLayout);
		
		tabbedPaneEdition = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPaneEdition = new GridBagConstraints();
		gbc_tabbedPaneEdition.fill = GridBagConstraints.BOTH;
		gbc_tabbedPaneEdition.gridx = 0;
		gbc_tabbedPaneEdition.gridy = 0;
		
		tabbedPaneEdition.add("Volet 1", volet_1);
		tabbedPaneEdition.add("Volet 2", volet_1);
		tabbedPaneEdition.add("Volet 3", volet_1);
		tabbedPaneEdition.add("Volet 4", volet_1);
		
		add(tabbedPaneEdition, gbc_tabbedPaneEdition);
	}

}
*/