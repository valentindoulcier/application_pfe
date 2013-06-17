/**
 * 
 */
package sections.parseurXML.ui.volets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;


/**
 * @author Valentin DOULCIER
 *
 */
public class VoletParseur extends JPanel {

	private static final long serialVersionUID = -7929534743664074552L;

	//private static Logger logger = Logger.getLogger(VoletParseur.class);
	
	private GridBagLayout gridBagLayout;
	
	private JTextArea textArea;
	
	
	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletParseur() {

		initComponents();
		
	}

	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540));
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText("Parseur XML :\n\n" +
				"Ce parseur XML a pour but de prendre en entrée un fichier XML correspondant à un dictionnaire, et de parser ce fichier afin de remplir la base de données de l'application principale.");
		textArea.setBackground(Color.LIGHT_GRAY);
		
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		add(textArea, gbc_textArea);

	}

}
