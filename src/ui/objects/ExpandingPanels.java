package ui.objects;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */
public class ExpandingPanels extends MouseAdapter {
	
	//private static Logger logger = Logger.getLogger(ExpandingPanels.class);

	ArrayList<ActionPanel> aps;
    ArrayList<JPanel> panels;
    ArrayList<String> ids;

    /**
     * @wbp.parser.entryPoint
     */
    public ExpandingPanels(int nb) {
    	panels = new ArrayList<JPanel>();
    	ids = new ArrayList<String>();
    	aps = new ArrayList<ActionPanel>();
    }
 
    public void mousePressed(MouseEvent e) {
        ActionPanel ap = (ActionPanel)e.getSource();
        if(ap.getTarget().contains(e.getPoint()))
        {
            ap.toggleSelection();
            togglePanel1Visibility(ap);
        }
    }
 
    private void togglePanel1Visibility(ActionPanel ap) {
        int index = getPanel1Index(ap);
        if(panels.get(index).isShowing())
        	panels.get(index).setVisible(false);
        else
        	panels.get(index).setVisible(true);
        ap.getParent().validate();
    }
 
    private int getPanel1Index(ActionPanel ap) {
        for(int j = 0; j < aps.size(); j++)
            if(ap == aps.get(j))
                return j;
        return -1;
    }

    public void addVolet(String title, int nb, JPanel panel) {
    	ids.add(title);
    	panels.add(panel);
    	aps.add(new ActionPanel(title, nb, this));
    }
    
    public void clear() {
    	ids.clear();
    	panels.clear();
    	aps.clear();
    }
 

    public JPanel getComponent() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1,3,0,3);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        for(int j = 0; j < aps.size(); j++)
        {
            panel.add(aps.get(j), gbc);
            panel.add(panels.get(j), gbc);
            panels.get(j).setVisible(false);
        }
        JLabel padding = new JLabel();
        gbc.weighty = 1.0;
        panel.add(padding, gbc);
        return panel;
    }

}
