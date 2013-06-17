/**
 * 
 */
package sections.options.ui.volets;

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
public class VoletHeaderOptions extends JPanel {

	private static final long serialVersionUID = 4813679165580993748L;
	
	private JLabel lblRecherche;

	/**
	 * Create the panel.
	 */
	public VoletHeaderOptions() {
		
		initComponents();

	}
	
	public void initComponents() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		setLayout(null);
		
		lblRecherche = new JLabel("Options");
		lblRecherche.setForeground(Color.WHITE);
		lblRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecherche.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		lblRecherche.setBounds(6, 6, 288, 18);
		add(lblRecherche);
	}

}
