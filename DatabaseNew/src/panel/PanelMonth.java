package panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.Advertisement;
import main.Business;
import main.DataHandler;
import main.Format;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelMonth extends JPanel {
	private JLabel lblMonthName;
	private JTable mtable;
	private JComboBox<String> mcomboBox;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public PanelMonth() {
		setLayout(new MigLayout("", "[grow]", "[][grow]"));

		lblMonthName = new JLabel("Month Name");
		lblMonthName.setFont(new Font("Tahoma", Font.PLAIN,
				Format.FONT_SIZE_LARGE));
		add(lblMonthName, "flowx,cell 0 0");

		String[] columnNames = { "Business Name", "Size", "Price" };
		Object[][] data = new Object[60][3];

		for (int i = 0; i < DataHandler.businessList.size(); i++) {
			Business currentBusiness = DataHandler.businessList.get(i);
			int currentMonth = DataHandler.currentMonth;

			data[i][0] = currentBusiness.getName();

			if (!currentBusiness.getAdvertisements().isEmpty()) {
				Advertisement currentAd = null;

				for (Advertisement ad : currentBusiness.getAdvertisements()) {
					if (ad.getDate() == currentMonth) {
						currentAd = ad;
					}
				}

				if (currentAd != null) {
					data[i][1] = Advertisement.SIZES[currentAd.getSize()];
					data[i][2] = Advertisement.PRICES[currentAd.getPrice()];
				} else {
					data[i][1] = "";
					data[i][2] = "";
				}
			} else {
				data[i][1] = "";
				data[i][2] = "";
			}
		}

		mtable = new JTable(data, columnNames);

		scrollPane = new JScrollPane(mtable);
		mtable.setFillsViewportHeight(true);

		add(scrollPane, "cell 0 1,grow");

		mcomboBox = new JComboBox<String>();
		mcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				JComboBox cb = (JComboBox) e.getSource();
				int month = cb.getSelectedIndex();
				DataHandler.currentMonth = month;
				update();
			}
		});
		mcomboBox.setModel(new DefaultComboBoxModel<String>(
				Advertisement.MONTHS));
		add(mcomboBox, "cell 0 0");

		update();
	}

	public void update() {
		lblMonthName.setText(Advertisement.MONTHS[DataHandler.currentMonth]);

		String[] columnNames = { "Business Name", "Size", "Price" };
		Object[][] data = new Object[60][3];

		for (int i = 0; i < DataHandler.businessList.size(); i++) {
			Business currentBusiness = DataHandler.businessList.get(i);
			int currentMonth = DataHandler.currentMonth;
			data[i][0] = currentBusiness.getName();

			if (!currentBusiness.getAdvertisements().isEmpty()) {
				Advertisement currentAd = null;

				for (Advertisement ad : currentBusiness.getAdvertisements()) {
					if (ad.getDate() == currentMonth) {
						currentAd = ad;
					}
				}

				if (currentAd != null) {
					mtable.setValueAt(Advertisement.SIZES[currentAd.getSize()],
							i, 1);
					mtable.setValueAt(
							Advertisement.PRICES[currentAd.getPrice()], i, 2);
					// data[i][1] = Advertisement.SIZES[currentAd.getSize()];
					// data[i][2] = Advertisement.PRICES[currentAd.getPrice()];
				} else {
					mtable.setValueAt("", i, 1);
					mtable.setValueAt("", i, 2);
				}
			} else {
				mtable.setValueAt("", i, 1);
				mtable.setValueAt("", i, 2);
			}
		}

		// mtable = new JTable(data, columnNames);
		// mtable.setValueAt("PENIS", 0, 0);

		// scrollPane = new JScrollPane(mtable);
		// mtable.setFillsViewportHeight(true);
	}

}
