package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataHandler {
	public static ArrayList<Business> businessList = new ArrayList<Business>();
	public static int currentBusinessIndex;
	public static int currentMonth;
	private static FileWriter writer;
	private static BufferedReader reader;

	public static void addBusiness(String[] text) {
		businessList.add(new Business(text));
	}

	public static void addBusiness(String[] text, ArrayList<Advertisement> ads) {
		businessList.add(new Business(text, ads));
	}

	public static Business getCurrentBusiness() {
		return businessList.get(currentBusinessIndex);
	}

	public static void previousBusiness() {
		if (currentBusinessIndex > 0) {
			currentBusinessIndex--;
		}
	}

	public static void nextBusiness() {
		if (currentBusinessIndex < businessList.size() - 1) {
			currentBusinessIndex++;
		}
	}

	public static void load() throws IOException {
		String[] arguments = new String[] {};

		try {
			reader = new BufferedReader(new FileReader("data.csv"));

			String line;
			while ((line = reader.readLine()) != null) {
				arguments = line.split(",");
				businessList.add(new Business(arguments));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public static void save() throws IOException {
		try {
			writer = new FileWriter("data.csv");

			for (Business b : businessList) {
				writer.write(b.toCSV());
			}

		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

}
