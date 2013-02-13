/**
 * 
 */
package ui.mainframes.volets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import principal.Application;

/**
 * @author Valentin
 *
 */
public class VoletFooterEdition extends JPanel {

	private static final long serialVersionUID = -1208867908604626328L;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletFooterEdition(Application application) {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
	}

}
