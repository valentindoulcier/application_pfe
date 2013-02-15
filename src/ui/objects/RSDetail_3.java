package ui.objects;

import java.awt.Color;
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

import principal.Application;

import renderers.Caract_3;
import java.awt.Font;

//import org.apache.log4j.Logger;

/**
 * @author Valentin
 *
 */


public class RSDetail_3 extends JPanel {

	private static final long serialVersionUID = -4755709089708556283L;
	
	private int idHeadword;

	private GridBagLayout gridBagLayout;

	private JLabel lblMots;
	private JLabel lblCategories;

	private JButton btnEditer;
	private JButton btnMasquer;

	public RSDetail_3(final Application application) {

		initComponents();

		
		btnEditer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				application.getVoletHeader().show(application.getvHeader(), "voletHeaderEdition");
				application.getVoletPanel().show(application.getvPanel(), "voletEdition");
				application.getVoletFooter().show(application.getvFooter(), "voletFooterEdition");
				
				application.getContentHeader().show(application.getcHeader(), "contentHeaderEdition");
				application.getContentPanel().show(application.getcPanel(), "contentEdition");
				application.getContentFooter().show(application.getcFooter(), "contentFooterEdition");
				
				
				//layerApplication.getCardLayoutContent().show(layerApplication.getPanelContent(), "AppliContentEditionMot");
				//layerApplication.getAppliContentEditionMot().getVolet_1().getTextField().setText(String.valueOf(idHeadword));
				//System.out.println("Je suis : " + idHeadword);
			}
		});
		
		btnMasquer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, (Component) e.getSource());
				int row = table.getEditingRow();
				table.getCellEditor().stopCellEditing();
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		});

	}
	
	public void initComponents() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 232, 30, 30, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblMots = new JLabel("Mot");
		lblMots.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblMots, gbc_lblNewLabel);

		
		lblCategories = new JLabel("Catégories");
		lblCategories.setForeground(new Color(50, 205, 50));
		GridBagConstraints gbc_lblCategories = new GridBagConstraints();
		gbc_lblCategories.anchor = GridBagConstraints.WEST;
		gbc_lblCategories.insets = new Insets(0, 0, 0, 5);
		gbc_lblCategories.gridx = 2;
		gbc_lblCategories.gridy = 1;
		add(lblCategories, gbc_lblCategories);

		
		btnEditer = new JButton("Editer");
		btnEditer.setVisible(false);
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnEditer.gridheight = 2;
		gbc_btnEditer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditer.gridx = 4;
		gbc_btnEditer.gridy = 0;
		add(btnEditer, gbc_btnEditer);

		btnMasquer = new JButton("Masquer");
		btnMasquer.setVisible(false);
		GridBagConstraints gbc_btnMasquer = new GridBagConstraints();
		gbc_btnMasquer.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnMasquer.gridheight = 2;
		gbc_btnMasquer.gridx = 5;
		gbc_btnMasquer.gridy = 0;
		add(btnMasquer, gbc_btnMasquer);
	}


	public void setCaract(Caract_3 caract) {
		idHeadword = caract.idHeadword;
		lblMots.setText(caract.mot);
	}

	public Caract_3 getCaract() {
		return new Caract_3(idHeadword, lblMots.getText());
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


	/**
	 * @return the btnEditer
	 */
	public JButton getBtnEditer() {
		return btnEditer;
	}


	/**
	 * @param btnEditer the btnEditer to set
	 */
	public void setBtnEditer(JButton btnEditer) {
		this.btnEditer = btnEditer;
	}


	/**
	 * @return the btnMasquer
	 */
	public JButton getBtnMasquer() {
		return btnMasquer;
	}


	/**
	 * @param btnMasquer the btnMasquer to set
	 */
	public void setBtnMasquer(JButton btnMasquer) {
		this.btnMasquer = btnMasquer;
	}
}


/*
public class RSDetail_3 extends JPanel {

	private static final long serialVersionUID = -5360839512350231888L;

	//private static Logger logger = Logger.getLogger(RSDetail_3.class);

	private JLabel lblMot;
	private JLabel lblNewLabel;

	/**
 * Create the panel.
 *//*
	public RSDetail_3() {
		setLayout(null);

		setPreferredSize(new Dimension(400, 80));

		initComponents();

	}

	public void initComponents() {
		lblMot = new JLabel("New label");
		lblMot.setBounds(6, 6, 388, 16);
		add(lblMot);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(45, 25, 349, 16);
		add(lblNewLabel);
	}

	/**
  * @param e
  *//*
	public void mousePressed(MouseEvent e) {
		setBackground(Color.BLUE);
		System.out.println("Je suis cliqué : " + lblMot.getText());

	}

	/**
   * @param arg0
   *//*
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		setBackground(Color.ORANGE);
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
      * @return the lblNewLabel
      *//*
      public JLabel getLblNewLabel() {
    	  return lblNewLabel;
      }

      /**
       * @param lblNewLabel the lblNewLabel to set
       *//*
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

}
        */
