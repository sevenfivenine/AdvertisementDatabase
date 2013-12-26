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
	public PanelContract() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (image != null) {
			g.drawImage(
					image.getScaledInstance(this.getWidth() - 2,
							this.getHeight() - 2, Image.SCALE_SMOOTH), 1, 1,
					null);
		}
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
