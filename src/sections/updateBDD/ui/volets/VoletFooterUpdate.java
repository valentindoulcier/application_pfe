/**
 * 
 */
package sections.updateBDD.ui.volets;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;

import principal.Application;
import sections.parseurXML.ParseurXML;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletFooterUpdate extends JPanel {

	private static final long serialVersionUID = 1129835814490832264L;

	private JButton btnParseur;
	
	private JButton btnHistorique;


	/**
	 * Create the panel.
	 */
	public VoletFooterUpdate(final Application application) {

		initComponents();

		btnParseur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ParseurXML.getInstance(application).fermerCurrentOnglet();
				ParseurXML.getInstance(application).ouvrirOnglet(1);
			}
		});

		btnHistorique.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ParseurXML.getInstance(application).fermerCurrentOnglet();
				ParseurXML.getInstance(application).ouvrirOnglet(2);
				
				ParseurXML.getInstance(application).getVoletHistorique().chargerHistorique(application);
			}

		});
	}

	public void initComponents() {

		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 100, 100, 100, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		btnParseur = new JButton("Parseur");
		btnParseur.setSize(80, 25);
		GridBagConstraints gbc_btnParseur = new GridBagConstraints();
		gbc_btnParseur.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnParseur.insets = new Insets(0, 0, 0, 5);
		gbc_btnParseur.gridx = 1;
		gbc_btnParseur.gridy = 0;
		add(btnParseur, gbc_btnParseur);

		btnHistorique = new JButton("Histo");
		btnHistorique.setSize(80, 25);
		GridBagConstraints gbc_btnHistorique = new GridBagConstraints();
		gbc_btnHistorique.insets = new Insets(0, 0, 0, 5);
		gbc_btnHistorique.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHistorique.gridx = 2;
		gbc_btnHistorique.gridy = 0;
		add(btnHistorique, gbc_btnHistorique);
	}
}
