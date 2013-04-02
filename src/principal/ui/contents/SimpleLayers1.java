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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SimpleLayers1 extends JFrame {
	
	JButton btnNewButton;
	
  public SimpleLayers1() {
    super("LayeredPane Demonstration");
    setSize(394, 259);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{20, 0, 20, 0};
    gridBagLayout.rowHeights = new int[]{20, 0, 20, 0};
    gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
    getContentPane().setLayout(gridBagLayout);
    
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setLayout(null);
    GridBagConstraints gbc_layeredPane = new GridBagConstraints();
    gbc_layeredPane.insets = new Insets(0, 0, 5, 5);
    gbc_layeredPane.fill = GridBagConstraints.BOTH;
    gbc_layeredPane.gridx = 1;
    gbc_layeredPane.gridy = 1;
    getContentPane().add(layeredPane, gbc_layeredPane);
    
    final JPanel panel = new JPanel();
    panel.setBounds(6, 6, 317, 161);
    panel.setBackground(Color.GREEN);
    layeredPane.add(panel, new Integer(1));
    
    final JPanel panel_2 = new JPanel();
    panel_2.setVisible(false);
    panel_2.setBackground(Color.MAGENTA);
    panel_2.setBounds(58, 6, 206, 85);
    layeredPane.add(panel_2, new Integer(2));
    
    JButton btnAfficher = new JButton("Afficher");
    GridBagConstraints gbc_btnAfficher = new GridBagConstraints();
    gbc_btnAfficher.insets = new Insets(0, 0, 0, 5);
    gbc_btnAfficher.gridx = 1;
    gbc_btnAfficher.gridy = 2;
    getContentPane().add(btnAfficher, gbc_btnAfficher);
   
    btnAfficher.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(panel_2.isVisible())
				panel_2.setVisible(false);
			else
				panel_2.setVisible(true);
		}
	});
    
    
    
  }

  public static void main(String[] args) {
    SimpleLayers1 sl = new SimpleLayers1();
    sl.setVisible(true);
  }
}