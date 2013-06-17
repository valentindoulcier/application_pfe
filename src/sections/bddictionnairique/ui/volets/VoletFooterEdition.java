/**
 * 
 */
package sections.bddictionnairique.ui.volets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import principal.Application;
import sections.bddictionnairique.Bddictionnairique;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletFooterEdition extends JPanel {

	private static final long serialVersionUID = -8205513947303933417L;
	
	int ecranAppellant;
	
	private JButton btnClose;
	
	public VoletFooterEdition(final Application application) {
		
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
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		
		btnClose = new JButton("Close");
		add(btnClose);
	}

}
