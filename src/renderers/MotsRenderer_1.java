package renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.util.EventObject;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import principal.Application;

import ui.objects.*;

/**
 * @author Valentin
 *
 */
public class MotsRenderer_1 extends JPanel {

	private static final long serialVersionUID = -7278560233653998493L;

	private TableModel_1 compModel = null;


	public MotsRenderer_1(Application application, Vector<RSDetail_1> listeMots) {
		
		if(listeMots.size() > 0) {
			if(30*listeMots.size()+5 > 250) {
				this.setPreferredSize(new Dimension(0, 250));
			}
			else {
				this.setPreferredSize(new Dimension(0, 30*listeMots.size()+5));
			}
		}
		else {
			this.setPreferredSize(new Dimension(0, 0));
		}
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JScrollPane compTableScrollpane = new JScrollPane(CreateCompTable(application, listeMots), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		this.add(compTableScrollpane, gbc_scrollPane);
	}

	public JTable CreateCompTable(Application application, Vector<RSDetail_1> listeMots) {

		compModel = new TableModel_1();

		compModel.addRows(listeMots);

		JTable table = new JTable(compModel);
		table.setRowHeight(30);
		table.setTableHeader(null);
		CellEditorRenderer_1 cellEditorRenderer = new CellEditorRenderer_1(application);
		table.setDefaultRenderer(Object.class, cellEditorRenderer);
		table.setDefaultEditor(Object.class, cellEditorRenderer);
		return table;
	}

}



class CellEditorRenderer_1 extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private static final long serialVersionUID = -1167972153205157391L;

	private RSDetail_1 renderer;
    private RSDetail_1 editor;
    
    public CellEditorRenderer_1(Application application) {
    	renderer = new RSDetail_1(application);
    	editor = new RSDetail_1(application);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderer.setCaract((Caract_1) value);
        return renderer;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editor.setCaract((Caract_1) value);
    	editor.getBtnNewButton_2().setVisible(true);
    	editor.getBtnNewButton_1().setVisible(true);
    	editor.setBackground(Color.ORANGE);
        return editor;
    }

    @Override
    public Object getCellEditorValue() {
        return editor.getCaract();
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return false;
    }
}


class TableModel_1 extends DefaultTableModel {

    private static final long serialVersionUID = 1L;

    @Override
    public int getColumnCount() {
        return 1;
    }

    public void addRows(Vector<RSDetail_1> listeMots) {
    	for(int i = 0; i < listeMots.size(); i++) {
    		super.addRow(new Object[]{new Caract_1(listeMots.get(i).getIdHeadword(), listeMots.get(i).getLblMots().getText())});
    	}
        //super.fireTableDataChanged();
    }
}