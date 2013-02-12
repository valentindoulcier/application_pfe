package ui.components;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;

import org.apache.log4j.Logger;

import renderers.MenuRenderer;
import ui.objects.RSMenuListe;

import dao.DictionnairesDAO;
import database.Dictionnaires;

/**
 * @author Valentin
 *
 */
public class AppliMenuRechercheSimple extends JPanel {

	private static final long serialVersionUID = -1450575053596774785L;
	
	private static Logger logger = Logger.getLogger(AppliMenuRechercheSimple.class);
	
	private GridBagLayout gridBagLayout;
	
	private JLabel lblDictionnaires;
	
	private JPanel listeDico;
	
	private MenuRenderer menuRenderer;

	/**
	 * Create the panel.
	 */
	public AppliMenuRechercheSimple() {
		
		initComponents();
		
	}
	
	public void initComponents() {
		
		setBackground(Color.GREEN);
		
		this.setSize(new Dimension(250, 500));
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 196, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 100, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
	}
	
	
	public JPanel listeDico() {

		logger.debug("4 - Je vais créer le menu recherche simple");
		DictionnairesDAO dictionnaires = new DictionnairesDAO("local");
		List<?> dico = null;
		if(dictionnaires.getSession() != null) {
			dico = dictionnaires.findAll();
		}
		
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

}
