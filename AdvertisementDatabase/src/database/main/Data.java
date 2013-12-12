package database.main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Data {
	public static ArrayList<Business> businessList = new ArrayList<Business>();
	private static FileWriter writer;
	private static BufferedReader reader;
	private static Scanner scanner;

	public Data() {
		writer = null;
		reader = null;
		scanner = null;
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
