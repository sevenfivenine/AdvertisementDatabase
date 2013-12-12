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

	private int currentBusiness;
	private JButton mbutton;
	private JButton mbutton_1;
	private JLabel mlabel;
	
	private JLabel lblBusinessName;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZip;
	private JLabel lblPhone;
	private JLabel lblEmail;

	/**
	 * Create the panel.
	 */
	public PanelBusiness() {
		setSize(988, 711);
		setLayout(null);

		currentBusiness = 0;

		lblBusinessName = new JLabel("Business Name");
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
		try {
		} catch (Exception e) {
			//e.printStackTrace();
		}
		try {
		} catch (Exception e) {
			//e.printStackTrace();
		}
		try {
		} catch (Exception e) {
			//e.printStackTrace();
		}
		try {
		} catch (Exception e) {
			//e.printStackTrace();
		}
		try {
		} catch (Exception e) {
			//e.printStackTrace();
		}
		try {
		} catch (Exception e) {
			//e.printStackTrace();
		}

		mbutton = new JButton("Previous");
		mbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(currentBusiness > 0) {
						currentBusiness -= 1;
					}
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
					if(currentBusiness < Data.businessList.size() - 1) {
						currentBusiness += 1;
					}
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
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 93, 180, 14);
		add(lblAddress);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(10, 118, 180, 14);
		add(lblCity);
		
		lblState = new JLabel("State");
		lblState.setBounds(10, 143, 180, 14);
		add(lblState);
		
		lblZip = new JLabel("ZIP");
		lblZip.setBounds(10, 168, 180, 14);
		add(lblZip);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 193, 180, 14);
		add(lblPhone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 218, 180, 14);
		add(lblEmail);
	}

	public void updatePanel() {
		try {
			lblBusinessName.setText(Data.businessList.get(currentBusiness).getName());
			lblAddress.setText(Data.businessList.get(currentBusiness).getAddress());
			lblCity.setText(Data.businessList.get(currentBusiness).getCity());
			lblZip.setText(Data.businessList.get(currentBusiness).getZip());
			lblState.setText(Data.businessList.get(currentBusiness).getState());
			lblPhone.setText(Data.businessList.get(currentBusiness).getPhone());
			lblEmail.setText(Data.businessList.get(currentBusiness).getEmail());
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
}
