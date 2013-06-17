package sections.bddictionnairique.objects;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import database.AvoirPourCategorieHeadword;
import database.Headword;

import principal.Application;

import sections.bddictionnairique.Bddictionnairique;
import sections.bddictionnairique.renderers.Caract_Mots;

import java.awt.Font;
import java.awt.Color;
import java.util.Set;

//import org.apache.log4j.Logger;

/**
 * @author Valentin DOULCIER
 *
 */

public class MotsCell extends JPanel {

	private static final long serialVersionUID = -1857283576377080842L;
	
	private Headword headword;

	private GridBagLayout gridBagLayout;
	
	private JLabel lblMots;
	
	private Application application;
	private JLabel lblCategories;
	private JLabel lblDatacategories;
	private JLabel lblRegion;
	private JLabel lblDataregion;
	private JLabel lblSchema;
	private JLabel lblDataschema;
	private JLabel lblType;
	private JLabel lblDatatype;
	private JLabel lblSyllabes;
	private JLabel lblDatasyllabes;
	private JButton btnEditer;
	private JButton btnMasquer;

	public MotsCell(final Application application) {
		this.application = application;
		headword = new Headword();
		
		initComponents();
		
		btnEditer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Bddictionnairique.getInstance(application).ouvrirOnglet(4);
				Bddictionnairique.getInstance(application).getContentEdition().setHeadword(headword);
				Bddictionnairique.getInstance(application).getContentEdition().chargerData();
			}
		});
		
		btnMasquer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, (Component) e.getSource());
				int row = table.getEditingRow();
				table.getCellEditor().stopCellEditing();
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		});
		
	}
	
	public void initComponents() {
		
		//setPreferredSize(new Dimension(540, 30));

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 50, 232, 50, 232, 50, 232, 30, 30, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblMots = new JLabel("mot");
		lblMots.setVisible(false);
		lblMots.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblMots, gbc_lblNewLabel);
		
		lblCategories = new JLabel("Catégorie(s)");
		lblCategories.setVisible(false);
		lblCategories.setForeground(new Color(34, 139, 34));
		GridBagConstraints gbc_lblCategories = new GridBagConstraints();
		gbc_lblCategories.anchor = GridBagConstraints.WEST;
		gbc_lblCategories.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategories.gridx = 2;
		gbc_lblCategories.gridy = 1;
		add(lblCategories, gbc_lblCategories);
		
		lblDatacategories = new JLabel("dataCategories");
		lblDatacategories.setVisible(false);
		GridBagConstraints gbc_lblDatacategories = new GridBagConstraints();
		gbc_lblDatacategories.anchor = GridBagConstraints.WEST;
		gbc_lblDatacategories.gridwidth = 5;
		gbc_lblDatacategories.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatacategories.gridx = 3;
		gbc_lblDatacategories.gridy = 1;
		add(lblDatacategories, gbc_lblDatacategories);
		
		btnEditer = new JButton("Editer");
		btnEditer.setVisible(false);
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.gridheight = 4;
		gbc_btnEditer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditer.gridx = 8;
		gbc_btnEditer.gridy = 0;
		add(btnEditer, gbc_btnEditer);
		
		btnMasquer = new JButton("Masquer");
		btnMasquer.setVisible(false);
		GridBagConstraints gbc_btnMasquer = new GridBagConstraints();
		gbc_btnMasquer.gridheight = 4;
		gbc_btnMasquer.gridx = 9;
		gbc_btnMasquer.gridy = 0;
		add(btnMasquer, gbc_btnMasquer);
		
		lblRegion = new JLabel("Région");
		lblRegion.setVisible(false);
		GridBagConstraints gbc_lblRegion = new GridBagConstraints();
		gbc_lblRegion.anchor = GridBagConstraints.WEST;
		gbc_lblRegion.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegion.gridx = 2;
		gbc_lblRegion.gridy = 2;
		add(lblRegion, gbc_lblRegion);
		
		lblDataregion = new JLabel("dataRegion");
		lblDataregion.setVisible(false);
		GridBagConstraints gbc_lblDataregion = new GridBagConstraints();
		gbc_lblDataregion.anchor = GridBagConstraints.WEST;
		gbc_lblDataregion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataregion.gridx = 3;
		gbc_lblDataregion.gridy = 2;
		add(lblDataregion, gbc_lblDataregion);
		
		lblSchema = new JLabel("Schéma");
		lblSchema.setVisible(false);
		GridBagConstraints gbc_lblSchema = new GridBagConstraints();
		gbc_lblSchema.anchor = GridBagConstraints.WEST;
		gbc_lblSchema.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchema.gridx = 4;
		gbc_lblSchema.gridy = 2;
		add(lblSchema, gbc_lblSchema);
		
		lblDataschema = new JLabel("dataSchema");
		lblDataschema.setVisible(false);
		GridBagConstraints gbc_lblDataschema = new GridBagConstraints();
		gbc_lblDataschema.anchor = GridBagConstraints.WEST;
		gbc_lblDataschema.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataschema.gridx = 5;
		gbc_lblDataschema.gridy = 2;
		add(lblDataschema, gbc_lblDataschema);
		
		lblType = new JLabel("Type");
		lblType.setVisible(false);
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.WEST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 6;
		gbc_lblType.gridy = 2;
		add(lblType, gbc_lblType);
		
		lblDatatype = new JLabel("dataType");
		lblDatatype.setVisible(false);
		GridBagConstraints gbc_lblDatatype = new GridBagConstraints();
		gbc_lblDatatype.anchor = GridBagConstraints.WEST;
		gbc_lblDatatype.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatatype.gridx = 7;
		gbc_lblDatatype.gridy = 2;
		add(lblDatatype, gbc_lblDatatype);
		
		lblSyllabes = new JLabel("syllabes");
		lblSyllabes.setVisible(false);
		GridBagConstraints gbc_lblSyllabes = new GridBagConstraints();
		gbc_lblSyllabes.anchor = GridBagConstraints.WEST;
		gbc_lblSyllabes.insets = new Insets(0, 0, 0, 5);
		gbc_lblSyllabes.gridx = 2;
		gbc_lblSyllabes.gridy = 3;
		add(lblSyllabes, gbc_lblSyllabes);
		
		lblDatasyllabes = new JLabel("dataSyllabes");
		lblDatasyllabes.setVisible(false);
		GridBagConstraints gbc_lblDatasyllabes = new GridBagConstraints();
		gbc_lblDatasyllabes.anchor = GridBagConstraints.WEST;
		gbc_lblDatasyllabes.gridwidth = 5;
		gbc_lblDatasyllabes.insets = new Insets(0, 0, 0, 5);
		gbc_lblDatasyllabes.gridx = 3;
		gbc_lblDatasyllabes.gridy = 3;
		add(lblDatasyllabes, gbc_lblDatasyllabes);
	}

	public void setCaract(Caract_Mots caract) {
		headword = caract.headword;
		
		chargerMot();
		
		if (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getValue() == Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getMinimum()) {
			afficher_1();
		}
		else if (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getMaximum())/2) {
			afficher_2();
		}
		else if (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getMaximum())) {
			afficher_2();
		}
    }
	
	public Caract_Mots getCaract() {
        return new Caract_Mots(headword);
    }
	
	public void chargerMot() {
		// Mot
		lblMots.setText(headword.getMot());	
		
		// Catégorie
		Set<AvoirPourCategorieHeadword> listAvoirPourCategorieHeadword = headword.getAvoirPourCategorieHeadwords();
		String categories = "";
		for(AvoirPourCategorieHeadword avoirPourCategorieHeadword : listAvoirPourCategorieHeadword) {
			categories += avoirPourCategorieHeadword.getListeCategories().getNom();
			categories += " ";
		}
		lblDatacategories.setText(categories);
		
		// Région
		
		
		// Schéma
		
		// Type
		
		// Syllabes
		
	}
	
	public void afficher_1() {
		lblMots.setVisible(true);
	}
	
	public void afficher_2() {
		lblMots.setVisible(true);
		lblCategories.setVisible(true);
		lblDatacategories.setVisible(true);
		lblRegion.setVisible(true);
		lblDataregion.setVisible(true);
		lblSchema.setVisible(true);
		lblDataschema.setVisible(true);
		lblType.setVisible(true);
		lblDatatype.setVisible(true);
		lblSyllabes.setVisible(true);
		lblDatasyllabes.setVisible(true);
	}
	
	public void afficher_3() {
		afficher_2();
	}

	/**
	 * @return the headword
	 */
	public Headword getHeadword() {
		return headword;
	}

	/**
	 * @param headword the headword to set
	 */
	public void setHeadword(Headword headword) {
		this.headword = headword;
	}

	/**
	 * @return the btnEditer
	 */
	public JButton getBtnEditer() {
		return btnEditer;
	}


	/**
	 * @param btnEditer the btnEditer to set
	 */
	public void setBtnEditer(JButton btnEditer) {
		this.btnEditer = btnEditer;
	}


	/**
	 * @return the btnMasquer
	 */
	public JButton getBtnMasquer() {
		return btnMasquer;
	}


	/**
	 * @param btnMasquer the btnMasquer to set
	 */
	public void setBtnMasquer(JButton btnMasquer) {
		this.btnMasquer = btnMasquer;
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
	 * @return the lblMots
	 */
	public JLabel getLblMots() {
		return lblMots;
	}

	/**
	 * @param lblMots the lblMots to set
	 */
	public void setLblMots(JLabel lblMots) {
		this.lblMots = lblMots;
	}
}
