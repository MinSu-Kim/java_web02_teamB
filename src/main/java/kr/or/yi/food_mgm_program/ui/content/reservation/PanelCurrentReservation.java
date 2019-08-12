package kr.or.yi.food_mgm_program.ui.content.reservation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Reservation;
import kr.or.yi.food_mgm_program.service.PanelCurrentReservationService;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.PanelMain;
import kr.or.yi.food_mgm_program.ui.content.statistics.DateLabelFormatter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class PanelCurrentReservation extends JPanel implements ActionListener{
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmPopDelete;
	private JMenuItem mntmPopUpdate;
	private List<Reservation> rsvList;
	private JPanel panel;
	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker2;
	private JButton btnDate;
	private PanelCurrentReservationService service;
	private PanelInputReservation pInput;
	private JTextField tfTel;
	private JButton btnTel;
	private PanelMain pSeat;
	private JButton btnRemain;
	private JButton btnAll;
	private JLabel lblNewLabel;
	public PanelCurrentReservation(PanelMain pSeat) {
		this.pSeat = pSeat;
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
		
		mntmPopUpdate = new JMenuItem("예약수정");
		mntmPopUpdate.addActionListener(this);
		popupMenu.add(mntmPopUpdate);
		
		mntmPopDelete = new JMenuItem("예약취소");
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
		
		lblNewLabel = new JLabel("~");
		panel.add(lblNewLabel);
		
		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		panel.add(datePicker2);
		
		btnDate = new JButton("날짜로 검색");
		btnDate.addActionListener(this);
		panel.add(btnDate);
		
		tfTel = new JTextField();
		tfTel.addActionListener(this);
		
		panel.add(tfTel);
		tfTel.setColumns(10);
		
		btnTel = new JButton("전화번호로 검색");
		btnTel.addActionListener(this);
		panel.add(btnTel);
		
		btnRemain = new JButton("오늘남은예약보기");
		btnRemain.addActionListener(this);
		panel.add(btnRemain);
		
		btnAll = new JButton("전체예약보기");
		btnAll.addActionListener(this);
		panel.add(btnAll);
		
		
	}
	
	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));

		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5,6,7, 8);
		tableSetWidth(70,80,150,100,150,80,130,130, 80);
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
		return new String[] { "회원번호", "회원명", "전화번호", "인원", "예약시간","테이블 번호", "예약등록날짜", "변경날짜", "예약상태"};
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
		
		for (int i = 0; i < getColumnNames().length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new ReturnTableCellRenderer());
		}
		
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	@SuppressWarnings("serial")
	public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (value==null) return this;
			setText(value.toString());
			setOpaque(true);
			
			setHorizontalAlignment(JLabel.CENTER);
		
			if (table.getValueAt(row, 8).toString().equals("취소")) {
				setForeground(Color.RED);
			}else {
				setForeground(Color.BLACK);
			}
			if (isSelected) {
				setBackground(new Color(57, 105, 138));
			}else {
				setBackground(Color.WHITE);
			}
			return this;
		}
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfTel) {
			actionPerformedTfTel(e);
		}
		if (e.getSource() == btnTel) {
			actionPerformedBtnTel(e);
		}
		if (e.getSource() == btnDate) {
			try {
				actionPerformedBtnDate(e);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		if(e.getSource() == btnRemain) {
			actionPerformedBtnRemain();
		}
		
		if(e.getSource() == btnAll) {
			actionPerformedBtnAll();
		}
		
	}
	
	private void actionPerformedBtnAll() {
		Member member = new Member();
		member.setMbTel("");
		List<Reservation> list = service.selectByTel(member);
		this.rsvList = list;
		setClear();
		reloadData();
		
	}
	private void actionPerformedBtnRemain() {
		rsvList = service.selectByTime();
		reloadData();
		
	}
	private void actionPerformedmntmPopDelete() throws ParseException {
		int i = table.getSelectedRow();
		String time = (String) table.getModel().getValueAt(i, 4);
		String tableNo = (String) table.getModel().getValueAt(i, 5);
		String tableCurrent = (String) table.getModel().getValueAt(i, 8);
		
		if(tableCurrent.equals("취소")) {
			JOptionPane.showMessageDialog(null, "이미 취소된 예약입니다.");
			return;
		}
		
		Reservation rsv = new Reservation();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		rsv.setRsvTime(sd.parse(time));
		rsv.setRsvTableNo(tableNo);
		rsv.setRsvUpdateTime(new Date());
		rsv.setRsvCancel(true);
		
		
		int a = JOptionPane.showConfirmDialog(null, "예약을 취소하시겠습니까?");
		
		if(a==0) {
			service.deleteRsv(rsv);
			rsvList = service.selectByTime();
			reloadData();
			pSeat.getPanelSeat().setBtnColor();
		}else {
			return;
		}
		
		
		
		
		
	}
	private void actionPerformedmntmPopUpdate() throws ParseException {
		int i = table.getSelectedRow();
		String time = (String) table.getModel().getValueAt(i, 4);
		String tableNo = (String) table.getModel().getValueAt(i, 5);
		String time2 = (String) table.getModel().getValueAt(i, 6);
		String tableCurrent = (String) table.getModel().getValueAt(i, 8);
		
		if(tableCurrent.equals("취소")) {
			JOptionPane.showMessageDialog(null, "취소된 예약은 수정할 수 없습니다.");
			return;
		}
		
		Reservation rsv = new Reservation();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		rsv.setRsvTime(sd.parse(time));
		rsv.setRsvTableNo(tableNo);
		rsv.setRsvInputTime(sd.parse(time2));
		
		
		Reservation reservation = service.selectByTimeTable(rsv);
		
		pInput.setTf(reservation, rsv);
		
		
		
		
	}
	public void setList(List<Reservation> rsvlist) {
		this.rsvList = rsvlist;
	}
	protected void actionPerformedBtnDate(ActionEvent e) throws ParseException {
		String date = datePicker.getJFormattedTextField().getText();
		String date2 = datePicker2.getJFormattedTextField().getText();
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		
		if(sd.parse(date).getTime()>sd.parse(date2).getTime()) {
			JOptionPane.showMessageDialog(null, "검색시작 날짜 이후만 선택가능합니다.");
		}
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", date);
		map.put("date2", date2);
		rsvList = service.selectByRangeDate(map);
		setClear();
		reloadData();
	}
	
	
	public void setPInput(PanelInputReservation pinput) {
		this.pInput = pinput;
	}
	protected void actionPerformedBtnTel(ActionEvent e) {
		searchPhone();
		
	}
	
	protected void actionPerformedTfTel(ActionEvent e) {
		searchPhone();
	}
	public void setClear() {
		tfTel.setText("");
		datePicker.getJFormattedTextField().setText("");
		datePicker2.getJFormattedTextField().setText("");
	}
	
	private void searchPhone() {
		String tel = tfTel.getText();
		Member member = new Member();
		member.setMbTel(tel);
		List<Reservation> list = service.selectByTel(member);
		
		if(list.size()==0) {
			JOptionPane.showMessageDialog(null, "없는 번호 입니다.");
			tfTel.setText("");
			return;
		}
		
		this.rsvList = list;
		setClear();
		reloadData();
	}
	
}















