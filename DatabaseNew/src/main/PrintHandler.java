package main;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JPanel;

public class PrintHandler {

	/**
	 * Prints the panel.
	 */
	public static void printPanel(JPanel panel) {
		PrinterJob job = PrinterJob.getPrinterJob();

		job.setPrintable(new TestPrinter(panel));

		boolean doPrint = job.printDialog();

		if (doPrint) {
			try {
				job.print();
			} catch (PrinterException e) {
				// Printing failed
			}
		}

	}

}
