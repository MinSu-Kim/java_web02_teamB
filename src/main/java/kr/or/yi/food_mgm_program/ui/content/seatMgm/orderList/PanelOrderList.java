package kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.food_mgm_program.dto.Food;

public class PanelOrderList extends JPanel {
	private JTable table;
	private List<Food> list;
	private String no;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	public PanelOrderList() {
	
		initComponents();
		reloadData();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.NORTH);
		
		table = new JTable();
		scrollPane.setViewportView(table);	
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		lblNewLabel = new JLabel("테이블 번호 :");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
	}
	
	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));

		tableCellAlignment(SwingConstants.CENTER, 0, 2);
		tableCellAlignment(SwingConstants.RIGHT,1,3);
		
		tableSetWidth(150, 70, 70, 70);
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
		if(list.contains(food)) {
			int a = list.indexOf(food);
			list.get(a).plusCount();
		}else {
			list.add(food);
		}
		
		reloadData();
	}
	public void resetList() {
		lblNewLabel.setText("테이블 번호 :");
		list.clear();
		reloadData();
	}
	public void selectCancel() {
		int i = table.getSelectedRow();
		list.remove(i);
		reloadData();
		
	}
	public void setPlus() {
		int i = table.getSelectedRow();
		list.get(i).plusCount();	
		reloadData();
		table.setRowSelectionInterval(i, i);
		
	}
	
	public void setMinus() {
		int i = table.getSelectedRow();
		list.get(i).minusCount();
		if(list.get(i).getCount()<1) {
			list.get(i).plusCount();
			return;
		}
		reloadData();
		table.setRowSelectionInterval(i, i);
	}
	
	public List<Food> getList(){
		return list;
	}
	
	public void setList(List<Food> list) {
		this.list = list;
		reloadData();
	}
	public void setTableNo(String no) {
		this.no = no;
		if(this.no==null) {
			this.no="";
		}
		lblNewLabel.setText("테이블 번호 : "+this.no);
		
	}
	public String getTableNo() {
		return no;
	}
	
	
	
}













