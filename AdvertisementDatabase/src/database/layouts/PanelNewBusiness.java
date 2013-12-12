package database.layouts;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import database.main.AdvertisementDatabase;
import database.main.Business;
import database.main.Data;

public class PanelNewBusiness extends JPanel {
	private JTextField mtextField;
	private JTextField mtextField_1;
	private JTextField mtextField_2;
	private JTextField mtextField_3;
	private JTextField mtextField_4;
	private JTextField mtextField_5;
	private JTextField mtextField_6;
	
	private AdvertisementDatabase database;

	/**
	 * Create the panel.
	 * @param advertisementDatabase 
	 */
	public PanelNewBusiness(AdvertisementDatabase advertisementDatabase) {
		database = advertisementDatabase;
		
		setSize(988, 711);
		setLayout(null);
		
		JLabel lblNewBusiness = new JLabel("New Business");
		lblNewBusiness.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewBusiness.setBounds(397, 36, 193, 39);
		add(lblNewBusiness);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 86, 976, 12);
		add(separator);
		
		JLabel lblBusinessName = new JLabel("Business Name");
		lblBusinessName.setBounds(10, 109, 71, 14);
		add(lblBusinessName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 134, 46, 14);
		add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 159, 46, 14);
		add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(10, 184, 46, 14);
		add(lblState);
		
		JLabel lblZipCode = new JLabel("ZIP Code");
		lblZipCode.setBounds(10, 209, 46, 14);
		add(lblZipCode);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(10, 234, 70, 14);
		add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 259, 46, 14);
		add(lblEmail);
		
		mtextField = new JTextField();
		//mtextField.setText("Name Field");
		mtextField.setBounds(91, 106, 187, 20);
		add(mtextField);
		mtextField.setColumns(10);
		
		mtextField_1 = new JTextField();
		//mtextField_1.setText("Address Field");
		mtextField_1.setBounds(91, 131, 187, 20);
		add(mtextField_1);
		mtextField_1.setColumns(10);
		
		mtextField_2 = new JTextField();
		//mtextField_2.setText("City Field");
		mtextField_2.setBounds(91, 156, 187, 20);
		add(mtextField_2);
		mtextField_2.setColumns(10);
		
		mtextField_3 = new JTextField();
		//mtextField_3.setText("State Field");
		mtextField_3.setBounds(91, 181, 187, 20);
		add(mtextField_3);
		mtextField_3.setColumns(10);
		
		mtextField_4 = new JTextField();
		//mtextField_4.setText("ZIP Field");
		mtextField_4.setBounds(91, 206, 187, 20);
		add(mtextField_4);
		mtextField_4.setColumns(10);
		
		mtextField_5 = new JTextField();
		//mtextField_5.setText("Phone Field");
		mtextField_5.setBounds(91, 231, 187, 20);
		add(mtextField_5);
		mtextField_5.setColumns(10);
		
		mtextField_6 = new JTextField();
		//mtextField_6.setText("Email Field");
		mtextField_6.setBounds(91, 256, 187, 20);
		add(mtextField_6);
		mtextField_6.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBusiness();
			}
		});
		btnAdd.setBounds(91, 287, 89, 23);
		add(btnAdd);
	}

	public void addBusiness() {
		Data.businessList.add(new Business(mtextField.getText(), mtextField_1.getText(), mtextField_2.getText(), 
				mtextField_3.getText(), mtextField_4.getText(), mtextField_5.getText(), mtextField_6.getText()));
		database.openLayout(Layout.BUSINESS);
	}
}
