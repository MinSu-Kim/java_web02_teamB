package kr.or.yi.food_mgm_program.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.ui.insert.PanelPaymentInfo;


public class PaymentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMember;
	private PanelPaymentInfo panelInfo;
	private JPanel panelCal;
	private JPanel panelButton;
	private JButton btnCash;
	private JButton btnCard;
	private JButton btnMileage;
	private JButton btnCoupon;
	private JButton btnGrade;
	private MemberDao mDao;
	private SaleDao sDao;
	private Member mem;


	public PaymentFrame() {
		initComponents();
		mDao = new MemberDaoImpl();
		sDao = new SaleDaoImpl();
	}

	private void initComponents() {
		setTitle("결제화면");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 1014, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 15, 0));

		panelInfo = new PanelPaymentInfo();
		contentPane.add(panelInfo);
		panelInfo.setLayout(new GridLayout(0, 2, 0, 0));

		panelCal = new JPanel();
		contentPane.add(panelCal);

		panelButton = new JPanel();
		contentPane.add(panelButton);
		panelButton.setLayout(new GridLayout(0, 2, 0, 0));

		btnCash = new JButton("현금");
		btnCash.addActionListener(this);
		panelButton.add(btnCash);

		btnCard = new JButton("신용카드");
		btnCard.addActionListener(this);
		panelButton.add(btnCard);

		btnMileage = new JButton("마일리지");
		btnMileage.addActionListener(this);
		panelButton.add(btnMileage);

		btnMember = new JButton("회원");
		btnMember.addActionListener(this);
		panelButton.add(btnMember);

		btnCoupon = new JButton("쿠폰");
		btnCoupon.addActionListener(this);
		panelButton.add(btnCoupon);

		btnGrade = new JButton("등급 할인");
		btnGrade.addActionListener(this);
		panelButton.add(btnGrade);

		btnMileage.setEnabled(false);
		btnCoupon.setEnabled(false);
		btnGrade.setEnabled(false);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCard) {
			actionPerformedBtnCard(e);
		}
		if (e.getSource() == btnCash) {
			actionPerformedBtnCash(e);
		}
		if (e.getSource() == btnCoupon) {
			actionPerformedBtnCoupon(e);
		}
		if (e.getSource() == btnGrade) {
			actionPerformedBtnGrade(e);
		}
		if (e.getSource() == btnMileage) {
			actionPerformedBtnMileage(e);
		}
		if (e.getSource() == btnMember) {
			actionPerformedBtnNewButton_3(e);
		}
	}

	protected void actionPerformedBtnNewButton_3(ActionEvent e) {// 회원 버튼 클릭시
		String sNumber = JOptionPane.showInputDialog("번호를 입력하세요");
		if(sNumber == null) {
			return;
		}
		
		if( sNumber.equals("")) {
			JOptionPane.showMessageDialog(null, "선택된 회원이 없습니다.");
			return;
		}
		
		
		if (sNumber != null) {
			int number = Integer.parseInt(sNumber);
			mem = mDao.selectByTel(number); // 번호에 맞는 회원객체
		}

		if (mem != null) {
			panelInfo.setMemberInfo(mem); // 회원정보가 올라감

			btnMileage.setEnabled(true);
			btnCoupon.setEnabled(true);
			btnGrade.setEnabled(true);
			btnMember.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(null, "없는 회원입니다");
		}

	}

	protected void actionPerformedBtnMileage(ActionEvent e) { //마일리지 버튼 클릭시
		panelInfo.setDiscountInfo(mem, 1);
	}

	protected void actionPerformedBtnCoupon(ActionEvent e) { //쿠폰 버튼 클릭시
		panelInfo.setDiscountInfo(mem, 2);
	}

	protected void actionPerformedBtnGrade(ActionEvent e) { // 등급 버튼 클릭시
		panelInfo.setDiscountInfo(mem, 3);
	}

	protected void actionPerformedBtnCash(ActionEvent e) { // 현금 결제
		int res = JOptionPane.showConfirmDialog(null, "정말 결제(현금) 하시겠습니까?", "결제확인", JOptionPane.YES_OPTION);
		if (res == 0) {
			List<Sale> list = new ArrayList<>();
			for (Sale s : list) {
				s.setSaletime(new Date());
				s.setSaleType(1);
				s.setMbNo(new Member(mem.getMbNo()));

			}

			Map<String, List<Sale>> map = new HashMap<>();
			map.put("list", list);
			sDao.insertSale(map);
			PaymentFrame.this.dispose();
		}

	}

	protected void actionPerformedBtnCard(ActionEvent e) { // 신용카드 결제
		int res = JOptionPane.showConfirmDialog(null, "정말 결제(카드) 하시겠습니까?", "결제확인", JOptionPane.YES_OPTION);
		if (res == 0) {
			List<Sale> list = new ArrayList<>();
			for (Sale s : list) {
				s.setSaletime(new Date());
				s.setSaleType(0);
				s.setMbNo(new Member(mem.getMbNo()));
				PaymentFrame.this.dispose();
			}

			Map<String, List<Sale>> map = new HashMap<>();
			map.put("list", list);
			sDao.insertSale(map);
			PaymentFrame.this.dispose();
		}
	}
	
	public void setInitWork(String price, List<Sale> saleList) {
		panelInfo.setInitWork(price, saleList);
	}
	
}
