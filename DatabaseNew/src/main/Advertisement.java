package main;

public class Advertisement {
	public static final String[] MONTHS = new String[] {"September", "October", "November", "December", "January", "February", "March", "April"};
	public static final String[] SIZES = new String[] {"2x4", "4x2", "4x4", "6x2", "Half Page", "Full Page"};
	public static final String[] PRICES = new String[] {"$30", "$60", "$45", "$360", "$720"};

	private int date;
	private int size;
	private int price;
	private boolean paid;

	public Advertisement() {

	}

	public Advertisement(int date, int size, int price, boolean paid) {
		super();
		this.date = date;
		this.size = size;
		this.price = price;
		this.paid = paid;
	}

	public Advertisement(String month, Object size, Object price, Object paid) {
		this.date = getMonthNum(month);
		this.size = getSizeNum(size);
		this.price = getPriceNum(price);
		this.paid = getPaidBoolean(paid);
	}

	

	public int getMonthNum(String month) {
		for (int i = 0; i < MONTHS.length; i++) {
			if(MONTHS[i].equals(month)) {
				return i;
			}
		}
		
		return -1;
	}

	public int getSizeNum(Object size) {
		for (int i = 0; i < SIZES.length; i++) {
			if(SIZES[i].equals(size)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int getPriceNum(Object price) {
		for (int i = 0; i < PRICES.length; i++) {
			if(PRICES[i].equals(size)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean getPaidBoolean(Object paid) {
		System.out.println(paid);
		return false;
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
