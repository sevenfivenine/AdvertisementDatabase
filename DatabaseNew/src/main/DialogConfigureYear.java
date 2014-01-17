package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;

public class DialogConfigureYear extends JDialog {

	private final JPanel mcontentPanel = new JPanel();
	private JTextField mtextField;
	private JLabel label;

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
		setBounds(100, 100, 450, 300);
		setTitle("Configure New Year");
		getContentPane().setLayout(new BorderLayout());
		mcontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mcontentPanel, BorderLayout.CENTER);
		mcontentPanel.setLayout(new MigLayout("", "[][][]", "[][grow]"));
		{
			JLabel lblSchoolYear = new JLabel("School Year:");
			mcontentPanel.add(lblSchoolYear, "cell 0 0,alignx trailing");
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
			mcontentPanel.add(mtextField, "cell 1 0,growx");
			mtextField.setColumns(10);
		}
		{
			label = new JLabel(" - 2015");
			mcontentPanel.add(label, "cell 2 0");
		}
		{
			JLabel lblIssues = new JLabel("Issues:");
			mcontentPanel.add(lblIssues, "cell 0 1");
		}
		{
			JTextArea txtrSeptember = new JTextArea();
			txtrSeptember.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtrSeptember.setText("September");
			mcontentPanel.add(txtrSeptember, "cell 1 1,grow");
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
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
