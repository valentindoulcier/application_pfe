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
	
	private AccueilPanel accueilPanel;
	private PullPanel pullPanel;
	private PushPanel pushPanel;
	private ResetPanel resetPanel;

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
		
		accueilPanel = new AccueilPanel();
		pullPanel = new PullPanel();
		pushPanel = new PushPanel();
		resetPanel = new ResetPanel(application);
		
		this.add(accueilPanel, "accueilPanel");
		this.add(pullPanel, "pullPanel");
		this.add(pushPanel, "pushPanel");
		this.add(resetPanel, "resetPanel");
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

	/**
	 * @return the accueilPanel
	 */
	public JPanel getAccueilPanel() {
		return accueilPanel;
	}

	/**
	 * @param accueilPanel the accueilPanel to set
	 */
	public void setAccueilPanel(AccueilPanel accueilPanel) {
		this.accueilPanel = accueilPanel;
	}

	/**
	 * @return the pullPanel
	 */
	public PullPanel getPullPanel() {
		return pullPanel;
	}

	/**
	 * @param pullPanel the pullPanel to set
	 */
	public void setPullPanel(PullPanel pullPanel) {
		this.pullPanel = pullPanel;
	}

	/**
	 * @return the pushPanel
	 */
	public PushPanel getPushPanel() {
		return pushPanel;
	}

	/**
	 * @param pushPanel the pushPanel to set
	 */
	public void setPushPanel(PushPanel pushPanel) {
		this.pushPanel = pushPanel;
	}

	/**
	 * @return the resetPanel
	 */
	public ResetPanel getResetPanel() {
		return resetPanel;
	}

	/**
	 * @param resetPanel the resetPanel to set
	 */
	public void setResetPanel(ResetPanel resetPanel) {
		this.resetPanel = resetPanel;
	}
}
