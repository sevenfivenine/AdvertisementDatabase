package main;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelNewAdvertisement extends JPanel {
	private boolean isEnabled;
	private String month;
	private JComboBox sizeBox, priceBox, paidBox;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelNewAdvertisement(String month) {
		this.setMonth(month);
		setLayout(new MigLayout("", "[][][]", "[][][][]"));

		JCheckBox chckbxEnabled = new JCheckBox();
		chckbxEnabled.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				isEnabled = !isEnabled;
				update();
			}
		});
		chckbxEnabled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(chckbxEnabled, "cell 0 0");

		JLabel lblMonth = new JLabel(month);
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblMonth, "cell 1 0 2 1,alignx center");

		JLabel lblSize = new JLabel("Size");
		add(lblSize, "cell 1 1,alignx trailing");

		sizeBox = new JComboBox();
		sizeBox.setModel(new DefaultComboBoxModel(new String[] {"2x4", "4x2", "4x4", "Half Page", "Full Page"}));
		add(sizeBox, "cell 2 1,growx");

		JLabel lblPrice = new JLabel("Price");
		add(lblPrice, "cell 1 2,alignx trailing");

		priceBox = new JComboBox();
		priceBox.setModel(new DefaultComboBoxModel(new String[] {"$30", "$60", "$360", "$720"}));
		add(priceBox, "cell 2 2,growx");

		JLabel lblPaid = new JLabel("Paid?");
		add(lblPaid, "cell 1 3,alignx trailing");

		paidBox = new JComboBox();
		paidBox.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		add(paidBox, "cell 2 3,growx");

		update();
	}

	public void update() {
		sizeBox.setEnabled(isEnabled);
		priceBox.setEnabled(isEnabled);
		paidBox.setEnabled(isEnabled);
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public JComboBox getSizeBox() {
		return sizeBox;
	}

	public JComboBox getPriceBox() {
		return priceBox;
	}

	public JComboBox getPaidBox() {
		return paidBox;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
