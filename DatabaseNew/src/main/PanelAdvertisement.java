package main;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelAdvertisement extends JPanel {
	private JLabel lblMonth, lblSizeField, lblPriceField;
	private int index;

	/**
	 * Create the panel.
	 */
	public PanelAdvertisement() {
		setLayout(new MigLayout("", "[][]", "[][][]"));

		lblMonth = new JLabel("Month");
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

	}

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
			Business currentBusiness = DataHandler.businessList.get(DataHandler.currentBusiness);
			Advertisement ad = currentBusiness.getAdvertisements().get(index);

			String size = Integer.toString(ad.getSize());
			String price = Integer.toString(ad.getPrice());
			
			lblSizeField.setText(size);
			lblPriceField.setText(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
