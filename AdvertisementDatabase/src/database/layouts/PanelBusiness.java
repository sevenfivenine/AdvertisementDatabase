package database.layouts;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import database.main.Data;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBusiness extends JPanel {

	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtZip;
	private JTextField txtName;
	private JTextField txtState;
	private JTextField txtPhone;
	private JTextField txtEmail;

	private int currentBusiness;
	private JButton mbutton;
	private JButton mbutton_1;
	private JLabel mlabel;

	/**
	 * Create the panel.
	 */
	public PanelBusiness() {
		setSize(988, 711);
		setLayout(null);

		currentBusiness = 0;

		JLabel lblBusinessName = new JLabel("Business Name");
		lblBusinessName.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblBusinessName.setBounds(377, 25, 233, 33);
		add(lblBusinessName);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 70, 976, 12);
		add(separator);

		txtAddress = new JTextField();
		try {
			txtAddress.setText(Data.businessList.get(currentBusiness).getAddress());
		} catch (Exception e) {
			//e.printStackTrace();
		}
		add(txtAddress);
		txtAddress.setColumns(10);

		txtCity = new JTextField();
		try {
			txtCity.setText(Data.businessList.get(currentBusiness).getCity());
		} catch (Exception e) {
			//e.printStackTrace();
		}
		txtCity.setBounds(6, 174, 216, 28);
		add(txtCity);
		txtCity.setColumns(10);

		txtZip = new JTextField();
		try {
			txtZip.setText(Data.businessList.get(currentBusiness).getZip());
		} catch (Exception e) {
			//e.printStackTrace();
		}
		txtZip.setBounds(6, 214, 90, 28);
		add(txtZip);
		txtZip.setColumns(10);

		txtName = new JTextField();
		try {
			txtName.setText(Data.businessList.get(currentBusiness).getName());
		} catch (Exception e) {
			//e.printStackTrace();
		}
		txtName.setBounds(6, 94, 287, 28);
		add(txtName);
		txtName.setColumns(10);

		txtState = new JTextField();
		try {
			txtState.setText(Data.businessList.get(currentBusiness).getState());
		} catch (Exception e) {
			//e.printStackTrace();
		}
		txtState.setBounds(234, 174, 59, 28);
		add(txtState);
		txtState.setColumns(10);

		txtPhone = new JTextField();
		try {
			txtPhone.setText(Data.businessList.get(currentBusiness).getPhone());
		} catch (Exception e) {
			//e.printStackTrace();
		}
		txtPhone.setBounds(796, 94, 186, 28);
		add(txtPhone);
		txtPhone.setColumns(10);

		txtEmail = new JTextField();
		try {
			txtEmail.setText(Data.businessList.get(currentBusiness).getEmail());
		} catch (Exception e) {
			//e.printStackTrace();
		}
		txtEmail.setBounds(796, 134, 186, 28);
		add(txtEmail);
		txtEmail.setColumns(10);

		mbutton = new JButton("Previous");
		mbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					currentBusiness -= 1;
					updatePanel();
					mlabel.setText(Integer.toString(currentBusiness));
				} catch (Exception e1) {
					//e1.printStackTrace();
				}
			}
		});
		mbutton.setBounds(743, 30, 89, 23);
		add(mbutton);

		mbutton_1 = new JButton("Next");
		mbutton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					currentBusiness += 1;
					updatePanel();
					mlabel.setText(Integer.toString(currentBusiness));
				} catch (Exception e1) {
					//e1.printStackTrace();
				}
			}
		});
		mbutton_1.setBounds(842, 30, 89, 23);
		add(mbutton_1);

		mlabel = new JLabel("0");
		mlabel.setBounds(941, 34, 15, 14);
		add(mlabel);
	}

	public void updatePanel() {
		try {
			txtAddress.setText(Data.businessList.get(currentBusiness).getAddress());
			txtCity.setText(Data.businessList.get(currentBusiness).getCity());
			txtZip.setText(Data.businessList.get(currentBusiness).getZip());
			txtName.setText(Data.businessList.get(currentBusiness).getName());
			txtState.setText(Data.businessList.get(currentBusiness).getState());
			txtPhone.setText(Data.businessList.get(currentBusiness).getPhone());
			txtEmail.setText(Data.businessList.get(currentBusiness).getEmail());
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

}
