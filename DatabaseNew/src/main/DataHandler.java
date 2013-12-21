package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHandler {
	public static ArrayList<Business> businessList = new ArrayList<Business>();
	public static int currentBusiness;
	private static FileWriter writer;
	private static BufferedReader reader;
	private static Scanner scanner;

	public DataHandler() {
		businessList = new ArrayList<Business>();
		businessList.add(new Business("Steve's", "", "", "", "", "", ""));
		currentBusiness = 0;
		writer = null;
		reader = null;
		scanner = null;
	}

	public static void addBusiness(String[] text) {
		businessList.add(new Business(text));
		System.out.println(businessList);
	}

	public static void addBusiness(String[] text, ArrayList<Advertisement> ads) {
		businessList.add(new Business(text, ads));
	}

	public static void previousBusiness() {
		if(currentBusiness > 0) {
			currentBusiness--;
		}
	}

	public static void nextBusiness() {
		if(currentBusiness < businessList.size() - 1) {
			currentBusiness++;
		}
	}

	public static void load() throws IOException {
		String[] arguments = new String[] {};

		try {
			reader = new BufferedReader(new FileReader("data.csv"));

			String line;
			while((line = reader.readLine()) != null) {
				arguments = line.split(",");
				businessList.add(new Business(arguments));
				//System.out.println(arguments.toString());
			}

			for(String s : arguments) {
				//System.out.println(s);
			}


		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public static void save() throws IOException {
		try {
			writer = new FileWriter("data.csv");

			for(Business b : businessList) {
				writer.write(b.toCSV());
			}

		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

}
