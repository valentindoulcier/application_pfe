package renderers;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import org.apache.log4j.Logger;

import ui.objects.*;

/**
 * @author Valentin
 *
 */
public class MotsRenderer_2 extends JPanel implements ListSelectionListener, MouseListener {

	private static final long serialVersionUID = -3594983798608599109L;
	
	//private static Logger logger = Logger.getLogger(MotsRenderer_2.class);

	public static JList maListe;
	public JScrollPane scrollPane;
	public Vector<RSDetail_2> listeItems;

	public MotsRenderer_2(Vector<RSDetail_2> listeMots)
	{
		super(new BorderLayout());

		listeItems = listeMots;

		maListe = new JList(listeItems);
		maListe.setSelectedIndex(0);

		JListMotsRenderer renderer = new JListMotsRenderer();
		maListe.setCellRenderer(renderer);
		maListe.addMouseListener(this);

		maListe.addListSelectionListener(this);

		scrollPane = new JScrollPane(maListe);

		add(scrollPane, BorderLayout.CENTER);

	}

	public void valueChanged(ListSelectionEvent e) 
	{
		;
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}