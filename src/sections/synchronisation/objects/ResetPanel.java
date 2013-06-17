/**
 * 
 */
package sections.synchronisation.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import principal.Application;
import sections.synchronisation.Synchronisation;
import dao.UtilisateurDAO;
import database.Utilisateur;
import javax.swing.JProgressBar;

/**
 * @author Valentin DOULCIER
 *
 */
public class ResetPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -3072421748808043843L;

	private JLabel lblEtat;
	private JButton btnReset;
	private JProgressBar progressBar;

	private Application application;

	//private Thread thread;

	/**
	 * Create the panel.
	 */
	public ResetPanel(final Application application) {

		this.application = application;


		initComponents();

		//thread = new Thread(this);
		//thread.start();


		btnReset.addActionListener(this);

		/*
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Object[] options = {"Je comprends",	"Annuler"};

				int value = JOptionPane.showOptionDialog(new Frame(),
						"Cette action supprimera l'intégralité des données de la base.\nAussi, cette action est irreversible",
						"Attention",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE,
						null,
						options,
						options[0]);

				if(value == 0) {
					synchronized(this) {
						notifyAll();
					}
					if(Synchronisation.getInstance(application).resetDatabase()) {
						lblEtat.setForeground(Color.GREEN);
						lblEtat.setText("Réinitialisation : OK");
					}
					else {
						lblEtat.setForeground(Color.RED);
						lblEtat.setText("Réinitialisation : Echec");
					}
					new UtilisateurDAO("local").create(new Utilisateur("Administrateur", "Admin", "dc647eb65e6711e155375218212b3964", true));				
					new UtilisateurDAO("local").create(new Utilisateur("Valentin DOULCIER", "valentin.doulcier", "ab4f63f9ac65152575886860dde480a1", true));
					new UtilisateurDAO("local").create(new Utilisateur("Adrien BATAILLE", "adrien.bataille", "ab4f63f9ac65152575886860dde480a1", false));
				}
			}
		});
		 */

	}

	public void actionPerformed(ActionEvent ae) {

		Object[] options = {"Je comprends",	"Annuler"};

		int value = JOptionPane.showOptionDialog(new Frame(),
				"Cette action supprimera l'intégralité des données de la base.\nAussi, cette action est irreversible",
				"Attention",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[0]);

		if(value == 0) {
			new Thread(new Runnable() {
	            @Override
	            public void run() {
	            	for (int i = 0; i <= 100; i++) {
	    	            progressBar.setValue(i);
	    	            try {
	    	            	Thread.sleep(20);
	    	            }
	    	            catch (InterruptedException e) {}
	    	        }
	            }
	        }).start();
			

			if(Synchronisation.getInstance(application).resetDatabase()) {
				lblEtat.setForeground(Color.GREEN);
				lblEtat.setText("Réinitialisation : OK");
			}
			else {
				lblEtat.setForeground(Color.RED);
				lblEtat.setText("Réinitialisation : Echec");
			}
			new UtilisateurDAO("local").create(new Utilisateur("Administrateur", "Admin", "dc647eb65e6711e155375218212b3964", true));				
			new UtilisateurDAO("local").create(new Utilisateur("Valentin DOULCIER", "valentin.doulcier", "ab4f63f9ac65152575886860dde480a1", true));
			new UtilisateurDAO("local").create(new Utilisateur("Adrien BATAILLE", "adrien.bataille", "ab4f63f9ac65152575886860dde480a1", false));
		}
	}

	
	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 75, 0, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblTitre = new JLabel("Réinitialiser la base de données");
		lblTitre.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre.gridx = 1;
		gbc_lblTitre.gridy = 1;
		add(lblTitre, gbc_lblTitre);

		lblEtat = new JLabel("");
		lblEtat.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		GridBagConstraints gbc_lblEtat = new GridBagConstraints();
		gbc_lblEtat.insets = new Insets(0, 0, 5, 5);
		gbc_lblEtat.gridx = 1;
		gbc_lblEtat.gridy = 3;
		add(lblEtat, gbc_lblEtat);

		btnReset = new JButton("Reset");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.fill = GridBagConstraints.VERTICAL;
		gbc_btnReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnReset.gridx = 1;
		gbc_btnReset.gridy = 4;
		add(btnReset, gbc_btnReset);

		progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 5;
		add(progressBar, gbc_progressBar);
	}

	/**
	 * @return the progressBar
	 */
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	/**
	 * @param progressBar the progressBar to set
	 */
	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	/**
	 * @return the lblEtat
	 */
	public JLabel getLblEtat() {
		return lblEtat;
	}

	/**
	 * @param lblEtat the lblEtat to set
	 */
	public void setLblEtat(JLabel lblEtat) {
		this.lblEtat = lblEtat;
	}

	/**
	 * @return the btnReset
	 */
	public JButton getBtnReset() {
		return btnReset;
	}

	/**
	 * @param btnReset the btnReset to set
	 */
	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

}
