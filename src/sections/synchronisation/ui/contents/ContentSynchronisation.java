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
	
	private JPanel accueilPanel = new AccueilPanel();
	private JPanel pullPanel = new PullPanel();
	private JPanel pushPanel = new PushPanel();
	private JPanel resetPanel = new ResetPanel();

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentSynchronisation(final Application application) {

		initComponents();

		/*
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Synchronisation.getInstance(application).resetDatabase();
				new UtilisateurDAO("local").create(new Utilisateur("Administrateur", "Admin", "dc647eb65e6711e155375218212b3964", true));				
				new UtilisateurDAO("local").create(new Utilisateur("Valentin DOULCIER", "valentin.doulcier", "ab4f63f9ac65152575886860dde480a1", true));
				new UtilisateurDAO("local").create(new Utilisateur("Adrien BATAILLE", "adrien.bataille", "ab4f63f9ac65152575886860dde480a1", false));
			}
		});
		*/

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
		this.setLayout(cardLayout);
		
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
	public void setAccueilPanel(JPanel accueilPanel) {
		this.accueilPanel = accueilPanel;
	}

	/**
	 * @return the pullPanel
	 */
	public JPanel getPullPanel() {
		return pullPanel;
	}

	/**
	 * @param pullPanel the pullPanel to set
	 */
	public void setPullPanel(JPanel pullPanel) {
		this.pullPanel = pullPanel;
	}

	/**
	 * @return the pushPanel
	 */
	public JPanel getPushPanel() {
		return pushPanel;
	}

	/**
	 * @param pushPanel the pushPanel to set
	 */
	public void setPushPanel(JPanel pushPanel) {
		this.pushPanel = pushPanel;
	}

	/**
	 * @return the resetPanel
	 */
	public JPanel getResetPanel() {
		return resetPanel;
	}

	/**
	 * @param resetPanel the resetPanel to set
	 */
	public void setResetPanel(JPanel resetPanel) {
		this.resetPanel = resetPanel;
	}
}
