package principal;

import ui.mainframes.*;

import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.apache.log4j.Logger;

import java.awt.Window;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Cette classe concerne la fenêtre principale de l'application.
 * 
 * @author Valentin DOULCIER
 * @version 0.0.1
 */
@SuppressWarnings("unused")
public class Application extends JFrame {

	private static final long serialVersionUID = -8042460976894676449L;
	
	private static Logger logger = Logger.getLogger(Application.class);

	private JMenuBar menuBar;
	private JMenu mnTemporaire;
	private JMenuItem mntmConfigurationItem;
	private JMenuItem mntmApplicationItem;
	private CardLayout cardLayout;

	private LayerConfiguration layerConfiguration;
	private LayerApplication layerApplication;

	/**
	 * Constructeur de la fenêtre.
	 */
	public Application() {

		if (isMacOSX()) {
			enableFullScreenMode(this);
		}

		initComponents();



	}


	private void initComponents() {

		// Main Frame
		this.setTitle("Application L.L.L.");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1000, 650);
		this.setMinimumSize(getSize());

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

		
		cardLayout = new CardLayout(0, 0);
		getContentPane().setLayout(cardLayout);

		layerApplication = new LayerApplication(this);
		layerConfiguration = new LayerConfiguration(this);
		getContentPane().add(layerConfiguration, "layerConfiguration");
		getContentPane().add(layerApplication, "layerApplication");

		mntmConfigurationItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(getContentPane(), "layerConfiguration");
			}
		});

		mntmApplicationItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), "layerApplication");
			}
		});

		this.setVisible(true);
	}


	public CardLayout getCardLayout() {
		return cardLayout;
	}


	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
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
}
