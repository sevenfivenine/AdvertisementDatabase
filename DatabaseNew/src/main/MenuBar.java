package main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	public MenuBar() {

		JMenu mnFile = new JMenu("File");
		add(mnFile);

		JMenu mnEdit = new JMenu("Edit");
		add(mnEdit);

		JMenu mnHelp = new JMenu("Help");
		add(mnHelp);
	}

}
