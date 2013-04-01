/**
 * 
 */
package sections.bddictionnairique.ui.volets;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;

import principal.Application;
import sections.bddictionnairique.Bddictionnairique;
import sections.bddictionnairique.ui.contents.ContentHeaderHistorique;
import sections.bddictionnairique.ui.contents.ContentHeaderRechercheAvancee;
import sections.bddictionnairique.ui.contents.ContentHeaderRechercheSimple;
import sections.bddictionnairique.ui.contents.ContentHistorique;
import sections.bddictionnairique.ui.contents.ContentRechercheAvancee;
import sections.bddictionnairique.ui.contents.ContentRechercheSimple;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Valentin
 *
 */
public class VoletFooterRecherche extends JPanel {

	private static final long serialVersionUID = 1129835814490832264L;
	
	// 1 - Recherche Simple
	// 2 - Recherche Avancée
	// 3 - Historique
	private int jeViensDe = -1;
	
	private JButton btnSimple;
	private JButton btnAvancee;
	private JButton btnHistorique;

	private VoletHeaderRechercheSimple voletHeaderRechercheSimple;
	private VoletRechercheSimple voletRechercheSimple;
	
	private VoletHeaderRechercheAvancee voletHeaderRechercheAvancee;
	private VoletRechercheAvancee voletRechercheAvancee;
	
	private VoletHeaderHistorique voletHeaderHistorique;
	private VoletHistorique voletHistorique;
	
	
	private ContentHeaderRechercheSimple contentHeaderRechercheSimple;
	private ContentRechercheSimple contentRechercheSimple;
	
	private ContentHeaderRechercheAvancee contentHeaderRechercheAvancee;
	private ContentRechercheAvancee contentRechercheAvancee;
	
	private ContentHeaderHistorique contentHeaderHistorique;
	private ContentHistorique contentHistorique;
	

	/**
	 * Create the panel.
	 */
	public VoletFooterRecherche(final Application application) {
		
		initComponents();
		
		btnSimple.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(jeViensDe == -1) {
					voletHeaderRechercheSimple = Bddictionnairique.getInstance(application).getVoletHeaderRechercheSimple();
					voletRechercheSimple = Bddictionnairique.getInstance(application).getVoletRechercheSimple();
					
					application.getvHeader().remove(Bddictionnairique.getInstance(application).getVoletHeaderRechercheSimple());
					application.getvPanel().remove(Bddictionnairique.getInstance(application).getVoletRechercheSimple());
					
					application.getvHeader().add(voletHeaderRechercheSimple, "voletHeaderRechercheSimple");
					application.getvPanel().add(voletRechercheSimple, "voletRechercheSimple");

					contentHeaderRechercheSimple = Bddictionnairique.getInstance(application).getContentHeaderRechercheSimple();
					contentRechercheSimple = Bddictionnairique.getInstance(application).getContentRechercheSimple();
					
					application.getcHeader().remove(Bddictionnairique.getInstance(application).getContentHeaderRechercheSimple());
					application.getcPanel().remove(Bddictionnairique.getInstance(application).getContentRechercheSimple());

					application.getcHeader().add(contentHeaderRechercheSimple, "contentHeaderRechercheSimple");
					application.getcPanel().add(contentRechercheSimple, "contentRechercheSimple");
					
					jeViensDe = 1;
				}
				
				if(jeViensDe == 2) {
					voletHeaderRechercheSimple = new VoletHeaderRechercheSimple();
					voletRechercheSimple = new VoletRechercheSimple(application);
					
					application.getvHeader().add(voletHeaderRechercheSimple, "voletHeaderRechercheSimple");
					application.getvPanel().add(voletRechercheSimple, "voletRechercheSimple");
					
					contentHeaderRechercheSimple = new ContentHeaderRechercheSimple(application);
					contentRechercheSimple = new ContentRechercheSimple(application);
				
					application.getcHeader().add(contentHeaderRechercheSimple, "contentHeaderRechercheSimple");
					application.getcPanel().add(contentRechercheSimple, "contentRechercheSimple");
					
					application.getvHeader().remove(voletHeaderRechercheAvancee);
					application.getvPanel().remove(voletRechercheAvancee);
					
					application.getcHeader().remove(contentHeaderRechercheAvancee);
					application.getcPanel().remove(contentRechercheAvancee);
					
				}
				else if(jeViensDe == 3) {					
					voletHeaderRechercheSimple = new VoletHeaderRechercheSimple();
					voletRechercheSimple = new VoletRechercheSimple(application);
					
					application.getvHeader().add(voletHeaderRechercheSimple, "voletHeaderRechercheSimple");
					application.getvPanel().add(voletRechercheSimple, "voletRechercheSimple");
				
					contentHeaderRechercheSimple = new ContentHeaderRechercheSimple(application);
					contentRechercheSimple = new ContentRechercheSimple(application);
				
					application.getcHeader().add(contentHeaderRechercheSimple, "contentHeaderRechercheSimple");
					application.getcPanel().add(contentRechercheSimple, "contentRechercheSimple");
					
					application.getvHeader().remove(voletHeaderHistorique);
					application.getvPanel().remove(voletHistorique);
					
					application.getcHeader().remove(contentHeaderHistorique);
					application.getcPanel().remove(contentHistorique);
					
				}
				
				application.getVoletHeader().show(application.getvHeader(), "voletHeaderRechercheSimple");
				application.getVoletPanel().show(application.getvPanel(), "voletRechercheSimple");
				
				application.getContentHeader().show(application.getcHeader(), "contentHeaderRechercheSimple");
				application.getContentPanel().show(application.getcPanel(), "contentRechercheSimple");
				
				jeViensDe = 1;
			}
			
		});
		
		btnAvancee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(jeViensDe == -1) {
					voletHeaderRechercheSimple = Bddictionnairique.getInstance(application).getVoletHeaderRechercheSimple();
					voletRechercheSimple = Bddictionnairique.getInstance(application).getVoletRechercheSimple();
					
					application.getvHeader().remove(Bddictionnairique.getInstance(application).getVoletHeaderRechercheSimple());
					application.getvPanel().remove(Bddictionnairique.getInstance(application).getVoletRechercheSimple());
					
					application.getvHeader().add(voletHeaderRechercheSimple, "voletHeaderRechercheSimple");
					application.getvPanel().add(voletRechercheSimple, "voletRechercheSimple");

					contentHeaderRechercheSimple = Bddictionnairique.getInstance(application).getContentHeaderRechercheSimple();
					contentRechercheSimple = Bddictionnairique.getInstance(application).getContentRechercheSimple();
					
					application.getcHeader().remove(Bddictionnairique.getInstance(application).getContentHeaderRechercheSimple());
					application.getcPanel().remove(Bddictionnairique.getInstance(application).getContentRechercheSimple());

					application.getcHeader().add(contentHeaderRechercheSimple, "contentHeaderRechercheSimple");
					application.getcPanel().add(contentRechercheSimple, "contentRechercheSimple");
					
					jeViensDe = 1;
				}
				
				if(jeViensDe == 1) {
					voletHeaderRechercheAvancee = new VoletHeaderRechercheAvancee();
					voletRechercheAvancee = new VoletRechercheAvancee(application);
					
					application.getvHeader().add(voletHeaderRechercheAvancee, "voletHeaderRechercheAvancee");
					application.getvPanel().add(voletRechercheAvancee, "voletRechercheAvancee");
				
					contentHeaderRechercheAvancee = new ContentHeaderRechercheAvancee(application);
					contentRechercheAvancee = new ContentRechercheAvancee(application);
				
					application.getcHeader().add(contentHeaderRechercheAvancee, "contentHeaderRechercheAvancee");
					application.getcPanel().add(contentRechercheAvancee, "contentRechercheAvancee");
					
					application.getvHeader().remove(voletHeaderRechercheSimple);
					application.getvPanel().remove(voletRechercheSimple);
					
					application.getcHeader().remove(contentHeaderRechercheSimple);
					application.getcPanel().remove(contentRechercheSimple);
					
				}
				else if(jeViensDe == 3) {
					voletHeaderRechercheAvancee = new VoletHeaderRechercheAvancee();
					voletRechercheAvancee = new VoletRechercheAvancee(application);
					
					application.getvHeader().add(voletHeaderRechercheAvancee, "voletHeaderRechercheAvancee");
					application.getvPanel().add(voletRechercheAvancee, "voletRechercheAvancee");
				
					contentHeaderRechercheAvancee = new ContentHeaderRechercheAvancee(application);
					contentRechercheAvancee = new ContentRechercheAvancee(application);
					
					application.getcHeader().add(contentHeaderRechercheAvancee, "contentHeaderRechercheAvancee");
					application.getcPanel().add(contentRechercheAvancee, "contentRechercheAvancee");
					
					application.getvHeader().remove(voletHeaderHistorique);
					application.getvPanel().remove(voletHistorique);
					
					application.getcHeader().remove(contentHeaderHistorique);
					application.getcPanel().remove(contentHistorique);
					
				}
				
				application.getVoletHeader().show(application.getvHeader(), "voletHeaderRechercheAvancee");
				application.getVoletPanel().show(application.getvPanel(), "voletRechercheAvancee");
				
				application.getContentHeader().show(application.getcHeader(), "contentHeaderRechercheAvancee");
				application.getContentPanel().show(application.getcPanel(), "contentRechercheAvancee");
				
				jeViensDe = 2;
			}
			
		});
		
		btnHistorique.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(jeViensDe == -1) {
					voletHeaderRechercheSimple = Bddictionnairique.getInstance(application).getVoletHeaderRechercheSimple();
					voletRechercheSimple = Bddictionnairique.getInstance(application).getVoletRechercheSimple();
					
					application.getvHeader().remove(Bddictionnairique.getInstance(application).getVoletHeaderRechercheSimple());
					application.getvPanel().remove(Bddictionnairique.getInstance(application).getVoletRechercheSimple());
					
					application.getvHeader().add(voletHeaderRechercheSimple, "voletHeaderRechercheSimple");
					application.getvPanel().add(voletRechercheSimple, "voletRechercheSimple");

					contentHeaderRechercheSimple = Bddictionnairique.getInstance(application).getContentHeaderRechercheSimple();
					contentRechercheSimple = Bddictionnairique.getInstance(application).getContentRechercheSimple();
					
					application.getcHeader().remove(Bddictionnairique.getInstance(application).getContentHeaderRechercheSimple());
					application.getcPanel().remove(Bddictionnairique.getInstance(application).getContentRechercheSimple());

					application.getcHeader().add(contentHeaderRechercheSimple, "contentHeaderRechercheSimple");
					application.getcPanel().add(contentRechercheSimple, "contentRechercheSimple");
					
					jeViensDe = 1;
				}
				
				if(jeViensDe == 1) {
					voletHeaderHistorique = new VoletHeaderHistorique();
					voletHistorique = new VoletHistorique(application);
					
					application.getvHeader().add(voletHeaderHistorique, "voletHeaderHistorique");
					application.getvPanel().add(voletHistorique, "voletHistorique");
					
					contentHeaderHistorique = new ContentHeaderHistorique(application);
					contentHistorique = new ContentHistorique(application);
					
					application.getcHeader().add(contentHeaderHistorique, "contentHeaderHistorique");
					application.getcPanel().add(contentHistorique, "contentHistorique");
					
					application.getvHeader().remove(voletHeaderRechercheSimple);
					application.getvPanel().remove(voletRechercheSimple);
					
					application.getcHeader().remove(contentHeaderRechercheSimple);
					application.getcPanel().remove(contentRechercheSimple);
					
				}
				else if(jeViensDe == 2) {
					voletHeaderHistorique = new VoletHeaderHistorique();
					voletHistorique = new VoletHistorique(application);
					
					application.getvHeader().add(voletHeaderHistorique, "voletHeaderHistorique");
					application.getvPanel().add(voletHistorique, "voletHistorique");
					
					contentHeaderHistorique = new ContentHeaderHistorique(application);
					contentHistorique = new ContentHistorique(application);
					
					application.getcHeader().add(contentHeaderHistorique, "contentHeaderHistorique");
					application.getcPanel().add(contentHistorique, "contentHistorique");
					
					application.getvHeader().remove(voletHeaderRechercheAvancee);
					application.getvPanel().remove(voletRechercheAvancee);
				
					application.getcHeader().remove(contentHeaderRechercheAvancee);
					application.getcPanel().remove(contentRechercheAvancee);
				
				}
				
				voletHistorique.chargerHistorique(application);
				
				application.getVoletHeader().show(application.getvHeader(), "voletHeaderHistorique");
				application.getVoletPanel().show(application.getvPanel(), "voletHistorique");
				
				application.getContentHeader().show(application.getcHeader(), "contentHeaderHistorique");
				application.getContentPanel().show(application.getcPanel(), "contentHistorique");
				
				jeViensDe = 3;
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

	/**
	 * @return the jeViensDe
	 */
	public int getJeViensDe() {
		return jeViensDe;
	}

	/**
	 * @param jeViensDe the jeViensDe to set
	 */
	public void setJeViensDe(int jeViensDe) {
		this.jeViensDe = jeViensDe;
	}

	/**
	 * @return the voletHeaderRechercheSimple
	 */
	public VoletHeaderRechercheSimple getVoletHeaderRechercheSimple() {
		return voletHeaderRechercheSimple;
	}

	/**
	 * @param voletHeaderRechercheSimple the voletHeaderRechercheSimple to set
	 */
	public void setVoletHeaderRechercheSimple(
			VoletHeaderRechercheSimple voletHeaderRechercheSimple) {
		this.voletHeaderRechercheSimple = voletHeaderRechercheSimple;
	}

	/**
	 * @return the voletRechercheSimple
	 */
	public VoletRechercheSimple getVoletRechercheSimple() {
		return voletRechercheSimple;
	}

	/**
	 * @param voletRechercheSimple the voletRechercheSimple to set
	 */
	public void setVoletRechercheSimple(VoletRechercheSimple voletRechercheSimple) {
		this.voletRechercheSimple = voletRechercheSimple;
	}

	/**
	 * @return the voletHeaderRechercheAvancee
	 */
	public VoletHeaderRechercheAvancee getVoletHeaderRechercheAvancee() {
		return voletHeaderRechercheAvancee;
	}

	/**
	 * @param voletHeaderRechercheAvancee the voletHeaderRechercheAvancee to set
	 */
	public void setVoletHeaderRechercheAvancee(
			VoletHeaderRechercheAvancee voletHeaderRechercheAvancee) {
		this.voletHeaderRechercheAvancee = voletHeaderRechercheAvancee;
	}

	/**
	 * @return the voletRechercheAvancee
	 */
	public VoletRechercheAvancee getVoletRechercheAvancee() {
		return voletRechercheAvancee;
	}

	/**
	 * @param voletRechercheAvancee the voletRechercheAvancee to set
	 */
	public void setVoletRechercheAvancee(VoletRechercheAvancee voletRechercheAvancee) {
		this.voletRechercheAvancee = voletRechercheAvancee;
	}

	/**
	 * @return the voletHeaderHistorique
	 */
	public VoletHeaderHistorique getVoletHeaderHistorique() {
		return voletHeaderHistorique;
	}

	/**
	 * @param voletHeaderHistorique the voletHeaderHistorique to set
	 */
	public void setVoletHeaderHistorique(VoletHeaderHistorique voletHeaderHistorique) {
		this.voletHeaderHistorique = voletHeaderHistorique;
	}

	/**
	 * @return the voletHistorique
	 */
	public VoletHistorique getVoletHistorique() {
		return voletHistorique;
	}

	/**
	 * @param voletHistorique the voletHistorique to set
	 */
	public void setVoletHistorique(VoletHistorique voletHistorique) {
		this.voletHistorique = voletHistorique;
	}

	/**
	 * @return the contentHeaderRechercheSimple
	 */
	public ContentHeaderRechercheSimple getContentHeaderRechercheSimple() {
		return contentHeaderRechercheSimple;
	}

	/**
	 * @param contentHeaderRechercheSimple the contentHeaderRechercheSimple to set
	 */
	public void setContentHeaderRechercheSimple(
			ContentHeaderRechercheSimple contentHeaderRechercheSimple) {
		this.contentHeaderRechercheSimple = contentHeaderRechercheSimple;
	}

	/**
	 * @return the contentRechercheSimple
	 */
	public ContentRechercheSimple getContentRechercheSimple() {
		return contentRechercheSimple;
	}

	/**
	 * @param contentRechercheSimple the contentRechercheSimple to set
	 */
	public void setContentRechercheSimple(
			ContentRechercheSimple contentRechercheSimple) {
		this.contentRechercheSimple = contentRechercheSimple;
	}

	/**
	 * @return the contentHeaderRechercheAvancee
	 */
	public ContentHeaderRechercheAvancee getContentHeaderRechercheAvancee() {
		return contentHeaderRechercheAvancee;
	}

	/**
	 * @param contentHeaderRechercheAvancee the contentHeaderRechercheAvancee to set
	 */
	public void setContentHeaderRechercheAvancee(
			ContentHeaderRechercheAvancee contentHeaderRechercheAvancee) {
		this.contentHeaderRechercheAvancee = contentHeaderRechercheAvancee;
	}

	/**
	 * @return the contentRechercheAvancee
	 */
	public ContentRechercheAvancee getContentRechercheAvancee() {
		return contentRechercheAvancee;
	}

	/**
	 * @param contentRechercheAvancee the contentRechercheAvancee to set
	 */
	public void setContentRechercheAvancee(
			ContentRechercheAvancee contentRechercheAvancee) {
		this.contentRechercheAvancee = contentRechercheAvancee;
	}

	/**
	 * @return the contentHeaderHistorique
	 */
	public ContentHeaderHistorique getContentHeaderHistorique() {
		return contentHeaderHistorique;
	}

	/**
	 * @param contentHeaderHistorique the contentHeaderHistorique to set
	 */
	public void setContentHeaderHistorique(
			ContentHeaderHistorique contentHeaderHistorique) {
		this.contentHeaderHistorique = contentHeaderHistorique;
	}

	/**
	 * @return the contentHistorique
	 */
	public ContentHistorique getContentHistorique() {
		return contentHistorique;
	}

	/**
	 * @param contentHistorique the contentHistorique to set
	 */
	public void setContentHistorique(ContentHistorique contentHistorique) {
		this.contentHistorique = contentHistorique;
	}

}
