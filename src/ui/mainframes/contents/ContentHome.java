/**
 * 
 */
package ui.mainframes.contents;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JButton;

import principal.Application;
import ui.mainframes.volets.*;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * @author Valentin
 *
 */
public class ContentHome extends JPanel {

	private static final long serialVersionUID = 8023381629976468353L;

	private JLabel lblApplication;

	private JLabel lblDescription;

	private JButton btnRecherche;
	private JButton btnLiensDictionnaires;
	private JButton btnOptions;

	// Recherche
	private VoletFooterRecherche voletFooterRecherche;
	private VoletFooterEdition voletFooterEdition;
	
	private VoletHeaderRechercheSimple voletHeaderRechercheSimple;
	private VoletRechercheSimple voletRechercheSimple;
	private VoletHeaderRechercheAvancee voletHeaderRechercheAvancee;
	private VoletRechercheAvancee voletRechercheAvancee;
	private VoletHeaderHistorique voletHeaderHistorique;
	private VoletHistorique voletHistorique;
	private VoletHeaderEdition voletHeaderEdition;
	private VoletEdition voletEdition;

	private ContentFooterRecherche contentFooterRecherche;
	private ContentFooterEdition contentFooterEdition;
	
	private ContentHeaderRechercheSimple contentHeaderRechercheSimple;
	private ContentRechercheSimple contentRechercheSimple;
	private ContentHeaderRechercheAvancee contentHeaderRechercheAvancee;
	private ContentRechercheAvancee contentRechercheAvancee;
	private ContentHeaderHistorique contentHeaderHistorique;
	private ContentHistorique contentHistorique;
	private ContentHeaderEdition contentHeaderEdition;
	private ContentEdition contentEdition;

	// Liens Dictionnaires
	private VoletHeaderLiensDictionnaires voletHeaderLiensDictionnaires;
	private VoletLiensDictionnaires voletLiensDictionnaires;
	private VoletFooterLiensDictionnaires voletFooterLiensDictionnaires;

	private ContentHeaderLiensDictionnaires contentHeaderLiensDictionnaires;
	private ContentLiensDictionnaires contentLiensDictionnaires;
	private ContentFooterLiensDictionnaires contentFooterLiensDictionnaires;

	// Options
	private VoletHeaderOptions voletHeaderOptions;
	private VoletOptions voletOptions;
	private VoletFooterOptions voletFooterOptions;

	private ContentHeaderOptions contentHeaderOptions;
	private ContentOptions contentOptions;
	private ContentFooterOptions contentFooterOptions;


	/**
	 * Create the panel.
	 */
	public ContentHome(final Application application) {

		setBackground(Color.LIGHT_GRAY);

		initComponents();


		btnRecherche.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				// VOLET
				voletFooterRecherche = new VoletFooterRecherche(application);
				voletFooterEdition = new VoletFooterEdition(application);
				
				voletHeaderRechercheSimple = new VoletHeaderRechercheSimple();
				voletRechercheSimple = new VoletRechercheSimple(application);
				voletHeaderRechercheAvancee = new VoletHeaderRechercheAvancee();
				voletRechercheAvancee = new VoletRechercheAvancee(application);
				voletHeaderHistorique = new VoletHeaderHistorique();
				voletHistorique = new VoletHistorique(application);
				voletHeaderEdition = new VoletHeaderEdition();
				voletEdition = new VoletEdition(application);

				application.getvFooter().add(voletFooterRecherche, "voletFooterRecherche");
				application.getvFooter().add(voletFooterEdition, "voletFooterEdition");
				
				application.getvHeader().add(voletHeaderRechercheSimple, "voletHeaderRechercheSimple");
				application.getvPanel().add(voletRechercheSimple, "voletRechercheSimple");
				application.getvHeader().add(voletHeaderRechercheAvancee, "voletHeaderRechercheAvancee");
				application.getvPanel().add(voletRechercheAvancee, "voletRechercheAvancee");
				application.getvHeader().add(voletHeaderHistorique, "voletHeaderHistorique");
				application.getvPanel().add(voletHistorique, "voletHistorique");
				application.getvHeader().add(voletHeaderEdition, "voletHeaderEdition");
				application.getvPanel().add(voletEdition, "voletEdition");


				application.getVoletHeader().show(application.getvHeader(), "voletHeaderRechercheSimple");
				application.getVoletPanel().show(application.getvPanel(), "voletRechercheSimple");
				application.getVoletFooter().show(application.getvFooter(), "voletFooterRecherche");

				// CONTENT
				contentFooterRecherche = new ContentFooterRecherche(application);
				contentFooterEdition = new ContentFooterEdition(application);
				
				contentHeaderRechercheSimple = new ContentHeaderRechercheSimple(application);
				contentRechercheSimple = new ContentRechercheSimple(application);
				contentHeaderRechercheAvancee = new ContentHeaderRechercheAvancee(application);
				contentRechercheAvancee = new ContentRechercheAvancee(application);
				contentHeaderHistorique = new ContentHeaderHistorique(application);
				contentHistorique = new ContentHistorique(application);
				contentHeaderEdition = new ContentHeaderEdition(application);
				contentEdition = new ContentEdition(application);

				application.getcFooter().add(contentFooterRecherche, "contentFooterRecherche");
				application.getcFooter().add(contentFooterEdition, "contentFooterEdition");
				
				application.getcHeader().add(contentHeaderRechercheSimple, "contentHeaderRechercheSimple");
				application.getcPanel().add(contentRechercheSimple, "contentRechercheSimple");
				application.getcHeader().add(contentHeaderRechercheAvancee, "contentHeaderRechercheAvancee");
				application.getcPanel().add(contentRechercheAvancee, "contentRechercheAvancee");
				application.getcHeader().add(contentHeaderHistorique, "contentHeaderHistorique");
				application.getcPanel().add(contentHistorique, "contentHistorique");
				application.getcHeader().add(contentHeaderEdition, "contentHeaderEdition");
				application.getcPanel().add(contentEdition, "contentEdition");

				application.getContentHeader().show(application.getcHeader(), "contentHeaderRechercheSimple");
				application.getContentPanel().show(application.getcPanel(), "contentRechercheSimple");
				application.getContentFooter().show(application.getcFooter(), "contentFooterRecherche");

				application.OuvrirVolet();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour effectuer une nouvelle recherche");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});


		btnLiensDictionnaires.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// VOLET
				voletHeaderLiensDictionnaires = new VoletHeaderLiensDictionnaires();
				voletLiensDictionnaires = new VoletLiensDictionnaires();
				voletFooterLiensDictionnaires = new VoletFooterLiensDictionnaires();

				application.getvHeader().add(voletHeaderLiensDictionnaires, "voletHeaderLiensDictionnaires");
				application.getvPanel().add(voletLiensDictionnaires, "voletLiensDictionnaires");
				application.getvFooter().add(voletFooterLiensDictionnaires, "voletFooterLiensDictionnaires");

				application.getVoletHeader().show(application.getvHeader(), "voletHeaderLiensDictionnaires");
				application.getVoletPanel().show(application.getvPanel(), "voletLiensDictionnaires");
				application.getVoletFooter().show(application.getvFooter(), "voletFooterLiensDictionnaires");

				// CONTENT
				contentHeaderLiensDictionnaires = new ContentHeaderLiensDictionnaires(application);
				contentLiensDictionnaires = new ContentLiensDictionnaires(application);
				contentFooterLiensDictionnaires = new ContentFooterLiensDictionnaires(application);

				application.getcHeader().add(contentHeaderLiensDictionnaires, "contentHeaderLiensDictionnaires");
				application.getcPanel().add(contentLiensDictionnaires, "contentLiensDictionnaires");
				application.getcFooter().add(contentFooterLiensDictionnaires, "contentFooterLiensDictionnaires");

				application.getContentHeader().show(application.getcHeader(), "contentHeaderLiensDictionnaires");
				application.getContentPanel().show(application.getcPanel(), "contentLiensDictionnaires");
				application.getContentFooter().show(application.getcFooter(), "contentFooterLiensDictionnaires");

				application.OuvrirVolet();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour éditer les liens dictionnaires");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});


		btnOptions.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// VOLET
				voletHeaderOptions = new VoletHeaderOptions();
				voletOptions = new VoletOptions();
				voletFooterOptions = new VoletFooterOptions();

				application.getvHeader().add(voletHeaderOptions, "voletHeaderOptions");
				application.getvPanel().add(voletOptions, "voletOptions");
				application.getvFooter().add(voletFooterOptions, "voletFooterOptions");

				application.getVoletHeader().show(application.getvHeader(), "voletHeaderOptions");
				application.getVoletPanel().show(application.getvPanel(), "voletOptions");
				application.getVoletFooter().show(application.getvFooter(), "voletFooterOptions");

				// CONTENT
				contentHeaderOptions = new ContentHeaderOptions(application);
				contentOptions = new ContentOptions(application);
				contentFooterOptions = new ContentFooterOptions(application);

				application.getcHeader().add(contentHeaderOptions, "contentHeaderOptions");
				application.getcPanel().add(contentOptions, "contentOptions");
				application.getcFooter().add(contentFooterOptions, "contentFooterOptions");

				application.getContentHeader().show(application.getcHeader(), "contentHeaderOptions");
				application.getContentPanel().show(application.getcPanel(), "contentOptions");
				application.getContentFooter().show(application.getcFooter(), "contentFooterOptions");

				application.OuvrirVolet();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour accéder aux options");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void initComponents() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 120, 30, 120, 30, 120, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 56, 45, 30, 10, 100, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblApplication = new JLabel("Laboratoire Ligérien de Linguistique");
		lblApplication.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		GridBagConstraints gbc_lblApplication = new GridBagConstraints();
		gbc_lblApplication.gridwidth = 5;
		gbc_lblApplication.insets = new Insets(0, 0, 5, 5);
		gbc_lblApplication.gridx = 2;
		gbc_lblApplication.gridy = 1;
		add(lblApplication, gbc_lblApplication);

		lblDescription = new JLabel("");
		lblDescription.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.gridwidth = 5;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 2;
		gbc_lblDescription.gridy = 3;
		add(lblDescription, gbc_lblDescription);

		btnRecherche = new JButton("Recherche");
		btnRecherche.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnRecherche = new GridBagConstraints();
		gbc_btnRecherche.fill = GridBagConstraints.BOTH;
		gbc_btnRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecherche.gridx = 2;
		gbc_btnRecherche.gridy = 5;
		add(btnRecherche, gbc_btnRecherche);

		btnLiensDictionnaires = new JButton("Liens Dico");
		btnLiensDictionnaires.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnLiensDictionnaires = new GridBagConstraints();
		gbc_btnLiensDictionnaires.fill = GridBagConstraints.BOTH;
		gbc_btnLiensDictionnaires.insets = new Insets(0, 0, 5, 5);
		gbc_btnLiensDictionnaires.gridx = 4;
		gbc_btnLiensDictionnaires.gridy = 5;
		add(btnLiensDictionnaires, gbc_btnLiensDictionnaires);

		btnOptions = new JButton("Options");
		btnOptions.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnOptions = new GridBagConstraints();
		gbc_btnOptions.fill = GridBagConstraints.BOTH;
		gbc_btnOptions.insets = new Insets(0, 0, 5, 5);
		gbc_btnOptions.gridx = 6;
		gbc_btnOptions.gridy = 5;
		add(btnOptions, gbc_btnOptions);
	}

	/**
	 * @return the lblApplication
	 */
	public JLabel getLblApplication() {
		return lblApplication;
	}

	/**
	 * @param lblApplication the lblApplication to set
	 */
	public void setLblApplication(JLabel lblApplication) {
		this.lblApplication = lblApplication;
	}

	/**
	 * @return the lblDescription
	 */
	public JLabel getLblDescription() {
		return lblDescription;
	}

	/**
	 * @param lblDescription the lblDescription to set
	 */
	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}

	/**
	 * @return the btnRecherche
	 */
	public JButton getBtnRecherche() {
		return btnRecherche;
	}

	/**
	 * @param btnRecherche the btnRecherche to set
	 */
	public void setBtnRecherche(JButton btnRecherche) {
		this.btnRecherche = btnRecherche;
	}

	/**
	 * @return the btnLiensDictionnaires
	 */
	public JButton getBtnLiensDictionnaires() {
		return btnLiensDictionnaires;
	}

	/**
	 * @param btnLiensDictionnaires the btnLiensDictionnaires to set
	 */
	public void setBtnLiensDictionnaires(JButton btnLiensDictionnaires) {
		this.btnLiensDictionnaires = btnLiensDictionnaires;
	}

	/**
	 * @return the btnOptions
	 */
	public JButton getBtnOptions() {
		return btnOptions;
	}

	/**
	 * @param btnOptions the btnOptions to set
	 */
	public void setBtnOptions(JButton btnOptions) {
		this.btnOptions = btnOptions;
	}

	/**
	 * @return the voletHeaderRecherche
	 */
	public VoletHeaderRechercheSimple getVoletHeaderRechercheSimple() {
		return voletHeaderRechercheSimple;
	}

	/**
	 * @param voletHeaderRechercheSimple the voletHeaderRecherche to set
	 */
	public void setVoletHeaderRechercheSimple(VoletHeaderRechercheSimple voletHeaderRechercheSimple) {
		this.voletHeaderRechercheSimple = voletHeaderRechercheSimple;
	}

	/**
	 * @return the voletHeaderRechercheAvancee
	 */
	public VoletHeaderRechercheAvancee getVoletHeaderRechercheAvancee() {
		return voletHeaderRechercheAvancee;
	}

	/**
	 * @param voletHeaderRechercheAvancee the voletHeaderRechercheAvancee to set
	 */
	public void setVoletHeaderRechercheAvancee(
			VoletHeaderRechercheAvancee voletHeaderRechercheAvancee) {
		this.voletHeaderRechercheAvancee = voletHeaderRechercheAvancee;
	}

	/**
	 * @return the voletRechercheAvancee
	 */
	public VoletRechercheAvancee getVoletRechercheAvancee() {
		return voletRechercheAvancee;
	}

	/**
	 * @param voletRechercheAvancee the voletRechercheAvancee to set
	 */
	public void setVoletRechercheAvancee(VoletRechercheAvancee voletRechercheAvancee) {
		this.voletRechercheAvancee = voletRechercheAvancee;
	}

	/**
	 * @return the contentHeaderRechercheAvancee
	 */
	public ContentHeaderRechercheAvancee getContentHeaderRechercheAvancee() {
		return contentHeaderRechercheAvancee;
	}

	/**
	 * @param contentHeaderRechercheAvancee the contentHeaderRechercheAvancee to set
	 */
	public void setContentHeaderRechercheAvancee(
			ContentHeaderRechercheAvancee contentHeaderRechercheAvancee) {
		this.contentHeaderRechercheAvancee = contentHeaderRechercheAvancee;
	}

	/**
	 * @return the contentRechercheAvancee
	 */
	public ContentRechercheAvancee getContentRechercheAvancee() {
		return contentRechercheAvancee;
	}

	/**
	 * @param contentRechercheAvancee the contentRechercheAvancee to set
	 */
	public void setContentRechercheAvancee(
			ContentRechercheAvancee contentRechercheAvancee) {
		this.contentRechercheAvancee = contentRechercheAvancee;
	}

	/**
	 * @return the voletFooterEdition
	 */
	public VoletFooterEdition getVoletFooterEdition() {
		return voletFooterEdition;
	}

	/**
	 * @param voletFooterEdition the voletFooterEdition to set
	 */
	public void setVoletFooterEdition(VoletFooterEdition voletFooterEdition) {
		this.voletFooterEdition = voletFooterEdition;
	}

	/**
	 * @return the voletHeaderEdition
	 */
	public VoletHeaderEdition getVoletHeaderEdition() {
		return voletHeaderEdition;
	}

	/**
	 * @param voletHeaderEdition the voletHeaderEdition to set
	 */
	public void setVoletHeaderEdition(VoletHeaderEdition voletHeaderEdition) {
		this.voletHeaderEdition = voletHeaderEdition;
	}

	/**
	 * @return the voletEdition
	 */
	public VoletEdition getVoletEdition() {
		return voletEdition;
	}

	/**
	 * @param voletEdition the voletEdition to set
	 */
	public void setVoletEdition(VoletEdition voletEdition) {
		this.voletEdition = voletEdition;
	}

	/**
	 * @return the contentFooterEdition
	 */
	public ContentFooterEdition getContentFooterEdition() {
		return contentFooterEdition;
	}

	/**
	 * @param contentFooterEdition the contentFooterEdition to set
	 */
	public void setContentFooterEdition(ContentFooterEdition contentFooterEdition) {
		this.contentFooterEdition = contentFooterEdition;
	}

	/**
	 * @return the contentHeaderEdition
	 */
	public ContentHeaderEdition getContentHeaderEdition() {
		return contentHeaderEdition;
	}

	/**
	 * @param contentHeaderEdition the contentHeaderEdition to set
	 */
	public void setContentHeaderEdition(ContentHeaderEdition contentHeaderEdition) {
		this.contentHeaderEdition = contentHeaderEdition;
	}

	/**
	 * @return the contentEdition
	 */
	public ContentEdition getContentEdition() {
		return contentEdition;
	}

	/**
	 * @param contentEdition the contentEdition to set
	 */
	public void setContentEdition(ContentEdition contentEdition) {
		this.contentEdition = contentEdition;
	}

	/**
	 * @return the voletHeaderHistorique
	 */
	public VoletHeaderHistorique getVoletHeaderHistorique() {
		return voletHeaderHistorique;
	}

	/**
	 * @param voletHeaderHistorique the voletHeaderHistorique to set
	 */
	public void setVoletHeaderHistorique(VoletHeaderHistorique voletHeaderHistorique) {
		this.voletHeaderHistorique = voletHeaderHistorique;
	}

	/**
	 * @return the voletHistorique
	 */
	public VoletHistorique getVoletHistorique() {
		return voletHistorique;
	}

	/**
	 * @param voletHistorique the voletHistorique to set
	 */
	public void setVoletHistorique(VoletHistorique voletHistorique) {
		this.voletHistorique = voletHistorique;
	}

	/**
	 * @return the contentHeaderHistorique
	 */
	public ContentHeaderHistorique getContentHeaderHistorique() {
		return contentHeaderHistorique;
	}

	/**
	 * @param contentHeaderHistorique the contentHeaderHistorique to set
	 */
	public void setContentHeaderHistorique(
			ContentHeaderHistorique contentHeaderHistorique) {
		this.contentHeaderHistorique = contentHeaderHistorique;
	}

	/**
	 * @return the contentHistorique
	 */
	public ContentHistorique getContentHistorique() {
		return contentHistorique;
	}

	/**
	 * @param contentHistorique the contentHistorique to set
	 */
	public void setContentHistorique(ContentHistorique contentHistorique) {
		this.contentHistorique = contentHistorique;
	}

	/**
	 * @return the voletRecherche
	 */
	public VoletRechercheSimple getVoletRechercheSimple() {
		return voletRechercheSimple;
	}

	/**
	 * @param voletRechercheSimple the voletRecherche to set
	 */
	public void setVoletRechercheSimple(VoletRechercheSimple voletRechercheSimple) {
		this.voletRechercheSimple = voletRechercheSimple;
	}

	/**
	 * @return the voletFooterRecherche
	 */
	public VoletFooterRecherche getVoletFooterRecherche() {
		return voletFooterRecherche;
	}

	/**
	 * @param voletFooterRecherche the voletFooterRecherche to set
	 */
	public void setVoletFooterRecherche(VoletFooterRecherche voletFooterRecherche) {
		this.voletFooterRecherche = voletFooterRecherche;
	}

	/**
	 * @return the contentHeaderRecherche
	 */
	public ContentHeaderRechercheSimple getContentHeaderRechercheSimple() {
		return contentHeaderRechercheSimple;
	}

	/**
	 * @param contentHeaderRechercheSimple the contentHeaderRecherche to set
	 */
	public void setContentHeaderRechercheSimple(
			ContentHeaderRechercheSimple contentHeaderRechercheSimple) {
		this.contentHeaderRechercheSimple = contentHeaderRechercheSimple;
	}

	/**
	 * @return the contentRecherche
	 */
	public ContentRechercheSimple getContentRechercheSimple() {
		return contentRechercheSimple;
	}

	/**
	 * @param contentRechercheSimple the contentRecherche to set
	 */
	public void setContentRechercheSimple(ContentRechercheSimple contentRechercheSimple) {
		this.contentRechercheSimple = contentRechercheSimple;
	}

	/**
	 * @return the contentFooterRecherche
	 */
	public ContentFooterRecherche getContentFooterRecherche() {
		return contentFooterRecherche;
	}

	/**
	 * @param contentFooterRecherche the contentFooterRecherche to set
	 */
	public void setContentFooterRecherche(
			ContentFooterRecherche contentFooterRecherche) {
		this.contentFooterRecherche = contentFooterRecherche;
	}

	/**
	 * @return the voletHeaderLiensDictionnaires
	 */
	public VoletHeaderLiensDictionnaires getVoletHeaderLiensDictionnaires() {
		return voletHeaderLiensDictionnaires;
	}

	/**
	 * @param voletHeaderLiensDictionnaires the voletHeaderLiensDictionnaires to set
	 */
	public void setVoletHeaderLiensDictionnaires(
			VoletHeaderLiensDictionnaires voletHeaderLiensDictionnaires) {
		this.voletHeaderLiensDictionnaires = voletHeaderLiensDictionnaires;
	}

	/**
	 * @return the voletLiensDictionnaires
	 */
	public VoletLiensDictionnaires getVoletLiensDictionnaires() {
		return voletLiensDictionnaires;
	}

	/**
	 * @param voletLiensDictionnaires the voletLiensDictionnaires to set
	 */
	public void setVoletLiensDictionnaires(
			VoletLiensDictionnaires voletLiensDictionnaires) {
		this.voletLiensDictionnaires = voletLiensDictionnaires;
	}

	/**
	 * @return the voletFooterLiensDictionnaires
	 */
	public VoletFooterLiensDictionnaires getVoletFooterLiensDictionnaires() {
		return voletFooterLiensDictionnaires;
	}

	/**
	 * @param voletFooterLiensDictionnaires the voletFooterLiensDictionnaires to set
	 */
	public void setVoletFooterLiensDictionnaires(
			VoletFooterLiensDictionnaires voletFooterLiensDictionnaires) {
		this.voletFooterLiensDictionnaires = voletFooterLiensDictionnaires;
	}

	/**
	 * @return the contentHeaderLiensDictionnaires
	 */
	public ContentHeaderLiensDictionnaires getContentHeaderLiensDictionnaires() {
		return contentHeaderLiensDictionnaires;
	}

	/**
	 * @param contentHeaderLiensDictionnaires the contentHeaderLiensDictionnaires to set
	 */
	public void setContentHeaderLiensDictionnaires(
			ContentHeaderLiensDictionnaires contentHeaderLiensDictionnaires) {
		this.contentHeaderLiensDictionnaires = contentHeaderLiensDictionnaires;
	}

	/**
	 * @return the contentLiensDictionnaires
	 */
	public ContentLiensDictionnaires getContentLiensDictionnaires() {
		return contentLiensDictionnaires;
	}

	/**
	 * @param contentLiensDictionnaires the contentLiensDictionnaires to set
	 */
	public void setContentLiensDictionnaires(
			ContentLiensDictionnaires contentLiensDictionnaires) {
		this.contentLiensDictionnaires = contentLiensDictionnaires;
	}

	/**
	 * @return the contentFooterLiensDictionnaires
	 */
	public ContentFooterLiensDictionnaires getContentFooterLiensDictionnaires() {
		return contentFooterLiensDictionnaires;
	}

	/**
	 * @param contentFooterLiensDictionnaires the contentFooterLiensDictionnaires to set
	 */
	public void setContentFooterLiensDictionnaires(
			ContentFooterLiensDictionnaires contentFooterLiensDictionnaires) {
		this.contentFooterLiensDictionnaires = contentFooterLiensDictionnaires;
	}

	/**
	 * @return the voletHeaderOptions
	 */
	public VoletHeaderOptions getVoletHeaderOptions() {
		return voletHeaderOptions;
	}

	/**
	 * @param voletHeaderOptions the voletHeaderOptions to set
	 */
	public void setVoletHeaderOptions(VoletHeaderOptions voletHeaderOptions) {
		this.voletHeaderOptions = voletHeaderOptions;
	}

	/**
	 * @return the voletOptions
	 */
	public VoletOptions getVoletOptions() {
		return voletOptions;
	}

	/**
	 * @param voletOptions the voletOptions to set
	 */
	public void setVoletOptions(VoletOptions voletOptions) {
		this.voletOptions = voletOptions;
	}

	/**
	 * @return the voletFooterOptions
	 */
	public VoletFooterOptions getVoletFooterOptions() {
		return voletFooterOptions;
	}

	/**
	 * @param voletFooterOptions the voletFooterOptions to set
	 */
	public void setVoletFooterOptions(VoletFooterOptions voletFooterOptions) {
		this.voletFooterOptions = voletFooterOptions;
	}

	/**
	 * @return the contentHeaderOptions
	 */
	public ContentHeaderOptions getContentHeaderOptions() {
		return contentHeaderOptions;
	}

	/**
	 * @param contentHeaderOptions the contentHeaderOptions to set
	 */
	public void setContentHeaderOptions(ContentHeaderOptions contentHeaderOptions) {
		this.contentHeaderOptions = contentHeaderOptions;
	}

	/**
	 * @return the contentOptions
	 */
	public ContentOptions getContentOptions() {
		return contentOptions;
	}

	/**
	 * @param contentOptions the contentOptions to set
	 */
	public void setContentOptions(ContentOptions contentOptions) {
		this.contentOptions = contentOptions;
	}

	/**
	 * @return the contentFooterOptions
	 */
	public ContentFooterOptions getContentFooterOptions() {
		return contentFooterOptions;
	}

	/**
	 * @param contentFooterOptions the contentFooterOptions to set
	 */
	public void setContentFooterOptions(ContentFooterOptions contentFooterOptions) {
		this.contentFooterOptions = contentFooterOptions;
	}

}
