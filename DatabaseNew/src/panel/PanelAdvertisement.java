package panel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Advertisement;
import main.Business;
import main.DataHandler;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelAdvertisement extends JPanel {
	private JLabel lblMonth, lblSizeField, lblPriceField;
	private int index;

	/**
	 * Create the panel.
	 */
	public PanelAdvertisement(int i) {
		index = i;

		setLayout(new MigLayout("", "[][]", "[][][]"));

		String month = Advertisement.MONTHS[i];
		lblMonth = new JLabel(month);
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblMonth, "cell 0 0 2 1,alignx center");

		JLabel lblSize = new JLabel("Size: ");
		add(lblSize, "cell 0 1");

		lblSizeField = new JLabel("size field");
		add(lblSizeField, "cell 1 1");

		JLabel lblPrice = new JLabel("Price: ");
		add(lblPrice, "cell 0 2");

		lblPriceField = new JLabel("price field");
		add(lblPriceField, "cell 1 2");

		update();
	}

	public void update() {
		try {
			Business currentBusiness = DataHandler.getCurrentBusiness();

			if (!currentBusiness.getAdvertisements().isEmpty()) {
				Advertisement panelAd = null;

				for (Advertisement ad : currentBusiness.getAdvertisements()) {
					if (ad.getDate() == index) {
						panelAd = ad;
					}
				}

				if (panelAd != null) {
					lblSizeField
							.setText(Advertisement.SIZES[panelAd.getSize()]);
					lblPriceField.setText(Advertisement.PRICES[panelAd
							.getPrice()]);
				} else {
					lblSizeField.setText("--");
					lblPriceField.setText("--");
				}
			} else {
				lblSizeField.setText("--");
				lblPriceField.setText("--");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
