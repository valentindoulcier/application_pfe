/**
 * 
 */
package sections.updateBDD.ui.volets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import principal.Application;
import sections.updateBDD.objects.UpdateCell;
import sections.updateBDD.renderers.UpdateRenderer;


/**
 * @author Valentin DOULCIER
 *
 */
public class VoletUpdate extends JPanel {

	private static final long serialVersionUID = 9200931919131551743L;

	private GridBagLayout gridBagLayout;
	
	private GridBagConstraints gbc_panel;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletUpdate(Application application) {

		initComponents(application);

	}

	public void initComponents(Application application) {
		setPreferredSize(new Dimension(300, 540));
		setBackground(Color.GRAY);

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
	}

	public void chargerHistorique(Application application) {

		Vector<UpdateCell> listeFichiers = new Vector<UpdateCell>();
		ArrayList<String> tables = getTablesReference();

		UpdateCell updateCell;

		for(String table : tables) {
			updateCell = new UpdateCell(application);
			updateCell.setNomTable(table);
			listeFichiers.add(0, updateCell);//addElement(historiqueCell);
		}		

		JPanel historiqueRenderer = new UpdateRenderer(application, listeFichiers);
		historiqueRenderer.setBackground(Color.GRAY);
		add(historiqueRenderer, gbc_panel);

		revalidate();
	}
	
	public ArrayList<String> getTablesReference() {
		ArrayList<String> listeTablesReferences = new ArrayList<String>();
		
		SAXReader reader =  new SAXReader();
		reader.setEncoding("UTF-8");

		Document doc;
		try {
			doc = reader.read(new File("src/hibernateLocal.reveng.xml"));
			Element root = doc.getRootElement();
			for (Iterator<?> i = root.elementIterator(); i.hasNext(); ) {
				Element itemObject = (Element) i.next();
				if (itemObject.getName().equals("table-filter")) {
					listeTablesReferences.add(itemObject.attribute("match-name").getText());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return listeTablesReferences;
	}

	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	public void setGridBagLayout(GridBagLayout gridBagLayout) {
		this.gridBagLayout = gridBagLayout;
	}

	public GridBagConstraints getGbc_panel() {
		return gbc_panel;
	}

	public void setGbc_panel(GridBagConstraints gbc_panel) {
		this.gbc_panel = gbc_panel;
	}
}
