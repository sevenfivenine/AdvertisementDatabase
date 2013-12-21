package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Window {

	private JFrame theFrame;
	private JPanel mainPanel;
	private JPanel panelBusiness;
	private JPanel panelMonth;
	private JPanel panelNewBusiness;

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
		//theFrame.setBounds(100, 100, 450, 300);
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

		try {
			DataHandler.load();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		mainPanel = new JPanel();
		theFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new CardLayout(0, 0));

		JToolBar toolBar = new ToolBar(mainPanel, this);
		theFrame.getContentPane().add(toolBar, BorderLayout.NORTH);

		panelBusiness = new PanelBusiness();
		mainPanel.add(panelBusiness, "Business");

		panelMonth = new PanelMonth();
		mainPanel.add(panelMonth, "Month");

		panelNewBusiness = new PanelNewBusiness();
		mainPanel.add(panelNewBusiness, "New Business");
		
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

}