package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataHandler {
	public static final String CONFIG_HEADER = "adBase v0.1 --CONFIGURATION--";

	public static ArrayList<Business> businessList = new ArrayList<Business>();
	public static int currentBusinessIndex;
	public static int currentMonth;
	public static int year;
	public static String currentReadFile;
	private static FileWriter configWriter;
	private static BufferedReader configReader;
	private static FileWriter writer;
	private static BufferedReader reader;

	public static void addBusiness(String[] text) {
		businessList.add(new Business(text));
	}

	public static void addBusiness(String[] text, ArrayList<Advertisement> ads) {
		businessList.add(new Business(text, ads));
	}

	public static Business getCurrentBusiness() {
		if (businessList.isEmpty())
			return null;
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
			configReader = new BufferedReader(new FileReader("adBase\\config.txt"));

			String line;
			while ((line = configReader.readLine()) != null) {
				if (!line.equals(CONFIG_HEADER)) {
					currentReadFile = line;
				}
			}

			if (currentReadFile != null) {
				reader = new BufferedReader(new FileReader(currentReadFile));

				while ((line = reader.readLine()) != null) {
					if (line.startsWith("<HEAD>")) {
						try {
							year = Integer.parseInt(line.substring(7, 11));
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						arguments = line.split(",");
						businessList.add(new Business(arguments));
					}
				}
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
			File directory = new File("adBase");
			if (!directory.exists()) {
				directory.mkdirs();
			}

			configWriter = new FileWriter("adBase\\config.txt");

			configWriter.write(CONFIG_HEADER + "\r\n");

			if (currentReadFile != null)
				configWriter.write(currentReadFile + "\r\n");

			if (currentReadFile != null) {
				writer = new FileWriter(currentReadFile);

				writer.write("<HEAD> " + year + "\r\n");

				for (Business b : businessList) {
					writer.write(b.toCSV());
				}
			}

		} finally {
			if (configWriter != null) {
				configWriter.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

}
