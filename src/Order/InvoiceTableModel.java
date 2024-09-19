package Order;

import java.util.ArrayList;



import javax.swing.table.AbstractTableModel;

import Constructors.Invoice;



public class InvoiceTableModel extends AbstractTableModel {
	
	
	
	
	String title[]={"No.","Product","Size","Price","Qty"};
	ArrayList<Invoice> c=new ArrayList<Invoice>();
	
	public InvoiceTableModel(ArrayList<Invoice> arrayList){
		c=arrayList;
	}
	
	


	public String getColumnName(int col){
		return title[col];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return c.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		
		if (row >= c.size() || row < 0) {
            return null;
        }
		Invoice in=c.get(row);
		switch(col){
		case 0:return row+1;
		case 1:return in.getDetoxName();
		case 2:return in.getSize();
		case 3:return in.getPrice();
		case 4:return in.getQuantity();
		
		
		//case 5:return (in.getPrice()*in.getQuantity());
		}
		
	
		return null;
	}
	
	

	 public void setInvoices(ArrayList<Invoice> invoices) {
	        this.c.clear();
	        this.c.addAll(invoices);
	        fireTableDataChanged();
	    }

}
