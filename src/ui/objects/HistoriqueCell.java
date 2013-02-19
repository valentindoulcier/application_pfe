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
	
	private JLabel lblDate;

	public HistoriqueCell(final Application application) {

		initComponents();

	}
	
	public void initComponents() {
		
		//setPreferredSize(new Dimension(300, 30));
		//setMinimumSize(new Dimension(300, 30));
		
		setBackground(Color.LIGHT_GRAY);
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblMots = new JLabel("Mot");
		lblMots.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblMots = new GridBagConstraints();
		gbc_lblMots.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblMots.insets = new Insets(0, 0, 5, 5);
		gbc_lblMots.gridx = 1;
		gbc_lblMots.gridy = 0;
		add(lblMots, gbc_lblMots);
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(Color.GRAY);
		lblDate.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 1;
		add(lblDate, gbc_lblDate);

	}


	public void setCaract(Caract_Historique caract) {
		numRecherche = caract.numRecherche;
		lblMots.setText(caract.mot);
		lblDate.setText(caract.date);
	}

	public Caract_Historique getCaract() {
		return new Caract_Historique(numRecherche, lblMots.getText(), lblDate.getText());
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

	/**
	 * @return the lblDate
	 */
	public JLabel getLblDate() {
		return lblDate;
	}

	/**
	 * @param lblDate the lblDate to set
	 */
	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}
}