package ui.objects;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import renderers.*;
import ui.mainframes.LayerApplication;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */

public class RSDetail_1 extends JPanel {

	private static final long serialVersionUID = -1857283576377080842L;
	
	private int idHeadword;

	private GridBagLayout gridBagLayout;
	
	private JLabel lblMots;

	private JButton btnNewButton_2;
	private JButton btnNewButton_1;

	public RSDetail_1(final LayerApplication layerApplication) {

		//setPreferredSize(new Dimension(540, 30));

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 232, 30, 30, 0, 0};
		gridBagLayout.rowHeights = new int[]{5, 20, 5, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblMots = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblMots, gbc_lblNewLabel);

		btnNewButton_1 = new JButton("Supprime");
		btnNewButton_1.setVisible(false);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 3;
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 0;
		add(btnNewButton_1, gbc_btnNewButton_1);

		btnNewButton_2 = new JButton("Je suis");
		btnNewButton_2.setVisible(false);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridheight = 3;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 0;
		add(btnNewButton_2, gbc_btnNewButton_2);

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, (Component) e.getSource());
				int row = table.getEditingRow();
				table.getCellEditor().stopCellEditing();
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layerApplication.getCardLayoutContent().show(layerApplication.getPanelContent(), "AppliContentEditionMot");
				layerApplication.getAppliContentEditionMot().getVolet_1().getTextField().setText(String.valueOf(idHeadword));
				//System.out.println("Je suis : " + idHeadword);
			}
		});

	}
	

	/**
	 * @return the idHeadword
	 */
	public int getIdHeadword() {
		return idHeadword;
	}


	/**
	 * @param idHeadword the idHeadword to set
	 */
	public void setIdHeadword(int idHeadword) {
		this.idHeadword = idHeadword;
	}


	public void setCaract(Caract_1 caract) {
		idHeadword = caract.idHeadword;
        lblMots.setText(caract.mot);
    }
	
	public Caract_1 getCaract() {
        return new Caract_1(idHeadword, lblMots.getText());
    }

	/**
	 * @return the gridBagLayout
	 */
	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	/**
	 * @param gridBagLayout the gridBagLayout to set
	 */
	public void setGridBagLayout(GridBagLayout gridBagLayout) {
		this.gridBagLayout = gridBagLayout;
	}

	/**
	 * @return the btnNewButton_2
	 */
	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

	/**
	 * @param btnNewButton_2 the btnNewButton_2 to set
	 */
	public void setBtnNewButton_2(JButton btnNewButton_2) {
		this.btnNewButton_2 = btnNewButton_2;
	}

	/**
	 * @return the btnNewButton_1
	 */
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	/**
	 * @param btnNewButton_1 the btnNewButton_1 to set
	 */
	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	/**
	 * @return the lblMots
	 */
	public JLabel getLblMots() {
		return lblMots;
	}

	/**
	 * @param lblMots the lblMots to set
	 */
	public void setLblMots(JLabel lblMots) {
		this.lblMots = lblMots;
	}
}






/*
public class RSDetail_1 extends JPanel {

	private static final long serialVersionUID = -3876783685613141646L;
	
	//private static Logger logger = Logger.getLogger(RSDetail_1.class);
	
	private JLabel lblMot;

	/**
	 * Create the panel.
	 */
/*
	public RSDetail_1() {
		setLayout(null);
		setPreferredSize(new Dimension(400, 25));
		
		initComponents();
	}
	
	public void initComponents() {
		lblMot = new JLabel("Mot");
		lblMot.setBounds(6, 6, 116, 13);
		add(lblMot);
	}

	/**
	 * @return the lblMot
	 */
/*
	public JLabel getLblMot() {
		return lblMot;
	}

	/**
	 * @param lblMot the lblMot to set
	 */
/*
	public void setLblMot(JLabel lblMot) {
		this.lblMot = lblMot;
	}
}
*/
