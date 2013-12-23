package main;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import panel.PanelBusiness;
import panel.PanelEditBusiness;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
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

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataHandler.previousBusiness();
				((PanelBusiness) window.getPanelBusiness()).update();
			}
		});
		add(btnPrevious);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataHandler.nextBusiness();
				((PanelBusiness) window.getPanelBusiness()).update();
			}
		});
		add(btnNext);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "Edit Business");
				((PanelEditBusiness) window.getPanelEditBusiness()).update();
			}
		});
		add(btnEdit);
	}
}
