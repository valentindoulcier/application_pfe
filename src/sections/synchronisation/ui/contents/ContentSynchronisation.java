/**
 * 
 */
package sections.synchronisation.ui.contents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import javax.swing.JButton;

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
