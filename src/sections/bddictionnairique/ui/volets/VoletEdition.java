/**
 * 
 */
package sections.bddictionnairique.ui.volets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import principal.Application;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletEdition extends JPanel {

	private static final long serialVersionUID = -4425749701304403558L;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletEdition(Application application) {
		
		initComponents();

	}
	
	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540));
	}

}
