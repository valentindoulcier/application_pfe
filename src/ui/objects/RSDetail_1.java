package ui.objects;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */
public class RSDetail_1 extends JPanel {

	private static final long serialVersionUID = -3876783685613141646L;
	
	//private static Logger logger = Logger.getLogger(RSDetail_1.class);
	
	private JLabel lblMot;

	/**
	 * Create the panel.
	 */
	public RSDetail_1() {
		setLayout(null);
		setPreferredSize(new Dimension(400, 25));
		
		initComponents();
	}
	
	public void initComponents() {
		lblMot = new JLabel("Mot");
		lblMot.setBounds(6, 6, 116, 13);
		add(lblMot);
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
}
