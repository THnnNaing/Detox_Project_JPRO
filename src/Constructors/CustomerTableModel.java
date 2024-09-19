package Constructors;

import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;



public class CustomerTableModel extends AbstractTableModel {
	String title[]= {"No.","Name","Date Of Birth","Gender","Phone NO","Address","Email"};
	
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
		
		Customer c=data.get(row);
		switch(col) {
		case 0:return c.getId();
		case 1:return c.getName();
		case 2:return c.getDob();
		case 3:return c.getGender();
		case 4:return c.getPhno();
		case 5:return c.getAddress();
		case 6:return c.getEmail();
		
		
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
