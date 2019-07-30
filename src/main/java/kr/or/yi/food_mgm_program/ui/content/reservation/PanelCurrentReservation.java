package kr.or.yi.food_mgm_program.ui.content.reservation;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.food_mgm_program.dto.Reservation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PanelCurrentReservation extends JPanel implements ActionListener {
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmPopDelete;
	private List<Reservation> rsvList;
	private JPanel panel;
	
	public PanelCurrentReservation() {
		
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);		
		
		popupMenu = new JPopupMenu();

		mntmPopDelete = new JMenuItem("삭제");
		mntmPopDelete.addActionListener(this);
		popupMenu.add(mntmPopDelete);

		table.setComponentPopupMenu(popupMenu);
		scrollPane.setComponentPopupMenu(popupMenu);
		
		reloadData();
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		
	}
	
	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));

		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);
		tableSetWidth(50,100,150,100,150,100);
	}

	private Object[][] getRows() {
		if(rsvList ==null) {
			rsvList = new ArrayList<Reservation>();
		}
		Object[][] rows = new Object[rsvList.size()][];
		for (int i = 0; i < rsvList.size(); i++) {
			rows[i] = rsvList.get(i).toArray();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] { "회원번호", "회원명", "전화번호", "인원", "시간","테이블 번호"};
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setList(List<Reservation> rsvlist) {
		this.rsvList = rsvlist;
	}
	

}
