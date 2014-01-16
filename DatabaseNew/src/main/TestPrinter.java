package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JPanel;

public class TestPrinter implements Printable {

	private JPanel panel;

	public TestPrinter(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// We have only one page, and 'page'
		// is zero-based
		if (pageIndex > 0) {
			return NO_SUCH_PAGE;
		}

		// User (0,0) is typically outside the
		// imageable area, so we must translate
		// by the X and Y values in the PageFormat
		// to avoid clipping.
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		double sx = 0, sy = 0;

		// Checks to see if panel won't fit within page
		if (panel.getWidth() > pageFormat.getImageableWidth() || panel.getHeight() > pageFormat.getImageableHeight()) {

			// Checks to see if panel is too wide
			if (panel.getWidth() > pageFormat.getImageableWidth()) {
				// Fits width to page
				sx = pageFormat.getImageableWidth() / panel.getWidth();

				// Checks to see if panel is too tall
				if (panel.getHeight() > pageFormat.getImageableHeight()) {
					// Fits height to page
					sy = pageFormat.getImageableHeight() / panel.getHeight();
				} else {
					// Set y to scale with x, keeping aspect ratio constant
					sy = sx;
				}
			}

			// Checks to see if panel is too tall
			else if (panel.getHeight() > pageFormat.getImageableHeight()) {
				// Fits height to page
				sy = pageFormat.getImageableHeight() / panel.getHeight();

				// Checks to see if panel is too wide
				if (panel.getWidth() > pageFormat.getImageableWidth()) {
					// Fits width to page
					sy = pageFormat.getImageableWidth() / panel.getWidth();
				} else {
					// Set x to scale with y, keeping aspect ratio constant
					sx = sy;
				}
			}

			g2d.scale(sx, sy);
		}

		// Now we perform our rendering
		// graphics.drawString("Hello world!", 100, 100);
		try {
			panel.printAll(g2d);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		// tell the caller that this page is part
		// of the printed document
		return PAGE_EXISTS;
	}
}
