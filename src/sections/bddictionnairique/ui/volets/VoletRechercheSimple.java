/**
 * 
 */
package sections.bddictionnairique.ui.volets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;

import org.apache.log4j.Logger;

import principal.Application;

import dao.DictionnairesDAO;
import database.Dictionnaires;

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

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletRechercheSimple extends JPanel {

	private static final long serialVersionUID = -7929534743664074552L;

	private static Logger logger = Logger.getLogger(VoletRechercheSimple.class);

	private GridBagLayout gridBagLayout;

	private JLabel lblDictionnaires;

	private JPanel listeDico;
	
	private JLabel lblDetails;
	
	private JSlider sliderDetails;
	
	private HashMap<Integer, String> listeDicos;


	
	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletRechercheSimple(Application application) {

		initComponents(application);
		
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

	public void initComponents(Application application) {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540));
		
		listeDicos = new HashMap<Integer, String>();
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 260, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 100, 20, 20, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
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

	public JPanel listeDico(Application application) {

		logger.debug("4 - Chargement des dictionnaires");
		DictionnairesDAO dictionnaires = new DictionnairesDAO("local");
		List<?> dico = null;
		
		
		if(dictionnaires.getSession().isOpen()) {
			dico = dictionnaires.findAll();
		}
		else
			JOptionPane.showMessageDialog(null, "Connexion fermée VOLET DICO 2 !");
		

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

}
