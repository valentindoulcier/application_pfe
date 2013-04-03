/**
 * 
 */
package sections.parseurXML.ui.contents;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sections.parseurXML.components.InformationsFichier;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import administration.Administration;
import administration.Fichier;

import java.awt.FileDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentParseur extends JPanel {

	private static final long serialVersionUID = 848524817828466211L;

	private JButton btnJfilechooser;

	//private static Logger logger = Logger.getLogger(ContentParseur.class);

	private GridBagLayout gridBagLayout;
	
	private InformationsFichier informationsFichier;

	private Timer timer;
	private ActionListener taskPerformer;

	public boolean rede = false;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentParseur() {


		initComponents();

		btnJfilechooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileDialog d = new FileDialog(new JFrame(), "Charger un fichier XML", FileDialog.LOAD);
				d.setVisible(true);

				// Si un fichier est sélectionné
				if(!"".equalsIgnoreCase(d.getFile()) &&  (d.getFile() != null)) {

					// Init du timmer
					timer.stop();
					informationsFichier.getLblMessage().setVisible(false);

					Fichier monFichier = new Fichier(new File(d.getDirectory() + d.getFile()));

					afficherInfo(monFichier);

					if(".xml".equalsIgnoreCase(monFichier.getExtension())) {
						monFichier.setNumero(Administration.getMesFichiers().size() + 1);

						Administration.getMesFichiers().add(monFichier);
					}
					else {
						// Rien...
					}
				}
			}
		});

		taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//...Perform a task...

				Border toto = new LineBorder(Color.RED, 2);
				Border tata = new LineBorder(new Color(238, 238, 238), 2);
				boolean red = !rede;
				if(red) {
					informationsFichier.getLblMessage().setVisible(true);
					informationsFichier.setBorder(toto);
					rede = true;
				}
				else {
					informationsFichier.getLblMessage().setVisible(false);
					informationsFichier.setBorder(tata);
					rede = false;
				}
				revalidate();
				repaint();
			}
		};
	}

	public void initComponents() {
		timer = new Timer( 500 , taskPerformer);
		timer.setRepeats(true);
		timer.start();

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 117, 40, 117, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 29, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		btnJfilechooser = new JButton("JFileChooser");
		GridBagConstraints gbc_btnJfilechooser = new GridBagConstraints();
		gbc_btnJfilechooser.insets = new Insets(0, 0, 5, 5);
		gbc_btnJfilechooser.anchor = GridBagConstraints.NORTH;
		gbc_btnJfilechooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnJfilechooser.gridx = 1;
		gbc_btnJfilechooser.gridy = 1;
		add(btnJfilechooser, gbc_btnJfilechooser);

		informationsFichier = new InformationsFichier();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridheight = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		add(informationsFichier, gbc_panel);
	}


	public void afficherInfo(Fichier monFichier) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy ~ HH:mm:ss");

		informationsFichier.getLblDataNomFichier().setText(monFichier.getNom());

		informationsFichier.getLblDatapath().setText(monFichier.getPath());

		informationsFichier.getLblDataextension().setText(monFichier.getExtension());

		informationsFichier.getLblDatatype().setText(monFichier.getType());

		informationsFichier.getLblDatataille().setText(monFichier.getTaille());

		informationsFichier.getLblDataauteur().setText(monFichier.getAuteur());

		informationsFichier.getLblDatadatemodif().setText(simpleDateFormat.format(monFichier.getDateModification()));

		informationsFichier.getLblDatalisible().setText(monFichier.getCanRead());

		informationsFichier.getLblDatadate().setText(simpleDateFormat.format(monFichier.getDateParsing()));

		if(".xml".equalsIgnoreCase(monFichier.getExtension())) {
			Border toto = new LineBorder(Color.GREEN, 2);
			informationsFichier.setBorder(toto);
		}
		else {

			timer = new Timer( 500 , taskPerformer);
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