package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;

public class DialogConfigureYear extends JDialog implements ActionListener {

	private final JPanel mcontentPanel = new JPanel();
	private JTextField mtextField;
	private JLabel label;
	private JTextArea txtrSeptember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		launchNew();
	}

	public static void launchNew() {
		try {
			DialogConfigureYear dialog = new DialogConfigureYear();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogConfigureYear() {
		setBounds(100, 100, 350, 200);
		setLocationRelativeTo(null);
		setTitle("Configure New Year");
		getContentPane().setLayout(new BorderLayout());
		mcontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mcontentPanel, BorderLayout.CENTER);
		mcontentPanel.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		{
			JLabel lblSchoolYear = new JLabel("School Year:");
			mcontentPanel.add(lblSchoolYear, "flowx,cell 0 0,alignx center");
		}
		{
			JLabel lblIssues = new JLabel("Issues:");
			mcontentPanel.add(lblIssues, "flowx,cell 0 1,alignx center,aligny top");
		}
		{
			mtextField = new JTextField();
			mtextField.getDocument().addDocumentListener(new DocumentListener() {
				public void changedUpdate(DocumentEvent e) {
					warn();
				}

				public void removeUpdate(DocumentEvent e) {
					warn();
				}

				public void insertUpdate(DocumentEvent e) {
					warn();
				}

				public void warn() {
					try {
						int year = Integer.parseInt(mtextField.getText());
						if (year > 2000 && year < 3000) {
							label.setText(" - " + (year + 1));
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				}
			});
			mtextField.setText("2014");
			mcontentPanel.add(mtextField, "cell 0 0,alignx center");
			mtextField.setColumns(4);
		}
		{
			label = new JLabel("- 2015");
			mcontentPanel.add(label, "cell 0 0,alignx center");
		}
		{
			txtrSeptember = new JTextArea();
			txtrSeptember.setLineWrap(true);
			txtrSeptember.setPreferredSize(new Dimension(180, 60));
			txtrSeptember.setBorder(new LineBorder(Color.LIGHT_GRAY));
			txtrSeptember.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtrSeptember.setText("September,October,November,December,January,February,March,April");
			mcontentPanel.add(txtrSeptember, "cell 0 1,alignx center,aligny top");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if ("Cancel".equals(e.getActionCommand())) {
			dispose();
		} else if ("OK".equals(e.getActionCommand())) {
			configureNewYear();
		}
	}

	public void configureNewYear() {
		int year = 0;
		try {
			year = Integer.parseInt(mtextField.getText());
			DataHandler.save();
			DataHandler.year = year;
			DataHandler.currentReadFile = "adBase\\" + year + "-" + (year + 1) + ".csv";
		} catch (Exception e) {
			e.printStackTrace();
		}
		String issues = txtrSeptember.getText();
		System.out.println(issues);
		String[] issuesArray = issues.split(",");
		for (String s : issuesArray) {
			System.out.println(s);
		}
	}

	public static void noDatabaseMessage() {
		JOptionPane.showMessageDialog(null, "Open a data file or create a new one.");
	}
}
