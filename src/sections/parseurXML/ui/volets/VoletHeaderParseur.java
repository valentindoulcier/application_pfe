/**
 * 
 */
package sections.parseurXML.ui.volets;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletHeaderParseur extends JPanel {

	private static final long serialVersionUID = 8159876948413571398L;
	
	private JLabel lblRecherche;

	/**
	 * Create the panel.
	 */
	public VoletHeaderParseur() {
		
		initComponents();

	}
	
	public void initComponents() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		setLayout(null);
		
		lblRecherche = new JLabel("Parseur XML");
		lblRecherche.setForeground(Color.WHITE);
		lblRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecherche.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		lblRecherche.setBounds(6, 6, 288, 18);
		add(lblRecherche);
	}
}
