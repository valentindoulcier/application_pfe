package ui.objects;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import principal.Application;

import renderers.Caract_2;
import java.awt.Font;
import java.awt.Color;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */

public class RSDetail_2 extends JPanel {

	private static final long serialVersionUID = 8933677136466352896L;
	
	private int idHeadword;

	private GridBagLayout gridBagLayout;

	private JLabel lblMots;
	private JLabel lblCategories;

	private JButton btnEditer;
	private JButton btnMasquer;
	private JLabel lblRegion;
	private JLabel lblType;
	private JLabel lblSchema;
	private JLabel lblSyllabes;

	public RSDetail_2(final Application application) {

		initComponents();		

		btnEditer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				application.getVoletHeader().show(application.getvHeader(), "voletHeaderEdition");
				application.getVoletPanel().show(application.getvPanel(), "voletEdition");
				application.getVoletFooter().show(application.getvFooter(), "voletFooterEdition");
				
				application.getContentHeader().show(application.getcHeader(), "contentHeaderEdition");
				application.getContentPanel().show(application.getcPanel(), "contentEdition");
				application.getContentFooter().show(application.getcFooter(), "contentFooterEdition");
				
				
				//layerApplication.getCardLayoutContent().show(layerApplication.getPanelContent(), "AppliContentEditionMot");
				//layerApplication.getAppliContentEditionMot().getVolet_1().getTextField().setText(String.valueOf(idHeadword));
				//System.out.println("Je suis : " + idHeadword);
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
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 120, 120, 120, 80, 30, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 10, 10, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblMots = new JLabel("Mot");
		lblMots.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblMots = new GridBagConstraints();
		gbc_lblMots.anchor = GridBagConstraints.WEST;
		gbc_lblMots.gridwidth = 5;
		gbc_lblMots.insets = new Insets(0, 0, 5, 5);
		gbc_lblMots.gridx = 1;
		gbc_lblMots.gridy = 0;
		add(lblMots, gbc_lblMots);

		
		lblCategories = new JLabel("Catégories");
		lblCategories.setForeground(new Color(50, 205, 50));
		GridBagConstraints gbc_lblCategories = new GridBagConstraints();
		gbc_lblCategories.gridwidth = 4;
		gbc_lblCategories.anchor = GridBagConstraints.WEST;
		gbc_lblCategories.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategories.gridx = 2;
		gbc_lblCategories.gridy = 1;
		add(lblCategories, gbc_lblCategories);
		
		btnEditer = new JButton("Editer");
		btnEditer.setVisible(false);
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnEditer.gridheight = 2;
		gbc_btnEditer.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditer.gridx = 6;
		gbc_btnEditer.gridy = 0;
		add(btnEditer, gbc_btnEditer);

		btnMasquer = new JButton("Masquer");
		btnMasquer.setVisible(false);
		GridBagConstraints gbc_btnMasquer = new GridBagConstraints();
		gbc_btnMasquer.insets = new Insets(0, 0, 5, 0);
		gbc_btnMasquer.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnMasquer.gridheight = 2;
		gbc_btnMasquer.gridx = 7;
		gbc_btnMasquer.gridy = 0;
		add(btnMasquer, gbc_btnMasquer);
		
		lblRegion = new JLabel("Region : UK");
		GridBagConstraints gbc_lblRegion = new GridBagConstraints();
		gbc_lblRegion.anchor = GridBagConstraints.WEST;
		gbc_lblRegion.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegion.gridx = 2;
		gbc_lblRegion.gridy = 2;
		add(lblRegion, gbc_lblRegion);
		
		lblSchema = new JLabel("Schema : 1012");
		GridBagConstraints gbc_lblSchema = new GridBagConstraints();
		gbc_lblSchema.anchor = GridBagConstraints.WEST;
		gbc_lblSchema.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchema.gridx = 3;
		gbc_lblSchema.gridy = 2;
		add(lblSchema, gbc_lblSchema);
		
		lblType = new JLabel("Type : Primaire");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.WEST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 4;
		gbc_lblType.gridy = 2;
		add(lblType, gbc_lblType);
		
		lblSyllabes = new JLabel("New label : ezf ehzf uhezf uhiezh izuhe iuzhf eizhf ezuhfei zuh ziehfizeh izfh");
		GridBagConstraints gbc_lblSyllabes = new GridBagConstraints();
		gbc_lblSyllabes.insets = new Insets(0, 0, 0, 5);
		gbc_lblSyllabes.anchor = GridBagConstraints.WEST;
		gbc_lblSyllabes.gridwidth = 4;
		gbc_lblSyllabes.gridx = 2;
		gbc_lblSyllabes.gridy = 3;
		add(lblSyllabes, gbc_lblSyllabes);

	}


	public void setCaract(Caract_2 caract) {
		idHeadword = caract.idHeadword;
		lblMots.setText(caract.mot);
		lblCategories.setText(caract.categorie);
		lblRegion.setText(caract.region);
		lblSchema.setText(caract.schema);
		lblType.setText(caract.type);
		lblSyllabes.setText(caract.syllabes);
	}

	public Caract_2 getCaract() {
		return new Caract_2(idHeadword, lblMots.getText(), lblCategories.getText(), lblRegion.getText(), lblSchema.getText(), lblType.getText(), lblSyllabes.getText());
	}
	
	/**
	 * @return the idHeadword
	 */
	public int getIdHeadword() {
		return idHeadword;
	}


	/**
	 * @param idHeadword the idHeadword to set
	 */
	public void setIdHeadword(int idHeadword) {
		this.idHeadword = idHeadword;
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
	 * @return the lblCategories
	 */
	public JLabel getLblCategories() {
		return lblCategories;
	}

	/**
	 * @param lblCategories the lblCategories to set
	 */
	public void setLblCategories(JLabel lblCategories) {
		this.lblCategories = lblCategories;
	}

	/**
	 * @return the lblRegion
	 */
	public JLabel getLblRegion() {
		return lblRegion;
	}

	/**
	 * @param lblRegion the lblRegion to set
	 */
	public void setLblRegion(JLabel lblRegion) {
		this.lblRegion = lblRegion;
	}

	/**
	 * @return the lblType
	 */
	public JLabel getLblType() {
		return lblType;
	}

	/**
	 * @param lblType the lblType to set
	 */
	public void setLblType(JLabel lblType) {
		this.lblType = lblType;
	}

	/**
	 * @return the lblSchema
	 */
	public JLabel getLblSchema() {
		return lblSchema;
	}

	/**
	 * @param lblSchema the lblSchema to set
	 */
	public void setLblSchema(JLabel lblSchema) {
		this.lblSchema = lblSchema;
	}

	/**
	 * @return the lblSyllabes
	 */
	public JLabel getLblSyllabes() {
		return lblSyllabes;
	}

	/**
	 * @param lblSyllabes the lblSyllabes to set
	 */
	public void setLblSyllabes(JLabel lblSyllabes) {
		this.lblSyllabes = lblSyllabes;
	}
}




/*
public class RSDetail_2 extends JPanel {

	private static final long serialVersionUID = -3287414739952994994L;

	//private static Logger logger = Logger.getLogger(RSDetail_2.class);

	private JLabel lblMot;
	private JLabel lblDescription;
	private JButton btnNewButton;

	/**
 * Create the panel.
 */
/*
	public RSDetail_2() {
		setLayout(null);

		setPreferredSize(new Dimension(400, 60));

		lblMot = new JLabel("New label");
		lblMot.setBounds(6, 6, 388, 16);
		add(lblMot);

		lblDescription = new JLabel("New label");
		lblDescription.setBounds(45, 25, 349, 16);
		add(lblDescription);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(277, 20, 117, 29);
		add(btnNewButton);

		/*
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Je marche !!");

			}
		});
 */
/*
		btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, (Component) e.getSource());
                int row = table.getEditingRow();
                table.getCellEditor().stopCellEditing();
                ((DefaultTableModel) table.getModel()).removeRow(row);
            }
        });

	}

	/**
 * @return the lblMot
 *//*
	public JLabel getLblMot() {
		return lblMot;
	}

	/**
  * @param lblMot the lblMot to set
  *//*
	public void setLblMot(JLabel lblMot) {
		this.lblMot = lblMot;
	}

	/**
   * @return the lblDescription
   *//*
	public JLabel getLblDescription() {
		return lblDescription;
	}

	/**
    * @param lblDescription the lblDescription to set
    *//*
	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}
}
     */
