package ui.objects;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */
public class RSDetail_2 extends JPanel {

	private static final long serialVersionUID = -3287414739952994994L;
	
	//private static Logger logger = Logger.getLogger(RSDetail_2.class);
	
	private JLabel lblMot;
	private JLabel lblDescription;

	/**
	 * Create the panel.
	 */
	public RSDetail_2() {
		setLayout(null);
		
		setPreferredSize(new Dimension(400, 60));
		
		lblMot = new JLabel("New label");
		lblMot.setBounds(6, 6, 388, 16);
		add(lblMot);
		
		lblDescription = new JLabel("New label");
		lblDescription.setBounds(45, 25, 349, 16);
		add(lblDescription);

	}

	/**
	 * @return the lblMot
	 */
	public JLabel getLblMot() {
		return lblMot;
	}

	/**
	 * @param lblMot the lblMot to set
	 */
	public void setLblMot(JLabel lblMot) {
		this.lblMot = lblMot;
	}

	/**
	 * @return the lblDescription
	 */
	public JLabel getLblDescription() {
		return lblDescription;
	}

	/**
	 * @param lblDescription the lblDescription to set
	 */
	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}

}
