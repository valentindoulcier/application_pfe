/**
 * 
 */
package ui.mainframes.contents;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import principal.Application;

/**
 * @author Valentin
 *
 */
public class ContentHeaderRechercheSimple extends JPanel {

	private static final long serialVersionUID = 5428423567932680960L;

	private static Logger logger = Logger.getLogger(ContentHeaderRechercheSimple.class);

	private static boolean ouvert = false;

	/**
	 * Create the panel.
	 */
	public ContentHeaderRechercheSimple(final Application application) {
		setBackground(Color.GRAY);		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		Box horizontalBox = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox = new GridBagConstraints();
		gbc_horizontalBox.fill = GridBagConstraints.BOTH;
		gbc_horizontalBox.gridx = 0;
		gbc_horizontalBox.gridy = 0;
		add(horizontalBox, gbc_horizontalBox);

		JButton btnHome = new JButton("HOME");
		horizontalBox.add(btnHome);

		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				application.getContentHeader().show(application.getcHeader(), "ContentHeaderHome");
				application.getContentPanel().show(application.getcPanel(), "ContentHome");
				application.getContentFooter().show(application.getcFooter(), "ContentFooterHome");

				application.FermerVolet();

				application.getcHeader().remove(application.getContentHome().getContentHeaderEdition());
				application.getcPanel().remove(application.getContentHome().getContentEdition());
				application.getcFooter().remove(application.getContentHome().getContentFooterEdition());

				application.getvHeader().remove(application.getContentHome().getVoletHeaderEdition());
				application.getvPanel().remove(application.getContentHome().getVoletEdition());
				application.getvFooter().remove(application.getContentHome().getVoletFooterEdition());


				application.getcFooter().remove(application.getContentHome().getContentFooterRecherche());
				application.getvFooter().remove(application.getContentHome().getVoletFooterRecherche());


				if(application.getContentHome().getVoletFooterRecherche().getJeViensDe() == -1) {
					application.getvHeader().remove(application.getContentHome().getVoletHeaderRechercheSimple());
					application.getvPanel().remove(application.getContentHome().getVoletRechercheSimple());

					application.getcHeader().remove(application.getContentHome().getContentHeaderRechercheSimple());
					application.getcPanel().remove(application.getContentHome().getContentRechercheSimple());
				}
				else if(application.getContentHome().getVoletFooterRecherche().getJeViensDe() == 1) {
					application.getvHeader().remove(application.getContentHome().getVoletFooterRecherche().getVoletHeaderRechercheSimple());
					application.getvPanel().remove(application.getContentHome().getVoletFooterRecherche().getVoletRechercheSimple());

					application.getcHeader().remove(application.getContentHome().getVoletFooterRecherche().getContentHeaderRechercheSimple());
					application.getcPanel().remove(application.getContentHome().getVoletFooterRecherche().getContentRechercheSimple());
				}
				else {
					logger.error("Problème ligne 80 ContentHeaderRechercheSimple");
				}
			}
		});

		final JButton btnNewButton = new JButton("FERMER");
		horizontalBox.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ouvert) {
					application.OuvrirVolet();
					btnNewButton.setText("FERMER");
					ouvert = false;
				}
				else {
					application.FermerVolet();
					btnNewButton.setText("OUVRIR");
					ouvert = true;
				}
			}
		});
	}

}
