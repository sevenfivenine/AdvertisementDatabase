package panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
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
