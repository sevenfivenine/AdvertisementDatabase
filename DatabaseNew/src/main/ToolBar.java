package main;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import panel.PanelBusiness;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
	private JLabel lblYear;

	public ToolBar(JPanel p, Window w) {
		final JPanel panel = p;
		final Window window = w;

		setFloatable(false);

		JLabel lblLayout = new JLabel("Layout: ");
		add(lblLayout);

		JButton btnBusiness = new JButton("Business");
		btnBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "Business");
				((PanelBusiness) window.getPanelBusiness()).update();
			}
		});
		add(btnBusiness);

		JButton btnMonth = new JButton("Month");
		btnMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "Month");
			}
		});
		add(btnMonth);

		JButton btnNewBusiness = new JButton("New Business");
		btnNewBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "New Business");
			}
		});
		add(btnNewBusiness);
		
		lblYear = new JLabel("Year");
		add(lblYear);
	}
	
	public void update() {
		lblYear.setText(Integer.toString(DataHandler.year));
	}
}
