/**
 * 
 */
package sections.updateBDD.ui.contents;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import principal.Application;
import sections.updateBDD.UpdateBDD;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentHeaderUpdate extends JPanel {

	private static final long serialVersionUID = 4317613445205581498L;

	private static boolean ouvert = false;
	
	private GridBagLayout gridBagLayout;
	
	private Box horizontalBox;
	
	private JButton btnHome;
	
	private JButton btnFermer;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentHeaderUpdate(final Application application) {
		
		initComponents();
		
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				application.dechargerApplication();
				UpdateBDD.getInstance(application).dechargerSynchronisation();
			}
		});
		
		btnFermer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(ouvert) {
					application.OuvrirVolet();
					btnFermer.setText("FERMER");
					ouvert = false;
				}
				else {
					application.FermerVolet();
					btnFermer.setText("OUVRIR");
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
		
		btnHome = new JButton("ADMINISTRATION");
		horizontalBox.add(btnHome);
		
		btnFermer = new JButton("FERMER");
		horizontalBox.add(btnFermer);
	}

}
