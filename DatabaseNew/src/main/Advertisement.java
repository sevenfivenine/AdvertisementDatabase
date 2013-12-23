package main;

public class Advertisement {
	public static final String[] MONTHS = new String[] { "September",
			"October", "November", "December", "January", "February", "March",
			"April" };
	public static final String[] SIZES = new String[] { "2x4", "4x2", "4x4",
			"6x2", "Half Page", "Full Page" };
	public static final String[] PRICES = new String[] { "$30", "$60", "$45",
			"$360", "$720" };

	private int date;
	private int size;
	private int price;
	private boolean paid;

	public Advertisement(int date, int size, int price, boolean paid) {
		super();
		this.date = date;
		this.size = size;
		this.price = price;
		this.paid = paid;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

}
