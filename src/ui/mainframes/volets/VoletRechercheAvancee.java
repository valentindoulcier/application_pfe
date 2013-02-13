/**
 * 
 */
package ui.mainframes.volets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import principal.Application;

import renderers.MenuRenderer;
import ui.objects.RSMenuListe;
import dao.DictionnairesDAO;
import database.Dictionnaires;

/**
 * @author Valentin
 *
 */
public class VoletRechercheAvancee extends JPanel {

	private static final long serialVersionUID = 7997937547434852750L;

	private static Logger logger = Logger.getLogger(VoletRechercheSimple.class);

	private GridBagLayout gridBagLayout;

	private JLabel lblDictionnaires;

	private JPanel listeDico;

	private MenuRenderer menuRenderer;
	
	private JLabel lblDetails;
	
	private JSlider sliderDetails;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletRechercheAvancee(Application application) {

		initComponents();
		
		sliderDetails.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
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

	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540));
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 260, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 100, 20, 20, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblDictionnaires = new JLabel("Dictionnaires");
		GridBagConstraints gbc_lblDictionnaires = new GridBagConstraints();
		gbc_lblDictionnaires.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDictionnaires.insets = new Insets(0, 0, 5, 5);
		gbc_lblDictionnaires.gridx = 1;
		gbc_lblDictionnaires.gridy = 1;
		add(lblDictionnaires, gbc_lblDictionnaires);

		listeDico = listeDico();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(listeDico, gbc_panel);
		
		lblDetails = new JLabel("Détail : x");
		GridBagConstraints gbc_lblDetails = new GridBagConstraints();
		gbc_lblDetails.anchor = GridBagConstraints.WEST;
		gbc_lblDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetails.gridx = 1;
		gbc_lblDetails.gridy = 4;
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
		gbc_sliderDetail.gridy = 5;
		add(sliderDetails, gbc_sliderDetail);

	}

	public JPanel listeDico() {

		logger.debug("4 - Chargement des dictionnaires");
		DictionnairesDAO dictionnaires = new DictionnairesDAO("local");
		List<?> dico = null;
		
		
		if(dictionnaires.getSession().isOpen()) {
			dico = dictionnaires.findAll();
		}
		else
			JOptionPane.showMessageDialog(null, "Connexion fermée VOLET DICO 2 !");
		
		
		
		

		Vector<RSMenuListe> listeDictionnaires = new Vector<RSMenuListe>();

		RSMenuListe rsmenuListe;

		if(dico != null){
			for(Object l : dico) {
				rsmenuListe = new RSMenuListe();
				rsmenuListe.getChckbxDictionnaires().setText(((Dictionnaires) l).getNomDictionnaire().toUpperCase());
				listeDictionnaires.addElement(rsmenuListe);
			}
		}

		menuRenderer = new MenuRenderer(listeDictionnaires);

		return menuRenderer;
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
	 * @return the menuRenderer
	 */
	public MenuRenderer getMenuRenderer() {
		return menuRenderer;
	}

	/**
	 * @param menuRenderer the menuRenderer to set
	 */
	public void setMenuRenderer(MenuRenderer menuRenderer) {
		this.menuRenderer = menuRenderer;
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


}
