/**
 * 
 */
package ui.mainframes.contents;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import principal.Application;
import ui.objects.ExpandingPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * @author Valentin
 *
 */
public class ContentHistorique extends JPanel {

	private static final long serialVersionUID = -3584920438752843211L;
	
	//private static Logger logger = Logger.getLogger(ContentHistorique.class);
	
	private GridBagLayout gridBagLayout;

	private ExpandingPanels expandingPanels;
	
	private JPanel resultat;
	
	private GridBagConstraints gbc_result;
	

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentHistorique(Application application) {
		
		initComponents();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	
	public void initComponents() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 20, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		resultat = new JPanel();
		GridBagConstraints gbc_resultat = new GridBagConstraints();
		gbc_resultat.gridwidth = 3;
		gbc_resultat.insets = new Insets(0, 0, 5, 5);
		gbc_resultat.fill = GridBagConstraints.BOTH;
		gbc_resultat.gridx = 1;
		gbc_resultat.gridy = 3;
		add(resultat, gbc_resultat);
		
		GridBagLayout gbl_resultat = new GridBagLayout();
		gbl_resultat.columnWidths = new int[]{0, 0};
		gbl_resultat.rowHeights = new int[]{0, 0};
		gbl_resultat.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_resultat.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		resultat.setLayout(gbl_resultat);
		
		gbc_result = new GridBagConstraints();
		gbc_result.fill = GridBagConstraints.BOTH;
		gbc_result.gridx = 0;
		gbc_result.gridy = 0;
	}

}
