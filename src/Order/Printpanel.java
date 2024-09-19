package Order;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JPanel;

public class Printpanel implements Printable{
	
	
	
	private JPanel panel;

    public Printpanel(JPanel panel) {
        this.panel = panel;
    }
	

	@Override
	public int print(Graphics g, PageFormat format, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		if (pageIndex > 0) {
            return NO_SUCH_PAGE;
	}
		
		
		 Graphics2D g2d = (Graphics2D) g;
	        g2d.translate(format.getImageableX(), format.getImageableY());

	        //  to fit the page
	        double panelWidth = panel.getWidth();
	        double panelHeight = panel.getHeight();
	        double pageWidth = format.getImageableWidth();
	        double pageHeight = format.getImageableHeight();
	        double scaleX = pageWidth / panelWidth;
	        double scaleY = pageHeight / panelHeight;
	        double scale = Math.min(scaleX, scaleY);
	        g2d.scale(scale, scale);

	        panel.paint(g2d);
	        return PAGE_EXISTS;
	    }

}
