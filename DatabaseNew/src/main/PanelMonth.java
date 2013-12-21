package main;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class PanelMonth extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMonth() {
		setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel lblMonth = new JLabel("Month");
		add(lblMonth, "cell 0 0");

	}

}
