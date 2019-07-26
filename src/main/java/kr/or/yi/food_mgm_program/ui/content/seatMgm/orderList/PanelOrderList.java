package kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.food_mgm_program.dto.Food;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

public class PanelOrderList extends JPanel {
	private JTable table;
	private List<Food> list;
	public PanelOrderList() {

		initComponents();
		reloadData();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);	
	}
	
	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));

		tableCellAlignment(SwingConstants.CENTER, 0, 2);
		tableCellAlignment(SwingConstants.RIGHT,1,3);
		
		tableSetWidth(100, 100, 50, 100);
	}

	private Object[][] getRows() {
		if(list==null) {
			list = new ArrayList<Food>();
		}
		Object[][] rows = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rows[i] = list.get(i).toArray();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] { "메뉴명", "단가", "수량", "금액"};
	}

	// 테이블 셀 내용의 정렬
	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 테이블 셀의 폭 설정
	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	public void setList(Food food) {
		list.add(food);
	}
}
