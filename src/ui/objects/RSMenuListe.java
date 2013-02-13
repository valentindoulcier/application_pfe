package ui.objects;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JCheckBox;

//import org.apache.log4j.Logger;

/**
 * @author Valentin DOULCIER
 *
 */
public class RSMenuListe extends JPanel {

	private static final long serialVersionUID = 5855332653312823192L;
	
	//private static Logger logger = Logger.getLogger(RSMenuListe.class);
	
	private JCheckBox chckbxDictionnaire;

	/**
	 * Create the panel.
	 */
	public RSMenuListe() {
		setLayout(null);
		setPreferredSize(new Dimension(165, 30));
		
		initComponents();
	}
	
	public void initComponents() {
		chckbxDictionnaire = new JCheckBox("Dictionnaire");
		chckbxDictionnaire.setSelected(true);
		chckbxDictionnaire.setBounds(6, 6, 140, 18);
		add(chckbxDictionnaire);
	}

	public JCheckBox getChckbxDictionnaires() {
		return chckbxDictionnaire;
	}

	public void setChckbxDictionnaires(JCheckBox chckbxDictionnaire) {
		this.chckbxDictionnaire = chckbxDictionnaire;
	}

	/**
	 * @param arg0
	 */
	public void mousePressed(MouseEvent arg0) {
		
		//chckbxDictionnaire.setSelected(!chckbxDictionnaire.isSelected());
		
		if (chckbxDictionnaire.isSelected()) {
			chckbxDictionnaire.setSelected(false);
		}
		else {
			chckbxDictionnaire.setSelected(true);
		}
		this.revalidate();
	}

}
