/**
 * 
 */
package ui.mainframes.contents;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import database.AvoirPourCategorieHeadword;
import database.Headword;
import database.ListeCategories;
import database.Syllabes;

import principal.Application;
import principal.Recherche;
import renderers.MotsRenderer_1;
import renderers.MotsRenderer_2;
import renderers.MotsRenderer_3;
import ui.objects.ExpandingPanels;
import ui.objects.RSDetail_1;
import ui.objects.RSDetail_2;
import ui.objects.RSDetail_3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

/**
 * @author Valentin
 *
 */
public class ContentHistorique extends JPanel {

	private static final long serialVersionUID = -3584920438752843211L;
	
	//private static Logger logger = Logger.getLogger(ContentHistorique.class);
	
	private GridBagLayout gridBagLayoutInformations;
	
	private GridBagLayout gridBagLayoutResultats;

	
	private JPanel informations;
	private JLabel lblNumero;
	private JSlider sliderDetails;
	
	private JPanel resultat;
	private ExpandingPanels expandingPanels;
	private GridBagConstraints gbc_result;
	
	private int numRechercheEnCours;
	private JLabel lblMot;
	private JLabel lblDico;
	private JLabel lblCritere;
	private JLabel lblDans;
	private JLabel lblDatamot;
	private JLabel lblDatacritere;
	private JLabel lblDatadico;
	private JLabel lblDatadans;
	private JLabel lblDetail;
	

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentHistorique(final Application application) {
		
		initComponents();
		
		if(application.getMesRecherches().size() > 0)
			afficherRecherche(application, application.getMesRecherches().size() - 1);
		
		
		sliderDetails.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				afficherRecherche(application, numRechercheEnCours);
				lblDetail.setText("");
				if(sliderDetails.getValue() == 0)
	        	{
					lblDetail.setText("Détail : x");
	        	}
	        	else if(sliderDetails.getValue() == 50) {
	        		lblDetail.setText("Détail : xx");
	        	}
	        	else {
	        		lblDetail.setText("Détail : xxx");
	        	}
			}
		});
		
	}
	
	public void initComponents() {
		gridBagLayoutResultats = new GridBagLayout();
		gridBagLayoutResultats.columnWidths = new int[]{20, 0, 200, 20, 0};
		gridBagLayoutResultats.rowHeights = new int[]{20, 20, 30, 20, 0, 20, 0};
		gridBagLayoutResultats.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutResultats.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutResultats);
		
		informations = new JPanel();
		informations.setBorder(new LineBorder(SystemColor.textHighlight));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(informations, gbc_panel);
		
		gridBagLayoutInformations = new GridBagLayout();
		gridBagLayoutInformations.columnWidths = new int[]{5, 60, 130, 20, 50, 130, 20, 0};
		gridBagLayoutInformations.rowHeights = new int[]{5, 0, 0, 0, 3, 0};
		gridBagLayoutInformations.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutInformations.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		informations.setLayout(gridBagLayoutInformations);
		
		lblNumero = new JLabel("Numéro");
		lblNumero.setForeground(Color.GRAY);
		lblNumero.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		GridBagConstraints gbc_lblNumro = new GridBagConstraints();
		gbc_lblNumro.anchor = GridBagConstraints.WEST;
		gbc_lblNumro.gridwidth = 6;
		gbc_lblNumro.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumro.gridx = 1;
		gbc_lblNumro.gridy = 1;
		informations.add(lblNumero, gbc_lblNumro);
		
		lblMot = new JLabel("Mot :");
		lblMot.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblMot.setForeground(Color.GRAY);
		GridBagConstraints gbc_lblMot = new GridBagConstraints();
		gbc_lblMot.anchor = GridBagConstraints.WEST;
		gbc_lblMot.insets = new Insets(0, 0, 5, 5);
		gbc_lblMot.gridx = 1;
		gbc_lblMot.gridy = 2;
		informations.add(lblMot, gbc_lblMot);
		
		lblDatamot = new JLabel("dataMot");
		lblDatamot.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblDatamot = new GridBagConstraints();
		gbc_lblDatamot.anchor = GridBagConstraints.WEST;
		gbc_lblDatamot.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatamot.gridx = 2;
		gbc_lblDatamot.gridy = 2;
		informations.add(lblDatamot, gbc_lblDatamot);
		
		lblDico = new JLabel("Dico :");
		lblDico.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblDico.setForeground(Color.GRAY);
		GridBagConstraints gbc_lblDico = new GridBagConstraints();
		gbc_lblDico.anchor = GridBagConstraints.WEST;
		gbc_lblDico.insets = new Insets(0, 0, 5, 5);
		gbc_lblDico.gridx = 4;
		gbc_lblDico.gridy = 2;
		informations.add(lblDico, gbc_lblDico);
		
		lblDatadico = new JLabel("dataDico");
		GridBagConstraints gbc_lblDatadico = new GridBagConstraints();
		gbc_lblDatadico.anchor = GridBagConstraints.WEST;
		gbc_lblDatadico.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatadico.gridx = 5;
		gbc_lblDatadico.gridy = 2;
		informations.add(lblDatadico, gbc_lblDatadico);
		
		lblCritere = new JLabel("Critère :");
		lblCritere.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblCritere.setForeground(Color.GRAY);
		GridBagConstraints gbc_lblCritere = new GridBagConstraints();
		gbc_lblCritere.anchor = GridBagConstraints.WEST;
		gbc_lblCritere.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritere.gridx = 1;
		gbc_lblCritere.gridy = 3;
		informations.add(lblCritere, gbc_lblCritere);
		
		lblDatacritere = new JLabel("dataCritere");
		GridBagConstraints gbc_lblDatacritere = new GridBagConstraints();
		gbc_lblDatacritere.anchor = GridBagConstraints.WEST;
		gbc_lblDatacritere.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatacritere.gridx = 2;
		gbc_lblDatacritere.gridy = 3;
		informations.add(lblDatacritere, gbc_lblDatacritere);
		
		lblDans = new JLabel("Dans :");
		lblDans.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblDans.setForeground(Color.GRAY);
		GridBagConstraints gbc_lblDans = new GridBagConstraints();
		gbc_lblDans.anchor = GridBagConstraints.WEST;
		gbc_lblDans.insets = new Insets(0, 0, 5, 5);
		gbc_lblDans.gridx = 4;
		gbc_lblDans.gridy = 3;
		informations.add(lblDans, gbc_lblDans);
		
		lblDatadans = new JLabel("dataDans");
		GridBagConstraints gbc_lblDatadans = new GridBagConstraints();
		gbc_lblDatadans.anchor = GridBagConstraints.WEST;
		gbc_lblDatadans.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatadans.gridx = 5;
		gbc_lblDatadans.gridy = 3;
		informations.add(lblDatadans, gbc_lblDatadans);
		
		lblDetail = new JLabel("Détail : x");
		GridBagConstraints gbc_lblDetail = new GridBagConstraints();
		gbc_lblDetail.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetail.gridx = 2;
		gbc_lblDetail.gridy = 1;
		add(lblDetail, gbc_lblDetail);
		
		sliderDetails = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 20);
		sliderDetails.setSnapToTicks(true);
		sliderDetails.setPaintTicks(true);
		sliderDetails.setMinorTickSpacing(50);
		sliderDetails.setMajorTickSpacing(50);
		GridBagConstraints gbc_sliderDetails = new GridBagConstraints();
		gbc_sliderDetails.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderDetails.insets = new Insets(0, 0, 5, 5);
		gbc_sliderDetails.gridx = 2;
		gbc_sliderDetails.gridy = 2;
		add(sliderDetails, gbc_sliderDetails);
		
		resultat = new JPanel();
		GridBagConstraints gbc_resultat = new GridBagConstraints();
		gbc_resultat.gridwidth = 2;
		gbc_resultat.insets = new Insets(0, 0, 5, 5);
		gbc_resultat.fill = GridBagConstraints.BOTH;
		gbc_resultat.gridx = 1;
		gbc_resultat.gridy = 4;
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
	
	
	
public void afficherRecherche(Application application, int numRecherche) {
	
		numRechercheEnCours = numRecherche;
		resultat.removeAll();
		
		Recherche maRecherche = application.getMesRecherches().get(numRecherche);
		
		// Informations

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy ~ HH:mm:ss");
		
		lblNumero.setText("Recherche n° " + maRecherche.getNumRecherche() + " du " + simpleDateFormat.format(maRecherche.getDateRecherche()));
		
		lblDatamot.setText(maRecherche.getMotRecherche());
		
		lblDatacritere.setText(maRecherche.getCritereRecherche());
		
		
		String listeDico = "";
		for(String dico : maRecherche.getListeDictionnaire()) {
			listeDico += (dico.toUpperCase() + "   ");
		}
		lblDatadico.setText(listeDico);
		
		if(maRecherche.getDansRecherche() == -1)
			lblDatadans.setText("Nouvelle Recherche");
		else
			lblDatadans.setText("Cascade depuis recherche " + maRecherche.getDansRecherche());
		
		
		// Resultats
		
		resultat.removeAll();
		
		ArrayList<String> dico = application.getMesRecherches().get(numRecherche).getListeDictionnaire();
		
		expandingPanels = new ExpandingPanels(dico.size());
		expandingPanels.clear();

		for(String dictionnaire : dico) {			

			// DETAIL 1
			if (sliderDetails.getValue() == sliderDetails.getMinimum()) {
				
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
			else if (sliderDetails.getValue() == (sliderDetails.getMaximum())/2) {
				
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
			else if (sliderDetails.getValue() == sliderDetails.getMaximum()) {
				
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
 * @return the gridBagLayoutInformations
 */
public GridBagLayout getGridBagLayoutInformations() {
	return gridBagLayoutInformations;
}

/**
 * @param gridBagLayoutInformations the gridBagLayoutInformations to set
 */
public void setGridBagLayoutInformations(GridBagLayout gridBagLayoutInformations) {
	this.gridBagLayoutInformations = gridBagLayoutInformations;
}

/**
 * @return the gridBagLayoutResultats
 */
public GridBagLayout getGridBagLayoutResultats() {
	return gridBagLayoutResultats;
}

/**
 * @param gridBagLayoutResultats the gridBagLayoutResultats to set
 */
public void setGridBagLayoutResultats(GridBagLayout gridBagLayoutResultats) {
	this.gridBagLayoutResultats = gridBagLayoutResultats;
}

/**
 * @return the informations
 */
public JPanel getInformations() {
	return informations;
}

/**
 * @param informations the informations to set
 */
public void setInformations(JPanel informations) {
	this.informations = informations;
}

/**
 * @return the lblNumero
 */
public JLabel getLblNumero() {
	return lblNumero;
}

/**
 * @param lblNumero the lblNumero to set
 */
public void setLblNumero(JLabel lblNumero) {
	this.lblNumero = lblNumero;
}

/**
 * @return the sliderDetails
 */
public JSlider getSliderDetails() {
	return sliderDetails;
}

/**
 * @param sliderDetails the sliderDetails to set
 */
public void setSliderDetails(JSlider sliderDetails) {
	this.sliderDetails = sliderDetails;
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

/**
 * @return the numRechercheEnCours
 */
public int getNumRechercheEnCours() {
	return numRechercheEnCours;
}

/**
 * @param numRechercheEnCours the numRechercheEnCours to set
 */
public void setNumRechercheEnCours(int numRechercheEnCours) {
	this.numRechercheEnCours = numRechercheEnCours;
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
 * @return the lblDico
 */
public JLabel getLblDico() {
	return lblDico;
}

/**
 * @param lblDico the lblDico to set
 */
public void setLblDico(JLabel lblDico) {
	this.lblDico = lblDico;
}

/**
 * @return the lblCritere
 */
public JLabel getLblCritere() {
	return lblCritere;
}

/**
 * @param lblCritere the lblCritere to set
 */
public void setLblCritere(JLabel lblCritere) {
	this.lblCritere = lblCritere;
}

/**
 * @return the lblDans
 */
public JLabel getLblDans() {
	return lblDans;
}

/**
 * @param lblDans the lblDans to set
 */
public void setLblDans(JLabel lblDans) {
	this.lblDans = lblDans;
}

/**
 * @return the lblDatamot
 */
public JLabel getLblDatamot() {
	return lblDatamot;
}

/**
 * @param lblDatamot the lblDatamot to set
 */
public void setLblDatamot(JLabel lblDatamot) {
	this.lblDatamot = lblDatamot;
}

/**
 * @return the lblDatacritere
 */
public JLabel getLblDatacritere() {
	return lblDatacritere;
}

/**
 * @param lblDatacritere the lblDatacritere to set
 */
public void setLblDatacritere(JLabel lblDatacritere) {
	this.lblDatacritere = lblDatacritere;
}

/**
 * @return the lblDatadico
 */
public JLabel getLblDatadico() {
	return lblDatadico;
}

/**
 * @param lblDatadico the lblDatadico to set
 */
public void setLblDatadico(JLabel lblDatadico) {
	this.lblDatadico = lblDatadico;
}

/**
 * @return the lblDatadans
 */
public JLabel getLblDatadans() {
	return lblDatadans;
}

/**
 * @param lblDatadans the lblDatadans to set
 */
public void setLblDatadans(JLabel lblDatadans) {
	this.lblDatadans = lblDatadans;
}

/**
 * @return the lblDetail
 */
public JLabel getLblDetail() {
	return lblDetail;
}

/**
 * @param lblDetail the lblDetail to set
 */
public void setLblDetail(JLabel lblDetail) {
	this.lblDetail = lblDetail;
}

}
