package Admin;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import Constructors.Staff;

public class StaffTableModel extends AbstractTableModel {

	String title[] = { "No,", "Name", "Gender", "Phno", "Position" };

	ArrayList<Staff> data = new ArrayList<Staff>();

	public StaffTableModel(ArrayList<Staff> s) {
		data = s;
	}

	public String getColumnName(int col) {
		return title[col];
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Staff pro = data.get(row);
		switch (col) {
		case 0:
			return pro.getId();
		case 1:
			return pro.getName();
		case 2:
			return pro.getGender();
		case 3:
			return pro.getPhno();
		case 4:
			return pro.getPosition();

		}

		return null;
	}

	public void removeRow(int row) {
		if (row >= 0 && row < data.size()) {
			data.remove(row);
			fireTableRowsDeleted(row, row);
		}
	}

	public Staff getStaff(int index) {
		if (index >= 0 && index < data.size()) {
			return data.get(index);
		} else {
			return null;
		}
	}

}
