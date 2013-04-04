package sections.bddictionnairique.objects;

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

import sections.bddictionnairique.Bddictionnairique;
import sections.bddictionnairique.renderers.Caract_1;

import java.awt.Font;

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

	private JButton btnEditer;
	private JButton btnMasquer;

	public RSDetail_1(final Application application) {

		//setPreferredSize(new Dimension(540, 30));

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 20, 232, 30, 30, 0, 0};
		gridBagLayout.rowHeights = new int[]{5, 20, 5, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblMots = new JLabel("Mot");
		lblMots.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblMots, gbc_lblNewLabel);

		btnEditer = new JButton("Editer");
		btnEditer.setVisible(false);
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.gridheight = 3;
		gbc_btnEditer.anchor = GridBagConstraints.EAST;
		gbc_btnEditer.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditer.gridx = 4;
		gbc_btnEditer.gridy = 0;
		add(btnEditer, gbc_btnEditer);

		btnMasquer = new JButton("Masquer");
		btnMasquer.setVisible(false);
		GridBagConstraints gbc_btnMasquer = new GridBagConstraints();
		gbc_btnMasquer.gridheight = 3;
		gbc_btnMasquer.insets = new Insets(0, 0, 5, 0);
		gbc_btnMasquer.anchor = GridBagConstraints.EAST;
		gbc_btnMasquer.gridx = 5;
		gbc_btnMasquer.gridy = 0;
		add(btnMasquer, gbc_btnMasquer);


		btnEditer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Bddictionnairique.getInstance(application).ouvrirOnglet(4);
				//Bddictionnairique.getInstance(application).getContentEdition().setHeadword(headword);
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
