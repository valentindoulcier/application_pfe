package sections.updateBDD.objects;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import principal.Application;

import sections.updateBDD.renderers.Caract_Update;


//import org.apache.log4j.Logger;

/**
 * @author Valentin DOULCIER
 *
 */

public class UpdateCell extends JPanel {

	private static final long serialVersionUID = 8933677136466352896L;

	private GridBagLayout gridBagLayout;
	
	private String nomTable;
	private JLabel lblNomtable;

	public UpdateCell(final Application application) {

		initComponents();

	}
	
	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 8, 0};
		gridBagLayout.rowHeights = new int[]{10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNomtable = new JLabel("");
		GridBagConstraints gbc_lblNomtable = new GridBagConstraints();
		gbc_lblNomtable.anchor = GridBagConstraints.WEST;
		gbc_lblNomtable.insets = new Insets(0, 0, 0, 5);
		gbc_lblNomtable.gridx = 1;
		gbc_lblNomtable.gridy = 0;
		add(lblNomtable, gbc_lblNomtable);
	}


	public void setCaract(Caract_Update value) {
		nomTable = value.nomTable;
		lblNomtable.setText(nomTable);
	}

	public Caract_Update getCaract() {
		return new Caract_Update(nomTable);
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
	 * @return the nomTable
	 */
	public String getNomTable() {
		return nomTable;
	}

	/**
	 * @param nomTable the nomTable to set
	 */
	public void setNomTable(String nomTable) {
		this.nomTable = nomTable;
	}

	/**
	 * @return the lblNomtable
	 */
	public JLabel getLblNomtable() {
		return lblNomtable;
	}

	/**
	 * @param lblNomtable the lblNomtable to set
	 */
	public void setLblNomtable(JLabel lblNomtable) {
		this.lblNomtable = lblNomtable;
	}
}