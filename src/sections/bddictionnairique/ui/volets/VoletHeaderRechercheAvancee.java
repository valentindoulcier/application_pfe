/**
 * 
 */
package sections.bddictionnairique.ui.volets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletHeaderRechercheAvancee extends JPanel {

	private static final long serialVersionUID = -8582378237543549926L;
	
	private JLabel lblRecherche;

	/**
	 * Create the panel.
	 */
	public VoletHeaderRechercheAvancee() {
		
		initComponents();
		
	}
	
	public void initComponents() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		setLayout(null);
		
		lblRecherche = new JLabel("Recherche Avancée");
		lblRecherche.setForeground(Color.WHITE);
		lblRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecherche.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		lblRecherche.setBounds(6, 6, 288, 18);
		add(lblRecherche);
	}

}
