/**
 * 
 */
package ui.mainframes.volets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import principal.Application;
import principal.Recherche;
import renderers.HistoriqueRenderer;
import ui.objects.HistoriqueCell;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JButton;

/**
 * @author Valentin
 *
 */
public class VoletHistorique extends JPanel {

	private static final long serialVersionUID = 9200931919131551743L;
	
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_panel;
	
	private JPanel jpanel;


	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletHistorique(Application application) {
		
		initComponents(application);
		
	}
	
	public void initComponents(Application application) {
		setBackground(Color.RED);
		setPreferredSize(new Dimension(300, 540));
		
		GridBagLayout gridBagLayout_1 = new GridBagLayout();
		gridBagLayout_1.columnWidths = new int[]{0, 0};
		gridBagLayout_1.rowHeights = new int[]{0, 0};
		gridBagLayout_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout_1);
		
		jpanel = new JPanel();
		jpanel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(jpanel, gbc_panel);
		
	}
	
	
	public void chargerHistorique(Application application) {
		
		//jpanel.removeAll();
		
		Vector<HistoriqueCell> listeRecherches = new Vector<HistoriqueCell>();

		HistoriqueCell historiqueCell;

		for(Object recherche : application.getMesRecherches()) {
			historiqueCell = new HistoriqueCell(application);
			historiqueCell.setNumRecherche(((Recherche) recherche).getNumRecherche());
			historiqueCell.getLblMots().setText(((Recherche) recherche).getMotRecherche());
			listeRecherches.addElement(historiqueCell);
		}
		
		historiqueCell = new HistoriqueCell(application);
		historiqueCell.setNumRecherche(1);
		historiqueCell.getLblMots().setText("Valentin");
		listeRecherches.addElement(historiqueCell);
		
		historiqueCell.setNumRecherche(2);
		historiqueCell.getLblMots().setText("Pauline");
		listeRecherches.addElement(historiqueCell);
		
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		System.out.println("\tIl y a " + listeRecherches.size() + " éléments !!");
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		
		//Vector<RSDetail_2> toto = new Vector<RSDetail_2>();
		//RSDetail_2 tempo = new RSDetail_2(application);
		//tempo.setIdHeadword(3);
		//tempo.getLblMots().setText("TTESTT");
		
		//toto.add(tempo);
		
		
		//application.getContentHome().getVoletHistorique().getPanel().removeAll();
		//HistoriqueRenderer titi = 
		//titi.setBackground(Color.YELLOW);
		//application.getContentHome().getVoletHistorique().add(titi, application.getContentHome().getVoletHistorique().getGbc_panel());
		//application.getContentHome().getVoletHistorique().add(new MotsRenderer_2(application, toto), application.getContentHome().getVoletHistorique().getGbc_panel());
		//application.getContentHome().getVoletHistorique().setPanel(new HistoriqueRenderer(application, listeRecherches));//, application.getContentHome().getVoletHistorique().getGbc_panel());
		
		jpanel.removeAll();
		
		jpanel = new HistoriqueRenderer(application, listeRecherches);
		
		//jpanel.add(jpanel, gbc_panel);
		
		jpanel.revalidate();
		revalidate();
	}

	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	public void setGridBagLayout(GridBagLayout gridBagLayout) {
		this.gridBagLayout = gridBagLayout;
	}

	public GridBagConstraints getGbc_panel() {
		return gbc_panel;
	}

	public void setGbc_panel(GridBagConstraints gbc_panel) {
		this.gbc_panel = gbc_panel;
	}
}
