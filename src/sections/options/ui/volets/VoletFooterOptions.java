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
public class VoletFooterOptions extends JPanel {

	private static final long serialVersionUID = 4283262447681658276L;

	/**
	 * Create the panel.
	 */
	public VoletFooterOptions() {
		
		initComponents();

	}
	
	public void initComponents() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
	}

}
