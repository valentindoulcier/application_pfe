/**
 * 
 */
package sections.bddictionnairique.ui.contents;

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
 * @author Valentin DOULCIER
 *
 */
public class ContentHeaderRechercheSimple extends JPanel {

	private static final long serialVersionUID = 5428423567932680960L;

	private static Logger logger = Logger.getLogger(ContentHeaderRechercheSimple.class);

	private static boolean ouvert = false;
	
	private GridBagLayout gridBagLayout;
	
	private Box horizontalBox;
	
	private JButton btnHome;
	
	private JButton btnVolets;

	/**
	 * Create the panel.
	 */
	public ContentHeaderRechercheSimple(final Application application) {
		
		initComponents();

		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				logger.error("Problème ligne 80 ContentHeaderRechercheSimple");
			}
		});

		btnVolets.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ouvert) {
					application.OuvrirVolet();
					btnVolets.setText("FERMER");
					ouvert = false;
				}
				else {
					application.FermerVolet();
					btnVolets.setText("OUVRIR");
					ouvert = true;
				}
			}
		});
	}
	
	public void initComponents() {
		setBackground(Color.GRAY);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		horizontalBox = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox = new GridBagConstraints();
		gbc_horizontalBox.fill = GridBagConstraints.BOTH;
		gbc_horizontalBox.gridx = 0;
		gbc_horizontalBox.gridy = 0;
		add(horizontalBox, gbc_horizontalBox);

		btnHome = new JButton("HOME");
		horizontalBox.add(btnHome);

		btnVolets = new JButton("FERMER");
		horizontalBox.add(btnVolets);
	}
}
