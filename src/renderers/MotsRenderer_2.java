package renderers;

import java.awt.Color;
import java.awt.Component;
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

import ui.objects.*;

/**
 * @author Valentin
 *
 */
public class MotsRenderer_2 extends JPanel {

	private static final long serialVersionUID = -7278560233653998493L;

	private TableModel_2 compModel = null;


	public MotsRenderer_2(Vector<RSDetail_2> listeMots) {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane compTableScrollpane = new JScrollPane(CreateCompTable(listeMots), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(compTableScrollpane, gbc_scrollPane);
	}

	public JTable CreateCompTable(Vector<RSDetail_2> listeMots) {

		compModel = new TableModel_2();

		System.out.println("TAILLE 1 : " + listeMots.size());

		compModel.addRows(listeMots);

		JTable table = new JTable(compModel);
		table.setRowHeight(60);
		table.setTableHeader(null);
		CellEditorRenderer_2 cellEditorRenderer = new CellEditorRenderer_2();
		table.setDefaultRenderer(Object.class, cellEditorRenderer);
		table.setDefaultEditor(Object.class, cellEditorRenderer);
		return table;
	}

}



class CellEditorRenderer_2 extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private static final long serialVersionUID = -1167972153205157391L;

	private RSDetail_2 renderer = new RSDetail_2();
    private RSDetail_2 editor = new RSDetail_2();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderer.setCaract((Caract_2) value);
        return renderer;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editor.setCaract((Caract_2) value);
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


class TableModel_2 extends DefaultTableModel {

    private static final long serialVersionUID = 1L;

    @Override
    public int getColumnCount() {
        return 1;
    }

    public void addRows(Vector<RSDetail_2> listeMots) {
    	for(int i = 0; i < listeMots.size(); i++) {
    		super.addRow(new Object[]{new Caract_2(listeMots.get(i).getIdHeadword(), listeMots.get(i).getLblMots().getText())});
    	}
        //super.fireTableDataChanged();
    }
}