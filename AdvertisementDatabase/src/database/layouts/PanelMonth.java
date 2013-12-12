package database.layouts;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class PanelMonth extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMonth() {
		setLayout(null);
		
		JLabel lblMonthName = new JLabel("Month Name");
		lblMonthName.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblMonthName.setBounds(108, 25, 233, 33);
		add(lblMonthName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 70, 438, 12);
		add(separator);

	}
}
