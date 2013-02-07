package ui.objects;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import renderers.Caract_2;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */

public class RSDetail_2 extends JPanel {

	private static final long serialVersionUID = 8933677136466352896L;
	
	private int idHeadword;

	private GridBagLayout gridBagLayout;

	private JLabel lblMots;

	private JButton btnNewButton_2;
	private JButton btnNewButton_1;

	public RSDetail_2() {

		//setPreferredSize(new Dimension(438, 45));

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 232, 30, 30, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblMots = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblMots, gbc_lblNewLabel);

		btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.setVisible(false);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton_1.gridheight = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 0;
		add(btnNewButton_1, gbc_btnNewButton_1);

		btnNewButton_2 = new JButton("Je suis");
		btnNewButton_2.setVisible(false);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton_2.gridheight = 2;
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 0;
		add(btnNewButton_2, gbc_btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

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
				System.out.println("Je suis : " + idHeadword);
			}
		});

	}


	public void setCaract(Caract_2 caract) {
		idHeadword = caract.idHeadword;
		lblMots.setText(caract.mot);
	}

	public Caract_2 getCaract() {
		return new Caract_2(idHeadword, lblMots.getText());
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
public class RSDetail_2 extends JPanel {

	private static final long serialVersionUID = -3287414739952994994L;

	//private static Logger logger = Logger.getLogger(RSDetail_2.class);

	private JLabel lblMot;
	private JLabel lblDescription;
	private JButton btnNewButton;

	/**
 * Create the panel.
 */
/*
	public RSDetail_2() {
		setLayout(null);

		setPreferredSize(new Dimension(400, 60));

		lblMot = new JLabel("New label");
		lblMot.setBounds(6, 6, 388, 16);
		add(lblMot);

		lblDescription = new JLabel("New label");
		lblDescription.setBounds(45, 25, 349, 16);
		add(lblDescription);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(277, 20, 117, 29);
		add(btnNewButton);

		/*
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Je marche !!");

			}
		});
 */
/*
		btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, (Component) e.getSource());
                int row = table.getEditingRow();
                table.getCellEditor().stopCellEditing();
                ((DefaultTableModel) table.getModel()).removeRow(row);
            }
        });

	}

	/**
 * @return the lblMot
 *//*
	public JLabel getLblMot() {
		return lblMot;
	}

	/**
  * @param lblMot the lblMot to set
  *//*
	public void setLblMot(JLabel lblMot) {
		this.lblMot = lblMot;
	}

	/**
   * @return the lblDescription
   *//*
	public JLabel getLblDescription() {
		return lblDescription;
	}

	/**
    * @param lblDescription the lblDescription to set
    *//*
	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}
}
     */
