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
public class VoletHeaderHistorique extends JPanel {

	private static final long serialVersionUID = -7448173838345482989L;
	
	private JLabel lblHistorique;

	/**
	 * Create the panel.
	 */
	public VoletHeaderHistorique() {
		
		initComponents();

	}
	
	public void initComponents() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		setLayout(null);
		
		lblHistorique = new JLabel("Historique");
		lblHistorique.setForeground(Color.WHITE);
		lblHistorique.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistorique.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		lblHistorique.setBounds(6, 6, 288, 18);
		add(lblHistorique);
	}

}
