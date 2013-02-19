/**
 * 
 */
package ui.mainframes.contents;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import principal.Application;
import principal.Recherche;
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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.JButton;

import org.apache.log4j.Logger;

import dao.HeadwordDAO;
import database.AvoirPourCategorieHeadword;
import database.Headword;
import database.ListeCategories;
import database.Syllabes;

/**
 * @author Valentin
 *
 */
public class ContentRechercheSimple extends JPanel {

	private static final long serialVersionUID = 848524817828466211L;
	
	private static Logger logger = Logger.getLogger(ContentRechercheSimple.class);
	
	private JTextField textFieldRecherche;
	
	private JButton btnRechercher;

	private GridBagLayout gridBagLayout;

	private ExpandingPanels expandingPanels;
	
	private JPanel resultat;
	
	private GridBagConstraints gbc_result;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentRechercheSimple(final Application application) {
		
		initComponents();
		
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.debug("On lance la recherche");
				enregistrerRecherche(application);
				afficherRecherche(application, application.getMesRecherches().size() - 1);
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
		
		resultat = new JPanel();
		GridBagConstraints gbc_resultat = new GridBagConstraints();
		gbc_resultat.gridwidth = 3;
		gbc_resultat.insets = new Insets(0, 0, 5, 5);
		gbc_resultat.fill = GridBagConstraints.BOTH;
		gbc_resultat.gridx = 1;
		gbc_resultat.gridy = 3;
		add(resultat, gbc_resultat);
		
		GridBagLayout gbl_resultat = new GridBagLayout();
		gbl_resultat.columnWidths = new int[]{0, 0};
		gbl_resultat.rowHeights = new int[]{0, 0};
		gbl_resultat.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_resultat.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		resultat.setLayout(gbl_resultat);
		
		gbc_result = new GridBagConstraints();
		gbc_result.fill = GridBagConstraints.BOTH;
		gbc_result.gridx = 0;
		gbc_result.gridy = 0;
	}
	
	public void enregistrerRecherche(Application application) {
		
		Recherche maRecherche = new Recherche();
		
		maRecherche.setNumRecherche(application.getMesRecherches().size()+1);
		
		maRecherche.setDateRecherche(new Date());
		
		maRecherche.setMotRecherche(textFieldRecherche.getText());
		
		//int nbDictionnaires = application.getContentHome().getVoletRechercheSimple().getListeDicos().size();

		//for(int i = 0; i < nbDictionnaires; i++) {
		//	if(application.getContentHome().getVoletRechercheSimple().getDictionnairesRenderer().getListeItems().get(i).getChckbxDictionnaires().isSelected()) {
		//		maRecherche.getListeDictionnaire().add(application.getContentHome().getVoletRechercheSimple().getMenuRenderer().getListeItems().get(i).getChckbxDictionnaires().getText());
		//	}
		//}
		
		for(String dico : application.getContentHome().getVoletRechercheSimple().getListeDicos()) {
			maRecherche.getListeDictionnaire().add(dico);
		}
		
		HeadwordDAO headwords = new HeadwordDAO("local");

		for(String dictionnaire : maRecherche.getListeDictionnaire()) {
			
			List<?> mots = headwords.findExactly(textFieldRecherche.getText(), dictionnaire);
			
			for(Object headword : mots) {
				maRecherche.getListeResultat().put(((Headword) headword).getIdHeadword(), ((Headword) headword));
			}
		}
		
		application.getMesRecherches().add(maRecherche);
	}
	
	
	
	public void afficherRecherche(Application application, int numRecherche) {
		
		resultat.removeAll();
		
		ArrayList<String> dico = application.getMesRecherches().get(numRecherche).getListeDictionnaire();
		
		expandingPanels = new ExpandingPanels(dico.size());
		expandingPanels.clear();

		for(String dictionnaire : dico) {

			System.out.println("Ici de dico " + textFieldRecherche.getText() + "    " + dictionnaire);
			

			// DETAIL 1
			if (application.getContentHome().getVoletRechercheSimple().getSliderDetails().getValue() == application.getContentHome().getVoletRechercheSimple().getSliderDetails().getMinimum()) {
				
				Vector<RSDetail_1> listeMots = new Vector<RSDetail_1>();
				RSDetail_1 rsdetail_1;

				for(Object hw : application.getMesRecherches().get(numRecherche).getListeResultat().values()) {
					if(dictionnaire.equalsIgnoreCase(((Headword) hw).getDictionnaires().getNomDictionnaire())) {
						rsdetail_1 = new RSDetail_1(application);
						rsdetail_1.setIdHeadword(((Headword) hw).getIdHeadword());
						rsdetail_1.getLblMots().setText(((Headword) hw).getMot());
						listeMots.addElement(rsdetail_1);
					}
				}
				
				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), listeMots.size(), new MotsRenderer_1(application, listeMots));
			}
			// DETAIL 2
			else if (application.getContentHome().getVoletRechercheSimple().getSliderDetails().getValue() == (application.getContentHome().getVoletRechercheSimple().getSliderDetails().getMaximum())/2) {
				
				Vector<RSDetail_2> listeMots = new Vector<RSDetail_2>();

				RSDetail_2 rsdetail_2;

				for(Object hw : application.getMesRecherches().get(numRecherche).getListeResultat().values()) {
					if(dictionnaire.equalsIgnoreCase(((Headword) hw).getDictionnaires().getNomDictionnaire())) {
						rsdetail_2 = new RSDetail_2(application);
						rsdetail_2.setIdHeadword(((Headword) hw).getIdHeadword());
						rsdetail_2.getLblMots().setText(((Headword) hw).getMot());
						rsdetail_2.getLblCategories().setText(((Headword) hw).getMot());
						
						String cat = "Catégorie(s) : ";
						
						Set<?> test = ((Headword) hw).getAvoirPourCategorieHeadwords();
						
						Set<ListeCategories> test1 = new HashSet<ListeCategories>(0);
						
						for(Object object : test) {
								test1.add(((AvoirPourCategorieHeadword) object).getListeCategories());
						}
						
						for(Object object1 : test1) {
							cat += ((ListeCategories) object1).getNom();
							cat += "          ";
						}
						
						rsdetail_2.getLblCategories().setText(cat);
						
						for(Object object : ((Headword) hw).getSyllabeses()) {
						    System.out.println("Région : " + ((Syllabes) object).getRegion());
						    System.out.println("Schéma : " + ((Syllabes) object).getSchema());
						    System.out.println("Type : " + ((Syllabes) object).getTypePrononciation() + "\n");
						    
						    rsdetail_2.getLblRegion().setText("Région : " + ((Syllabes) object).getRegion());
						    rsdetail_2.getLblSchema().setText("Schéma : " + ((Syllabes) object).getSchema());
						    rsdetail_2.getLblType().setText("Type : " + ((Syllabes) object).getTypePrononciation());
						    
						    rsdetail_2.getLblSyllabes().setText("Syllabes : " + ((Syllabes) object).getSyllabe1() + "   " + ((Syllabes) object).getSyllabe2() + "   " + ((Syllabes) object).getSyllabe3() + "   " + ((Syllabes) object).getSyllabe4() + "   " + ((Syllabes) object).getSyllabe5() + "   " + ((Syllabes) object).getSyllabe6() + "   " + ((Syllabes) object).getSyllabe7() + "\t" + ((Syllabes) object).getSyllabe8() + "   " + ((Syllabes) object).getSyllabe9() + "   " + ((Syllabes) object).getSyllabe10());
						}
						
						listeMots.addElement(rsdetail_2);
					}
				}

				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), listeMots.size(), new MotsRenderer_2(application, listeMots));
			}
			// DETAIL 3
			else if (application.getContentHome().getVoletRechercheSimple().getSliderDetails().getValue() == application.getContentHome().getVoletRechercheSimple().getSliderDetails().getMaximum()) {
				
				Vector<RSDetail_3> listeMots = new Vector<RSDetail_3>();

				RSDetail_3 rsdetail_3;

				for(Object hw : application.getMesRecherches().get(numRecherche).getListeResultat().values()) {
					if(dictionnaire.equalsIgnoreCase(((Headword) hw).getDictionnaires().getNomDictionnaire())) {
						rsdetail_3 = new RSDetail_3(application);
						rsdetail_3.setIdHeadword(((Headword) hw).getIdHeadword());
						rsdetail_3.getLblMots().setText(((Headword) hw).getMot());
						listeMots.addElement(rsdetail_3);
					}
				}

				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), listeMots.size(), new MotsRenderer_3(application, listeMots));
			}
		}
		
		resultat.add(new JScrollPane(expandingPanels.getComponent()), gbc_result);
		this.revalidate();
	}

	/**
	 * @return the textFieldRecherche
	 */
	public JTextField getTextFieldRecherche() {
		return textFieldRecherche;
	}

	/**
	 * @param textFieldRecherche the textFieldRecherche to set
	 */
	public void setTextFieldRecherche(JTextField textFieldRecherche) {
		this.textFieldRecherche = textFieldRecherche;
	}

	/**
	 * @return the btnRechercher
	 */
	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	/**
	 * @param btnRechercher the btnRechercher to set
	 */
	public void setBtnRechercher(JButton btnRechercher) {
		this.btnRechercher = btnRechercher;
	}

	/**
	 * @return the gridBagLayout
	 */
	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	/**
	 * @param gridBagLayout the gridBagLayout to set
	 */
	public void setGridBagLayout(GridBagLayout gridBagLayout) {
		this.gridBagLayout = gridBagLayout;
	}

	/**
	 * @return the expandingPanels
	 */
	public ExpandingPanels getExpandingPanels() {
		return expandingPanels;
	}

	/**
	 * @param expandingPanels the expandingPanels to set
	 */
	public void setExpandingPanels(ExpandingPanels expandingPanels) {
		this.expandingPanels = expandingPanels;
	}

	/**
	 * @return the resultat
	 */
	public JPanel getResultat() {
		return resultat;
	}

	/**
	 * @param resultat the resultat to set
	 */
	public void setResultat(JPanel resultat) {
		this.resultat = resultat;
	}

	/**
	 * @return the gbc_result
	 */
	public GridBagConstraints getGbc_result() {
		return gbc_result;
	}

	/**
	 * @param gbc_result the gbc_result to set
	 */
	public void setGbc_result(GridBagConstraints gbc_result) {
		this.gbc_result = gbc_result;
	}

}



/*
	public void afficherRecherche(Application application) {
		
		resultat.removeAll();
		
		ArrayList<String> dico = new ArrayList<String>();
		int nbDictionnaires = application.getContentHome().getVoletRechercheSimple().getMenuRenderer().getListeItems().size();

		for(int i = 0; i < nbDictionnaires; i++) {
			if(application.getContentHome().getVoletRechercheSimple().getMenuRenderer().getListeItems().get(i).getChckbxDictionnaires().isSelected()) {
				dico.add(application.getContentHome().getVoletRechercheSimple().getMenuRenderer().getListeItems().get(i).getChckbxDictionnaires().getText());
			}
		}
		
		expandingPanels = new ExpandingPanels(dico.size());
		expandingPanels.clear();

		HeadwordDAO headwords = new HeadwordDAO("local");

		for(String dictionnaire : dico) {

			System.out.println("Ici de dico " + textFieldRecherche.getText() + "    " + dictionnaire);
			List<?> mots = headwords.findExactly(textFieldRecherche.getText(), dictionnaire);

			// DETAIL 1
			if (application.getContentHome().getVoletRechercheSimple().getSliderDetails().getValue() == application.getContentHome().getVoletRechercheSimple().getSliderDetails().getMinimum()) {
				
				Vector<RSDetail_1> listeMots = new Vector<RSDetail_1>();
				RSDetail_1 rsdetail_1;

				for(Object hw : mots) {
					rsdetail_1 = new RSDetail_1(application);
					rsdetail_1.setIdHeadword(((Headword) hw).getIdHeadword());
					rsdetail_1.getLblMots().setText(((Headword) hw).getMot());
					listeMots.addElement(rsdetail_1);
				}
				
				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), listeMots.size(), new MotsRenderer_1(application, listeMots));
			}
			// DETAIL 2
			else if (application.getContentHome().getVoletRechercheSimple().getSliderDetails().getValue() == (application.getContentHome().getVoletRechercheSimple().getSliderDetails().getMaximum())/2) {
				
				Vector<RSDetail_2> listeMots = new Vector<RSDetail_2>();

				RSDetail_2 rsdetail_2;

				for(Object hw : mots) {
					rsdetail_2 = new RSDetail_2(application);
					rsdetail_2.setIdHeadword(((Headword) hw).getIdHeadword());
					rsdetail_2.getLblMots().setText(((Headword) hw).getMot());
					listeMots.addElement(rsdetail_2);
				}

				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), listeMots.size(), new MotsRenderer_2(application, listeMots));
			}
			// DETAIL 3
			else if (application.getContentHome().getVoletRechercheSimple().getSliderDetails().getValue() == application.getContentHome().getVoletRechercheSimple().getSliderDetails().getMaximum()) {
				
				Vector<RSDetail_3> listeMots = new Vector<RSDetail_3>();

				RSDetail_3 rsdetail_3;

				for(Object hw : mots) {
					rsdetail_3 = new RSDetail_3(application);
					rsdetail_3.setIdHeadword(((Headword) hw).getIdHeadword());
					rsdetail_3.getLblMots().setText(((Headword) hw).getMot());
					listeMots.addElement(rsdetail_3);
				}

				this.expandingPanels.addVolet(dictionnaire.toUpperCase(), listeMots.size(), new MotsRenderer_3(application, listeMots));
			}
		}
		
		resultat.add(new JScrollPane(expandingPanels.getComponent()), gbc_result);
		this.revalidate();
	}
*/






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

