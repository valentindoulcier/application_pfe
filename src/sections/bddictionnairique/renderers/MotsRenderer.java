package sections.bddictionnairique.renderers;

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

import sections.bddictionnairique.Bddictionnairique;
import sections.bddictionnairique.objects.*;

/**
 * @author Valentin
 *
 */
public class MotsRenderer extends JPanel {
	
	public static final int SIZE_CELL_1 = 30;
	public static final int SIZE_CELL_2 = 90;
	public static final int SIZE_CELL_3 = 110;
	
	public static final int SIZE_VOLET_1 = 250;
	public static final int SIZE_VOLET_2 = 300;
	public static final int SIZE_VOLET_3 = 300;

	private static final long serialVersionUID = -7278560233653998493L;

	private MotsTableModel compModel = null;

	public MotsRenderer(Application application, Vector<MotsCell> listeMots) {
		
		int size_cell = 30;
		int size_volet = 250;
		
		if(Bddictionnairique.getInstance(application).getJeViensDe() == 1 || Bddictionnairique.getInstance(application).getJeViensDe() == 2) {
			if (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getValue() == Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getMinimum()) {
				size_cell = SIZE_CELL_1;
				size_volet = SIZE_VOLET_1;
			}
			else if (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getMaximum())/2) {
				size_cell = SIZE_CELL_2;
				size_volet = SIZE_VOLET_2;			
			}
			else if (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getMaximum())) {
				size_cell = SIZE_CELL_3;
				size_volet = SIZE_VOLET_3;
			}
		}
		else if(Bddictionnairique.getInstance(application).getJeViensDe() == 3) {
			if (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getValue() == Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getMinimum()) {
				size_cell = SIZE_CELL_1;
				size_volet = SIZE_VOLET_1;
			}
			else if (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getMaximum())/2) {
				size_cell = SIZE_CELL_2;
				size_volet = SIZE_VOLET_2;			
			}
			else if (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getMaximum())) {
				size_cell = SIZE_CELL_3;
				size_volet = SIZE_VOLET_3;
			}
		}
		
		
		if(listeMots.size() > 0) {
			if(size_cell * listeMots.size() + 5 > size_volet) {
				this.setPreferredSize(new Dimension(0, size_volet));
			}
			else {
				this.setPreferredSize(new Dimension(0, size_cell * listeMots.size() + 5));
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
		
		JScrollPane compTableScrollpane = new JScrollPane(CreateCompTable(application, listeMots, size_cell), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		this.add(compTableScrollpane, gbc_scrollPane);
	}

	public JTable CreateCompTable(Application application, Vector<MotsCell> listeMots, int size_cell) {

		compModel = new MotsTableModel();

		compModel.addRows(listeMots);

		JTable table = new JTable(compModel);
		table.setRowHeight(size_cell);
		table.setTableHeader(null);
		MotsCellEditorRenderer cellEditorRenderer = new MotsCellEditorRenderer(application);
		table.setDefaultRenderer(Object.class, cellEditorRenderer);
		table.setDefaultEditor(Object.class, cellEditorRenderer);
		return table;
	}

}



class MotsCellEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private static final long serialVersionUID = -1167972153205157391L;

	private MotsCell renderer;
    private MotsCell editor;
    
    public MotsCellEditorRenderer(Application application) {
    	renderer = new MotsCell(application);
    	editor = new MotsCell(application);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderer.setCaract((Caract_Mots) value);
        return renderer;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editor.setCaract((Caract_Mots) value);
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


class MotsTableModel extends DefaultTableModel {

    private static final long serialVersionUID = 1L;

    @Override
    public int getColumnCount() {
        return 1;
    }

    public void addRows(Vector<MotsCell> listeMots) {
    	for(int i = 0; i < listeMots.size(); i++) {
    		super.addRow(new Object[]{new Caract_Mots(listeMots.get(i).getHeadword())});
    	}
        //super.fireTableDataChanged();
    }
}































/*






package sections.bddictionnairique.renderers;

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

import sections.bddictionnairique.Bddictionnairique;
import sections.bddictionnairique.objects.*;

*//**
 * @author Valentin
 *
 *//*
public class MotsRenderer extends JPanel {
	
	public static final int SIZE_CELL_1 = 30;
	public static final int SIZE_CELL_2 = 90;
	public static final int SIZE_CELL_3 = 110;
	
	public static final int SIZE_VOLET_1 = 250;
	public static final int SIZE_VOLET_2 = 300;
	public static final int SIZE_VOLET_3 = 300;

	private static final long serialVersionUID = -7278560233653998493L;

	private MotsTableModel compModel = null;

	public MotsRenderer(Application application, Vector<MotsCell> listeMots) {
		
		int size_cell = 30;
		int size_volet = 250;
		
		if(Bddictionnairique.getInstance(application).getJeViensDe() == 1 || Bddictionnairique.getInstance(application).getJeViensDe() == 2) {
			if (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getValue() == Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getMinimum()) {
				size_cell = SIZE_CELL_1;
				size_volet = SIZE_VOLET_1;
			}
			else if (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getMaximum())/2) {
				size_cell = SIZE_CELL_2;
				size_volet = SIZE_VOLET_2;			
			}
			else if (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getVoletRechercheSimple().getSliderDetails().getMaximum())) {
				size_cell = SIZE_CELL_3;
				size_volet = SIZE_VOLET_3;
			}
		}
		else if(Bddictionnairique.getInstance(application).getJeViensDe() == 3) {
			if (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getValue() == Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getMinimum()) {
				size_cell = SIZE_CELL_1;
				size_volet = SIZE_VOLET_1;
			}
			else if (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getMaximum())/2) {
				size_cell = SIZE_CELL_2;
				size_volet = SIZE_VOLET_2;			
			}
			else if (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getValue() == (Bddictionnairique.getInstance(application).getContentHistorique().getSliderDetails().getMaximum())) {
				size_cell = SIZE_CELL_3;
				size_volet = SIZE_VOLET_3;
			}
		}
		
		
		if(listeMots.size() > 0) {
			if(size_cell * listeMots.size() + 5 > size_volet) {
				this.setPreferredSize(new Dimension(0, size_volet));
			}
			else {
				this.setPreferredSize(new Dimension(0, size_cell * listeMots.size() + 5));
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
		
		JScrollPane compTableScrollpane = new JScrollPane(CreateCompTable(application, listeMots, size_cell), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		this.add(compTableScrollpane, gbc_scrollPane);
	}

	public JTable CreateCompTable(Application application, Vector<MotsCell> listeMots, int size_cell) {

		compModel = new MotsTableModel();

		compModel.addRows(listeMots);

		JTable table = new JTable(compModel);
		table.setRowHeight(size_cell);
		table.setTableHeader(null);
		CellEditorRenderer cellEditorRenderer = new CellEditorRenderer(application);
		table.setDefaultRenderer(Object.class, cellEditorRenderer);
		table.setDefaultEditor(Object.class, cellEditorRenderer);
		return table;
	}

}



class MotsCellEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private static final long serialVersionUID = -1167972153205157391L;

	private MotsCell renderer;
    private MotsCell editor;
    
    public MotsCellEditorRenderer(Application application) {
    	renderer = new MotsCell(application);
    	editor = new MotsCell(application);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderer.setCaract((Caract_Mots) value);
        return renderer;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editor.setCaract((Caract_Mots) value);
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


class MotsTableModel extends DefaultTableModel {

    private static final long serialVersionUID = 1L;

    @Override
    public int getColumnCount() {
        return 1;
    }

    public void addRows(Vector<MotsCell> listeMots) {
    	for(int i = 0; i < listeMots.size(); i++) {
    		super.addRow(new Object[]{new Caract_Mots(listeMots.get(i).getHeadword())});
    	}
        //super.fireTableDataChanged();
    }
}


*/


