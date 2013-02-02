package ui.components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.objects.ExpandingPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import java.awt.GridBagConstraints;

/**
 * @author Valentin
 *
 */
@SuppressWarnings({ "static-access"})
public class AppliContentRechercheSimple extends JPanel {

	private static final long serialVersionUID = -6948901479750294821L;
	
	private JScrollPane jScrollPane = new JScrollPane();

	/**
	 * Create the panel.
	 */
	public AppliContentRechercheSimple() {
		setBackground(Color.ORANGE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,1,2,1);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
 
        JPanel p1 = new JPanel(new GridBagLayout());
        gbc.gridwidth = gbc.RELATIVE;
        p1.add(new JButton("button 1"), gbc);
        gbc.gridwidth = gbc.REMAINDER;
        p1.add(new JButton("button 2"), gbc);
        gbc.gridwidth = gbc.RELATIVE;
        p1.add(new JButton("button 3"), gbc);
        gbc.gridwidth = gbc.REMAINDER;
        p1.add(new JButton("button 4"), gbc);
 
        JPanel p2 = new JPanel(new GridBagLayout());
        gbc.gridwidth = 1;
        gbc.anchor = gbc.EAST;
        p2.add(new JLabel("enter"), gbc);
        gbc.anchor = gbc.WEST;
        p2.add(new JTextField(8), gbc);
        gbc.anchor = gbc.CENTER;
        p2.add(new JButton("button 1"), gbc);
        gbc.gridwidth = gbc.REMAINDER;
        p2.add(new JButton("button 2"), gbc);
 
        JPanel p3 = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(8,12);
        textArea.setLineWrap(true);
        p3.add(new JScrollPane(textArea));
        
        JPanel p5 = new JPanel(new GridBagLayout());
        p5.add(new JButton("button 1"), gbc);
        p5.add(new JButton("button 2"), gbc);
        p5.add(new JButton("button 3"), gbc);
        p5.add(new JButton("button 4"), gbc);
        p5.add(new JButton("button 5"), gbc);
        p5.add(new JButton("button 6"), gbc);
        p5.add(new JButton("button 7"), gbc);
        p5.add(new JButton("button 8"), gbc);
        p5.add(new JButton("button 9"), gbc);
        p5.add(new JButton("button 10"), gbc);
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        
        
		ExpandingPanels expandingPanels = new ExpandingPanels(4);
		
		expandingPanels.addVolet("Test 1", p1);
		expandingPanels.addVolet("Test 2", p2);
		expandingPanels.addVolet("Test 3", p3);
		expandingPanels.addVolet("Test 4", p5);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(new JScrollPane(expandingPanels.getComponent()), gbc_btnNewButton);
	}

	public JScrollPane getjScrollPane() {
		return jScrollPane;
	}

	public void setjScrollPane(JScrollPane jScrollPane) {
		this.jScrollPane = jScrollPane;
	}

}














/*
 *  public static void main(String[] args)
    {
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,1,2,1);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
 
        JPanel p1 = new JPanel(new GridBagLayout());
        gbc.gridwidth = gbc.RELATIVE;
        p1.add(new JButton("button 1"), gbc);
        gbc.gridwidth = gbc.REMAINDER;
        p1.add(new JButton("button 2"), gbc);
        gbc.gridwidth = gbc.RELATIVE;
        p1.add(new JButton("button 3"), gbc);
        gbc.gridwidth = gbc.REMAINDER;
        p1.add(new JButton("button 4"), gbc);
 
        JPanel p2 = new JPanel(new GridBagLayout());
        gbc.gridwidth = 1;
        gbc.anchor = gbc.EAST;
        p2.add(new JLabel("enter"), gbc);
        gbc.anchor = gbc.WEST;
        p2.add(new JTextField(8), gbc);
        gbc.anchor = gbc.CENTER;
        p2.add(new JButton("button 1"), gbc);
        gbc.gridwidth = gbc.REMAINDER;
        p2.add(new JButton("button 2"), gbc);
 
        JPanel p3 = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(8,12);
        textArea.setLineWrap(true);
        p3.add(new JScrollPane(textArea));
        
        JPanel p5 = new JPanel(new GridBagLayout());
        p5.add(new JButton("button 1"), gbc);
        p5.add(new JButton("button 2"), gbc);
        p5.add(new JButton("button 3"), gbc);
        p5.add(new JButton("button 4"), gbc);
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
    	
    	
    	
        Test test = new Test(4);
        
        test.addVolet("Bonjour", p1);
        test.addVolet("Salut", p2);
        test.addVolet("Hallo", p3);
        test.addVolet("Hello", p5);
        
        
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new JScrollPane(test.getComponent()));
        f.setSize(360,500);
        f.setLocation(200,100);
        f.setVisible(true);
    }
    */
