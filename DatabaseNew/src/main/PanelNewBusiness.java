package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PanelNewBusiness extends JPanel {
	private JTextField fieldName;
	private JTextField fieldAddress;
	private JTextField fieldCity;
	private JTextField fieldState;
	private JTextField fieldZIP;
	private JTextField fieldPhone;
	private JTextField fieldEmail;

	private ArrayList<JPanel> adPanels;

	/**
	 * Create the panel.
	 */
	public PanelNewBusiness() {
		setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][]"));

		JLabel lblBusinessName = new JLabel("Business Name");
		add(lblBusinessName, "cell 0 0,alignx trailing");

		fieldName = new JTextField();
		//fieldName.setText("Name Field");
		add(fieldName, "cell 1 0 2 1,growx");
		fieldName.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "cell 0 1,alignx trailing");

		fieldAddress = new JTextField();
		//fieldAddress.setText("Address Field");
		add(fieldAddress, "cell 1 1 2 1,growx");
		fieldAddress.setColumns(10);

		JLabel lblCity = new JLabel("City");
		add(lblCity, "cell 0 2,alignx trailing");

		fieldCity = new JTextField();
		//fieldCity.setText("City Field");
		add(fieldCity, "cell 1 2 2 1,growx");
		fieldCity.setColumns(10);

		JLabel lblState = new JLabel("State");
		add(lblState, "cell 0 3,alignx trailing");

		fieldState = new JTextField();
		//fieldState.setText("State Field");
		add(fieldState, "cell 1 3 2 1,growx");
		fieldState.setColumns(10);

		JLabel lblZipCode = new JLabel("ZIP Code");
		add(lblZipCode, "cell 0 4,alignx trailing");

		fieldZIP = new JTextField();
		//fieldZIP.setText("ZIP Field");
		add(fieldZIP, "cell 1 4 2 1,growx");
		fieldZIP.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		add(lblPhoneNumber, "cell 0 5,alignx trailing");

		fieldPhone = new JTextField();
		//fieldPhone.setText("Phone Field");
		add(fieldPhone, "cell 1 5 2 1,growx");
		fieldPhone.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 0 6,alignx trailing");

		fieldEmail = new JTextField();
		//fieldEmail.setText("Email Field");
		add(fieldEmail, "cell 1 6 2 1,growx");
		fieldEmail.setColumns(10);

		adPanels = new ArrayList<JPanel>();

		JPanel month1 = new PanelNewAdvertisement("September");
		add(month1, "cell 1 7,grow");
		adPanels.add(month1);

		JPanel month2 = new PanelNewAdvertisement("October");
		add(month2, "cell 2 7,grow");
		adPanels.add(month2);

		JPanel month3 = new PanelNewAdvertisement("November");
		add(month3, "cell 3 7,grow");
		adPanels.add(month3);

		JPanel month4 = new PanelNewAdvertisement("December");
		add(month4, "cell 4 7,grow");
		adPanels.add(month4);

		JPanel month5 = new PanelNewAdvertisement("January");
		add(month5, "cell 1 8,grow");
		adPanels.add(month5);

		JPanel month6 = new PanelNewAdvertisement("February");
		add(month6, "cell 2 8,grow");
		adPanels.add(month6);

		JPanel month7 = new PanelNewAdvertisement("March");
		add(month7, "cell 3 8,grow");
		adPanels.add(month7);

		JPanel month8 = new PanelNewAdvertisement("April");
		add(month8, "cell 4 8,grow");
		adPanels.add(month8);

		JButton btnAddBusiness = new JButton("Add Business");
		btnAddBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] text = new String[] {fieldName.getText(), fieldAddress.getText(), fieldCity.getText(),
						fieldState.getText(), fieldZIP.getText(), fieldPhone.getText(), fieldEmail.getText()};
				
				ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
				
				for(JPanel p : adPanels) {
					PanelNewAdvertisement adPanel = (PanelNewAdvertisement) p;
					
					if(adPanel.isEnabled()) {
						ads.add(new Advertisement(adPanel.getMonth(), adPanel.getSizeBox().getSelectedItem(),
								adPanel.getPriceBox().getSelectedItem(), adPanel.getPaidBox().getSelectedItem()));
					}

				}
				
				DataHandler.addBusiness(text, ads);
			}
		});
		add(btnAddBusiness, "cell 1 9");
	}

}
