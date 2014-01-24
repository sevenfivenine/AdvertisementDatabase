package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import panel.PanelBusiness;
import panel.PanelEditBusiness;
import panel.PanelMonth;
import panel.PanelNewBusiness;

public class Window {

	/**
	 * The main frame for adBase.
	 */
	private JFrame theFrame;
	/**
	 * The main panel for adBase, whose layout is a CardLayout containing the different panel views. 
	 */
	private JPanel mainPanel;
	private JPanel panelBusiness, panelMonth, panelNewBusiness, panelEditBusiness;
	private JMenuBar menuBar;
	private JMenu mnFile, mnEdit, mnHelp;
	private JMenuItem mntmPrint, mntmConfigureNewYear, mntmOpen;
	private ToolBar toolBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.theFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		checkDataStatus();
	}

	/**
	 * Checks to see if there is data for adBase to work off of. If there is no data, will open a dialog notifying the user.
	 */
	public static void checkDataStatus() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (DataHandler.currentReadFileName == null)
			DialogConfigureYear.noDatabaseMessage();
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		theFrame = new JFrame();
		theFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					DataHandler.save();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// The default setting is (100, 100, 450, 300)
		theFrame.setBounds(100, 100, 900, 600);
		
		// Centers the frame on the screen
		theFrame.setLocationRelativeTo(null);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		theFrame.setTitle("adBase v0.1");

		try {
			DataHandler.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		mainPanel = new JPanel();
		theFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new CardLayout(0, 0));

		toolBar = new ToolBar(mainPanel, this);
		theFrame.getContentPane().add(toolBar, BorderLayout.NORTH);
		toolBar.update();

		panelBusiness = new PanelBusiness(this);
		mainPanel.add(panelBusiness, "Business");

		panelMonth = new PanelMonth();
		mainPanel.add(panelMonth, "Month");

		panelNewBusiness = new PanelNewBusiness(this);
		mainPanel.add(panelNewBusiness, "New Business");

		panelEditBusiness = new PanelEditBusiness(this);
		mainPanel.add(panelEditBusiness, "Edit Business");
		
		initializeMenu();
	}

	/**
	 * Initializes adBase's menu.
	 */
	public void initializeMenu() {
		menuBar = new JMenuBar();
		theFrame.setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmConfigureNewYear = new JMenuItem("Configure New Year...");
		mntmConfigureNewYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogConfigureYear.launchNew();
			}
		});
		mnFile.add(mntmConfigureNewYear);

		mntmOpen = new JMenuItem("Open...");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(theFrame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();

					if (file.getName().endsWith(".csv")) {
						DataHandler.openNewFile(file);
					}
				}
			}
		});
		mnFile.add(mntmOpen);

		mntmPrint = new JMenuItem("Print...");
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintHandler.printPanel(mainPanel);
			}
		});
		mnFile.add(mntmPrint);

		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
	}

	public JFrame getFrame() {
		return theFrame;
	}

	public JPanel getPanel() {
		return mainPanel;
	}

	public JPanel getPanelBusiness() {
		return panelBusiness;
	}

	public JPanel getPanelMonth() {
		return panelMonth;
	}

	public JPanel getPanelNewBusiness() {
		return panelNewBusiness;
	}

	public JPanel getPanelEditBusiness() {
		return panelEditBusiness;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

}
