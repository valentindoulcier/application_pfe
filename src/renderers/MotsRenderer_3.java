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
public class MotsRenderer_3 extends JPanel {

	private static final long serialVersionUID = -7278560233653998493L;

	private TableModel_3 compModel = null;


	public MotsRenderer_3(Application application, Vector<RSDetail_3> listeMots) {
		
		if(listeMots.size() > 0) {
			if(110*listeMots.size()+5 > 300) {
				this.setPreferredSize(new Dimension(0, 300));
			}
			else {
				this.setPreferredSize(new Dimension(0, 110*listeMots.size()+5));
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
		setLayout(gridBagLayout);
		
		JScrollPane compTableScrollpane = new JScrollPane(CreateCompTable(application, listeMots), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(compTableScrollpane, gbc_scrollPane);
		
	}

	public JTable CreateCompTable(Application application, Vector<RSDetail_3> listeMots) {

		compModel = new TableModel_3();

		compModel.addRows(listeMots);

		JTable table = new JTable(compModel);
		table.setRowHeight(110);
		table.setTableHeader(null);
		CellEditorRenderer_3 cellEditorRenderer = new CellEditorRenderer_3(application);
		table.setDefaultRenderer(Object.class, cellEditorRenderer);
		table.setDefaultEditor(Object.class, cellEditorRenderer);
		return table;
	}

}



class CellEditorRenderer_3 extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private static final long serialVersionUID = -1167972153205157391L;

	private RSDetail_3 renderer;
    private RSDetail_3 editor;
    
    public CellEditorRenderer_3(Application application) {
    	renderer = new RSDetail_3(application);
    	editor = new RSDetail_3(application);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderer.setCaract((Caract_3) value);
        return renderer;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editor.setCaract((Caract_3) value);
    	editor.getBtnEditer().setVisible(true);
    	editor.getBtnMasquer().setVisible(true);
    	editor.setBackground(new Color(204, 255, 229));
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


class TableModel_3 extends DefaultTableModel {

    private static final long serialVersionUID = 1L;

	@Override
    public int getColumnCount() {
        return 1;
    }

    public void addRows(Vector<RSDetail_3> listeMots) {
    	for(int i = 0; i < listeMots.size(); i++) {
    		super.addRow(new Object[]{new Caract_3(listeMots.get(i).getIdHeadword(), listeMots.get(i).getLblMots().getText(), listeMots.get(i).getLblCategories().getText(), listeMots.get(i).getLblRegion().getText(), listeMots.get(i).getLblSchema().getText(), listeMots.get(i).getLblType().getText(), listeMots.get(i).getLblSyllabes().getText())});
    	}
        //super.fireTableDataChanged();
    }
}