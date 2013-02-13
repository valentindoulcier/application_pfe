/**
 * 
 */
package ui.mainframes.contents;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import principal.Application;
import renderers.MotsRenderer_1;
import renderers.MotsRenderer_2;
import renderers.MotsRenderer_3;
import ui.objects.ExpandingPanels;
import ui.objects.RSDetail_1;
import ui.objects.RSDetail_2;
import ui.objects.RSDetail_3;

import java.awt.GridBagLayout;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;

import org.apache.log4j.Logger;

import dao.HeadwordDAO;
import database.Headword;

/**
 * @author Valentin
 *
 */
public class ContentRecherche extends JPanel {

	private static final long serialVersionUID = 848524817828466211L;
	
	private static Logger logger = Logger.getLogger(ContentRecherche.class);
	
	private JTextField textFieldRecherche;
	
	private JButton btnRechercher;

	private JScrollPane jScrollPane;

	private GridBagLayout gridBagLayout;

	private GridBagConstraints gbc_scrollPane;

	private ExpandingPanels expandingPanels;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentRecherche(final Application application) {
		
		initComponents();
		
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.debug("On lance la recherche");
				jScrollPane = new JScrollPane();
				jScrollPane.removeAll();
				afficherRecherche(application);
			}
		});

	}
	
	public void initComponents() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 20, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		textFieldRecherche = new JTextField();
		GridBagConstraints gbc_textFieldRecherche = new GridBagConstraints();
		gbc_textFieldRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRecherche.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRecherche.gridx = 1;
		gbc_textFieldRecherche.gridy = 1;
		add(textFieldRecherche, gbc_textFieldRecherche);
		textFieldRecherche.setColumns(10);

		btnRechercher = new JButton("Rechercher");
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercher.gridx = 3;
		gbc_btnRechercher.gridy = 1;
		add(btnRechercher, gbc_btnRechercher);
		
		jScrollPane = new JScrollPane();
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
	}
	
	
	public void afficherRecherche(Application application) {
		
		jScrollPane.removeAll();
		
		ArrayList<String> dico = new ArrayList<String>();
		int nbDictionnaires = application.getContentHome().getVoletRecherche().getMenuRenderer().getListeItems().size();

		for(int i = 0; i < nbDictionnaires; i++) {
			if(application.getContentHome().getVoletRecherche().getMenuRenderer().getListeItems().get(i).getChckbxDictionnaires().isSelected()) {
				dico.add(application.getContentHome().getVoletRecherche().getMenuRenderer().getListeItems().get(i).getChckbxDictionnaires().getText());
			}
		}
		
		expandingPanels = new ExpandingPanels(dico.size());
		expandingPanels.clear();

		HeadwordDAO headwords = new HeadwordDAO("local");

		for(String dictionnaire : dico) {

			System.out.println("Ici de dico " + textFieldRecherche.getText() + "    " + dictionnaire);
			List<?> mots = headwords.findExactly(textFieldRecherche.getText(), dictionnaire);

			// DETAIL 1
			if (application.getContentHome().getVoletRecherche().getSliderDetails().getValue() == application.getContentHome().getVoletRecherche().getSliderDetails().getMinimum()) {

				System.out.println("\t\tDETAIL 1");
				System.out.println("NB MOTS : " + mots.size());
				
				Vector<RSDetail_1> listeMots = new Vector<RSDetail_1>();
				RSDetail_1 rsdetail_1;

				for(Object hw : mots) {
					rsdetail_1 = new RSDetail_1(application);
					rsdetail_1.setIdHeadword(((Headword) hw).getIdHeadword());
					rsdetail_1.getLblMots().setText(((Headword) hw).getMot());
					listeMots.addElement(rsdetail_1);
				}
				
				System.out.println("TAILLE 1 : " + listeMots.size());
				
				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), new MotsRenderer_1(application, listeMots));
				//this.expandingPanels.addVolet(dictionnaire.toUpperCase(), new ComponentTable(listeMots));
			}
			// DETAIL 2
			else if (application.getContentHome().getVoletRecherche().getSliderDetails().getValue() == (application.getContentHome().getVoletRecherche().getSliderDetails().getMaximum())/2) {

				System.out.println("\t\tDETAIL 2");
				
				Vector<RSDetail_2> listeMots = new Vector<RSDetail_2>();

				RSDetail_2 rsdetail_2;

				for(Object hw : mots) {
					rsdetail_2 = new RSDetail_2(application);
					rsdetail_2.setIdHeadword(((Headword) hw).getIdHeadword());
					rsdetail_2.getLblMots().setText(((Headword) hw).getMot());
					listeMots.addElement(rsdetail_2);
				}

				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), new MotsRenderer_2(application, listeMots));
			}
			// DETAIL 3
			else if (application.getContentHome().getVoletRecherche().getSliderDetails().getValue() == application.getContentHome().getVoletRecherche().getSliderDetails().getMaximum()) {

				System.out.println("\t\tDETAIL 3");
				
				Vector<RSDetail_3> listeMots = new Vector<RSDetail_3>();

				RSDetail_3 rsdetail_3;

				for(Object hw : mots) {
					rsdetail_3 = new RSDetail_3(application);
					rsdetail_3.setIdHeadword(((Headword) hw).getIdHeadword());
					rsdetail_3.getLblMots().setText(((Headword) hw).getMot());
					listeMots.addElement(rsdetail_3);
				}

				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), new MotsRenderer_3(application, listeMots));
			}
		}
		
		add(new JScrollPane(expandingPanels.getComponent()), gbc_scrollPane);
		this.revalidate();
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

