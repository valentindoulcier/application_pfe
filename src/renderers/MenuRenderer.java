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
public class MenuRenderer extends JPanel implements ListSelectionListener, MouseListener {

	private static final long serialVersionUID = -6082325203843158487L;
	
	//private static Logger logger = Logger.getLogger(MenuRenderer.class);

	public static JList maListe;
	public JScrollPane scrollPane;
	public Vector<RSMenuListe> listeItems;

	public MenuRenderer(Vector<RSMenuListe> listeMots)
	{
		super(new BorderLayout());

		listeItems = listeMots;

		maListe = new JList(listeItems);
		maListe.setSelectedIndex(0);

		JListMenuRenderer renderer = new JListMenuRenderer();
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
		((RSMenuListe)maListe.getSelectedValue()).mousePressed(arg0);
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
	
	
	
	

	/**
	 * @return the maListe
	 */
	public static JList getMaListe() {
		return maListe;
	}

	/**
	 * @param maListe the maListe to set
	 */
	public static void setMaListe(JList maListe) {
		MenuRenderer.maListe = maListe;
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @param scrollPane the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	/**
	 * @return the listeItems
	 */
	public Vector<RSMenuListe> getListeItems() {
		return listeItems;
	}

	/**
	 * @param listeItems the listeItems to set
	 */
	public void setListeItems(Vector<RSMenuListe> listeItems) {
		this.listeItems = listeItems;
	}
}