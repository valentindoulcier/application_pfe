/**
 * 
 */
package sections.updateBDD.ui.volets;

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
public class VoletHeaderUpdate extends JPanel {

	private static final long serialVersionUID = -7448173838345482989L;
	
	private JLabel lblRecherche;

	/**
	 * Create the panel.
	 */
	public VoletHeaderUpdate() {
		
		initComponents();

	}
	
	public void initComponents() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		setLayout(null);
		
		lblRecherche = new JLabel("Historique");
		lblRecherche.setForeground(Color.WHITE);
		lblRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecherche.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		lblRecherche.setBounds(6, 6, 288, 18);
		add(lblRecherche);
	}

}
