package renderers;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

class JListMenuRenderer implements ListCellRenderer {

	public Component component;

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {        
		component = (Component)value;

		if(isSelected) {
			;
		}
		
		return component;
	}
}