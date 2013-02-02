package ui.objects;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Valentin
 *
 */
public class ExpandingPanels extends MouseAdapter {

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
            togglePanelVisibility(ap);
        }
    }
 
    private void togglePanelVisibility(ActionPanel ap) {
        int index = getPanelIndex(ap);
        if(panels.get(index).isShowing())
        	panels.get(index).setVisible(false);
        else
        	panels.get(index).setVisible(true);
        ap.getParent().validate();
    }
 
    private int getPanelIndex(ActionPanel ap) {
        for(int j = 0; j < aps.size(); j++)
            if(ap == aps.get(j))
                return j;
        return -1;
    }

    public void addVolet(String title, JPanel panel) {
    	ids.add(title);
    	panels.add(panel);
    	aps.add(new ActionPanel(title, this));
    }
 

    public JPanel getComponent() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1,3,0,3);
        gbc.weightx = 1.0;
        gbc.fill = gbc.HORIZONTAL;
        gbc.gridwidth = gbc.REMAINDER;
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
