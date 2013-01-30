/**
 * 
 */
package ui.mainframes;

import java.awt.Color;

import javax.swing.JPanel;

import principal.Application;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;

/**
 * @author Valentin
 *
 */
public class ConfigSqlEditor extends JPanel {

	private static final long serialVersionUID = -5336871510589064273L;

	private JEditorPane editorPane;
	private JButton btnNewButton;
	private JTable table;
	private JList list;

	/**
	 * Create the panel.
	 */
	public ConfigSqlEditor(final Application application) {
		
		initComponents(application);

	}
	
	
	public void initComponents(final Application application) {
		setBounds(100, 100, 450, 500);

		setBackground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 222, 90, 0};
		gridBagLayout.rowHeights = new int[]{121, 107, 107, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		editorPane = new JEditorPane();
		GridBagConstraints gbc_editorPane = new GridBagConstraints();
		gbc_editorPane.gridwidth = 2;
		gbc_editorPane.insets = new Insets(0, 0, 5, 5);
		gbc_editorPane.fill = GridBagConstraints.BOTH;
		gbc_editorPane.gridx = 0;
		gbc_editorPane.gridy = 0;
		add(editorPane, gbc_editorPane);
		
		btnNewButton = new JButton("Lancer");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(table, gbc_table);
		
		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 3;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		add(list, gbc_list);
	}
}
