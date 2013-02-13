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
	private VoletHeaderRecherche voletHeaderRecherche;
	private VoletRecherche voletRecherche;
	private VoletFooterRecherche voletFooterRecherche;

	private ContentHeaderRecherche contentHeaderRecherche;
	private ContentRecherche contentRecherche;
	private ContentFooterRecherche contentFooterRecherche;

	// Options
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
				voletHeaderRecherche = new VoletHeaderRecherche();
				voletRecherche = new VoletRecherche();
				voletFooterRecherche = new VoletFooterRecherche();

				application.getvHeader().add(voletHeaderRecherche, "voletHeaderRecherche");
				application.getvPanel().add(voletRecherche, "voletRecherche");
				application.getvFooter().add(voletFooterRecherche, "voletFooterRecherche");

				application.getVoletHeader().show(application.getvHeader(), "voletHeaderRecherche");
				application.getVoletPanel().show(application.getvPanel(), "voletRecherche");
				application.getVoletFooter().show(application.getvFooter(), "voletFooterRecherche");

				// CONTENT
				contentHeaderRecherche = new ContentHeaderRecherche(application);
				contentRecherche = new ContentRecherche(application);
				contentFooterRecherche = new ContentFooterRecherche(application);

				application.getcHeader().add(contentHeaderRecherche, "contentHeaderRecherche");
				application.getcPanel().add(contentRecherche, "contentRecherche");
				application.getcFooter().add(contentFooterRecherche, "contentFooterRecherche");

				application.getContentHeader().show(application.getcHeader(), "contentHeaderRecherche");
				application.getContentPanel().show(application.getcPanel(), "contentRecherche");
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
	public VoletHeaderRecherche getVoletHeaderRecherche() {
		return voletHeaderRecherche;
	}

	/**
	 * @param voletHeaderRecherche the voletHeaderRecherche to set
	 */
	public void setVoletHeaderRecherche(VoletHeaderRecherche voletHeaderRecherche) {
		this.voletHeaderRecherche = voletHeaderRecherche;
	}

	/**
	 * @return the voletRecherche
	 */
	public VoletRecherche getVoletRecherche() {
		return voletRecherche;
	}

	/**
	 * @param voletRecherche the voletRecherche to set
	 */
	public void setVoletRecherche(VoletRecherche voletRecherche) {
		this.voletRecherche = voletRecherche;
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
	public ContentHeaderRecherche getContentHeaderRecherche() {
		return contentHeaderRecherche;
	}

	/**
	 * @param contentHeaderRecherche the contentHeaderRecherche to set
	 */
	public void setContentHeaderRecherche(
			ContentHeaderRecherche contentHeaderRecherche) {
		this.contentHeaderRecherche = contentHeaderRecherche;
	}

	/**
	 * @return the contentRecherche
	 */
	public ContentRecherche getContentRecherche() {
		return contentRecherche;
	}

	/**
	 * @param contentRecherche the contentRecherche to set
	 */
	public void setContentRecherche(ContentRecherche contentRecherche) {
		this.contentRecherche = contentRecherche;
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
