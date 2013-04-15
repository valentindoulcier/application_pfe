/**
 * 
 */
package sections.bddictionnairique.ui.contents;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import sections.bddictionnairique.objects.EditionVolet_1;

import database.Headword;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentEdition extends JPanel {

	private static final long serialVersionUID = 8909943175984135265L;
	
	private Headword headword;
	
	private JTabbedPane tabbedPaneEdition;
	
	private EditionVolet_1 volet_1;
	private EditionVolet_1 volet_2;
	private EditionVolet_1 volet_3;
	private EditionVolet_1 volet_4;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentEdition() {

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
		
		volet_1 = new EditionVolet_1();
		volet_2 = new EditionVolet_1();
		volet_3 = new EditionVolet_1();
		volet_4 = new EditionVolet_1();
		
		tabbedPaneEdition.add("Volet 1", volet_1);
		tabbedPaneEdition.add("Volet 2", volet_2);
		tabbedPaneEdition.add("Volet 3", volet_3);
		tabbedPaneEdition.add("Volet 4", volet_4);
		
		add(tabbedPaneEdition, gbc_tabbedPaneEdition);
	}
	
	public void chargerData() {
		volet_1.getLblMot().setText("Le mot étudié est " + headword.getMot() + ", son id est " + headword.getIdHeadword());
	}

	/**
	 * @return the headword
	 */
	public Headword getHeadword() {
		return headword;
	}

	/**
	 * @param headword the headword to set
	 */
	public void setHeadword(Headword headword) {
		this.headword = headword;
	}

}
