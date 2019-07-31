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
import kr.or.yi.food_mgm_program.service.PanelCurrentReservationService;
import kr.or.yi.food_mgm_program.ui.content.statistics.DateLabelFormatter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class PanelCurrentReservation extends JPanel implements ActionListener {
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmPopDelete;
	private JMenuItem mntmPopUpdate;
	private List<Reservation> rsvList;
	private JPanel panel;
	private JDatePickerImpl datePicker;
	private JButton btnNewButton;
	private PanelCurrentReservationService service;
	private PanelInputReservation pInput;
	
	public PanelCurrentReservation() {
		service = PanelCurrentReservationService.getInstance();
		rsvList = service.selectByTime();
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);		
		
		popupMenu = new JPopupMenu();
		
		mntmPopUpdate = new JMenuItem("수정");
		mntmPopUpdate.addActionListener(this);
		popupMenu.add(mntmPopUpdate);
		
		mntmPopDelete = new JMenuItem("삭제");
		mntmPopDelete.addActionListener(this);
		popupMenu.add(mntmPopDelete);

		table.setComponentPopupMenu(popupMenu);
		scrollPane.setComponentPopupMenu(popupMenu);
		
		reloadData();
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		// jdatepicker 생성
		UtilDateModel model = new UtilDateModel();

		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panel.add(datePicker);
		
		btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		
	}
	
	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));

		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5,6,7);
		tableSetWidth(50,100,150,100,150,100,150,150);
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
		return new String[] { "회원번호", "회원명", "전화번호", "인원", "시간","테이블 번호", "예약등록날짜", "수정날짜"};
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
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == mntmPopUpdate) {
			try {
				actionPerformedmntmPopUpdate();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == mntmPopDelete) {
			try {
				actionPerformedmntmPopDelete();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
	
	private void actionPerformedmntmPopDelete() throws ParseException {
		int i = table.getSelectedRow();
		String time = (String) table.getModel().getValueAt(i, 4);
		String tableNo = (String) table.getModel().getValueAt(i, 5);
		Reservation rsv = new Reservation();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		rsv.setRsvTime(sd.parse(time));
		rsv.setRsvTableNo(tableNo);
		
		int a = JOptionPane.showConfirmDialog(null, "예약을 취소하시겠습니까?");
		if(a==0) {
			service.deleteRsv(rsv);
			rsvList = service.selectByTime();
			reloadData();
		}else {
			return;
		}
		
		
		
		
		
	}
	private void actionPerformedmntmPopUpdate() throws ParseException {
		int i = table.getSelectedRow();
		String time = (String) table.getModel().getValueAt(i, 4);
		String tableNo = (String) table.getModel().getValueAt(i, 5);
		Reservation rsv = new Reservation();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		rsv.setRsvTime(sd.parse(time));
		rsv.setRsvTableNo(tableNo);
		
	}
	public void setList(List<Reservation> rsvlist) {
		this.rsvList = rsvlist;
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
	
	
	public void setPInput(PanelInputReservation pinput) {
		this.pInput = pinput;
	}
}















