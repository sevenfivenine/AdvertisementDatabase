package main;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBusiness extends JPanel {
	private JLabel lblBusinessName;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZip;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JButton mbutton;
	private JPanel month1;
	private JPanel month2;
	private JPanel month3;
	private JPanel month4;
	private JPanel month5;
	private JPanel month6;
	private JPanel month7;
	private JPanel month8;

	/**
	 * Create the panel.
	 */
	public PanelBusiness() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[][][][][][grow][grow]"));

		lblBusinessName = new JLabel("Business Name");
		lblBusinessName.setFont(new Font("Tahoma", Font.PLAIN, 36));
		add(lblBusinessName, "cell 0 0 4 1,alignx center");

		lblPhone = new JLabel("Phone");
		add(lblPhone, "cell 3 1,alignx right");

		lblAddress = new JLabel("Address");
		add(lblAddress, "cell 0 2");

		lblEmail = new JLabel("Email");
		add(lblEmail, "cell 3 2,alignx right");

		lblCity = new JLabel("City");
		add(lblCity, "cell 0 3");

		lblState = new JLabel("State");
		add(lblState, "cell 1 3");

		lblZip = new JLabel("ZIP");
		add(lblZip, "cell 2 3");
		
		month1 = new PanelAdvertisement(0);
		add(month1, "cell 0 4,grow");
		
		month2 = new PanelAdvertisement(1);
		add(month2, "cell 1 4,grow");
		
		month3 = new PanelAdvertisement(2);
		add(month3, "cell 2 4,grow");
		
		month4 = new PanelAdvertisement(3);
		add(month4, "cell 3 4,grow");
		
		month5 = new PanelAdvertisement(4);
		add(month5, "cell 0 5,grow");
		
		month6 = new PanelAdvertisement(5);
		add(month6, "cell 1 5,grow");
		
		month7 = new PanelAdvertisement(6);
		add(month7, "cell 2 5,grow");
		
		month8 = new PanelAdvertisement(7);
		add(month8, "cell 3 5,grow");
		
		mbutton = new JButton("Delete Record");
		mbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete this business?");
				if(choice == 0) {
					DataHandler.businessList.remove(DataHandler.currentBusiness);
					DataHandler.currentBusiness--;
					update();
				}
			}
		});
		add(mbutton, "cell 3 6,alignx right");

		update();
	}

	public void update() {
		try {
			Business currentBusiness = DataHandler.businessList.get(DataHandler.currentBusiness);

			lblBusinessName.setText(currentBusiness.getName());
			lblAddress.setText(currentBusiness.getAddress());
			lblCity.setText(currentBusiness.getCity());
			lblState.setText(currentBusiness.getState());
			lblZip.setText(currentBusiness.getZip());
			lblPhone.setText(currentBusiness.getPhone());
			lblEmail.setText(currentBusiness.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
