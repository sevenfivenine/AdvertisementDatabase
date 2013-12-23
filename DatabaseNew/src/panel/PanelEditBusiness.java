package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Advertisement;
import main.Business;
import main.DataHandler;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelEditBusiness extends JPanel {
	private JTextField fieldName, fieldAddress, fieldCity, fieldState,
			fieldZIP, fieldPhone, fieldEmail;
	private JButton btnSaveBusiness;
	private ArrayList<JPanel> adPanels;

	/**
	 * Create the panel.
	 */
	public PanelEditBusiness() {
		setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][]"));

		JLabel lblBusinessName = new JLabel("Business Name");
		add(lblBusinessName, "cell 0 0,alignx trailing");

		fieldName = new JTextField();
		add(fieldName, "cell 1 0 2 1,growx");
		fieldName.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "cell 0 1,alignx trailing");

		fieldAddress = new JTextField();
		add(fieldAddress, "cell 1 1 2 1,growx");
		fieldAddress.setColumns(10);

		JLabel lblCity = new JLabel("City");
		add(lblCity, "cell 0 2,alignx trailing");

		fieldCity = new JTextField();
		add(fieldCity, "cell 1 2 2 1,growx");
		fieldCity.setColumns(10);

		JLabel lblState = new JLabel("State");
		add(lblState, "cell 0 3,alignx trailing");

		fieldState = new JTextField();
		add(fieldState, "cell 1 3 2 1,growx");
		fieldState.setColumns(10);

		JLabel lblZipCode = new JLabel("ZIP Code");
		add(lblZipCode, "cell 0 4,alignx trailing");

		fieldZIP = new JTextField();
		add(fieldZIP, "cell 1 4 2 1,growx");
		fieldZIP.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		add(lblPhoneNumber, "cell 0 5,alignx trailing");

		fieldPhone = new JTextField();
		add(fieldPhone, "cell 1 5 2 1,growx");
		fieldPhone.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 0 6,alignx trailing");

		fieldEmail = new JTextField();
		add(fieldEmail, "cell 1 6 2 1,growx");
		fieldEmail.setColumns(10);

		adPanels = new ArrayList<JPanel>();

		JPanel month1 = new PanelNewAdvertisement(0);
		add(month1, "cell 1 7,grow");
		adPanels.add(month1);

		JPanel month2 = new PanelNewAdvertisement(1);
		add(month2, "cell 2 7,grow");
		adPanels.add(month2);

		JPanel month3 = new PanelNewAdvertisement(2);
		add(month3, "cell 3 7,grow");
		adPanels.add(month3);

		JPanel month4 = new PanelNewAdvertisement(3);
		add(month4, "cell 4 7,grow");
		adPanels.add(month4);

		JPanel month5 = new PanelNewAdvertisement(4);
		add(month5, "cell 1 8,grow");
		adPanels.add(month5);

		JPanel month6 = new PanelNewAdvertisement(5);
		add(month6, "cell 2 8,grow");
		adPanels.add(month6);

		JPanel month7 = new PanelNewAdvertisement(6);
		add(month7, "cell 3 8,grow");
		adPanels.add(month7);

		JPanel month8 = new PanelNewAdvertisement(7);
		add(month8, "cell 4 8,grow");
		adPanels.add(month8);

		btnSaveBusiness = new JButton("Save Business");
		btnSaveBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] text = new String[] { fieldName.getText(),
						fieldAddress.getText(), fieldCity.getText(),
						fieldState.getText(), fieldZIP.getText(),
						fieldPhone.getText(), fieldEmail.getText() };

				ArrayList<Advertisement> ads = new ArrayList<Advertisement>();

				for (JPanel p : adPanels) {
					PanelNewAdvertisement adPanel = (PanelNewAdvertisement) p;

					if (adPanel.isEnabled()) {
						ads.add(new Advertisement(adPanel.getIndex(), adPanel
								.getSizeBox().getSelectedIndex(), adPanel
								.getPriceBox().getSelectedIndex(), true));
					}

				}

				Business currentBus = DataHandler.businessList
						.get(DataHandler.currentBusinessIndex);
				currentBus.setInfo(text);
				currentBus.setAdvertisements(ads);
			}
		});
		add(btnSaveBusiness, "cell 1 9");

		update();
	}

	public void update() {
		Business currentBusiness = DataHandler.businessList
				.get(DataHandler.currentBusinessIndex);
		fieldName.setText(currentBusiness.getName());
		fieldAddress.setText(currentBusiness.getAddress());
		fieldCity.setText(currentBusiness.getCity());
		fieldState.setText(currentBusiness.getState());
		fieldZIP.setText(currentBusiness.getZip());
		fieldPhone.setText(currentBusiness.getPhone());
		fieldEmail.setText(currentBusiness.getEmail());

		for (JPanel p : adPanels) {
			PanelNewAdvertisement adPanel = (PanelNewAdvertisement) p;

			for (Advertisement ad : currentBusiness.getAdvertisements()) {
				if (adPanel.getIndex() == ad.getDate()) {
					adPanel.setEnabled(true);
					adPanel.getChckbxEnabled().setSelected(true);
					adPanel.getSizeBox().setSelectedIndex(ad.getSize());
					adPanel.getPriceBox().setSelectedIndex(ad.getPrice());
					adPanel.update();
				}
			}
		}
	}
}
