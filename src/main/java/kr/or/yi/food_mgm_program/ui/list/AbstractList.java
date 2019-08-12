package kr.or.yi.food_mgm_program.ui.list;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public abstract class AbstractList<T> extends JPanel {
	protected JTable table;
	protected List<T> itemList;
	private JScrollPane scrollPane;

	public AbstractList(String title) {
		initComponents(title);
	}

	private void initComponents(String title) {
		setBorder(new TitledBorder(null, title + "목록", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 200));
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}

	public void setPopupMenu(JPopupMenu popupMenu) {
		table.setComponentPopupMenu(popupMenu);
		scrollPane.setComponentPopupMenu(popupMenu);
	}

	public void setItemList(List<T> itemList) {
		this.itemList = itemList;
	}

	public void reloadData() {
		MyTableModel model = new MyTableModel(getRows(), getColumnNames());
		table.setModel(model);
//		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableAlignmentAndWidth();
	}

	
	protected abstract Object[][] getRows();
	protected abstract void tableAlignmentAndWidth();

	protected abstract Object[] toArray(int idx);

	protected abstract String[] getColumnNames();
	
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
	}; 

	public T getSelectedItem() {
		int i = table.getSelectedRow();
		T item = null;
		if (table.getModel().getRowCount() == 0) {
			return item;
		}
		if (i < 0 || i > table.getModel().getRowCount() - 1) {
			JOptionPane.showMessageDialog(null, "선택된 부서가 없습니다.");
			return item;
		}

		item = itemList.get(i);
		return item;
	}
	public JTable getTable() {
		return table;
	}
}
