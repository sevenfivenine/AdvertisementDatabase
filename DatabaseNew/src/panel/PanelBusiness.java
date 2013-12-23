package panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Business;
import main.DataHandler;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelBusiness extends JPanel {
	private JLabel lblBusinessName, lblAddress, lblCity, lblState, lblZip,
			lblPhone, lblEmail;
	private JButton mbutton;
	private ArrayList<JPanel> adPanels;

	/**
	 * Create the panel.
	 */
	public PanelBusiness() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow]",
				"[][][][][][grow][grow]"));

		lblBusinessName = new JLabel("Business Name");
		lblBusinessName.setFont(new Font("Tahoma", Font.PLAIN, 36));
		add(lblBusinessName, "cell 0 0 4 1,alignx center");

		lblPhone = new JLabel("Phone");
		add(lblPhone, "cell 3 1,alignx right");

		lblAddress = new JLabel("Address");
		add(lblAddress, "cell 0 2");

		lblEmail = new JLabel("Email");
		add(lblEmail, "cell 3 2,alignx right");

		lblCity = new JLabel("City");
		add(lblCity, "cell 0 3");

		lblState = new JLabel("State");
		add(lblState, "cell 1 3");

		lblZip = new JLabel("ZIP");
		add(lblZip, "cell 2 3");

		adPanels = new ArrayList<JPanel>();

		String[] formats = new String[] { "cell 0 4,grow", "cell 1 4,grow",
				"cell 2 4,grow", "cell 3 4,grow", "cell 0 5,grow",
				"cell 1 5,grow", "cell 2 5,grow", "cell 3 5,grow" };

		for (int i = 0; i < 8; i++) {
			adPanels.add(new PanelAdvertisement(i));
			add(adPanels.get(i), formats[i]);
		}

		mbutton = new JButton("Delete Record");
		mbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null,
						"Are you sure you wish to delete this business?");
				if (choice == 0) {
					DataHandler.businessList
							.remove(DataHandler.currentBusinessIndex);
					DataHandler.currentBusinessIndex--;
					update();
				}
			}
		});
		add(mbutton, "cell 3 6,alignx right");

		update();
	}

	public void update() {
		try {
			Business currentBusiness = DataHandler.businessList
					.get(DataHandler.currentBusinessIndex);

			lblBusinessName.setText(currentBusiness.getName());
			lblAddress.setText(currentBusiness.getAddress());
			lblCity.setText(currentBusiness.getCity());
			lblState.setText(currentBusiness.getState());
			lblZip.setText(currentBusiness.getZip());
			lblPhone.setText(currentBusiness.getPhone());
			lblEmail.setText(currentBusiness.getEmail());

			for (JPanel p : adPanels) {
				((PanelAdvertisement) p).update();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
