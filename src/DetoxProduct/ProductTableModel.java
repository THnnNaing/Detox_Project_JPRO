package DetoxProduct;

import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;

import Constructors.Product;

public class ProductTableModel extends AbstractTableModel {
	String title[]= {"No.","Name","Size","Price"};
	
	ArrayList<Product>data =new ArrayList<Product>();
	public ProductTableModel(ArrayList<Product>p) {
		data=p;
	}
	
	public String getColumnName(int col) {
		return title[col];
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
		Product pro=data.get(row);
		switch(col) {
		case 0:return pro.getDetoxID();
		case 1:return pro.getName();
		case 2:return pro.getSize();
		case 3:return pro.getPrice();
		
	
		}
		
		return null;
	}
	 public void removeRow(int row) {
	        if (row >= 0 && row < data.size()) {
	            data.remove(row); 
	            fireTableRowsDeleted(row, row);  
	        }
	    }

	 public Product getProduct(int index) {
	        if (index >= 0 && index < data.size()) {
	            return data.get(index);
	        } else {
	            return null;
	        }
	    }
	
}

