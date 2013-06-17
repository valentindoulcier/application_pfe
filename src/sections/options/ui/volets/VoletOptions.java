/**
 * 
 */
package sections.options.ui.volets;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.apache.log4j.Logger;

import principal.Application;

import sections.options.Options;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletOptions extends JPanel {

	private static final long serialVersionUID = -2569046900134042036L;
	
	private static Logger logger = Logger.getLogger(VoletOptions.class);
	
	private JPanel configPanel;
	private JPanel sqlPanel;
	
	private Application application;
	
	/**
	 * Create the configPanel.
	 */
	public VoletOptions(final Application application) {
		
		this.application = application;
		
		initComponents();
		
		
		configPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				configPanel.setBackground(new Color(204, 153, 255));
				configPanel.setBorder(new LineBorder(new Color(178, 102, 255), 3, true));
				
				sqlPanel.setBackground(new Color(238, 238, 238));
				sqlPanel.setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
				
				// Chargement du panel Config
				Options.getContentOptions().getCardLayout().show(Options.getContentOptions(), "configPanel");
			}
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
		});
		
		sqlPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				configPanel.setBackground(new Color(238, 238, 238));
				configPanel.setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
				
				sqlPanel.setBackground(new Color(204, 153, 255));
				sqlPanel.setBorder(new LineBorder(new Color(178, 102, 255), 3, true));
				
				// Chargement du panel SQL
				Options.getContentOptions().getCardLayout().show(Options.getContentOptions(), "sqlPanel");
			}
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
		});
		
	}
	
	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 200, 200, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		
		configPanel = new JPanel();
		configPanel.setBackground(new Color(204, 153, 255));
		configPanel.setBorder(new LineBorder(new Color(178, 102, 255), 3, true));
		GridBagConstraints gbc_configPanel = new GridBagConstraints();
		gbc_configPanel.insets = new Insets(0, 0, 5, 0);
		gbc_configPanel.fill = GridBagConstraints.BOTH;
		gbc_configPanel.gridx = 0;
		gbc_configPanel.gridy = 1;
		add(configPanel, gbc_configPanel);
		GridBagLayout gbl_configPanel = new GridBagLayout();
		gbl_configPanel.columnWidths = new int[]{20, 0, 20, 0};
		gbl_configPanel.rowHeights = new int[]{20, 0, 20, 0, 20, 0};
		gbl_configPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_configPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		configPanel.setLayout(gbl_configPanel);
		
		JLabel lblConfigtitre = new JLabel("Configuration BDD");
		lblConfigtitre.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GridBagConstraints gbc_lblConfigtitre = new GridBagConstraints();
		gbc_lblConfigtitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfigtitre.gridx = 1;
		gbc_lblConfigtitre.gridy = 1;
		configPanel.add(lblConfigtitre, gbc_lblConfigtitre);
		
		
		
		
		sqlPanel = new JPanel();
		if("master".equalsIgnoreCase(Options.getInstance(application).getSource())) {
			sqlPanel.setVisible(true);
		}
		else if("local".equalsIgnoreCase(Options.getInstance(application).getSource())) {
			sqlPanel.setVisible(false);
		}
		else {
			sqlPanel.setVisible(false);
			logger.error("Source inconnue - Affichage SQL_PANEL");
		}
		sqlPanel.setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
		GridBagConstraints gbc_sqlPanel = new GridBagConstraints();
		gbc_sqlPanel.insets = new Insets(0, 0, 5, 0);
		gbc_sqlPanel.fill = GridBagConstraints.BOTH;
		gbc_sqlPanel.gridx = 0;
		gbc_sqlPanel.gridy = 2;
		add(sqlPanel, gbc_sqlPanel);
		GridBagLayout gbl_sqlPanel = new GridBagLayout();
		gbl_sqlPanel.columnWidths = new int[]{20, 0, 20, 0};
		gbl_sqlPanel.rowHeights = new int[]{20, 0, 20, 0, 20, 0};
		gbl_sqlPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_sqlPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		sqlPanel.setLayout(gbl_sqlPanel);
		
		JLabel lblSqltitre = new JLabel("Test SQL");
		lblSqltitre.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GridBagConstraints gbc_lblSqltitre = new GridBagConstraints();
		gbc_lblSqltitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblSqltitre.gridx = 1;
		gbc_lblSqltitre.gridy = 1;
		sqlPanel.add(lblSqltitre, gbc_lblSqltitre);
		
		
	}

}
