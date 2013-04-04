/**
 * 
 */
package sections.bddictionnairique.ui.contents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

import principal.Application;
import sections.bddictionnairique.Bddictionnairique;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentFooterEdition extends JPanel {

	private static final long serialVersionUID = 5305513960615199881L;
	
	int ecranAppellant;
	
	private JButton btnClose;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentFooterEdition(final Application application) {
		
		initComponents();
		
		ecranAppellant = Bddictionnairique.getInstance(application).getJeViensDe();
		
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Bddictionnairique.getInstance(application).fermerCurrentOnglet();
				Bddictionnairique.getInstance(application).afficherOnglet(ecranAppellant);
			}
		});
		
		
	}
	
	public void initComponents() {
		setBackground(Color.GRAY);
		
		btnClose = new JButton("Close");
		add(btnClose);
	}

}
