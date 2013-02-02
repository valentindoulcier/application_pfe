package ui.mainframes;


import principal.Application;
import ui.components.*;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;
import javax.swing.JTree;
import java.awt.Component;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 * @author Valentin
 *
 */
@SuppressWarnings("unused")
public class LayerApplication extends JPanel {

	private static final long serialVersionUID = -7537563501231664829L;
	
	private static Logger logger = Logger.getLogger(LayerApplication.class);
	
	
	private JButton btnRechercher;
	private JButton btnRechercheSimple;
	private JButton btnLiensDict;
	private JButton btnRechercheAvancee;
	private JButton btnOptions;
	private JButton btnHistorique;
	
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
	
	private AppliContentRechercheSimple appliContentRechercheSimple;
	private AppliContentRechercheAvancee appliContentRechercheAvancee;
	
	
	public LayerApplication(final Application application) {

		initComponents(application);
		
		final SimpleDateFormat maDate = new SimpleDateFormat( "hh:mm:ss" );
		
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date date = new Date(System.currentTimeMillis());
				textFieldRecherche.setText(maDate.format(date).toString());
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
		

	}
	
	
	public void initComponents(final Application application) {
		setBounds(100, 100, 800, 550);

		setBackground(Color.CYAN);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 200, 20, 0, 20, 0, 20, 130, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 226, 203, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textFieldRecherche = new JTextField();
		GridBagConstraints gbc_textFieldRecherche = new GridBagConstraints();
		gbc_textFieldRecherche.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRecherche.gridwidth = 4;
		gbc_textFieldRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRecherche.gridx = 1;
		gbc_textFieldRecherche.gridy = 1;
		add(textFieldRecherche, gbc_textFieldRecherche);
		textFieldRecherche.setColumns(10);
		
		btnRechercher = new JButton("Chercher");
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercher.gridx = 6;
		gbc_btnRechercher.gridy = 1;
		add(btnRechercher, gbc_btnRechercher);
		
		sliderDetails = new JSlider();
		GridBagConstraints gbc_sliderDetail = new GridBagConstraints();
		gbc_sliderDetail.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderDetail.insets = new Insets(0, 0, 5, 5);
		gbc_sliderDetail.gridx = 8;
		gbc_sliderDetail.gridy = 1;
		add(sliderDetails, gbc_sliderDetail);
		
		verticalBoxHaut = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBoxHaut = new GridBagConstraints();
		gbc_verticalBoxHaut.fill = GridBagConstraints.HORIZONTAL;
		gbc_verticalBoxHaut.anchor = GridBagConstraints.NORTH;
		gbc_verticalBoxHaut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBoxHaut.gridx = 1;
		gbc_verticalBoxHaut.gridy = 3;
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
		gbc_verticalBoxBas.gridy = 4;
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
		gbc_panelMenu.gridy = 3;
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
		gbc_panelContent.gridy = 3;
		add(panelContent, gbc_panelContent);
		panelContent.setLayout(cardLayoutContent);
		
		appliContentRechercheSimple = new AppliContentRechercheSimple();
		appliContentRechercheAvancee = new AppliContentRechercheAvancee();
		
		panelContent.add(appliContentRechercheSimple, "AppliContentRechercheSimple");
		panelContent.add(appliContentRechercheAvancee, "AppliContentRechercheAvancee");
		
	}
}
