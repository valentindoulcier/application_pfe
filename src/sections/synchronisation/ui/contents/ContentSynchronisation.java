/**
 * 
 */
package sections.synchronisation.ui.contents;

import java.awt.CardLayout;

import javax.swing.JPanel;

import principal.Application;
import sections.synchronisation.objects.AccueilPanel;
import sections.synchronisation.objects.PullPanel;
import sections.synchronisation.objects.PushPanel;
import sections.synchronisation.objects.ResetPanel;



/**
 * @author Valentin DOULCIER
 *
 */
public class ContentSynchronisation extends JPanel {

	private static final long serialVersionUID = -5468061806376610050L;
	
	private CardLayout cardLayout = new CardLayout(0, 0);

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentSynchronisation(final Application application) {

		initComponents(application);

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

	public void initComponents(Application application) {
		this.setLayout(cardLayout);
		
		this.add(new AccueilPanel(), "accueilPanel");
		this.add(new PullPanel(), "pullPanel");
		this.add(new PushPanel(), "pushPanel");
		this.add(new ResetPanel(application), "resetPanel");
	}

	/**
	 * @return the cardLayout
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * @param cardLayout the cardLayout to set
	 */
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
}
