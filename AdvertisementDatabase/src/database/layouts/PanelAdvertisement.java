package database.layouts;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class PanelAdvertisement extends JPanel {
	private JTextField txtInfo;

	/**
	 * Create the panel.
	 */
	public PanelAdvertisement() {
		setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblDate.setBounds(94, 6, 72, 38);
		add(lblDate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 56, 248, 12);
		add(separator);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setBounds(51, 98, 61, 16);
		add(lblSize);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(51, 126, 61, 16);
		add(lblPrice);
		
		JLabel lblPaid = new JLabel("Paid?");
		lblPaid.setBounds(51, 154, 61, 16);
		add(lblPaid);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 94, 85, 27);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(124, 122, 85, 27);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(124, 150, 85, 27);
		add(comboBox_2);
		
		txtInfo = new JTextField();
		txtInfo.setText("Info");
		txtInfo.setBounds(51, 182, 158, 28);
		add(txtInfo);
		txtInfo.setColumns(10);

	}
}
