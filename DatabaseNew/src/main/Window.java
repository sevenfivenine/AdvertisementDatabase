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

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import panel.PanelBusiness;
import panel.PanelEditBusiness;
import panel.PanelMonth;
import panel.PanelNewBusiness;

public class Window {

	private JFrame theFrame;
	private JPanel mainPanel, panelBusiness, panelMonth, panelNewBusiness, panelEditBusiness;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnHelp;
	private JMenuItem mntmPrint;
	private JMenuItem mntmConfigureNewYear;
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
		// theFrame.setBounds(100, 100, 450, 300);
		theFrame.setBounds(100, 100, 900, 600);
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

		File f = new File("data.csv");
		if(f.exists())
			System.out.println("database exists");
		else
			System.out.println("database does not exist");
		
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

		// Menu
		menuBar = new JMenuBar();
		theFrame.setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmPrint = new JMenuItem("Print...");
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintHandler.printTest(mainPanel);
			}
		});
		mnFile.add(mntmPrint);

		mntmConfigureNewYear = new JMenuItem("Configure New Year...");
		mntmConfigureNewYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogConfigureYear.launchNew();
			}
		});
		mnFile.add(mntmConfigureNewYear);

		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

	}

	public JFrame getFrame() {
		return theFrame;
	}

	public void setFrame(JFrame mframe) {
		this.theFrame = mframe;
	}

	public JPanel getPanel() {
		return mainPanel;
	}

	public void setPanel(JPanel panel) {
		this.mainPanel = panel;
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

	public void setPanelEditBusiness(JPanel panelEditBusiness) {
		this.panelEditBusiness = panelEditBusiness;
	}

}
