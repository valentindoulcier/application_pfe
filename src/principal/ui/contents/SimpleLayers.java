/*
Java Swing, 2nd Edition
By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
ISBN: 0-596-00408-7
Publisher: O'Reilly 
*/
// SimpleLayers.java
//A demonstration of the JLayeredPane class.
//
package principal.ui.contents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleLayers extends JFrame {
	
	JButton btnNewButton;
	
  public SimpleLayers() {
    super("LayeredPane Demonstration");
    setSize(394, 259);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    btnNewButton = new JButton("New button");
    getContentPane().add(btnNewButton, BorderLayout.SOUTH);

    JLayeredPane lp = getLayeredPane();

    // Create 3 buttons
    JPanel top = new JPanel();
    top.setBackground(Color.white);
    top.setBounds(20, 20, 50, 50);
    final JPanel middle = new JPanel();
    middle.setBackground(Color.gray);
    middle.setBounds(40, 40, 50, 50);
    JPanel bottom = new JPanel();
    bottom.setBackground(Color.black);
    bottom.setBounds(60, 60, 50, 50);

    // Place the buttons in different layers
    lp.add(middle, new Integer(2));
    lp.add(top, new Integer(3));
    lp.add(bottom, new Integer(1));
    
    btnNewButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(middle.isVisible())
				middle.setVisible(false);
			else
				middle.setVisible(true);
		}
	});
  }

  public static void main(String[] args) {
    SimpleLayers sl = new SimpleLayers();
    sl.setVisible(true);
  }
}