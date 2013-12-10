package database.layouts;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class PanelBusiness extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelBusiness() {
		setLayout(null);
		
		JLabel lblBusinessName = new JLabel("Business Name");
		lblBusinessName.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblBusinessName.setBounds(108, 25, 233, 33);
		add(lblBusinessName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 70, 438, 12);
		add(separator);

	}
}
