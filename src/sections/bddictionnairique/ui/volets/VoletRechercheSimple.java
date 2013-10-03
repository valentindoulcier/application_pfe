/**
 * 
 */
package sections.bddictionnairique.ui.volets;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;

//import org.apache.log4j.Logger;

import principal.Application;

import dao.DictionnairesDAO;
import database.Dictionnaires;

import sections.bddictionnairique.Bddictionnairique;
import sections.bddictionnairique.objects.DictionnairesCell;
import sections.bddictionnairique.renderers.DictionnairesRenderer;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletRechercheSimple extends JPanel {

	private static final long serialVersionUID = -7929534743664074552L;

	//private static Logger logger = Logger.getLogger(VoletRechercheSimple.class);

	private GridBagLayout gridBagLayout;

	private JLabel lblDictionnaires;

	private JPanel listeDico;
	
	private JLabel lblDetails;
	
	private JSlider sliderDetails;
	
	private HashMap<Integer, String> listeDicos;

	private boolean premiereRechercheFaite;
	
	private JLabel lblCorrespondances;
	private JTabbedPane tabbedPane;
	private JPanel panelPositif;
	private JPanel panelNegatif;
	private JRadioButton rdbtnContient;
	private JRadioButton rdbtnCommencePar;
	private JRadioButton rdbtnTerminePar;
	private JRadioButton rdbtnExacte;
	private JRadioButton rdbtnDifferent;
	private JRadioButton rdbtnNeContientPas;
	private JRadioButton rdbtnNeCommencePas;
	private JRadioButton rdbtnNeTerminePas;
	
	ButtonGroup groupePositif = new ButtonGroup();
	ButtonGroup groupeNegatif = new ButtonGroup();
	
	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletRechercheSimple(final Application application) {

		initComponents(application);
		
		sliderDetails.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
        		if(premiereRechercheFaite)
        			Bddictionnairique.getInstance(application).getContentRechercheSimple().afficherRecherche(application, application.getMesRecherches().size() - 1);
	        	if(sliderDetails.getValue() == 0)
	        	{
	        		lblDetails.setText("Détail : x");
	        	}
	        	else if(sliderDetails.getValue() == 50) {
	        		lblDetails.setText("Détail : xx");
	        	}
	        	else {
	        		lblDetails.setText("Détail : xxx");
	        	}
	        }
	    });
	}

	public void initComponents(Application application) {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540));

		premiereRechercheFaite = false;

		listeDicos = new HashMap<Integer, String>();

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 260, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 100, 20, 0, 0, 20, 20, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblDictionnaires = new JLabel("Dictionnaires");
		GridBagConstraints gbc_lblDictionnaires = new GridBagConstraints();
		gbc_lblDictionnaires.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDictionnaires.insets = new Insets(0, 0, 5, 5);
		gbc_lblDictionnaires.gridx = 1;
		gbc_lblDictionnaires.gridy = 1;
		add(lblDictionnaires, gbc_lblDictionnaires);

		listeDico = listeDico(application);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(listeDico, gbc_panel);
		
		lblCorrespondances = new JLabel("Correspondances");
		GridBagConstraints gbc_lblCorrespondances = new GridBagConstraints();
		gbc_lblCorrespondances.anchor = GridBagConstraints.WEST;
		gbc_lblCorrespondances.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorrespondances.gridx = 1;
		gbc_lblCorrespondances.gridy = 4;
		add(lblCorrespondances, gbc_lblCorrespondances);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 5;
		add(tabbedPane, gbc_tabbedPane);
		
		panelPositif = new JPanel();
		tabbedPane.addTab("Positif", null, panelPositif, null);
		GridBagLayout gbl_panelPositif = new GridBagLayout();
		gbl_panelPositif.columnWidths = new int[]{10, 0, 0, 0};
		gbl_panelPositif.rowHeights = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panelPositif.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPositif.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPositif.setLayout(gbl_panelPositif);
		
		rdbtnExacte = new JRadioButton("Exacte");
		rdbtnExacte.setSelected(true);
		GridBagConstraints gbc_rdbtnExacte = new GridBagConstraints();
		gbc_rdbtnExacte.anchor = GridBagConstraints.WEST;
		gbc_rdbtnExacte.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnExacte.gridx = 1;
		gbc_rdbtnExacte.gridy = 1;
		panelPositif.add(rdbtnExacte, gbc_rdbtnExacte);
		
		rdbtnContient = new JRadioButton("Contient");
		GridBagConstraints gbc_rdbtnContient = new GridBagConstraints();
		gbc_rdbtnContient.anchor = GridBagConstraints.WEST;
		gbc_rdbtnContient.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnContient.gridx = 1;
		gbc_rdbtnContient.gridy = 3;
		panelPositif.add(rdbtnContient, gbc_rdbtnContient);
		
		rdbtnCommencePar = new JRadioButton("Commence par");
		GridBagConstraints gbc_rdbtnCommencePar = new GridBagConstraints();
		gbc_rdbtnCommencePar.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCommencePar.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCommencePar.gridx = 1;
		gbc_rdbtnCommencePar.gridy = 5;
		panelPositif.add(rdbtnCommencePar, gbc_rdbtnCommencePar);
		
		rdbtnTerminePar = new JRadioButton("Termine par");
		GridBagConstraints gbc_rdbtnTerminePar = new GridBagConstraints();
		gbc_rdbtnTerminePar.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTerminePar.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTerminePar.gridx = 1;
		gbc_rdbtnTerminePar.gridy = 7;
		panelPositif.add(rdbtnTerminePar, gbc_rdbtnTerminePar);
		
		panelNegatif = new JPanel();
		tabbedPane.addTab("Négatif", null, panelNegatif, null);
		GridBagLayout gbl_panelNegatif = new GridBagLayout();
		gbl_panelNegatif.columnWidths = new int[]{10, 0, 0, 0};
		gbl_panelNegatif.rowHeights = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panelNegatif.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelNegatif.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelNegatif.setLayout(gbl_panelNegatif);
		
		rdbtnDifferent = new JRadioButton("Different");
		rdbtnDifferent.setSelected(true);
		GridBagConstraints gbc_rdbtnDifferent = new GridBagConstraints();
		gbc_rdbtnDifferent.anchor = GridBagConstraints.WEST;
		gbc_rdbtnDifferent.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDifferent.gridx = 1;
		gbc_rdbtnDifferent.gridy = 1;
		panelNegatif.add(rdbtnDifferent, gbc_rdbtnDifferent);
		
		rdbtnNeContientPas = new JRadioButton("Ne contient pas");
		GridBagConstraints gbc_rdbtnNeContientPas = new GridBagConstraints();
		gbc_rdbtnNeContientPas.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNeContientPas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNeContientPas.gridx = 1;
		gbc_rdbtnNeContientPas.gridy = 3;
		panelNegatif.add(rdbtnNeContientPas, gbc_rdbtnNeContientPas);
		
		rdbtnNeCommencePas = new JRadioButton("Ne commence pas par");
		GridBagConstraints gbc_rdbtnNeCommencePas = new GridBagConstraints();
		gbc_rdbtnNeCommencePas.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNeCommencePas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNeCommencePas.gridx = 1;
		gbc_rdbtnNeCommencePas.gridy = 5;
		panelNegatif.add(rdbtnNeCommencePas, gbc_rdbtnNeCommencePas);
		
		rdbtnNeTerminePas = new JRadioButton("Ne termine pas par");
		GridBagConstraints gbc_rdbtnNeTerminePas = new GridBagConstraints();
		gbc_rdbtnNeTerminePas.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNeTerminePas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNeTerminePas.gridx = 1;
		gbc_rdbtnNeTerminePas.gridy = 7;
		panelNegatif.add(rdbtnNeTerminePas, gbc_rdbtnNeTerminePas);
		
		lblDetails = new JLabel("Détail : x");
		GridBagConstraints gbc_lblDetails = new GridBagConstraints();
		gbc_lblDetails.anchor = GridBagConstraints.WEST;
		gbc_lblDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetails.gridx = 1;
		gbc_lblDetails.gridy = 7;
		add(lblDetails, gbc_lblDetails);
		
		sliderDetails = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 20);
		sliderDetails.setSnapToTicks(true);
		sliderDetails.setPaintTicks(true);
		sliderDetails.setMinorTickSpacing(50);
		sliderDetails.setMajorTickSpacing(50);
		sliderDetails.setToolTipText("");
		GridBagConstraints gbc_sliderDetail = new GridBagConstraints();
		gbc_sliderDetail.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderDetail.insets = new Insets(0, 0, 5, 5);
		gbc_sliderDetail.gridx = 1;
		gbc_sliderDetail.gridy = 8;
		add(sliderDetails, gbc_sliderDetail);
		
		groupePositif.add(rdbtnExacte);
		groupePositif.add(rdbtnContient);
		groupePositif.add(rdbtnCommencePar);
		groupePositif.add(rdbtnTerminePar);
		
		groupeNegatif.add(rdbtnDifferent);
		groupeNegatif.add(rdbtnNeContientPas);
		groupeNegatif.add(rdbtnNeCommencePas);
		groupeNegatif.add(rdbtnNeTerminePas);

	}

	public JPanel listeDico(Application application) {

		//logger.debug("4 - Chargement des dictionnaires");
		DictionnairesDAO dictionnaires = new DictionnairesDAO("local");
		List<?> dico = null;
		
		
		if(dictionnaires.getSession().isOpen()) {
			dico = dictionnaires.findAll();
		}
		else {
			// Non fonctionnel
			JOptionPane.showMessageDialog(null, "Connexion fermée VOLET DICO 2 !");
		}


		Vector<DictionnairesCell> listeDictionnaires = new Vector<DictionnairesCell>();

		DictionnairesCell dictionnairesCell;

		if(dico != null){
			for(Object l : dico) {
				listeDicos.put(((Dictionnaires) l).getIdDictionnaire() - 1, ((Dictionnaires) l).getNomDictionnaire().toUpperCase());
				dictionnairesCell = new DictionnairesCell(application);
				dictionnairesCell.getChckbxDictionnaires().setText(((Dictionnaires) l).getNomDictionnaire().toUpperCase());
				dictionnairesCell.setNum(((Dictionnaires) l).getIdDictionnaire() - 1);
				listeDictionnaires.addElement(dictionnairesCell);
			}
		}

		return new DictionnairesRenderer(application, listeDictionnaires);
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
	 * @return the lblDictionnaires
	 */
	public JLabel getLblDictionnaires() {
		return lblDictionnaires;
	}

	/**
	 * @param lblDictionnaires the lblDictionnaires to set
	 */
	public void setLblDictionnaires(JLabel lblDictionnaires) {
		this.lblDictionnaires = lblDictionnaires;
	}

	/**
	 * @return the listeDico
	 */
	public JPanel getListeDico() {
		return listeDico;
	}

	/**
	 * @param listeDico the listeDico to set
	 */
	public void setListeDico(JPanel listeDico) {
		this.listeDico = listeDico;
	}

	/**
	 * @return the lblDetails
	 */
	public JLabel getLblDetails() {
		return lblDetails;
	}

	/**
	 * @param lblDetails the lblDetails to set
	 */
	public void setLblDetails(JLabel lblDetails) {
		this.lblDetails = lblDetails;
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
	 * @return the listeDicos
	 */
	public HashMap<Integer, String> getListeDicos() {
		return listeDicos;
	}

	/**
	 * @param listeDicos the listeDicos to set
	 */
	public void setListeDicos(HashMap<Integer, String> listeDicos) {
		this.listeDicos = listeDicos;
	}

	/**
	 * @return the premiereRechercheFaite
	 */
	public boolean isPremiereRechercheFaite() {
		return premiereRechercheFaite;
	}

	/**
	 * @param premiereRechercheFaite the premiereRechercheFaite to set
	 */
	public void setPremiereRechercheFaite(boolean premiereRechercheFaite) {
		this.premiereRechercheFaite = premiereRechercheFaite;
	}

}
