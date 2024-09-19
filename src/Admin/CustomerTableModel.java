package Admin;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Constructors.Customer;



public class CustomerTableModel extends AbstractTableModel  {
	
	
String title[]= {"ID","Name","Gender","Phone NO","Email"};
	
	ArrayList<Customer>data =new ArrayList<Customer>();
	public CustomerTableModel(ArrayList<Customer>cus) {
		data=cus;
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
		
		Customer pro=data.get(row);
		switch(col) {
		case 0:return pro.getId();
		case 1:return pro.getName();
		case 2:return pro.getGender();
		case 3:return pro.getPhno();
		case 4:return pro.getEmail();
		}
		return null;
	}

	 public void removeRow(int row) {
	        if (row >= 0 && row < data.size()) {
	            data.remove(row); 
	            fireTableRowsDeleted(row, row);  
	        }
	    }

	 public Customer getProduct(int index) {
	        if (index >= 0 && index < data.size()) {
	            return data.get(index);
	        } else {
	            return null;
	        }
	    }
}
