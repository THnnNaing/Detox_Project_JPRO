package Constructors;

import java.awt.Image;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import Customer.Customer;
import Constructors.Product;



public class OrderTableModel extends AbstractTableModel{
	String title[]= {"Image","Name","Size","Price","Ingredients"};
	
	ArrayList<Product>data =new ArrayList<Product>();
	public OrderTableModel(ArrayList<Product>pro) {
		data=pro;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Product p=data.get(row);
		switch(col) {
		case 0:byte[] imageBytes = p.getImage();
        if (imageBytes != null) {
            return new ImageIcon(new ImageIcon(imageBytes).getImage().getScaledInstance(155, 100, Image.SCALE_SMOOTH));
        } else {
            return null;
        }
		case 1:return p.getName();
		case 2:return p.getSize();
		case 3:return p.getPrice();
		case 4:return p.getIngredients();
		}
		
		return null;
	}
	
	 public void removeRow(int row) {
	        if (row >= 0 && row < data.size()) {
	            data.remove(row); 
	            fireTableRowsDeleted(row, row);  
	        }
	    }
}
