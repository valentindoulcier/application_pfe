/**
 * 
 */
package sections.synchronisation.ui.volets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletFooterSynchronisation extends JPanel {

	private static final long serialVersionUID = 8980949469341459934L;

	/**
	 * Create the panel.
	 */
	public VoletFooterSynchronisation() {
		
		initComponents();

	}
	
	public void initComponents() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
	}

}
