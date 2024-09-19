package DetoxProduct;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Constructors.DetoxAndOrderdetail;
import Constructors.Product;

public class TodaySaleTableModel extends AbstractTableModel {

	String title[]= {"No.","Name","Size","quantity","Price"};
	ArrayList<DetoxAndOrderdetail>data =new ArrayList<DetoxAndOrderdetail>();
	public TodaySaleTableModel(ArrayList<DetoxAndOrderdetail>p) {
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
		DetoxAndOrderdetail pro=data.get(row);
		switch(col) {
		case 0:return  row+1;
		case 1:return pro.getName();
		case 2:return pro.getSize();
		case 3:return pro.getQuantity();
		case 4:return pro.getPrice();
		}
		return null;
	}
	
	
		public void removeRow(int row) {
	        if (row >= 0 && row < data.size()) {
	            data.remove(row); 
	            fireTableRowsDeleted(row, row);  
	        }
	    }

	 public DetoxAndOrderdetail getProduct(int index) {
	        if (index >= 0 && index < data.size()) {
	            return data.get(index);
	        } else {
	            return null;
	        }
	    }
	


	
	

}
