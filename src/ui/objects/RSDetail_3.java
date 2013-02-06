package ui.objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */
public class RSDetail_3 extends JPanel {

	private static final long serialVersionUID = -5360839512350231888L;
	
	//private static Logger logger = Logger.getLogger(RSDetail_3.class);
	
	private JLabel lblMot;
	private JLabel lblNewLabel;
	
	/**
	 * Create the panel.
	 */
	public RSDetail_3() {
		setLayout(null);
		
		setPreferredSize(new Dimension(400, 80));
		
		initComponents();
	
	}
	
	public void initComponents() {
		lblMot = new JLabel("New label");
		lblMot.setBounds(6, 6, 388, 16);
		add(lblMot);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(45, 25, 349, 16);
		add(lblNewLabel);
	}

	/**
	 * @param e
	 */
	public void mousePressed(MouseEvent e) {
		setBackground(Color.BLUE);
		System.out.println("Je suis cliqué : " + lblMot.getText());
		
	}

	/**
	 * @param arg0
	 */
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		setBackground(Color.ORANGE);
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
	 * @return the lblNewLabel
	 */
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	/**
	 * @param lblNewLabel the lblNewLabel to set
	 */
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

}
