/**
 * 
 */
package sections.synchronisation.ui.volets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sections.synchronisation.Synchronisation;

/**
 * @author Valentin DOULCIER
 *
 */
public class VoletSynchronisation extends JPanel {

	private static final long serialVersionUID = 5602083805686564474L;
	
	private JPanel panelPull;
	private JPanel panelPush;
	private JPanel panelReset;
	
	private JLabel lblPulltitre;
	private JLabel lblPushtitre;
	private JLabel lblResettitre;
	private JLabel lblPulldescriptionrow;
	private JLabel lblPulldescriptionrow_1;
	private JLabel lblPushdescriptionrow;
	private JLabel lblPushdescriptionrow_1;
	private JLabel lblResetdescriptionrow;
	private JLabel lblResetdescriptionrow_1;
	

	/**
	 * Create the panel.
	 */
	public VoletSynchronisation() {
		
		initComponents();
		
		panelPull.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				panelPull.setBackground(new Color(204, 153, 255));
				panelPull.setBorder(new LineBorder(new Color(178, 102, 255), 3, true));
				
				panelPush.setBackground(new Color(238, 238, 238));
				panelPush.setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
				
				panelReset.setBackground(new Color(255, 153, 153));
				panelReset.setBorder(new LineBorder(new Color(255, 102, 102), 2, true));
				
				Synchronisation.getContentSynchronisation().getCardLayout().show(Synchronisation.getContentSynchronisation(), "pullPanel");
			}
		});
		
		panelPush.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				panelPull.setBackground(new Color(238, 238, 238));
				panelPull.setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
				
				panelPush.setBackground(new Color(204, 153, 255));
				panelPush.setBorder(new LineBorder(new Color(178, 102, 255), 3, true));
				
				panelReset.setBackground(new Color(255, 153, 153));
				panelReset.setBorder(new LineBorder(new Color(255, 102, 102), 2, true));
				
				Synchronisation.getContentSynchronisation().getCardLayout().show(Synchronisation.getContentSynchronisation(), "pushPanel");
			}
		});
		
		panelReset.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				panelPull.setBackground(new Color(238, 238, 238));
				panelPull.setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
				
				panelPush.setBackground(new Color(238, 238, 238));
				panelPush.setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
				
				panelReset.setBackground(new Color(255, 102, 102));
				panelReset.setBorder(new LineBorder(Color.RED, 3, true));

				Synchronisation.getContentSynchronisation().getCardLayout().show(Synchronisation.getContentSynchronisation(), "resetPanel");
			}
		});

	}
	
	public void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(414, 696)); 
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		
		
		
		panelPull = new JPanel();
		panelPull.setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
		GridBagConstraints gbc_panelPull = new GridBagConstraints();
		gbc_panelPull.insets = new Insets(0, 0, 5, 0);
		gbc_panelPull.fill = GridBagConstraints.BOTH;
		gbc_panelPull.gridx = 0;
		gbc_panelPull.gridy = 0;
		add(panelPull, gbc_panelPull);
		GridBagLayout gbl_panelPull = new GridBagLayout();
		gbl_panelPull.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panelPull.rowHeights = new int[]{20, 0, 20, 0, 0, 20, 20, 0};
		gbl_panelPull.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelPull.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelPull.setLayout(gbl_panelPull);
		
		lblPulltitre = new JLabel("PULL");
		lblPulltitre.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GridBagConstraints gbc_lblPulltitre = new GridBagConstraints();
		gbc_lblPulltitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblPulltitre.gridx = 1;
		gbc_lblPulltitre.gridy = 1;
		panelPull.add(lblPulltitre, gbc_lblPulltitre);
		
		lblPulldescriptionrow = new JLabel("Récupérer la dernière version");
		GridBagConstraints gbc_lblPulldescriptionrow = new GridBagConstraints();
		gbc_lblPulldescriptionrow.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPulldescriptionrow.insets = new Insets(0, 0, 5, 5);
		gbc_lblPulldescriptionrow.gridx = 1;
		gbc_lblPulldescriptionrow.gridy = 3;
		panelPull.add(lblPulldescriptionrow, gbc_lblPulldescriptionrow);
		
		lblPulldescriptionrow_1 = new JLabel("de la base de données");
		GridBagConstraints gbc_lblPulldescriptionrow_1 = new GridBagConstraints();
		gbc_lblPulldescriptionrow_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPulldescriptionrow_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPulldescriptionrow_1.gridx = 1;
		gbc_lblPulldescriptionrow_1.gridy = 4;
		panelPull.add(lblPulldescriptionrow_1, gbc_lblPulldescriptionrow_1);
		
		
		
		
		
		
		
		panelPush = new JPanel();
		panelPush.setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
		GridBagConstraints gbc_panelPush = new GridBagConstraints();
		gbc_panelPush.insets = new Insets(0, 0, 5, 0);
		gbc_panelPush.fill = GridBagConstraints.BOTH;
		gbc_panelPush.gridx = 0;
		gbc_panelPush.gridy = 1;
		add(panelPush, gbc_panelPush);
		GridBagLayout gbl_panelPush = new GridBagLayout();
		gbl_panelPush.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panelPush.rowHeights = new int[]{20, 0, 20, 0, 0, 0, 20, 0};
		gbl_panelPush.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelPush.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelPush.setLayout(gbl_panelPush);
		
		lblPushtitre = new JLabel("PUSH");
		lblPushtitre.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GridBagConstraints gbc_lblPushtitre = new GridBagConstraints();
		gbc_lblPushtitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblPushtitre.gridx = 1;
		gbc_lblPushtitre.gridy = 1;
		panelPush.add(lblPushtitre, gbc_lblPushtitre);
		
		lblPushdescriptionrow = new JLabel("Envoyer les modifications sur la");
		GridBagConstraints gbc_lblPushdescriptionrow = new GridBagConstraints();
		gbc_lblPushdescriptionrow.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPushdescriptionrow.insets = new Insets(0, 0, 5, 5);
		gbc_lblPushdescriptionrow.gridx = 1;
		gbc_lblPushdescriptionrow.gridy = 3;
		panelPush.add(lblPushdescriptionrow, gbc_lblPushdescriptionrow);
		
		lblPushdescriptionrow_1 = new JLabel("base de données principale");
		GridBagConstraints gbc_lblPushdescriptionrow_1 = new GridBagConstraints();
		gbc_lblPushdescriptionrow_1.gridheight = 2;
		gbc_lblPushdescriptionrow_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPushdescriptionrow_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPushdescriptionrow_1.gridx = 1;
		gbc_lblPushdescriptionrow_1.gridy = 4;
		panelPush.add(lblPushdescriptionrow_1, gbc_lblPushdescriptionrow_1);
		
		
		
		
		
		
		
		panelReset = new JPanel();
		panelReset.setBackground(new Color(255, 153, 153));
		panelReset.setBorder(new LineBorder(new Color(255, 102, 102), 2, true));
		GridBagConstraints gbc_panelReset = new GridBagConstraints();
		gbc_panelReset.fill = GridBagConstraints.BOTH;
		gbc_panelReset.gridx = 0;
		gbc_panelReset.gridy = 2;
		add(panelReset, gbc_panelReset);
		GridBagLayout gbl_panelReset = new GridBagLayout();
		gbl_panelReset.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panelReset.rowHeights = new int[]{20, 0, 20, 0, 0, 0, 20, 0};
		gbl_panelReset.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelReset.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelReset.setLayout(gbl_panelReset);
		
		lblResettitre = new JLabel("RESET");
		lblResettitre.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GridBagConstraints gbc_lblResettitre = new GridBagConstraints();
		gbc_lblResettitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblResettitre.gridx = 1;
		gbc_lblResettitre.gridy = 1;
		panelReset.add(lblResettitre, gbc_lblResettitre);
		
		lblResetdescriptionrow = new JLabel("Réinitialiser la base de données");
		GridBagConstraints gbc_lblResetdescriptionrow = new GridBagConstraints();
		gbc_lblResetdescriptionrow.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblResetdescriptionrow.insets = new Insets(0, 0, 5, 5);
		gbc_lblResetdescriptionrow.gridx = 1;
		gbc_lblResetdescriptionrow.gridy = 3;
		panelReset.add(lblResetdescriptionrow, gbc_lblResetdescriptionrow);
		
		lblResetdescriptionrow_1 = new JLabel("de l'application");
		GridBagConstraints gbc_lblResetdescriptionrow_1 = new GridBagConstraints();
		gbc_lblResetdescriptionrow_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblResetdescriptionrow_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblResetdescriptionrow_1.gridx = 1;
		gbc_lblResetdescriptionrow_1.gridy = 4;
		panelReset.add(lblResetdescriptionrow_1, gbc_lblResetdescriptionrow_1);
	}

}
