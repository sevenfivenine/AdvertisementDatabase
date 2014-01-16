package panel;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Advertisement;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PanelNewAdvertisement extends JPanel {
	private boolean isEnabled;
	private int index;
	private JCheckBox chckbxEnabled;
	private JComboBox<String> sizeBox, priceBox, paidBox;

	/**
	 * Create the panel.
	 */
	public PanelNewAdvertisement(int i) {
		index = i;
		setLayout(new MigLayout("", "[][][]", "[][][][]"));

		chckbxEnabled = new JCheckBox();
		chckbxEnabled.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isEnabled = chckbxEnabled.isSelected();
				update();
			}
		});
		chckbxEnabled.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

			}
		});
		add(chckbxEnabled, "cell 0 0");

		JLabel lblMonth = new JLabel(Advertisement.MONTHS[index]);
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblMonth, "cell 1 0 2 1,alignx center");

		JLabel lblSize = new JLabel("Size");
		add(lblSize, "cell 1 1,alignx trailing");

		sizeBox = new JComboBox<String>();
		sizeBox.setModel(new DefaultComboBoxModel<String>(Advertisement.SIZES));
		add(sizeBox, "cell 2 1,growx");

		JLabel lblPrice = new JLabel("Price");
		add(lblPrice, "cell 1 2,alignx trailing");

		priceBox = new JComboBox<String>();
		priceBox.setModel(new DefaultComboBoxModel<String>(Advertisement.PRICES));
		add(priceBox, "cell 2 2,growx");

		JLabel lblPaid = new JLabel("Paid?");
		add(lblPaid, "cell 1 3,alignx trailing");

		paidBox = new JComboBox<String>();
		paidBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Yes", "No" }));
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

	public JComboBox<String> getSizeBox() {
		return sizeBox;
	}

	public JComboBox<String> getPriceBox() {
		return priceBox;
	}

	public JComboBox<String> getPaidBox() {
		return paidBox;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public JCheckBox getChckbxEnabled() {
		return chckbxEnabled;
	}

	public void setChckbxEnabled(JCheckBox chckbxEnabled) {
		this.chckbxEnabled = chckbxEnabled;
	}

}
