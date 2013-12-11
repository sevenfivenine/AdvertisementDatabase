package database.layouts;

import java.util.ArrayList;

import javax.swing.JComponent;

public class Layout {
	private int id;
	private String name;
	
	public static final int BUSINESS = 0;
	public static final int MONTH = 1;
	public static final int NEW_BUSINESS = 2;
	
	protected ArrayList<JComponent> components;
	
	public Layout(int nId, String sName) {
		id = nId;
		name = sName;
		
		components = new ArrayList<JComponent>();
	}
	
	public ArrayList<JComponent> getComponents() {
		return components;
	}
}
