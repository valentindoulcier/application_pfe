package sections.updateBDD.renderers;

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

import principal.Application;
import sections.updateBDD.objects.UpdateCell;

/**
 * @author Valentin DOULCIER
 *
 */
public class UpdateRenderer extends JPanel {

	private static final long serialVersionUID = -7278560233653998493L;

	private TableModel compModel = null;

	public UpdateRenderer(Application application, Vector<UpdateCell> listeFichiers) {
		
		//this.setMinimumSize(application.getContentHome().getVoletFooterRecherche().getVoletHistorique().getPreferredSize().getSize());
		//this.setBackground(Color.GRAY);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane compTableScrollpane = new JScrollPane(CreateCompTable(application, listeFichiers), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(compTableScrollpane, gbc_scrollPane);
	}

	public JTable CreateCompTable(Application application, Vector<UpdateCell> listeFichiers) {

		compModel = new TableModel();

		compModel.addRows(listeFichiers);

		JTable table = new JTable(compModel);
		table.setRowHeight(50);
		table.setTableHeader(null);
		CellEditorRenderer cellEditorRenderer = new CellEditorRenderer(application);
		table.setDefaultRenderer(Object.class, cellEditorRenderer);
		table.setDefaultEditor(Object.class, cellEditorRenderer);
		return table;
	}

}



class CellEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private static final long serialVersionUID = -1167972153205157391L;

	private UpdateCell renderer;
    private UpdateCell editor;
    
    @SuppressWarnings("unused")
	private Application application;
 
	public CellEditorRenderer(Application application) {
		renderer = new UpdateCell(application);
		editor = new UpdateCell(application);
		
		this.application = application;
	}
	
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderer.setCaract((Caract_Update) value);
        return renderer;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editor.setCaract((Caract_Update) value);
    	editor.setBackground(new Color(165, 207, 255));
    	//
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


class TableModel extends DefaultTableModel {

    private static final long serialVersionUID = 1L;

    @Override
    public int getColumnCount() {
        return 1;
    }

    public void addRows(Vector<UpdateCell> listeFichiers) {
    	for(int i = 0; i < listeFichiers.size(); i++) {
    		super.addRow(new Object[]{new Caract_Update(listeFichiers.get(i).getNomTable())});
    	}
    }
}