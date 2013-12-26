package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.Business;
import main.DataHandler;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelBusiness extends JPanel {
	private JLabel lblBusinessName, lblAddress, lblCity, lblState, lblZip,
			lblPhone, lblEmail;
	private JButton mbutton;
	private ArrayList<JPanel> adPanels;
	private PanelContract panelContract;

	/**
	 * Create the panel.
	 */
	public PanelBusiness() {
		setLayout(new MigLayout("", "[][][][][grow]",
				"[][][][][grow][grow][grow]"));

		lblBusinessName = new JLabel("Business Name");
		lblBusinessName.setFont(new Font("Segoe WP SemiLight", Font.PLAIN, 36));
		add(lblBusinessName, "cell 0 0 4 1,alignx leading");

		lblAddress = new JLabel("Address");
		add(lblAddress, "cell 0 1");

		lblPhone = new JLabel("Phone");
		add(lblPhone, "cell 3 1,alignx leading");

		lblCity = new JLabel("City");
		add(lblCity, "flowx,cell 0 2");

		lblEmail = new JLabel("Email");
		add(lblEmail, "cell 3 2,alignx leading");

		adPanels = new ArrayList<JPanel>();

		// Do not use loop to initialize these, as they will not show up in
		// design pane
		JPanel month1 = new PanelAdvertisement(0);
		add(month1, "cell 0 4,grow");
		adPanels.add(month1);

		JPanel month2 = new PanelAdvertisement(1);
		add(month2, "cell 1 4,grow");
		adPanels.add(month2);

		JPanel month3 = new PanelAdvertisement(2);
		add(month3, "cell 2 4,grow");
		adPanels.add(month3);

		JPanel month4 = new PanelAdvertisement(3);
		add(month4, "cell 3 4,grow");
		adPanels.add(month4);

		int panelContractWidth = 300;
		panelContract = new PanelContract();
		panelContract.setPreferredSize(new Dimension(panelContractWidth,
				(int) (1.3 * panelContractWidth)));
		panelContract.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelContract, "cell 4 4 1 2,alignx center,aligny center");

		JPanel month5 = new PanelAdvertisement(4);
		add(month5, "cell 0 5,grow");
		adPanels.add(month5);

		JPanel month6 = new PanelAdvertisement(5);
		add(month6, "cell 1 5,grow");
		adPanels.add(month6);

		JPanel month7 = new PanelAdvertisement(6);
		add(month7, "cell 2 5,grow");
		adPanels.add(month7);

		JPanel month8 = new PanelAdvertisement(7);
		add(month8, "cell 3 5,grow");
		adPanels.add(month8);

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

		lblState = new JLabel("State");
		add(lblState, "cell 0 2");

		lblZip = new JLabel("ZIP");
		add(lblZip, "cell 0 2");

		JButton btnUploadContract = new JButton("Upload Contract");
		btnUploadContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(PanelBusiness.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					BufferedImage img = null;
					try {
						img = ImageIO.read(file);
						panelContract.setImage(img);
						panelContract.repaint();
						DataHandler.getCurrentBusiness().setContractImage(img);
						ImageIO.write(img, "png", new File(DataHandler
								.getCurrentBusiness().getName() + ".png"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		add(btnUploadContract, "cell 4 6");

		update();
	}

	public void update() {
		try {
			Business currentBusiness = DataHandler.getCurrentBusiness();

			lblBusinessName.setText(currentBusiness.getName());
			lblAddress.setText(currentBusiness.getAddress());
			lblCity.setText(currentBusiness.getCity());
			lblState.setText(currentBusiness.getState());
			lblZip.setText(currentBusiness.getZip());
			lblPhone.setText(currentBusiness.getPhone());
			lblEmail.setText(currentBusiness.getEmail());

			panelContract.setImage(currentBusiness.getContractImage());
			panelContract.repaint();

			for (JPanel p : adPanels) {
				((PanelAdvertisement) p).update();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
