package kr.or.yi.food_mgm_program.ui.content.reservation;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Reservation;
import kr.or.yi.food_mgm_program.service.PanelReservationService;
import kr.or.yi.food_mgm_program.ui.content.PanelMember;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.PanelMain;

import javax.swing.BoxLayout;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class PanelInputReservation extends JPanel implements ActionListener, FocusListener{
	private JTextField tfMemberNo;
	private JTextField tfMemberName;
	private JTextField tfTel;
	private JTextField tfPeopleNumber;
	private JComboBox<String> cbTableNo;
	private JButton btnAdd;
	private String[] table = {"no.1","no.2","no.3","no.4","no.5","no.6","no.7"};
	private JButton btnCancel;
	private PanelReservationService service;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextField tfYear;
	private JLabel lblNewLabel_6;
	private JTextField tfMonth;
	private JLabel lblNewLabel_7;
	private JTextField tfDay;
	private JLabel lblNewLabel_8;
	private JTextField tfHour;
	private JLabel lblNewLabel_9;
	private JTextField tfMinute;
	private JLabel lblNewLabel_10;
	private PanelCurrentReservation pCR;
	private PanelMember pMember;
	private Reservation reservation;
	private PanelMain pSeat;
	
	public PanelInputReservation(PanelMember pMember, PanelMain pSeat) {
		this.pMember = pMember;
		this.pSeat = pSeat;
		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(100, 20, 100, 20));
		setLayout(new GridLayout(0, 2, 0, 25));
		
		JLabel lblNewLabel = new JLabel("회원번호");
		lblNewLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel);
		
		tfMemberNo = new JTextField();
		tfMemberNo.setFont(new Font("Dialog", Font.BOLD, 15));
		add(tfMemberNo);
		tfMemberNo.setColumns(10);
		tfMemberNo.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("회원명");
		lblNewLabel_1.setBorder(new EmptyBorder(20, 20, 20, 20));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel_1);
		
		tfMemberName = new JTextField();
		tfMemberName.setFont(new Font("Dialog", Font.BOLD, 15));
		tfMemberName.addActionListener(this);
		add(tfMemberName);
		tfMemberName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("전화번호");
		lblNewLabel_2.setBorder(new EmptyBorder(20, 20, 20, 20));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel_2);
		
		tfTel = new JTextField("");
		tfTel.addFocusListener(this);
		tfTel.setFont(new Font("Dialog", Font.BOLD, 15));
		tfTel.addActionListener(this);
		add(tfTel);
		tfTel.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("인원");
		lblNewLabel_3.setBorder(new EmptyBorder(20, 20, 20, 20));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel_3);
		
		tfPeopleNumber = new JTextField();
		tfPeopleNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		add(tfPeopleNumber);
		tfPeopleNumber.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("시간");
		lblNewLabel_4.setBorder(new EmptyBorder(20, 20, 20, 20));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel_4);
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 10, 5));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		tfYear = new JTextField();
		tfYear.setFont(new Font("Dialog", Font.BOLD, 15));
		tfYear.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(tfYear);
		tfYear.setColumns(10);
		
		lblNewLabel_6 = new JLabel(" 년");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_1.add(lblNewLabel_6);
		
		tfMonth = new JTextField();
		tfMonth.setFont(new Font("Dialog", Font.BOLD, 15));
		tfMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(tfMonth);
		tfMonth.setColumns(10);
		
		lblNewLabel_7 = new JLabel(" 월");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_1.add(lblNewLabel_7);
		
		tfDay = new JTextField();
		tfDay.setFont(new Font("Dialog", Font.BOLD, 15));
		tfDay.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(tfDay);
		tfDay.setColumns(10);
		
		lblNewLabel_8 = new JLabel(" 일");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_1.add(lblNewLabel_8);
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		tfHour = new JTextField();
		tfHour.setFont(new Font("Dialog", Font.BOLD, 15));
		tfHour.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(tfHour);
		tfHour.setColumns(10);
		
		lblNewLabel_9 = new JLabel(" 시");
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_2.add(lblNewLabel_9);
		
		tfMinute = new JTextField();
		tfMinute.setFont(new Font("Dialog", Font.BOLD, 15));
		tfMinute.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(tfMinute);
		tfMinute.setColumns(10);
		
		lblNewLabel_10 = new JLabel(" 분");
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_5 = new JLabel("테이블번호");
		lblNewLabel_5.setBorder(new EmptyBorder(20, 20, 20, 20));
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel_5);
		
		cbTableNo = new JComboBox<String>(table);
		cbTableNo.setFont(new Font("Dialog", Font.BOLD, 15));
		cbTableNo.setSelectedIndex(-1);
		add(cbTableNo);
		
		btnAdd = new JButton("등록");
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 15));
		btnAdd.addActionListener(this);
		add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 15));
		add(btnCancel);
		
		actionPerformedBtnNewButton_1();
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnNewButton_1();
		}
		if (e.getSource() == tfTel) {
			actionPerformedTfTel();
		}
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand().equals("등록")) {
				try {
					actionPerformedBtnNewButton();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				try {
					actionPerformedBtnUdate();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		if (e.getSource() == tfMemberName) {
			actionPerformedTfMemberName();
		}
	}
	
	protected void actionPerformedTfMemberName() {
		JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
	}
	
	protected void actionPerformedTfTel() {
		String name = tfMemberName.getText();
		String tel = tfTel.getText();
		Member member = new Member(name, tel);
		Member memberNo = service.selectByNameTel(member);
		if(memberNo==null) {
			tfMemberNo.setText(String.format("N%03d", service.selectListSize()));
		}else if(memberNo.getMbBirth()==null) {
			tfMemberNo.setText(String.format("N%03d", memberNo.getMbNo()));
		}
		else {
			tfMemberNo.setText(String.format("M%03d", memberNo.getMbNo()));
		}
		
	}
	
	protected void actionPerformedBtnNewButton() throws ParseException {
		int mbNo = Integer.parseInt(tfMemberNo.getText().substring(1));//회원번호
		
		String name = tfMemberName.getText(); //회원 이름
		String tel = tfTel.getText(); //전화번호
		Member member = new Member(mbNo); // 회원 번호 등록할 멤버 객체
		member.setMbName(name);
		member.setMbTel(tel);
		int rsvNumber =  Integer.parseInt(tfPeopleNumber.getText()); // 예약 인원
		String year = tfYear.getText();
		String month =tfMonth.getText();
		String day =tfDay.getText();
		String hour =tfHour.getText();
		String minute =tfMinute.getText();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		Date date =  sd.parse(year+"-"+month+"-"+day+" "+hour+":"+minute); //  예약시간
		String tableNo = (String) cbTableNo.getSelectedItem(); // 테이블 번호
		
		Date date2 = new Date(); // 예약 등록 시간
		
		Reservation rsv = new Reservation(rsvNumber, date, date2, null, member, tableNo, false);
		
		List<Reservation> list = service.selectByRangeTime(rsv);
		
		for(Reservation rssv : list) {
			if(rssv.getRsvTableNo().equals(tableNo)) {
				JOptionPane.showMessageDialog(null, "해당시간에 좌석이 예약되어있습니다.");
				return;
			}
			
		}
		Member search = new Member();
		search.setMbTel(tel);
		if(tfMemberNo.getText().substring(0, 1).equals("N")) {
			if(service.selectByTel(search)==null) {
				service.insertMember(member);
			}
			
		}
		
		service.insertRsv(rsv);
		JOptionPane.showMessageDialog(null, "예약 완료");
		actionPerformedBtnNewButton_1();
		pCR.setList(service.selectByTime());
		pCR.setClear();
		pMember.reloadList();
		pCR.reloadData();
		
		pSeat.getPanelSeat().setBtnColor();
		
	}
	
	protected void actionPerformedBtnNewButton_1() {
		tfMemberNo.setText("");
		tfMemberName.setText("");
		tfPeopleNumber.setText("");
		Date date = new Date();
		tfTel.setText("입력 후 엔터");
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
		String d = sd.format(date);
		tfYear.setText(d.substring(0, 4));
		tfMonth.setText(d.substring(4, 6));
		tfDay.setText(d.substring(6, 8));
		tfHour.setText("");
		tfMinute.setText("");
		cbTableNo.setSelectedIndex(-1);
		btnAdd.setText("등록");
		
	}
	
	public void setService(PanelReservationService service) {
		this.service = service;
	}
	
	public void setPCR(PanelCurrentReservation pcr) {
		this.pCR = pcr;
	}
	
	public void setTf(Reservation rsv, Reservation rsv2) {
		if(rsv.getMbNo().getMbBirth()==null) {
			tfMemberNo.setText(String.format("N%03d", rsv.getMbNo().getMbNo()));
		}else {
			tfMemberNo.setText(String.format("M%03d", rsv.getMbNo().getMbNo()));
		}
		tfMemberName.setText(rsv.getMbNo().getMbName());
		tfTel.setText(rsv.getMbNo().getMbTel());
		tfPeopleNumber.setText(Integer.toString(rsv.getRsvNumber()));
		cbTableNo.setSelectedItem(rsv.getRsvTableNo());
		
		reservation = rsv2;
		
		
		btnAdd.setText("수정");
		
		
	}
	
	private void actionPerformedBtnUdate() throws ParseException {
		
		int mbNo = Integer.parseInt(tfMemberNo.getText().substring(1));//회원번호
		String name = tfMemberName.getText(); //회원 이름
		String tel = tfTel.getText(); //전화번호
		Member member = new Member(mbNo); // 회원 번호 등록할 멤버 객체
		member.setMbName(name);
		member.setMbTel(tel);
		int rsvNumber =  Integer.parseInt(tfPeopleNumber.getText()); // 예약 인원
		String year = tfYear.getText();
		String month =tfMonth.getText();
		String day =tfDay.getText();
		String hour =tfHour.getText();
		String minute =tfMinute.getText();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		Date date =  sd.parse(year+"-"+month+"-"+day+" "+hour+":"+minute); //  예약시간
		String tableNo = (String) cbTableNo.getSelectedItem(); // 테이블 번호
		
		Date date2 = new Date(); // 예약 등록 시간
		
		Reservation rsv = new Reservation(rsvNumber, date, reservation.getRsvInputTime(), date2, member, tableNo, false);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("update", rsv);
		map.put("search", reservation);
		
		
		List<Reservation> list = service.selectByRangeTime(rsv);
		
		for(Reservation rssv : list) {
			if(rssv.getRsvTableNo().equals(tableNo) && rssv.getMbNo().getMbNo() != mbNo) {
				JOptionPane.showMessageDialog(null, "예약된 좌석입니다.");
				return;
			}
			
		}
		
		
		service.updateRsv(map);
		JOptionPane.showMessageDialog(null, "수정 완료");
		actionPerformedBtnNewButton_1();
		pCR.setList(service.selectByTime());
		btnAdd.setText("등록");
		pCR.setClear();
		pMember.reloadList();
		pCR.reloadData();
		pSeat.getPanelSeat().setBtnColor();
		
		}
	
	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfTel) {
			focusGainedTfTel(e);
		}
	}
	public void focusLost(FocusEvent e) {
		if(tfTel.getText().equals("")) {
			tfTel.setText("입력 후 엔터");
		}
	}
	protected void focusGainedTfTel(FocusEvent e) {
		if(tfTel.getText().equals("입력 후 엔터")) {
			tfTel.setText("");
		}
		
	}
}



















