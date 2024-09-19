package Order;

import java.util.ArrayList;
import Constructors.Order;

import javax.swing.table.AbstractTableModel;

public class OrderListTableModel extends AbstractTableModel{
	
	
	String title[]={"No.","Customer Name","Staff Name","Date"};
	ArrayList<Order> order=new ArrayList<Order>();
	public OrderListTableModel(ArrayList<Order> p){
		order=p;
	}

	public String getColumnName(int col) {
		return title[col];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return order.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		if (row >= order.size() || row < 0) {
            return null;
        }
		Order in=order.get(row);
		switch(col){
		case 0:return row+1;
		case 1:return in.getCname();
		case 2:return in.getSname();
		case 3:return in.getOrderDate();
		//case 4:return in.getNote();
		}
		return null;
	
	}

}
