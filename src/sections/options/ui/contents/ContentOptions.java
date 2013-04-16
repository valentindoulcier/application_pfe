/**
 * 
 */
package sections.options.ui.contents;

import java.awt.CardLayout;

import javax.swing.JPanel;

import sections.options.objects.ConfigPanel;
import sections.options.objects.SqlPanel;

/**
 * @author Valentin DOULCIER
 *
 */
public class ContentOptions extends JPanel {

	private static final long serialVersionUID = -2416705147969574300L;
	
	private CardLayout cardLayout;
	
	private ConfigPanel configPanel;
	private SqlPanel sqlPanel;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentOptions() {

		initComponents();
		
	}
	
	public void initComponents() {
		cardLayout = new CardLayout(0, 0);
		
		this.setLayout(cardLayout);
		
		configPanel = new ConfigPanel();
		sqlPanel = new SqlPanel();
		
		this.add(configPanel, "configPanel");
		this.add(sqlPanel, "sqlPanel");
	}

	/**
	 * @return the cardLayout
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/**
	 * @param cardLayout the cardLayout to set
	 */
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	/**
	 * @return the configPanel
	 */
	public ConfigPanel getConfigPanel() {
		return configPanel;
	}

	/**
	 * @param configPanel the configPanel to set
	 */
	public void setConfigPanel(ConfigPanel configPanel) {
		this.configPanel = configPanel;
	}

	/**
	 * @return the sqlPanel
	 */
	public SqlPanel getSqlPanel() {
		return sqlPanel;
	}

	/**
	 * @param sqlPanel the sqlPanel to set
	 */
	public void setSqlPanel(SqlPanel sqlPanel) {
		this.sqlPanel = sqlPanel;
	}

}
