/**
 * 
 */
package sections.updateBDD.ui.contents;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

import administration.Administration;

import principal.Application;
import sections.parseurXML.components.InformationsFichier;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentUpdate extends JPanel {

	private static final long serialVersionUID = -3584920438752843211L;

	private GridBagLayout gridBagLayout;
	
	private InformationsFichier informationsFichier;
	
	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentUpdate(final Application application) {

		initComponents();

	}

	public void initComponents() {
		setLayout(null);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 117, 40, 117, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 29, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		informationsFichier = new InformationsFichier();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridheight = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		add(informationsFichier, gbc_panel);
	}


	public void afficherInfo(Application application, int numeroFichier) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy ~ HH:mm:ss");

		informationsFichier.getLblDataNomFichier().setText(Administration.getMesFichiers().get(numeroFichier).getNom());

		informationsFichier.getLblDatapath().setText(Administration.getMesFichiers().get(numeroFichier).getPath());

		informationsFichier.getLblDataextension().setText(Administration.getMesFichiers().get(numeroFichier).getExtension());

		informationsFichier.getLblDatatype().setText(Administration.getMesFichiers().get(numeroFichier).getType());

		informationsFichier.getLblDatataille().setText(Administration.getMesFichiers().get(numeroFichier).getTaille());

		informationsFichier.getLblDataauteur().setText(Administration.getMesFichiers().get(numeroFichier).getAuteur());

		informationsFichier.getLblDatadatemodif().setText(simpleDateFormat.format(Administration.getMesFichiers().get(numeroFichier).getDateModification()));

		informationsFichier.getLblDatalisible().setText(Administration.getMesFichiers().get(numeroFichier).getCanRead());

		informationsFichier.getLblDatadate().setText(simpleDateFormat.format(Administration.getMesFichiers().get(numeroFichier).getDateParsing()));

		this.revalidate();
	}
}
