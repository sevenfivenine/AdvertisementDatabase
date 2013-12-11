package database.layouts;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class PanelBusiness extends JPanel {
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtZip;
	private JTextField txtName;
	private JTextField txtState;
	private JTextField txtPhone;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public PanelBusiness() {
		setSize(988, 711);
		setLayout(null);
		
		JLabel lblBusinessName = new JLabel("Business Name");
		lblBusinessName.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblBusinessName.setBounds(377, 25, 233, 33);
		add(lblBusinessName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 70, 976, 12);
		add(separator);
		
		txtAddress = new JTextField();
		txtAddress.setText("Address 1");
		txtAddress.setBounds(6, 134, 287, 28);
		add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setText("City");
		txtCity.setBounds(6, 174, 216, 28);
		add(txtCity);
		txtCity.setColumns(10);
		
		txtZip = new JTextField();
		txtZip.setText("ZIP");
		txtZip.setBounds(6, 214, 90, 28);
		add(txtZip);
		txtZip.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(6, 94, 287, 28);
		add(txtName);
		txtName.setColumns(10);
		
		txtState = new JTextField();
		txtState.setText("State");
		txtState.setBounds(234, 174, 59, 28);
		add(txtState);
		txtState.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setText("Phone");
		txtPhone.setBounds(796, 94, 186, 28);
		add(txtPhone);
		txtPhone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(796, 134, 186, 28);
		add(txtEmail);
		txtEmail.setColumns(10);

	}
}
