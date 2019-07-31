package kr.or.yi.food_mgm_program.ui.list;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{
	
	public MyTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
}