package ui.mainframes;

import ui.components.*;
import principal.Application;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import java.awt.CardLayout;

import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Valentin DOULCIER
 *
 */
public class LayerApplication extends JPanel {

	private static final long serialVersionUID = -7537563501231664829L;
	
	private static Logger logger = Logger.getLogger(LayerApplication.class);
	
	private JButton btnRechercher;
	private JButton btnRechercheSimple;
	private JButton btnLiensDict;
	private JButton btnRechercheAvancee;
	private JButton btnOptions;
	private JButton btnHistorique;

	private JLabel lblDetails;
	private JSlider sliderDetails;
	
	private JTextField textFieldRecherche;

	private Box verticalBoxHaut;
	private Box verticalBoxBas;
	
	private JPanel panelMenu;
	private JPanel panelContent;
	
	private CardLayout cardLayoutMenu = new CardLayout(0, 0);
	private CardLayout cardLayoutContent = new CardLayout(0, 0);
	
	private AppliMenuRechercheSimple appliMenuRechercheSimple;
	private AppliMenuLiensDictionnaires appliMenuLiensDictionnaires;
	private AppliMenuRechercheAvancee appliMenuRechercheAvancee;
	
	private AppliContentEditionMot appliContentEditionMot;
	private AppliContentRechercheSimple appliContentRechercheSimple;
	private AppliContentRechercheAvancee appliContentRechercheAvancee;
	
	
	public LayerApplication(final Application application) {

		initComponents(application);
		
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recherche();
				logger.info("Recherche()");
			}
		});
		
		btnRechercheSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayoutMenu.show(panelMenu, "AppliMenuRechercheSimple");
				cardLayoutContent.show(panelContent, "AppliContentRechercheSimple");
			}
		});
		
		btnLiensDict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayoutMenu.show(panelMenu, "AppliMenuLiensDictionnaires");
			}
		});
		
		btnRechercheAvancee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayoutMenu.show(panelMenu, "AppliMenuRechercheAvancee");
				cardLayoutContent.show(panelContent, "AppliContentRechercheAvancee");
			}
		});
		
		
		sliderDetails.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent ce) {
	        	if(sliderDetails.getValue() == 0)
	        	{
	        		lblDetails.setText("Détail : x");
	        	}
	        	else if(sliderDetails.getValue() == 50) {
	        		lblDetails.setText("Détail : xx");
	        	}
	        	else {
	        		lblDetails.setText("Détail : xxx");
	        	}
	        }
	    });
		

	}
	
	
	public void initComponents(final Application application) {
		setBounds(100, 100, 800, 550);

		setBackground(Color.CYAN);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 200, 20, 0, 20, 0, 20, 130, 20, 0};
		gridBagLayout.rowHeights = new int[]{10, 10, 0, 20, 226, 203, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textFieldRecherche = new JTextField();
		GridBagConstraints gbc_textFieldRecherche = new GridBagConstraints();
		gbc_textFieldRecherche.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRecherche.gridwidth = 4;
		gbc_textFieldRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRecherche.gridx = 1;
		gbc_textFieldRecherche.gridy = 2;
		add(textFieldRecherche, gbc_textFieldRecherche);
		textFieldRecherche.setColumns(10);
		
		btnRechercher = new JButton("Chercher");
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercher.gridx = 6;
		gbc_btnRechercher.gridy = 2;
		add(btnRechercher, gbc_btnRechercher);
		
		lblDetails = new JLabel("Détail : x");
		GridBagConstraints gbc_lblDetails = new GridBagConstraints();
		gbc_lblDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetails.gridx = 8;
		gbc_lblDetails.gridy = 1;
		add(lblDetails, gbc_lblDetails);
		
		sliderDetails = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 20);
		sliderDetails.setSnapToTicks(true);
		sliderDetails.setPaintTicks(true);
		sliderDetails.setMinorTickSpacing(50);
		sliderDetails.setMajorTickSpacing(50);
		sliderDetails.setToolTipText("");
		GridBagConstraints gbc_sliderDetail = new GridBagConstraints();
		gbc_sliderDetail.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderDetail.insets = new Insets(0, 0, 5, 5);
		gbc_sliderDetail.gridx = 8;
		gbc_sliderDetail.gridy = 2;
		add(sliderDetails, gbc_sliderDetail);
		
		verticalBoxHaut = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBoxHaut = new GridBagConstraints();
		gbc_verticalBoxHaut.fill = GridBagConstraints.HORIZONTAL;
		gbc_verticalBoxHaut.anchor = GridBagConstraints.NORTH;
		gbc_verticalBoxHaut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBoxHaut.gridx = 1;
		gbc_verticalBoxHaut.gridy = 4;
		add(verticalBoxHaut, gbc_verticalBoxHaut);
		
		btnRechercheSimple = new JButton("Rech. Simple");
		verticalBoxHaut.add(btnRechercheSimple);
		
		btnLiensDict = new JButton("Liens Dict.");
		verticalBoxHaut.add(btnLiensDict);
		
		btnRechercheAvancee = new JButton("Rech. Avancée");
		verticalBoxHaut.add(btnRechercheAvancee);
		
		verticalBoxBas = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBoxBas = new GridBagConstraints();
		gbc_verticalBoxBas.fill = GridBagConstraints.HORIZONTAL;
		gbc_verticalBoxBas.anchor = GridBagConstraints.SOUTH;
		gbc_verticalBoxBas.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBoxBas.gridx = 1;
		gbc_verticalBoxBas.gridy = 5;
		add(verticalBoxBas, gbc_verticalBoxBas);
		
		btnOptions = new JButton("Options");
		verticalBoxBas.add(btnOptions);
		
		btnHistorique = new JButton("Historique");
		verticalBoxBas.add(btnHistorique);
		
		panelMenu = new JPanel();
		GridBagConstraints gbc_panelMenu = new GridBagConstraints();
		gbc_panelMenu.gridheight = 2;
		gbc_panelMenu.insets = new Insets(0, 0, 5, 5);
		gbc_panelMenu.fill = GridBagConstraints.BOTH;
		gbc_panelMenu.gridx = 2;
		gbc_panelMenu.gridy = 4;
		add(panelMenu, gbc_panelMenu);
		panelMenu.setLayout(cardLayoutMenu);
		
		appliMenuRechercheSimple = new AppliMenuRechercheSimple();
		appliMenuLiensDictionnaires = new AppliMenuLiensDictionnaires();
		appliMenuRechercheAvancee = new AppliMenuRechercheAvancee();
		
		panelMenu.add(appliMenuRechercheSimple, "AppliMenuRechercheSimple");
		panelMenu.add(appliMenuLiensDictionnaires, "AppliMenuLiensDictionnaires");
		panelMenu.add(appliMenuRechercheAvancee, "AppliMenuRechercheAvancee");
		
		panelContent = new JPanel();
		GridBagConstraints gbc_panelContent = new GridBagConstraints();
		gbc_panelContent.gridheight = 2;
		gbc_panelContent.gridwidth = 5;
		gbc_panelContent.insets = new Insets(0, 0, 5, 5);
		gbc_panelContent.fill = GridBagConstraints.BOTH;
		gbc_panelContent.gridx = 4;
		gbc_panelContent.gridy = 4;
		add(panelContent, gbc_panelContent);
		panelContent.setLayout(cardLayoutContent);
		
		appliContentEditionMot = new AppliContentEditionMot();
		appliContentRechercheSimple = new AppliContentRechercheSimple();
		appliContentRechercheAvancee = new AppliContentRechercheAvancee();
		
		panelContent.add(appliContentRechercheSimple, "AppliContentRechercheSimple");
		panelContent.add(appliContentRechercheAvancee, "AppliContentRechercheAvancee");
		panelContent.add(appliContentEditionMot, "AppliContentEditionMot");
		
		this.revalidate();
	}
	
	private void Recherche() {
		appliContentRechercheSimple.afficherRecherche(this);
		this.revalidate();
	}


	/**
	 * @return the btnRechercher
	 */
	public JButton getBtnRechercher() {
		return btnRechercher;
	}


	/**
	 * @param btnRechercher the btnRechercher to set
	 */
	public void setBtnRechercher(JButton btnRechercher) {
		this.btnRechercher = btnRechercher;
	}


	/**
	 * @return the btnRechercheSimple
	 */
	public JButton getBtnRechercheSimple() {
		return btnRechercheSimple;
	}


	/**
	 * @param btnRechercheSimple the btnRechercheSimple to set
	 */
	public void setBtnRechercheSimple(JButton btnRechercheSimple) {
		this.btnRechercheSimple = btnRechercheSimple;
	}


	/**
	 * @return the btnLiensDict
	 */
	public JButton getBtnLiensDict() {
		return btnLiensDict;
	}


	/**
	 * @param btnLiensDict the btnLiensDict to set
	 */
	public void setBtnLiensDict(JButton btnLiensDict) {
		this.btnLiensDict = btnLiensDict;
	}


	/**
	 * @return the btnRechercheAvancee
	 */
	public JButton getBtnRechercheAvancee() {
		return btnRechercheAvancee;
	}


	/**
	 * @param btnRechercheAvancee the btnRechercheAvancee to set
	 */
	public void setBtnRechercheAvancee(JButton btnRechercheAvancee) {
		this.btnRechercheAvancee = btnRechercheAvancee;
	}


	/**
	 * @return the btnOptions
	 */
	public JButton getBtnOptions() {
		return btnOptions;
	}


	/**
	 * @param btnOptions the btnOptions to set
	 */
	public void setBtnOptions(JButton btnOptions) {
		this.btnOptions = btnOptions;
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
	 * @return the lblDetails
	 */
	public JLabel getLblDetails() {
		return lblDetails;
	}


	/**
	 * @param lblDetails the lblDetails to set
	 */
	public void setLblDetails(JLabel lblDetails) {
		this.lblDetails = lblDetails;
	}


	/**
	 * @return the sliderDetails
	 */
	public JSlider getSliderDetails() {
		return sliderDetails;
	}


	/**
	 * @param sliderDetails the sliderDetails to set
	 */
	public void setSliderDetails(JSlider sliderDetails) {
		this.sliderDetails = sliderDetails;
	}


	/**
	 * @return the textFieldRecherche
	 */
	public JTextField getTextFieldRecherche() {
		return textFieldRecherche;
	}


	/**
	 * @param textFieldRecherche the textFieldRecherche to set
	 */
	public void setTextFieldRecherche(JTextField textFieldRecherche) {
		this.textFieldRecherche = textFieldRecherche;
	}


	/**
	 * @return the verticalBoxHaut
	 */
	public Box getVerticalBoxHaut() {
		return verticalBoxHaut;
	}


	/**
	 * @param verticalBoxHaut the verticalBoxHaut to set
	 */
	public void setVerticalBoxHaut(Box verticalBoxHaut) {
		this.verticalBoxHaut = verticalBoxHaut;
	}


	/**
	 * @return the verticalBoxBas
	 */
	public Box getVerticalBoxBas() {
		return verticalBoxBas;
	}


	/**
	 * @param verticalBoxBas the verticalBoxBas to set
	 */
	public void setVerticalBoxBas(Box verticalBoxBas) {
		this.verticalBoxBas = verticalBoxBas;
	}


	/**
	 * @return the panelMenu
	 */
	public JPanel getPanelMenu() {
		return panelMenu;
	}


	/**
	 * @param panelMenu the panelMenu to set
	 */
	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}


	/**
	 * @return the panelContent
	 */
	public JPanel getPanelContent() {
		return panelContent;
	}


	/**
	 * @param panelContent the panelContent to set
	 */
	public void setPanelContent(JPanel panelContent) {
		this.panelContent = panelContent;
	}


	/**
	 * @return the cardLayoutMenu
	 */
	public CardLayout getCardLayoutMenu() {
		return cardLayoutMenu;
	}


	/**
	 * @param cardLayoutMenu the cardLayoutMenu to set
	 */
	public void setCardLayoutMenu(CardLayout cardLayoutMenu) {
		this.cardLayoutMenu = cardLayoutMenu;
	}


	/**
	 * @return the cardLayoutContent
	 */
	public CardLayout getCardLayoutContent() {
		return cardLayoutContent;
	}


	/**
	 * @param cardLayoutContent the cardLayoutContent to set
	 */
	public void setCardLayoutContent(CardLayout cardLayoutContent) {
		this.cardLayoutContent = cardLayoutContent;
	}


	/**
	 * @return the appliMenuRechercheSimple
	 */
	public AppliMenuRechercheSimple getAppliMenuRechercheSimple() {
		return appliMenuRechercheSimple;
	}


	/**
	 * @param appliMenuRechercheSimple the appliMenuRechercheSimple to set
	 */
	public void setAppliMenuRechercheSimple(
			AppliMenuRechercheSimple appliMenuRechercheSimple) {
		this.appliMenuRechercheSimple = appliMenuRechercheSimple;
	}


	/**
	 * @return the appliMenuLiensDictionnaires
	 */
	public AppliMenuLiensDictionnaires getAppliMenuLiensDictionnaires() {
		return appliMenuLiensDictionnaires;
	}


	/**
	 * @param appliMenuLiensDictionnaires the appliMenuLiensDictionnaires to set
	 */
	public void setAppliMenuLiensDictionnaires(
			AppliMenuLiensDictionnaires appliMenuLiensDictionnaires) {
		this.appliMenuLiensDictionnaires = appliMenuLiensDictionnaires;
	}


	/**
	 * @return the appliMenuRechercheAvancee
	 */
	public AppliMenuRechercheAvancee getAppliMenuRechercheAvancee() {
		return appliMenuRechercheAvancee;
	}


	/**
	 * @param appliMenuRechercheAvancee the appliMenuRechercheAvancee to set
	 */
	public void setAppliMenuRechercheAvancee(
			AppliMenuRechercheAvancee appliMenuRechercheAvancee) {
		this.appliMenuRechercheAvancee = appliMenuRechercheAvancee;
	}


	/**
	 * @return the appliContentEditionMot
	 */
	public AppliContentEditionMot getAppliContentEditionMot() {
		return appliContentEditionMot;
	}


	/**
	 * @param appliContentEditionMot the appliContentEditionMot to set
	 */
	public void setAppliContentEditionMot(
			AppliContentEditionMot appliContentEditionMot) {
		this.appliContentEditionMot = appliContentEditionMot;
	}


	/**
	 * @return the appliContentRechercheSimple
	 */
	public AppliContentRechercheSimple getAppliContentRechercheSimple() {
		return appliContentRechercheSimple;
	}


	/**
	 * @param appliContentRechercheSimple the appliContentRechercheSimple to set
	 */
	public void setAppliContentRechercheSimple(
			AppliContentRechercheSimple appliContentRechercheSimple) {
		this.appliContentRechercheSimple = appliContentRechercheSimple;
	}


	/**
	 * @return the appliContentRechercheAvancee
	 */
	public AppliContentRechercheAvancee getAppliContentRechercheAvancee() {
		return appliContentRechercheAvancee;
	}


	/**
	 * @param appliContentRechercheAvancee the appliContentRechercheAvancee to set
	 */
	public void setAppliContentRechercheAvancee(
			AppliContentRechercheAvancee appliContentRechercheAvancee) {
		this.appliContentRechercheAvancee = appliContentRechercheAvancee;
	}
}
