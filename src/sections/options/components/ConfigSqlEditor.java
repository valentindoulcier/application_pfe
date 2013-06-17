package sections.options.components;


import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JEditorPane;

//import org.apache.log4j.Logger;

import java.awt.Color;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

/**
 * @author Valentin
 *
 */
public class ConfigSqlEditor extends JPanel {

	private static final long serialVersionUID = -5336871510589064273L;
	
	//private static Logger logger = Logger.getLogger(ConfigSqlEditor.class);

	private JTable tableResult;
	private JList listRequetes;
	private JButton btnLancerRequete;
	private JEditorPane editorPaneRequete;

	/**
	 * Create the panel.
	 */
	public ConfigSqlEditor() {
		
		initComponents();
		
		btnLancerRequete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//String requete = editorPaneRequete.getText();
			}
		});

	}
	
	
	public void initComponents() {
		setBounds(100, 100, 450, 500);

		setBackground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 222, 90, 0};
		gridBagLayout.rowHeights = new int[]{121, 107, 107, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		editorPaneRequete = new JEditorPane();
		GridBagConstraints gbc_editorPaneRequete = new GridBagConstraints();
		gbc_editorPaneRequete.gridwidth = 2;
		gbc_editorPaneRequete.insets = new Insets(0, 0, 5, 5);
		gbc_editorPaneRequete.fill = GridBagConstraints.BOTH;
		gbc_editorPaneRequete.gridx = 0;
		gbc_editorPaneRequete.gridy = 0;
		add(editorPaneRequete, gbc_editorPaneRequete);
		
		btnLancerRequete = new JButton("Lancer");
		GridBagConstraints gbc_btnLancerRequete = new GridBagConstraints();
		gbc_btnLancerRequete.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
		gbc_btnLancerRequete.insets = new Insets(0, 0, 5, 0);
		gbc_btnLancerRequete.gridx = 2;
		gbc_btnLancerRequete.gridy = 0;
		add(btnLancerRequete, gbc_btnLancerRequete);
		
		tableResult = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(tableResult, gbc_table);
		
		listRequetes = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 3;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		add(listRequetes, gbc_list);
	}
}
