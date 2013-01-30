/**
 * 
 */
package ui.mainframes;

import javax.swing.JPanel;

import principal.Application;

import java.awt.Color;

/**
 * @author Valentin
 *
 */
public class LayerApplication extends JPanel {

	private static final long serialVersionUID = -7537563501231664829L;

	public LayerApplication(final Application application) {

		initComponents(application);

	}
	
	
	public void initComponents(final Application application) {
		setBounds(100, 100, 800, 550);

		setBackground(Color.CYAN);
		setLayout(null);
	}
}
