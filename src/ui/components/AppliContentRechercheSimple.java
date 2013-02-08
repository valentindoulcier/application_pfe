package ui.components;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import org.apache.log4j.Logger;

import ui.mainframes.LayerApplication;
import ui.objects.ExpandingPanels;

import java.awt.Color;
import java.awt.GridBagLayout;

import renderers.*;

import dao.*;
import database.*;
import ui.objects.*;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author Valentin
 *
 */
public class AppliContentRechercheSimple extends JPanel {

	private static final long serialVersionUID = -6948901479750294821L;
	
	//private static Logger logger = Logger.getLogger(AppliContentRechercheSimple.class);

	private JScrollPane jScrollPane = new JScrollPane();
	
	private GridBagLayout gridBagLayout;
	
	private GridBagConstraints gbc_panel;

	private ExpandingPanels expandingPanels;

	/**
	 * Create the panel.
	 */
	public AppliContentRechercheSimple() {

		initComponents();

	}


	public void initComponents() {
		setBackground(Color.ORANGE);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		
		setLayout(gridBagLayout);
		
		gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
	}

	public void afficherRecherche(LayerApplication layerApplication) {

		removeAll();

		ArrayList<String> dico = new ArrayList<String>();
		int nbDictionnaires = layerApplication.getAppliMenuRechercheSimple().getMenuRenderer().getListeItems().size();

		for(int i = 0; i < nbDictionnaires; i++) {
			if(layerApplication.getAppliMenuRechercheSimple().getMenuRenderer().getListeItems().get(i).getChckbxDictionnaires().isSelected()) {
				dico.add(layerApplication.getAppliMenuRechercheSimple().getMenuRenderer().getListeItems().get(i).getChckbxDictionnaires().getText());
			}
		}

		expandingPanels = new ExpandingPanels(dico.size());
		expandingPanels.clear();

		HeadwordDAO headwords = new HeadwordDAO("local");

		for(String dictionnaire : dico) {

			System.out.println("Ici de dico " + layerApplication.getTextFieldRecherche().getText() + "    " + dictionnaire);
			List<?> mots = headwords.findExactly(layerApplication.getTextFieldRecherche().getText(), dictionnaire);

			// DETAIL 1
			if (layerApplication.getSliderDetails().getValue() == layerApplication.getSliderDetails().getMinimum()) {

				System.out.println("NB MOTS : " + mots.size());
				
				Vector<RSDetail_1> listeMots = new Vector<RSDetail_1>();
				RSDetail_1 rsdetail_1;

				for(Object hw : mots) {
					rsdetail_1 = new RSDetail_1(layerApplication);
					rsdetail_1.setIdHeadword(((Headword) hw).getIdHeadword());
					rsdetail_1.getLblMots().setText(((Headword) hw).getMot());
					listeMots.addElement(rsdetail_1);
				}
				
				System.out.println("TAILLE 1 : " + listeMots.size());
				
				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), new MotsRenderer_1(layerApplication, listeMots));
				//this.expandingPanels.addVolet(dictionnaire.toUpperCase(), new ComponentTable(listeMots));
			}
			// DETAIL 2
			else if (layerApplication.getSliderDetails().getValue() == (layerApplication.getSliderDetails().getMaximum())/2) {
				Vector<RSDetail_2> listeMots = new Vector<RSDetail_2>();

				RSDetail_2 rsdetail_2;

				for(Object hw : mots) {
					rsdetail_2 = new RSDetail_2(layerApplication);
					rsdetail_2.setIdHeadword(((Headword) hw).getIdHeadword());
					rsdetail_2.getLblMots().setText(((Headword) hw).getMot());
					listeMots.addElement(rsdetail_2);
				}

				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), new MotsRenderer_2(layerApplication, listeMots));
			}
			// DETAIL 3
			else if (layerApplication.getSliderDetails().getValue() == layerApplication.getSliderDetails().getMaximum()) {
				Vector<RSDetail_3> listeMots = new Vector<RSDetail_3>();

				RSDetail_3 rsdetail_3;

				for(Object hw : mots) {
					rsdetail_3 = new RSDetail_3(layerApplication);
					rsdetail_3.setIdHeadword(((Headword) hw).getIdHeadword());
					rsdetail_3.getLblMots().setText(((Headword) hw).getMot());
					listeMots.addElement(rsdetail_3);
				}

				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), new MotsRenderer_3(layerApplication, listeMots));
			}


		}

		add(new JScrollPane(expandingPanels.getComponent()), gbc_panel);
	}

	
	public JScrollPane getjScrollPane() {
		return jScrollPane;
	}

	public void setjScrollPane(JScrollPane jScrollPane) {
		this.jScrollPane = jScrollPane;
	}

	public ExpandingPanels getExpandingPanels() {
		return expandingPanels;
	}

	public void setExpandingPanels(ExpandingPanels expandingPanels) {
		this.expandingPanels = expandingPanels;
	}

}














/*
 *  public static void main(String[] args)
    {
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,1,2,1);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        JPanel p1 = new JPanel(new GridBagLayout());
        gbc.gridwidth = gbc.RELATIVE;
        p1.add(new JButton("button 1"), gbc);
        gbc.gridwidth = gbc.REMAINDER;
        p1.add(new JButton("button 2"), gbc);
        gbc.gridwidth = gbc.RELATIVE;
        p1.add(new JButton("button 3"), gbc);
        gbc.gridwidth = gbc.REMAINDER;
        p1.add(new JButton("button 4"), gbc);

        JPanel p2 = new JPanel(new GridBagLayout());
        gbc.gridwidth = 1;
        gbc.anchor = gbc.EAST;
        p2.add(new JLabel("enter"), gbc);
        gbc.anchor = gbc.WEST;
        p2.add(new JTextField(8), gbc);
        gbc.anchor = gbc.CENTER;
        p2.add(new JButton("button 1"), gbc);
        gbc.gridwidth = gbc.REMAINDER;
        p2.add(new JButton("button 2"), gbc);

        JPanel p3 = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(8,12);
        textArea.setLineWrap(true);
        p3.add(new JScrollPane(textArea));

        JPanel p5 = new JPanel(new GridBagLayout());
        p5.add(new JButton("button 1"), gbc);
        p5.add(new JButton("button 2"), gbc);
        p5.add(new JButton("button 3"), gbc);
        p5.add(new JButton("button 4"), gbc);
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;



        Test test = new Test(4);

        test.addVolet("Bonjour", p1);
        test.addVolet("Salut", p2);
        test.addVolet("Hallo", p3);
        test.addVolet("Hello", p5);



        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new JScrollPane(test.getComponent()));
        f.setSize(360,500);
        f.setLocation(200,100);
        f.setVisible(true);
    }
 */
