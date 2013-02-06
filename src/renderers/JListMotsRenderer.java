package renderers;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

class JListMotsRenderer implements ListCellRenderer {

	public Component component;

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {        
		component = (Component)value;

		if(cellHasFocus) {
			component.setBackground(Color.BLUE);
		}
		else {
			component.setBackground(Color.LIGHT_GRAY);
		}

		if(isSelected) {
			;
		}
		
		return component;
	}
}