package administration.ui.contents;

import principal.Application;
import sections.parseurXML.ParseurXML;
import sections.updateBDD.UpdateBDD;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;


/**
 * @author Valentin DOULCIER
 *
 */
public class ContentAdministration extends JPanel {

	private static final long serialVersionUID = -159621405494399065L;

	private JLabel lblApplication;

	private JLabel lblDescription;

	private JButton btnParseurXML;
	private JButton btnOptions;
	private JLabel lblLogo;
	private JButton btnUpdateBdd;


	/**
	 * Create the panel.
	 */
	public ContentAdministration(final Application application) {

		setBackground(Color.LIGHT_GRAY);

		initComponents();


		btnParseurXML.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				ParseurXML.getInstance(application).chargerParseurXML();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour parser des dictionnaires");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		
		btnUpdateBdd.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici mettre à jour la BDD Master");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				UpdateBDD.getInstance(application).chargerSynchronisation();
			}
		});
		

		btnOptions.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Options.getInstance(application).chargerOptions();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour accéder aux options");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void initComponents() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 120, 30, 120, 30, 120, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 56, 45, 30, 10, 100, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 2.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblApplication = new JLabel("Administration de l'application");
		lblApplication.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		GridBagConstraints gbc_lblApplication = new GridBagConstraints();
		gbc_lblApplication.gridwidth = 5;
		gbc_lblApplication.insets = new Insets(0, 0, 5, 5);
		gbc_lblApplication.gridx = 2;
		gbc_lblApplication.gridy = 1;
		add(lblApplication, gbc_lblApplication);

		lblLogo = new JLabel(new ImageIcon("src/administration/images/logo.png"));
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogo.gridx = 4;
		gbc_lblLogo.gridy = 2;
		add(lblLogo, gbc_lblLogo);

		lblDescription = new JLabel("");
		lblDescription.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.gridwidth = 5;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 2;
		gbc_lblDescription.gridy = 3;
		add(lblDescription, gbc_lblDescription);

		btnParseurXML = new JButton("Parseur XML");
		btnParseurXML.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnParseurXML = new GridBagConstraints();
		gbc_btnParseurXML.fill = GridBagConstraints.BOTH;
		gbc_btnParseurXML.insets = new Insets(0, 0, 5, 5);
		gbc_btnParseurXML.gridx = 2;
		gbc_btnParseurXML.gridy = 5;
		add(btnParseurXML, gbc_btnParseurXML);

		btnUpdateBdd = new JButton("Update BDD");
		GridBagConstraints gbc_btnUpdateBdd = new GridBagConstraints();
		gbc_btnUpdateBdd.fill = GridBagConstraints.VERTICAL;
		gbc_btnUpdateBdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateBdd.gridx = 4;
		gbc_btnUpdateBdd.gridy = 5;
		add(btnUpdateBdd, gbc_btnUpdateBdd);

		btnOptions = new JButton("Options");
		btnOptions.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnOptions = new GridBagConstraints();
		gbc_btnOptions.fill = GridBagConstraints.BOTH;
		gbc_btnOptions.insets = new Insets(0, 0, 5, 5);
		gbc_btnOptions.gridx = 6;
		gbc_btnOptions.gridy = 5;
		add(btnOptions, gbc_btnOptions);
	}
}