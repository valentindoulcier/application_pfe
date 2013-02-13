/**
 * 
 */
package ui.objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

/**
 * @author Valentin
 *
 */
public class ActionPanel extends JPanel {

private static final long serialVersionUID = -2211953654486892627L;
	
	//private static Logger logger = Logger.getLogger(ActionPanel.class);

	private int nb;
	private String text;
	private Font font;
	private boolean selected;
	private BufferedImage open;
	private BufferedImage closed;
	private Rectangle target;
	final int
			OFFSET = 30,
			PAD    =  5;

	public ActionPanel(String text, int nb, MouseListener ml)
	{
		this.setNb(nb);
		this.text = text;
		this.addMouseListener(ml);
		this.font = new Font("sans-serif", Font.PLAIN, 12);
		this.selected = false;
		this.setBackground(new Color(122,197,255));
		this.setPreferredSize(new Dimension(200,20));
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.setPreferredSize(new Dimension(200,20));
		createImages();
		this.setRequestFocusEnabled(true);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 40, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("(" + String.valueOf(nb) + ")");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
	}

	public void toggleSelection()
	{
		selected = !selected;
		repaint();
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//int w = getWidth();
		int h = getHeight();
		
		if(selected) {
			g2.drawImage(open, PAD, 0, this);
		}
		else {
			g2.drawImage(closed, PAD, 0, this);
		}
			
		g2.setFont(font);
		FontRenderContext frc = g2.getFontRenderContext();
		LineMetrics lm = font.getLineMetrics(text, frc);
		float height = lm.getAscent() + lm.getDescent();
		float x = OFFSET;
		float y = (h + height)/2 - lm.getDescent();
		g2.drawString(text, x, y);
	}

	private void createImages()
	{
		int w = 16;
		int h = getPreferredSize().height;
		setTarget(new Rectangle(2, 0, 20, 18));
		Graphics2D g2;


		open = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		g2 = open.createGraphics();
		g2.setPaint(getBackground());
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.fillRect(0,0,w,h);
		int[] x = { 2, w/2, 14 };
		int[] y = { 4, 13,   4 };
		Polygon p = new Polygon(x, y, 3);
		g2.setPaint(new Color(204, 204, 204));
		g2.fill(p);
		g2.draw(p);
		g2.dispose();


		closed = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		g2 = closed.createGraphics();
		g2.setPaint(getBackground());
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.fillRect(0,0,w,h);
		x = new int[] { 3, 13,   3 };
		y = new int[] { 4, h/2, 16 };
		p = new Polygon(x, y, 3);
		g2.setPaint(new Color(102, 102, 102));
		g2.fill(p);
		g2.draw(p);
		g2.dispose();
	}

	public Rectangle getTarget() {
		return target;
	}

	public void setTarget(Rectangle target) {
		this.target = target;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

}
