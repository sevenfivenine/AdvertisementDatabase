package database.main;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import database.layouts.Layout;
import database.layouts.PanelBusiness;
import database.layouts.PanelMonth;
import database.layouts.PanelNewBusiness;
import java.awt.event.WindowAdapter;


public class AdvertisementDatabase {
	
	//private Data data;

	private JFrame frame;
	private int currentLayout;

	private Layout businessLayout;
	private Layout monthLayout;
	private Layout newBusinessLayout;

	private PanelBusiness panelBusiness;
	private PanelMonth panelMonth;
	private PanelNewBusiness panelNewBusiness;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdvertisementDatabase window = new AdvertisementDatabase();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdvertisementDatabase() {
		//setData(new Data());
		
		businessLayout = new Layout(0, "business");
		monthLayout = new Layout(1, "month");
		newBusinessLayout = new Layout(2, "new business");
		
		try {
			Data.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		currentLayout = Layout.BUSINESS;
		initialize();
		openLayout(currentLayout);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				try {
					Data.save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnNew = new JMenu("New");
		mnNew.setPreferredSize(new Dimension(150, 22));
		mnFile.add(mnNew);

		JMenuItem mntmBusiness = new JMenuItem("Business");
		mntmBusiness.setPreferredSize(new Dimension(150, 22));
		mntmBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openLayout(Layout.NEW_BUSINESS);
			}
		});
		mnNew.add(mntmBusiness);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Data.save();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnFile.add(mntmSave);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenu mnLayout = new JMenu("Layout");
		menuBar.add(mnLayout);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		frame.getContentPane().setLayout(null);

		//Business layout button
		JButton btnBusiness = new JButton("Business");
		btnBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openLayout(Layout.BUSINESS);
			}
		});
		btnBusiness.setBounds(102, 6, 117, 29);
		frame.getContentPane().add(btnBusiness);

		//Month layout button
		JButton btnMonth = new JButton("Month");
		btnMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openLayout(Layout.MONTH);
			}
		});
		btnMonth.setBounds(231, 6, 117, 29);
		frame.getContentPane().add(btnMonth);

		//Layout label
		JLabel lblLayoutMode = new JLabel("Layout Mode:");
		lblLayoutMode.setBounds(6, 11, 84, 16);
		frame.getContentPane().add(lblLayoutMode);

		//Business panel
		panelBusiness = new PanelBusiness();
		panelBusiness.setBounds(6, 39, 988, 711);
		frame.getContentPane().add(panelBusiness);

		businessLayout.getComponents().add(panelBusiness);

		//Month panel
		panelMonth = new PanelMonth();
		panelMonth.setBounds(6, 39, 988, 711);
		frame.getContentPane().add(panelMonth);

		monthLayout.getComponents().add(panelMonth);

		//New business panel
		panelNewBusiness = new PanelNewBusiness(this);
		panelNewBusiness.setBounds(6, 39, 988, 711);
		frame.getContentPane().add(panelNewBusiness);

		newBusinessLayout.getComponents().add(panelNewBusiness);
	}

	public void openLayout(int id) {
		currentLayout = id;

		if (currentLayout == Layout.BUSINESS) {
			for(JComponent comp : businessLayout.getComponents()) {
				comp.setVisible(true);
			}

			for(JComponent comp : monthLayout.getComponents()) {
				comp.setVisible(false);
			}
			
			for(JComponent comp : newBusinessLayout.getComponents()) {
				comp.setVisible(false);
			}
			
			panelBusiness.updatePanel();
		}


		if (currentLayout == Layout.MONTH) {
			for(JComponent comp : monthLayout.getComponents()) {
				comp.setVisible(true);
			}

			for(JComponent comp : businessLayout.getComponents()) {
				comp.setVisible(false);
			}
			
			for(JComponent comp : newBusinessLayout.getComponents()) {
				comp.setVisible(false);
			}
		}

		if (currentLayout == Layout.NEW_BUSINESS) {
			for(JComponent comp : newBusinessLayout.getComponents()) {
				comp.setVisible(true);
			}

			for(JComponent comp : businessLayout.getComponents()) {
				comp.setVisible(false);
			}
			
			for(JComponent comp : monthLayout.getComponents()) {
				comp.setVisible(false);
			}
		}
	}
}
