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
public class VoletSynchronisation extends JPanel {

	private static final long serialVersionUID = 5602083805686564474L;

	/**
	 * Create the panel.
	 */
	public VoletSynchronisation() {
		
		initComponents();

	}
	
	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540)); 
	}

}
