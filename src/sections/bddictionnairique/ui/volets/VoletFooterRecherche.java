/**
 * 
 */
package sections.bddictionnairique.ui.volets;

import principal.Application;
import sections.bddictionnairique.Bddictionnairique;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletFooterRecherche extends JPanel {

	private static final long serialVersionUID = 1129835814490832264L;
	
	private JButton btnSimple;
	private JButton btnAvancee;
	private JButton btnHistorique;
	

	/**
	 * Create the panel.
	 */
	public VoletFooterRecherche(final Application application) {
		
		initComponents();
		
		btnSimple.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Bddictionnairique.getInstance(application).fermerCurrentOnglet();
				Bddictionnairique.getInstance(application).ouvrirOnglet(1);
			}
			
		});
		
		btnAvancee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Bddictionnairique.getInstance(application).fermerCurrentOnglet();
				Bddictionnairique.getInstance(application).ouvrirOnglet(2);
			}
			
		});
		
		btnHistorique.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Bddictionnairique.getInstance(application).fermerCurrentOnglet();
				Bddictionnairique.getInstance(application).ouvrirOnglet(3);
				
				Bddictionnairique.getInstance(application).getVoletHistorique().chargerHistorique(application);
			}
			
		});
		
	}
	
	public void initComponents() {
		
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 100, 100, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnSimple = new JButton("Simple");
		btnSimple.setSize(80, 25);
		GridBagConstraints gbc_btnSimple = new GridBagConstraints();
		gbc_btnSimple.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSimple.insets = new Insets(0, 0, 0, 5);
		gbc_btnSimple.gridx = 0;
		gbc_btnSimple.gridy = 0;
		add(btnSimple, gbc_btnSimple);
		
		btnAvancee = new JButton("Avancée");
		btnAvancee.setSize(80, 25);
		GridBagConstraints gbc_btnAvancee = new GridBagConstraints();
		gbc_btnAvancee.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAvancee.insets = new Insets(0, 0, 0, 5);
		gbc_btnAvancee.gridx = 1;
		gbc_btnAvancee.gridy = 0;
		add(btnAvancee, gbc_btnAvancee);
		
		btnHistorique = new JButton("Histo");
		btnHistorique.setSize(80, 25);
		GridBagConstraints gbc_btnHistorique = new GridBagConstraints();
		gbc_btnHistorique.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHistorique.gridx = 2;
		gbc_btnHistorique.gridy = 0;
		add(btnHistorique, gbc_btnHistorique);
	}

	/**
	 * @return the btnSimple
	 */
	public JButton getBtnSimple() {
		return btnSimple;
	}

	/**
	 * @param btnSimple the btnSimple to set
	 */
	public void setBtnSimple(JButton btnSimple) {
		this.btnSimple = btnSimple;
	}

	/**
	 * @return the btnAvancee
	 */
	public JButton getBtnAvancee() {
		return btnAvancee;
	}

	/**
	 * @param btnAvancee the btnAvancee to set
	 */
	public void setBtnAvancee(JButton btnAvancee) {
		this.btnAvancee = btnAvancee;
	}

	/**
	 * @return the btnHistorique
	 */
	public JButton getBtnHistorique() {
		return btnHistorique;
	}

	/**
	 * @param btnHistorique the btnHistorique to set
	 */
	public void setBtnHistorique(JButton btnHistorique) {
		this.btnHistorique = btnHistorique;
	}
}
