package main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Business {
	private String name, address, city, state, zip, phone, email, notes;
	private ArrayList<Advertisement> advertisements;
	private Image contractImage;

	/**
	 * Use this constructor with an array of Strings of length 10.
	 * @param arguments
	 */
	public Business(String[] arguments) {
		this.name = arguments[0];
		this.address = arguments[1];
		this.city = arguments[2];
		this.state = arguments[3];
		this.zip = arguments[4];
		this.phone = arguments[5];
		this.email = arguments[6];
		this.notes = arguments[7];

		if (!arguments[8].equals("<NO IMAGE>")) {
			try {
				BufferedImage img = ImageIO.read(new File(arguments[8]));
				this.contractImage = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		setAdvertisements(new ArrayList<Advertisement>());

		if (arguments.length > 9) {
			String[] adList = new String[] {};
			adList = arguments[9].split("ad:");

			for (String s : adList) {
				if (!s.equals("<ads>")) {
					int date = Character.getNumericValue(s.charAt(0));
					int size = Character.getNumericValue(s.charAt(1));
					int price = Character.getNumericValue(s.charAt(2));
					advertisements.add(new Advertisement(date, size, price, 0));
				}
			}
		}
	}

	/**
	 * Use this constructor with an array of Strings of length 7, and an ArrayList of Advertisements.
	 * @param arguments
	 * @param ads
	 */
	public Business(String[] arguments, ArrayList<Advertisement> ads) {
		this.name = arguments[0];
		this.address = arguments[1];
		this.city = arguments[2];
		this.state = arguments[3];
		this.zip = arguments[4];
		this.phone = arguments[5];
		this.email = arguments[6];

		setAdvertisements(ads);
	}

	/**
	 * Returns a string "&lt;NULL&gt;" if s is null or empty.
	 * @param s
	 */
	public String formatNull(String s) {
		if (s == null || s.equals("")) {
			return "<NULL>";
		}

		return s;
	}

	/**
	 * Returns a string "&lt;NO IMAGE&gt;" if img is null or empty.
	 * @param img
	 */
	private String formatNull(Image img) {
		if (img == null) {
			return "<NO IMAGE>";
		}

		return formatNull(name) + ".png";
	}

	/**
	 * Returns a string with the contact information of the business.
	 */
	public String toString() {
		return "Name: " + name + " Address: " + address + " City: " + city + " State: " + state + " ZIP: " + zip
				+ " Phone: " + phone + " Email: " + email;
	}

	/**
	 * Returns a comma-separated value format of the business for saving data.
	 */
	public String toCSV() {
		String delimiter = ",";
		String newline = "\r\n";

		String adString = "<ads>";
		for (Advertisement ad : advertisements) {
			adString += "ad:";
			adString += ad.getDate();
			adString += ad.getSize();
			adString += ad.getPrice();
			adString += ad.getPaid();
		}

		return formatNull(name) + delimiter + formatNull(address) + delimiter + formatNull(city) + delimiter
				+ formatNull(state) + delimiter + formatNull(zip) + delimiter + formatNull(phone) + delimiter
				+ formatNull(email) + delimiter + formatNull(notes) + delimiter + formatNull(contractImage) + delimiter
				+ adString + newline;
	}

	/**
	 * Sets the contact information to arguments.
	 * @param arguments a String array of length 7.
	 */
	public void setInfo(String[] arguments) {
		this.name = arguments[0];
		this.address = arguments[1];
		this.city = arguments[2];
		this.state = arguments[3];
		this.zip = arguments[4];
		this.phone = arguments[5];
		this.email = arguments[6];
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ArrayList<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(ArrayList<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public Image getContractImage() {
		return contractImage;
	}

	public void setContractImage(Image contractImage) {
		this.contractImage = contractImage;
	}

}
