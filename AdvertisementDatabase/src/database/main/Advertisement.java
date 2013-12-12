package database.main;

public class Advertisement {
	private int date;
	private int size;
	private int price;
	private boolean paid;
	
	public static final int TWO_BY_FOUR = 0;
	public static final int FOUR_BY_TWO = 1;
	public static final int FOUR_BY_FOUR = 2;
	public static final int SIX_BY_TWO = 3;
	public static final int HALF_PAGE = 4;
	public static final int FULL_PAGE = 5;
		
	public Advertisement() {
		
	}

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
