package principal;

import java.awt.Window;
import java.lang.reflect.Method;
import javax.swing.JFrame;

/**
 * Cette classe concerne la fenêtre principale de l'application.
 * 
 * @author Valentin DOULCIER
 * @version 0.0.1
 */
public class Application extends JFrame {

	private static final long serialVersionUID = -8042460976894676449L;

	/**
	 * Constructeur de la fenêtre.
	 */
	public Application() {
		
		if (isMacOSX()) {
            enableFullScreenMode(this);
        }
		
		setTitle("Application L.L.L.");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		
		setVisible(true);
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
