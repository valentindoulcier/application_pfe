/**
 * 
 */
package sections.updateBDD.ui.volets;

import javax.swing.JPanel;

import principal.Application;

import java.awt.Color;
import java.awt.Dimension;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletFooterUpdate extends JPanel {

	private static final long serialVersionUID = 1129835814490832264L;


	/**
	 * Create the panel.
	 */
	public VoletFooterUpdate(final Application application) {

		initComponents();
	}

	public void initComponents() {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		setLayout(null);
	}
}
