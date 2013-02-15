package ui.objects;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JLabel;

import principal.Application;

import renderers.Caract_Historique;

import java.awt.Font;
import java.awt.Color;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */

public class HistoriqueCell extends JPanel {

	private static final long serialVersionUID = 8933677136466352896L;
	
	private int numRecherche;

	private GridBagLayout gridBagLayout;

	private JLabel lblMots;

	public HistoriqueCell(final Application application) {

		initComponents();

	}
	
	public void initComponents() {
		
		setBackground(Color.GREEN);
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblMots = new JLabel("Mot");
		lblMots.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblMots = new GridBagConstraints();
		gbc_lblMots.anchor = GridBagConstraints.WEST;
		gbc_lblMots.insets = new Insets(0, 0, 0, 5);
		gbc_lblMots.gridx = 1;
		gbc_lblMots.gridy = 0;
		add(lblMots, gbc_lblMots);

	}


	public void setCaract(Caract_Historique caract) {
		numRecherche = caract.numRecherche;
		lblMots.setText(caract.mot);
	}

	public Caract_Historique getCaract() {
		return new Caract_Historique(numRecherche, lblMots.getText());
	}
	
	/**
	 * @return the idHeadword
	 */
	public int getNumRecherche() {
		return numRecherche;
	}


	/**
	 * @param idHeadword the idHeadword to set
	 */
	public void setNumRecherche(int numRecherche) {
		this.numRecherche = numRecherche;
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