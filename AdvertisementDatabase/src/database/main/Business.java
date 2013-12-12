package database.main;

import java.util.ArrayList;

public class Business {
	private String name, address, city, state, zip, phone, email;
	private ArrayList<Advertisement> advertisements;

	public Business() {
		
	}

	public Business(String name, String address, String city, String state,
			String zip, String phone, String email) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		
		setAdvertisements(new ArrayList<Advertisement>());
	}

	public Business(String[] arguments) {
		super();
		this.name = arguments[0];
		this.address = arguments[1];
		this.city = arguments[2];
		this.state = arguments[3];
		this.zip = arguments[4];
		this.phone = arguments[5];
		this.email = arguments[6];
		
		setAdvertisements(new ArrayList<Advertisement>());
	}

	public String formatNull(String s) {
		if(s.equals("")) {
			return "<NULL>";
		}

		return s;
	}

	public String toString() {
		return "Name: " + name + " Address: " + address + " City: " + city + " State: " + state + " ZIP: " + zip + " Phone: " + phone + " Email: " + email;
	}

	public String toCSV() {
		String delimiter = ",";
		String newline = "\r\n";
		return formatNull(name) + delimiter + formatNull(address) + delimiter + formatNull(city) + delimiter
				+ formatNull(state) + delimiter + formatNull(zip) + delimiter + formatNull(phone) + delimiter + formatNull(email) + newline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(ArrayList<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

}
