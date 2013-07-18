/**
 * 
 */
package sections.parseurXML.ui.contents;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sections.parseurXML.components.AbstractDictionnaire;
import sections.parseurXML.components.InformationsFichier;
import sections.parseurXML.components.TraitementDictionnaire;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import administration.Administration;
import administration.objects.Fichier;

import java.awt.FileDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

/**
 * @author Valentin DOULCIER
 * @author Simon Kesteloot
 *
 */
public class ContentParseur extends JPanel {

	private static final long serialVersionUID = 848524817828466211L;

	private JButton btnJfilechooserDictionnaire;
	private JButton btnLauncher;

	// private static Logger logger = Logger.getLogger(ContentParseur.class);

	private GridBagLayout gridBagLayout;

	private InformationsFichier informationsFichierDictionnaire;

	private Timer timer;
	private ActionListener taskPerformer;

	public boolean rede = false;

	private String nomDeFichierDictionnaire;
	private String nomDeFichierDescripteur;

	/**
	 * Create the panel.
	 * @param application
	 */
	public ContentParseur() {

		initComponents();

		btnJfilechooserDictionnaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileDialog d = new FileDialog(new JFrame(),
						"Charger un fichier XML (dictionnaire)",
						FileDialog.LOAD);
				d.setVisible(true);

				// Si un fichier est sélectionné
				if (!"".equalsIgnoreCase(d.getFile()) && (d.getFile() != null)) {

					// Init du timmer
					timer.stop();
					informationsFichierDictionnaire.getLblMessage().setVisible(false);

					nomDeFichierDictionnaire = d.getDirectory() + d.getFile();

					Fichier monFichier = new Fichier(new File(nomDeFichierDictionnaire));

					afficherInfo(monFichier, informationsFichierDictionnaire, ".xml");
					System.out.println("lecture info fichier : "
							+ nomDeFichierDictionnaire);

					if (".xml".equalsIgnoreCase(monFichier.getExtension())) {
						monFichier.setNumero(Administration.getMesFichiers()
								.size() + 1);

						Administration.getMesFichiers().add(monFichier);
					} else {
						// Rien...
					}
				}
			}
		});

		btnLauncher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("lecture fichier : " + nomDeFichierDictionnaire);
				TraitementDictionnaire td = new TraitementDictionnaire(
						nomDeFichierDictionnaire, nomDeFichierDescripteur);
			}
		});

		// gere le clignotement du cadre autour des info fichier, en cas d'erreurs
		taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// ...Perform a task...

				Border toto = new LineBorder(Color.RED, 2);
				Border tata = new LineBorder(new Color(238, 238, 238), 2);
				boolean red = !rede;
				if (red) {
					informationsFichierDictionnaire.getLblMessage().setVisible(true);
					informationsFichierDictionnaire.setBorder(toto);
					rede = true;
				} else {
					informationsFichierDictionnaire.getLblMessage().setVisible(false);
					informationsFichierDictionnaire.setBorder(tata);
					rede = false;
				}
				revalidate();
				repaint();
			}
		};
	}

	public void initComponents() {
		timer = new Timer(500, taskPerformer);
		timer.setRepeats(true);
		timer.start();

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 30, 117, 40, 117, 30, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		btnJfilechooserDictionnaire = new JButton(
				"Choisir un Fichier xml (dictionnaire)");
		GridBagConstraints gbc_btnJfilechooserXML = new GridBagConstraints();
		gbc_btnJfilechooserXML.anchor = GridBagConstraints.NORTH;
		gbc_btnJfilechooserXML.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnJfilechooserXML.insets = new Insets(0, 0, 5, 5);
		gbc_btnJfilechooserXML.gridx = 1;
		gbc_btnJfilechooserXML.gridy = 1;
		add(btnJfilechooserDictionnaire, gbc_btnJfilechooserXML);

		btnLauncher = new JButton("lancer le chargment du dictionnaire");
		GridBagConstraints gbc_btnLauncher = new GridBagConstraints();
		gbc_btnLauncher.anchor = GridBagConstraints.NORTH;
		gbc_btnLauncher.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLauncher.insets = new Insets(0, 0, 5, 5);
		gbc_btnLauncher.gridx = 1;
		gbc_btnLauncher.gridy = 3;
		add(btnLauncher, gbc_btnLauncher);

		informationsFichierDictionnaire = new InformationsFichier("fichier Dictionnaire");
		informationsFichierDictionnaire.setMinimumSize(new Dimension(325, 350));
		GridBagConstraints gbc_panelDico = new GridBagConstraints();
		gbc_panelDico.insets = new Insets(0, 0, 5, 5);
		gbc_panelDico.gridheight = 16;
		gbc_panelDico.fill = GridBagConstraints.BOTH;
		gbc_panelDico.gridx = 3;
		gbc_panelDico.gridy = 1;
		add(informationsFichierDictionnaire, gbc_panelDico);
	}

	public void afficherInfo(Fichier monFichier, InformationsFichier infoFichier, String extensionFichier) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/yyyy ~ HH:mm:ss");

		infoFichier.getLblDataNomFichier().setText(monFichier.getNom());

		infoFichier.getLblDatapath().setText(monFichier.getPath());

		infoFichier.getLblDataextension().setText(
				monFichier.getExtension());

		infoFichier.getLblDatatype().setText(monFichier.getType());

		infoFichier.getLblDatataille().setText(monFichier.getTaille());

		infoFichier.getLblDataauteur().setText(monFichier.getAuteur());

		infoFichier.getLblDatadatemodif().setText(
				simpleDateFormat.format(monFichier.getDateModification()));

		infoFichier.getLblDatalisible()
				.setText(monFichier.getCanRead());

		infoFichier.getLblDatadate().setText(
				simpleDateFormat.format(monFichier.getDateParsing()));

		if (extensionFichier.equalsIgnoreCase(monFichier.getExtension())) {
			Border toto = new LineBorder(Color.GREEN, 2);
			infoFichier.setBorder(toto);
		} else {

			timer = new Timer(500, taskPerformer);
			timer.setRepeats(true);
			timer.start();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.revalidate();
	}
}
