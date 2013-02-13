/**
 * 
 */
package ui.mainframes.volets;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * @author Valentin
 *
 */
public class VoletHeaderRecherche extends JPanel {

	private static final long serialVersionUID = 8159876948413571398L;

	/**
	 * Create the panel.
	 */
	public VoletHeaderRecherche() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		setLayout(null);
		
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setForeground(Color.WHITE);
		lblRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecherche.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		lblRecherche.setBounds(6, 6, 288, 18);
		add(lblRecherche);

	}
}
