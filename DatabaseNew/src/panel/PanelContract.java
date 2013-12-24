package panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelContract extends JPanel {

	private Image image;

	/**
	 * Create the panel.
	 */
	public PanelContract(Image i) {
		image = i;
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.drawImage(image, 0, 0, null);
	}

}
