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

import principal.Application;

import ui.objects.*;

/**
 * @author Valentin
 *
 */
public class HistoriqueRenderer extends JPanel {

	private static final long serialVersionUID = -7278560233653998493L;

	private TableModel compModel = null;


	public HistoriqueRenderer(Application application, Vector<HistoriqueCell> listeRecherches) {
		
		this.setMinimumSize(application.getContentHome().getVoletFooterRecherche().getVoletHistorique().getPreferredSize().getSize());
		//this.setMinimumSize(new Dimension(300, 540));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane compTableScrollpane = new JScrollPane(CreateCompTable(application, listeRecherches), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		compTableScrollpane.setBackground(Color.PINK);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(compTableScrollpane, gbc_scrollPane);
	}

	public JTable CreateCompTable(Application application, Vector<HistoriqueCell> listeRecherches) {

		compModel = new TableModel();

		System.out.println("TAILLE 1 : " + listeRecherches.size());

		compModel.addRows(listeRecherches);

		JTable table = new JTable(compModel);
		table.setRowHeight(30);
		table.setTableHeader(null);
		CellEditorRenderer cellEditorRenderer = new CellEditorRenderer(application);
		table.setDefaultRenderer(Object.class, cellEditorRenderer);
		table.setDefaultEditor(Object.class, cellEditorRenderer);
		return table;
	}

}



class CellEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private static final long serialVersionUID = -1167972153205157391L;

	private HistoriqueCell renderer;
    private HistoriqueCell editor;
 
	public CellEditorRenderer(Application application) {
		renderer = new HistoriqueCell(application);
		editor = new HistoriqueCell(application);
	}
	
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderer.setCaract((Caract_Historique) value);
        return renderer;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editor.setCaract((Caract_Historique) value);
    	editor.setBackground(new Color(204, 255, 229));
    	System.out.println("Je suis : " + editor.getCaract().mot);
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

    public void addRows(Vector<HistoriqueCell> listeRecherches) {
    	for(int i = 0; i < listeRecherches.size(); i++) {
    		System.out.println("Element : " + i + "\n\tNuméro : " + listeRecherches.get(i).getNumRecherche() + "\n\tNom : " + listeRecherches.get(i).getLblMots().getText());
    		super.addRow(new Object[]{new Caract_Historique(listeRecherches.get(i).getNumRecherche(), listeRecherches.get(i).getLblMots().getText())});
    	}
    	/*new Caract_Historique(listeRecherches.get(i).getNumRecherche(), listeRecherches.get(i).getLblMots().getText())*/
        //super.fireTableDataChanged();
    }
}