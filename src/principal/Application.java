/**
 * 
 */
package principal;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JSplitPane;

import principal.ui.contents.ContentFooterHome;
import principal.ui.contents.ContentHeaderHome;
import principal.ui.contents.ContentHome;


/**
 * @author Valentin
 *
 */
public class Application extends JFrame {

	private static final long serialVersionUID = -5463882792147179527L;

	private JMenuBar menuBar;
	private JMenu mnTemporaire;
	private JMenuItem mntmConfigurationItem;
	private JMenuItem mntmApplicationItem;

	private JPanel volet;
	private JPanel content;

	private JPanel vHeader;
	private JPanel vPanel;
	private JPanel vFooter;

	private CardLayout voletHeader;
	private CardLayout voletPanel;
	private CardLayout voletFooter;

	private JPanel cHeader;
	private JPanel cPanel;
	private JPanel cFooter;

	private CardLayout contentHeader;
	private CardLayout contentPanel;
	private CardLayout contentFooter;

	private ContentHeaderHome contentHeaderHome;
	private ContentHome contentHome;
	private ContentFooterHome contentFooterHome;

	private JSplitPane splitPane;
	
	private ArrayList<Recherche> mesRecherches;

	/**
	 * Create the frame.
	 */
	public Application() {

		if (isMacOSX()) {
			enableFullScreenMode(this);
		}

		initMenu();
		initComponents();		
	}

	public void initComponents() {
		this.setTitle("Application L.L.L.");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1000, 600);
		this.setMinimumSize(getSize());
		
		mesRecherches = new ArrayList<Recherche>();

		// Panel Volet
		volet = new JPanel();
		volet.setLayout(new BorderLayout(0, 0));
		volet.setMinimumSize(new Dimension(0, 0));

		vHeader = new JPanel();
		vHeader.setMinimumSize(new Dimension(300, 30));
		vHeader.setPreferredSize(new Dimension(300, 30));
		voletHeader = new CardLayout();
		vHeader.setLayout(voletHeader);

		vPanel = new JPanel();
		voletPanel = new CardLayout();
		vPanel.setLayout(voletPanel);

		vFooter = new JPanel();
		vFooter.setMinimumSize(new Dimension(300, 30));
		vFooter.setPreferredSize(new Dimension(300, 30));
		voletFooter = new CardLayout();
		vFooter.setLayout(voletFooter);

		volet.add(vHeader, BorderLayout.NORTH);
		volet.add(vPanel, BorderLayout.CENTER);
		volet.add(vFooter, BorderLayout.SOUTH);


		// Panel Content
		content = new JPanel();
		content.setLayout(new BorderLayout(0, 0));
		content.setMinimumSize(new Dimension(0, 0));

		cHeader = new JPanel();
		cHeader.setMinimumSize(new Dimension(0, 30));
		cHeader.setPreferredSize(new Dimension(0, 30));
		contentHeader = new CardLayout();
		cHeader.setLayout(contentHeader);

		cPanel = new JPanel();
		contentPanel = new CardLayout();
		cPanel.setLayout(contentPanel);

		cFooter = new JPanel();
		cFooter.setMinimumSize(new Dimension(0, 30));
		cFooter.setPreferredSize(new Dimension(0, 30));
		contentFooter = new CardLayout();
		cFooter.setLayout(contentFooter);

		content.add(cHeader, BorderLayout.NORTH);
		content.add(cPanel, BorderLayout.CENTER);
		content.add(cFooter, BorderLayout.SOUTH);

		contentHeaderHome = new ContentHeaderHome(this);
		contentHome = new ContentHome(this);
		contentFooterHome = new ContentFooterHome(this);

		cHeader.add(contentHeaderHome, "ContentHeaderHome");
		cPanel.add(contentHome, "ContentHome");
		cFooter.add(contentFooterHome, "ContentFooterHome");

		// SplitPane
		splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setEnabled(false);
		splitPane.setDividerLocation(0);

		// Ajout des composants
		splitPane.setLeftComponent(volet);
		splitPane.setRightComponent(content);

		getContentPane().add(splitPane, BorderLayout.CENTER);

		this.setVisible(true);
	}
	
	public void OuvrirVolet() {
		splitPane.setDividerLocation(300);
	}
	
	public void FermerVolet() {
		splitPane.setDividerLocation(0);
	}

	public void initMenu() {
		// Menu Bar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Menu
		mnTemporaire = new JMenu("Temporaire");
		menuBar.add(mnTemporaire);

		// Menu item
		mntmConfigurationItem = new JMenuItem("Préférences");
		mntmApplicationItem = new JMenuItem("Application");
		mnTemporaire.add(mntmConfigurationItem);
		mnTemporaire.add(mntmApplicationItem);
	}

	/**
	 * Cette méthode regarde l'OS de l'utilisateur.
	 * 
	 * @return Un booleen qui indique si l'OS est Max OS X ou non.
	 */
	private static boolean isMacOSX() {
		return System.getProperty("os.name").indexOf("Mac OS X") >= 0;
	}

	/**
	 * Cette fonction permet à un utilisateur sous Mac OS X (Mountain Lion ou ultérieur) de passer en plein écran.
	 * 
	 * @param window
	 */
	public static void enableFullScreenMode(Window window) {
		String className = "com.apple.eawt.FullScreenUtilities";
		String methodName = "setWindowCanFullScreen";

		try {
			Class<?> clazz = Class.forName(className);

			Method method = clazz.getMethod(methodName, new Class<?>[] {
					Window.class, boolean.class 
			}
					);

			method.invoke(null, window, true);
		} catch (Throwable t) {
			System.err.println("Full screen mode is not supported");
			t.printStackTrace();
		}
	}

	/**
	 * @return the mesRecherches
	 */
	public ArrayList<Recherche> getMesRecherches() {
		return mesRecherches;
	}

	/**
	 * @param mesRecherches the mesRecherches to set
	 */
	public void setMesRecherches(ArrayList<Recherche> mesRecherches) {
		this.mesRecherches = mesRecherches;
	}

	/**
	 * @return the volet
	 */
	public JPanel getVolet() {
		return volet;
	}

	/**
	 * @param volet the volet to set
	 */
	public void setVolet(JPanel volet) {
		this.volet = volet;
	}

	/**
	 * @return the content
	 */
	public JPanel getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(JPanel content) {
		this.content = content;
	}

	/**
	 * @return the vHeader
	 */
	public JPanel getvHeader() {
		return vHeader;
	}

	/**
	 * @param vHeader the vHeader to set
	 */
	public void setvHeader(JPanel vHeader) {
		this.vHeader = vHeader;
	}

	/**
	 * @return the vPanel
	 */
	public JPanel getvPanel() {
		return vPanel;
	}

	/**
	 * @param vPanel the vPanel to set
	 */
	public void setvPanel(JPanel vPanel) {
		this.vPanel = vPanel;
	}

	/**
	 * @return the vFooter
	 */
	public JPanel getvFooter() {
		return vFooter;
	}

	/**
	 * @param vFooter the vFooter to set
	 */
	public void setvFooter(JPanel vFooter) {
		this.vFooter = vFooter;
	}

	/**
	 * @return the voletHeader
	 */
	public CardLayout getVoletHeader() {
		return voletHeader;
	}

	/**
	 * @param voletHeader the voletHeader to set
	 */
	public void setVoletHeader(CardLayout voletHeader) {
		this.voletHeader = voletHeader;
	}

	/**
	 * @return the voletPanel
	 */
	public CardLayout getVoletPanel() {
		return voletPanel;
	}

	/**
	 * @param voletPanel the voletPanel to set
	 */
	public void setVoletPanel(CardLayout voletPanel) {
		this.voletPanel = voletPanel;
	}

	/**
	 * @return the voletFooter
	 */
	public CardLayout getVoletFooter() {
		return voletFooter;
	}

	/**
	 * @param voletFooter the voletFooter to set
	 */
	public void setVoletFooter(CardLayout voletFooter) {
		this.voletFooter = voletFooter;
	}

	/**
	 * @return the cHeader
	 */
	public JPanel getcHeader() {
		return cHeader;
	}

	/**
	 * @param cHeader the cHeader to set
	 */
	public void setcHeader(JPanel cHeader) {
		this.cHeader = cHeader;
	}

	/**
	 * @return the cPanel
	 */
	public JPanel getcPanel() {
		return cPanel;
	}

	/**
	 * @param cPanel the cPanel to set
	 */
	public void setcPanel(JPanel cPanel) {
		this.cPanel = cPanel;
	}

	/**
	 * @return the cFooter
	 */
	public JPanel getcFooter() {
		return cFooter;
	}

	/**
	 * @param cFooter the cFooter to set
	 */
	public void setcFooter(JPanel cFooter) {
		this.cFooter = cFooter;
	}

	/**
	 * @return the contentHeader
	 */
	public CardLayout getContentHeader() {
		return contentHeader;
	}

	/**
	 * @param contentHeader the contentHeader to set
	 */
	public void setContentHeader(CardLayout contentHeader) {
		this.contentHeader = contentHeader;
	}

	/**
	 * @return the contentPanel
	 */
	public CardLayout getContentPanel() {
		return contentPanel;
	}

	/**
	 * @param contentPanel the contentPanel to set
	 */
	public void setContentPanel(CardLayout contentPanel) {
		this.contentPanel = contentPanel;
	}

	/**
	 * @return the contentFooter
	 */
	public CardLayout getContentFooter() {
		return contentFooter;
	}

	/**
	 * @param contentFooter the contentFooter to set
	 */
	public void setContentFooter(CardLayout contentFooter) {
		this.contentFooter = contentFooter;
	}

	/**
	 * @return the contentHeaderHome
	 */
	public ContentHeaderHome getContentHeaderHome() {
		return contentHeaderHome;
	}

	/**
	 * @param contentHeaderHome the contentHeaderHome to set
	 */
	public void setContentHeaderHome(ContentHeaderHome contentHeaderHome) {
		this.contentHeaderHome = contentHeaderHome;
	}

	/**
	 * @return the contentHome
	 */
	public ContentHome getContentHome() {
		return contentHome;
	}

	/**
	 * @param contentHome the contentHome to set
	 */
	public void setContentHome(ContentHome contentHome) {
		this.contentHome = contentHome;
	}

	/**
	 * @return the contentFooterHome
	 */
	public ContentFooterHome getContentFooterHome() {
		return contentFooterHome;
	}

	/**
	 * @param contentFooterHome the contentFooterHome to set
	 */
	public void setContentFooterHome(ContentFooterHome contentFooterHome) {
		this.contentFooterHome = contentFooterHome;
	}

	/**
	 * @return the splitPane
	 */
	public JSplitPane getSplitPane() {
		return splitPane;
	}

	/**
	 * @param splitPane the splitPane to set
	 */
	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

}
