/**
 * 
 */
package sections.options.ui.volets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletOptions extends JPanel {

	private static final long serialVersionUID = -2569046900134042036L;

	/**
	 * Create the panel.
	 */
	public VoletOptions() {
		
		initComponents();
		
	}
	
	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540));
	}

}
