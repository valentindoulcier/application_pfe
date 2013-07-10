package sections.parseurXML.components;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

/**
 * 
 * @author Valentin DOULCIER
 *
 */
public class InformationsFichier extends JPanel {

	private static final long serialVersionUID = -8401571116427937133L;

	private GridBagLayout gridBagLayout;

	private JLabel lblDataNomFichier;

	private JLabel lblPath;

	private JLabel lblDatapath;

	private JLabel lblExtension;

	private JLabel lblDataextension;

	private JLabel lblType;

	private JLabel lblDatatype;

	private JLabel lblTaille;

	private JLabel lblDatataille;

	private JLabel lblAuteur;

	private JLabel lblDataauteur;

	private JLabel lblDatemodif;

	private JLabel lblDatadatemodif;

	private JLabel lblLisible;

	private JLabel lblDatalisible;

	private JLabel lblDate;

	private JLabel lblDatadate;
	
	private JLabel lblMessage;

	/**
	 * Create the panel.
	 */
	public InformationsFichier() {
		initComponents();

	}
	
	public InformationsFichier(String titre) {
		initComponents();
		lblDataNomFichier.setText(titre);
	}

	public void initComponents() {
		this.setBorder(new LineBorder(SystemColor.textHighlight));
		this.setPreferredSize(new Dimension(400, 250));
		this.setMinimumSize(new Dimension(325, 500));

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 100, 0, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{20, 25, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblDataNomFichier = new JLabel("NomFichier");
		lblDataNomFichier.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GridBagConstraints gbc_lblDataNomFichier = new GridBagConstraints();
		gbc_lblDataNomFichier.gridwidth = 3;
		gbc_lblDataNomFichier.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataNomFichier.gridx = 1;
		gbc_lblDataNomFichier.gridy = 1;
		add(lblDataNomFichier, gbc_lblDataNomFichier);

		lblPath = new JLabel("Path");
		GridBagConstraints gbc_lblPath = new GridBagConstraints();
		gbc_lblPath.anchor = GridBagConstraints.WEST;
		gbc_lblPath.insets = new Insets(0, 0, 5, 5);
		gbc_lblPath.gridx = 1;
		gbc_lblPath.gridy = 2;
		add(lblPath, gbc_lblPath);

		lblDatapath = new JLabel("N/A");
		GridBagConstraints gbc_lblDatapath = new GridBagConstraints();
		gbc_lblDatapath.anchor = GridBagConstraints.WEST;
		gbc_lblDatapath.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatapath.gridx = 3;
		gbc_lblDatapath.gridy = 2;
		add(lblDatapath, gbc_lblDatapath);

		lblExtension = new JLabel("Extension");
		GridBagConstraints gbc_lblExtension = new GridBagConstraints();
		gbc_lblExtension.anchor = GridBagConstraints.WEST;
		gbc_lblExtension.insets = new Insets(0, 0, 5, 5);
		gbc_lblExtension.gridx = 1;
		gbc_lblExtension.gridy = 3;
		add(lblExtension, gbc_lblExtension);

		lblDataextension = new JLabel("N/A");
		GridBagConstraints gbc_lblDataextension = new GridBagConstraints();
		gbc_lblDataextension.anchor = GridBagConstraints.WEST;
		gbc_lblDataextension.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataextension.gridx = 3;
		gbc_lblDataextension.gridy = 3;
		add(lblDataextension, gbc_lblDataextension);

		lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.WEST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 1;
		gbc_lblType.gridy = 4;
		add(lblType, gbc_lblType);

		lblDatatype = new JLabel("N/A");
		GridBagConstraints gbc_lblDatatype = new GridBagConstraints();
		gbc_lblDatatype.anchor = GridBagConstraints.WEST;
		gbc_lblDatatype.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatatype.gridx = 3;
		gbc_lblDatatype.gridy = 4;
		add(lblDatatype, gbc_lblDatatype);

		lblTaille = new JLabel("Taille");
		GridBagConstraints gbc_lblTaille = new GridBagConstraints();
		gbc_lblTaille.anchor = GridBagConstraints.WEST;
		gbc_lblTaille.insets = new Insets(0, 0, 5, 5);
		gbc_lblTaille.gridx = 1;
		gbc_lblTaille.gridy = 5;
		add(lblTaille, gbc_lblTaille);

		lblDatataille = new JLabel("N/A");
		GridBagConstraints gbc_lblDatataille = new GridBagConstraints();
		gbc_lblDatataille.anchor = GridBagConstraints.WEST;
		gbc_lblDatataille.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatataille.gridx = 3;
		gbc_lblDatataille.gridy = 5;
		add(lblDatataille, gbc_lblDatataille);

		lblAuteur = new JLabel("Auteur");
		GridBagConstraints gbc_lblAuteur = new GridBagConstraints();
		gbc_lblAuteur.anchor = GridBagConstraints.WEST;
		gbc_lblAuteur.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuteur.gridx = 1;
		gbc_lblAuteur.gridy = 6;
		add(lblAuteur, gbc_lblAuteur);

		lblDataauteur = new JLabel("N/A");
		GridBagConstraints gbc_lblDataauteur = new GridBagConstraints();
		gbc_lblDataauteur.anchor = GridBagConstraints.WEST;
		gbc_lblDataauteur.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataauteur.gridx = 3;
		gbc_lblDataauteur.gridy = 6;
		add(lblDataauteur, gbc_lblDataauteur);

		lblDatemodif = new JLabel("DateModif");
		GridBagConstraints gbc_lblDatemodif = new GridBagConstraints();
		gbc_lblDatemodif.anchor = GridBagConstraints.WEST;
		gbc_lblDatemodif.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatemodif.gridx = 1;
		gbc_lblDatemodif.gridy = 7;
		add(lblDatemodif, gbc_lblDatemodif);

		lblDatadatemodif = new JLabel("N/A");
		GridBagConstraints gbc_lblDatadatemodif = new GridBagConstraints();
		gbc_lblDatadatemodif.anchor = GridBagConstraints.WEST;
		gbc_lblDatadatemodif.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatadatemodif.gridx = 3;
		gbc_lblDatadatemodif.gridy = 7;
		add(lblDatadatemodif, gbc_lblDatadatemodif);

		lblLisible = new JLabel("Lisible");
		GridBagConstraints gbc_lblLisible = new GridBagConstraints();
		gbc_lblLisible.anchor = GridBagConstraints.WEST;
		gbc_lblLisible.insets = new Insets(0, 0, 5, 5);
		gbc_lblLisible.gridx = 1;
		gbc_lblLisible.gridy = 8;
		add(lblLisible, gbc_lblLisible);

		lblDatalisible = new JLabel("N/A");
		GridBagConstraints gbc_lblDatalisible = new GridBagConstraints();
		gbc_lblDatalisible.anchor = GridBagConstraints.WEST;
		gbc_lblDatalisible.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatalisible.gridx = 3;
		gbc_lblDatalisible.gridy = 8;
		add(lblDatalisible, gbc_lblDatalisible);

		lblDate = new JLabel("Date du jour");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 9;
		add(lblDate, gbc_lblDate);

		lblDatadate = new JLabel("N/A");
		GridBagConstraints gbc_lblDatadate = new GridBagConstraints();
		gbc_lblDatadate.anchor = GridBagConstraints.WEST;
		gbc_lblDatadate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatadate.gridx = 3;
		gbc_lblDatadate.gridy = 9;
		add(lblDatadate, gbc_lblDatadate);
		
		lblMessage = new JLabel("Fichier non supporté");
		lblMessage.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblMessage.setForeground(Color.RED);
		lblMessage.setVisible(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 10;
		add(lblMessage, gbc_lblNewLabel);
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
	 * @return the lblDataNomFichier
	 */
	public JLabel getLblDataNomFichier() {
		return lblDataNomFichier;
	}

	/**
	 * @param lblDataNomFichier the lblDataNomFichier to set
	 */
	public void setLblDataNomFichier(JLabel lblDataNomFichier) {
		this.lblDataNomFichier = lblDataNomFichier;
	}

	/**
	 * @return the lblPath
	 */
	public JLabel getLblPath() {
		return lblPath;
	}

	/**
	 * @param lblPath the lblPath to set
	 */
	public void setLblPath(JLabel lblPath) {
		this.lblPath = lblPath;
	}

	/**
	 * @return the lblDatapath
	 */
	public JLabel getLblDatapath() {
		return lblDatapath;
	}

	/**
	 * @param lblDatapath the lblDatapath to set
	 */
	public void setLblDatapath(JLabel lblDatapath) {
		this.lblDatapath = lblDatapath;
	}

	/**
	 * @return the lblExtension
	 */
	public JLabel getLblExtension() {
		return lblExtension;
	}

	/**
	 * @param lblExtension the lblExtension to set
	 */
	public void setLblExtension(JLabel lblExtension) {
		this.lblExtension = lblExtension;
	}

	/**
	 * @return the lblDataextension
	 */
	public JLabel getLblDataextension() {
		return lblDataextension;
	}

	/**
	 * @param lblDataextension the lblDataextension to set
	 */
	public void setLblDataextension(JLabel lblDataextension) {
		this.lblDataextension = lblDataextension;
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
	 * @return the lblDatatype
	 */
	public JLabel getLblDatatype() {
		return lblDatatype;
	}

	/**
	 * @param lblDatatype the lblDatatype to set
	 */
	public void setLblDatatype(JLabel lblDatatype) {
		this.lblDatatype = lblDatatype;
	}

	/**
	 * @return the lblTaille
	 */
	public JLabel getLblTaille() {
		return lblTaille;
	}

	/**
	 * @param lblTaille the lblTaille to set
	 */
	public void setLblTaille(JLabel lblTaille) {
		this.lblTaille = lblTaille;
	}

	/**
	 * @return the lblDatataille
	 */
	public JLabel getLblDatataille() {
		return lblDatataille;
	}

	/**
	 * @param lblDatataille the lblDatataille to set
	 */
	public void setLblDatataille(JLabel lblDatataille) {
		this.lblDatataille = lblDatataille;
	}

	/**
	 * @return the lblAuteur
	 */
	public JLabel getLblAuteur() {
		return lblAuteur;
	}

	/**
	 * @param lblAuteur the lblAuteur to set
	 */
	public void setLblAuteur(JLabel lblAuteur) {
		this.lblAuteur = lblAuteur;
	}

	/**
	 * @return the lblDataauteur
	 */
	public JLabel getLblDataauteur() {
		return lblDataauteur;
	}

	/**
	 * @param lblDataauteur the lblDataauteur to set
	 */
	public void setLblDataauteur(JLabel lblDataauteur) {
		this.lblDataauteur = lblDataauteur;
	}

	/**
	 * @return the lblDatemodif
	 */
	public JLabel getLblDatemodif() {
		return lblDatemodif;
	}

	/**
	 * @param lblDatemodif the lblDatemodif to set
	 */
	public void setLblDatemodif(JLabel lblDatemodif) {
		this.lblDatemodif = lblDatemodif;
	}

	/**
	 * @return the lblDatadatemodif
	 */
	public JLabel getLblDatadatemodif() {
		return lblDatadatemodif;
	}

	/**
	 * @param lblDatadatemodif the lblDatadatemodif to set
	 */
	public void setLblDatadatemodif(JLabel lblDatadatemodif) {
		this.lblDatadatemodif = lblDatadatemodif;
	}

	/**
	 * @return the lblLisible
	 */
	public JLabel getLblLisible() {
		return lblLisible;
	}

	/**
	 * @param lblLisible the lblLisible to set
	 */
	public void setLblLisible(JLabel lblLisible) {
		this.lblLisible = lblLisible;
	}

	/**
	 * @return the lblDatalisible
	 */
	public JLabel getLblDatalisible() {
		return lblDatalisible;
	}

	/**
	 * @param lblDatalisible the lblDatalisible to set
	 */
	public void setLblDatalisible(JLabel lblDatalisible) {
		this.lblDatalisible = lblDatalisible;
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

	/**
	 * @return the lblDatadate
	 */
	public JLabel getLblDatadate() {
		return lblDatadate;
	}

	/**
	 * @param lblDatadate the lblDatadate to set
	 */
	public void setLblDatadate(JLabel lblDatadate) {
		this.lblDatadate = lblDatadate;
	}

	/**
	 * @return the lblMessage
	 */
	public JLabel getLblMessage() {
		return lblMessage;
	}

	/**
	 * @param lblMessage the lblMessage to set
	 */
	public void setLblMessage(JLabel lblMessage) {
		this.lblMessage = lblMessage;
	}

}
