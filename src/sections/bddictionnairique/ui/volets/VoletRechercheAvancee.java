/**
 * 
 */
package sections.bddictionnairique.ui.volets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

//import org.apache.log4j.Logger;

import principal.Application;

/**
 * @author Valentin
 *
 */
public class VoletRechercheAvancee extends JPanel {

	private static final long serialVersionUID = 7997937547434852750L;

	//private static Logger logger = Logger.getLogger(VoletRechercheAvancee.class);


	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletRechercheAvancee(Application application) {

		initComponents();
		
	}

	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540));
		
	}
}
