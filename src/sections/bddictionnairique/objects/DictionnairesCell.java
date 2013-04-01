package sections.bddictionnairique.objects;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JCheckBox;

import principal.Application;

import sections.bddictionnairique.Bddictionnairique;
import sections.bddictionnairique.renderers.Caract_Dictionnaire;

//import org.apache.log4j.Logger;

/**
 * @author Valentin DOULCIER
 *
 */
public class DictionnairesCell extends JPanel {

	private static final long serialVersionUID = 5855332653312823192L;
	
	//private static Logger logger = Logger.getLogger(RSMenuListe.class);
	
	private int num;
	
	private JCheckBox chckbxDictionnaire;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public DictionnairesCell(final Application application) {
		setLayout(null);
		setPreferredSize(new Dimension(165, 30));
		
		initComponents();
		
		chckbxDictionnaire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxDictionnaire.isSelected()) {
					System.out.println("JE SELECT");
					chckbxDictionnaire.setSelected(true);
					Bddictionnairique.getInstance(application).getVoletRechercheSimple().getListeDicos().put(num, chckbxDictionnaire.getText());
				}
				else {
					System.out.println("JE DE SELECT");
					chckbxDictionnaire.setSelected(false);
					Bddictionnairique.getInstance(application).getVoletRechercheSimple().getListeDicos().remove(num);
				}
			}
		});

	}
	
	public void initComponents() {
		chckbxDictionnaire = new JCheckBox("Dictionnaire");
		chckbxDictionnaire.setSelected(true);
		chckbxDictionnaire.setBounds(6, 6, 153, 18);
		add(chckbxDictionnaire);
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	public JCheckBox getChckbxDictionnaires() {
		return chckbxDictionnaire;
	}

	public void setChckbxDictionnaires(JCheckBox chckbxDictionnaire) {
		this.chckbxDictionnaire = chckbxDictionnaire;
	}
	
	public void setCaract(Caract_Dictionnaire caract) {
		num = caract.num;
		chckbxDictionnaire.setText(caract.dictionnaire);
		chckbxDictionnaire.setSelected(caract.selected);
	}

	public Caract_Dictionnaire getCaract() {
		return new Caract_Dictionnaire(num, chckbxDictionnaire.getText(), chckbxDictionnaire.isSelected());
	}

}
