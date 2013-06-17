package sections.parseurXML.objects;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JLabel;

import principal.Application;

import sections.parseurXML.renderers.Caract_Historique;

import java.awt.Font;
import java.awt.Color;

//import org.apache.log4j.Logger;

/**
 * @author Valentin DOULCIER
 *
 */

public class HistoriqueCell extends JPanel {

	private static final long serialVersionUID = 8933677136466352896L;
	
	private int numRecherche;

	private GridBagLayout gridBagLayout;
	
	private JLabel lblNumero;

	private JLabel lblFichier;
	
	private JLabel lblDate;

	public HistoriqueCell(final Application application) {

		initComponents();

	}
	
	public void initComponents() {
		
		//setPreferredSize(new Dimension(300, 30));
		//setMinimumSize(new Dimension(300, 30));
		
		setBackground(Color.LIGHT_GRAY);
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 50, 8, 0};
		gridBagLayout.rowHeights = new int[]{10, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblFichier = new JLabel("Fichier");
		lblFichier.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblFichier = new GridBagConstraints();
		gbc_lblFichier.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblFichier.insets = new Insets(0, 0, 5, 5);
		gbc_lblFichier.gridx = 1;
		gbc_lblFichier.gridy = 0;
		add(lblFichier, gbc_lblFichier);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.EAST;
		gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumero.gridx = 2;
		gbc_lblNumero.gridy = 0;
		add(lblNumero, gbc_lblNumero);
		
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
		lblNumero.setText(String.valueOf(caract.numRecherche));
		lblFichier.setText(caract.fichier);
		lblDate.setText(caract.date);
	}

	public Caract_Historique getCaract() {
		return new Caract_Historique(numRecherche, lblFichier.getText(), lblDate.getText());
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
	 * @return the lblFichier
	 */
	public JLabel getLblFichier() {
		return lblFichier;
	}

	/**
	 * @param lblFichier the lblFichier to set
	 */
	public void setLblFichier(JLabel lblFichier) {
		this.lblFichier = lblFichier;
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