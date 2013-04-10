/**
 * 
 */
package sections.synchronisation.ui.contents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import javax.swing.JButton;

import dao.UtilisateurDAO;
import database.Utilisateur;

import principal.Application;

import sections.synchronisation.Synchronisation;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentSynchronisation extends JPanel {

	private static final long serialVersionUID = -5468061806376610050L;

	private JButton btnReset;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentSynchronisation(final Application application) {

		initComponents();

		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Synchronisation.getInstance(application).resetDatabase();
				new UtilisateurDAO("local").create(new Utilisateur("Administrateur", "Admin", "dc647eb65e6711e155375218212b3964", true));				
				new UtilisateurDAO("local").create(new Utilisateur("Valentin DOULCIER", "valentin.doulcier", "ab4f63f9ac65152575886860dde480a1", true));
				new UtilisateurDAO("local").create(new Utilisateur("Adrien BATAILLE", "adrien.bataille", "ab4f63f9ac65152575886860dde480a1", false));
			}
		});

		/*
		SynchronisationDAO synchroDAO = new SynchronisationDAO("local");

		synchroDAO.chargerListeTablesDatabase();
		synchroDAO.chargerListeTablesReference();

		if(synchroDAO.isGoodSchema()) {
			System.out.println("CA MATCH LE SCHEMA !!");

			if(synchroDAO.isGoodDatabase()) {
				System.out.println("CA MATCH LES TABLES!!");
			}
			else {
				System.out.println("CA NE MATCH PAS LES TABLES!!");
			}
		}
		else {
			System.out.println("CA NE MATCH PAS LE SCHEMA !!");
		}
		*/
	}

	public void initComponents() {
		btnReset = new JButton("RESET");
		add(btnReset);
	}

}
