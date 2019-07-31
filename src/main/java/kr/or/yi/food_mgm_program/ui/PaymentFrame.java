package kr.or.yi.food_mgm_program.ui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
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

import org.apache.logging.log4j.core.impl.MementoMessage;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Coupon;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.service.PaymentService;
import kr.or.yi.food_mgm_program.ui.content.PanelMember;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.seat.PanelSeatOne;
import kr.or.yi.food_mgm_program.ui.content.statistics.PanelSaleList;
import kr.or.yi.food_mgm_program.ui.content.statistics.PanelSalesList;
import kr.or.yi.food_mgm_program.ui.insert.PanelPaymentInfo;
import kr.or.yi.food_mgm_program.ui.list.memberList;

public class PaymentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMember;
	private PanelPaymentInfo panelInfo;
	private JPanel panelButton;
	private JButton btnCash;
	private JButton btnCard;
	private JButton btnMileage;
	private JButton btnCoupon;
	private JButton btnGrade;
	private PaymentService service;
	private Member mem;
	private List<Sale> saleList;
	private int updateMileage;
	private int sum;

	private MainFrame frame;
	private PanelSeatOne parent;

	public PaymentFrame() {
		initComponents();
		service = PaymentService.getInstance();
	}
	


	public void setParent(PanelSeatOne parent) {
		this.parent = parent;
	}



	private void initComponents() {
		setTitle("결제화면");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 676, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 15, 0));

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

		panelInfo = new PanelPaymentInfo();
		contentPane.add(panelInfo);
		panelInfo.setLayout(new GridLayout(0, 2, 0, 0));

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
		if (sNumber == null) {
			return;
		}

		if (sNumber.equals("")) {
			JOptionPane.showMessageDialog(null, "선택된 회원이 없습니다.");
			return;
		}

		if (sNumber != null) {
			int number = Integer.parseInt(sNumber);
			mem = service.selectByTel(number); // 번호에 맞는 회원객체
		}

		if (mem != null) {
			panelInfo.setMemberInfo(mem, sum); // 회원정보가 올라감

			btnMileage.setEnabled(true);
			btnCoupon.setEnabled(true);
			btnGrade.setEnabled(true);
			btnMember.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(null, "없는 회원입니다");
		}

	}

	protected void actionPerformedBtnMileage(ActionEvent e) { // 마일리지 버튼 클릭시
		String Smileage = JOptionPane.showInputDialog("사용할 마일리지를 입력하세요. 현재 사용 가능한 마일리지 : " + mem.getMbMileage() + "원");

		if (Smileage == null) {
			return;
		}

		if (Smileage.equals("")) {
			JOptionPane.showMessageDialog(null, "선택된 회원이 없습니다.");
			return;
		}

		int mileage = Integer.parseInt(Smileage);

		if (mem.getMbMileage() < mileage) {
			JOptionPane.showMessageDialog(null, "최대 사용가능한 마일리지 : " + mem.getMbMileage() + "원");
		} else {
			updateMileage = mem.getMbMileage() - mileage;
			panelInfo.setDiscountInfoMileage(mileage);

		}

	}

	protected void actionPerformedBtnCoupon(ActionEvent e) { // 쿠폰 버튼 클릭시
		List<Coupon> couponList = mem.getCoupon();
		String[] selectionValues = new String[couponList.size()];
		int size = 0;

		for (Coupon c : couponList) {
			selectionValues[size++] = c.getCpName();
		}

		String coupon = (String) JOptionPane.showInputDialog(null, "사용할 쿠폰을 선택하세요", "쿠폰 선택",
				JOptionPane.QUESTION_MESSAGE, null, selectionValues, selectionValues[0]);

		Coupon searchCoupon = new Coupon(coupon);

		for (Coupon c : couponList) {
			if (c.equals(searchCoupon)) {
				searchCoupon = c;
			}
		}

		panelInfo.setDiscountInfoCoupon(searchCoupon);
	}

	protected void actionPerformedBtnGrade(ActionEvent e) { // 등급 버튼 클릭시
		panelInfo.setDiscountInfoGrade(mem);
	}

	protected void actionPerformedBtnCash(ActionEvent e) { // 현금 결제
		int res = JOptionPane.showConfirmDialog(null, "정말 결제(현금) 하시겠습니까?", "결제확인", JOptionPane.YES_OPTION);
		if (res == 0) {
			saleList = panelInfo.getInfo(saleList, mem, 1);

			Map<String, List<Sale>> map = new HashMap<>();
			map.put("list", saleList);

			String info = panelInfo.getTfDisCountInfo().getText();
			if (info.contains("마일리지") && mem != null) {
				Member member = mem;
				member.setMbMileage(updateMileage);
				System.out.println(member);
				service.insertSaleUpdateMileageTransaciton(map, member);
			} else if (mem == null) {
				service.insertSale(map);
			} else if (mem != null) {
				service.insertSale(map);
			}

			PanelSalesList s = (PanelSalesList) frame.getpSales();
			PanelSaleList s2 = (PanelSaleList) frame.getpSale();
			PanelMember m = (PanelMember) frame.getpMember();
			m.reloadList();
			s.setListAll();
			s2.setListAll();
			parent.setClear();
			PaymentFrame.this.dispose();
		}
	}

	protected void actionPerformedBtnCard(ActionEvent e) { // 신용카드 결제
		int res = JOptionPane.showConfirmDialog(null, "정말 결제(카드) 하시겠습니까?", "결제확인", JOptionPane.YES_OPTION);

		if (res == 0) {
			saleList = panelInfo.getInfo(saleList, mem, 0);

			Map<String, List<Sale>> map = new HashMap<>();
			map.put("list", saleList);

			String info = panelInfo.getTfDisCountInfo().getText();
			if (info.contains("마일리지") && mem != null) {
				Member member = mem;
				member.setMbMileage(updateMileage);
				System.out.println(member);
				service.insertSaleUpdateMileageTransaciton(map, member);
			} else if (mem == null) {
				service.insertSale(map);
			} else if (mem != null) {
				service.insertSale(map);
			}

			PanelSalesList s = (PanelSalesList) frame.getpSales();
			PanelSaleList s2 = (PanelSaleList) frame.getpSale();
			PanelMember m = (PanelMember) frame.getpMember();
			
			
			m.reloadList();
			s.setListAll();
			s2.setListAll();
			parent.setClear();
			PaymentFrame.this.dispose();
		}

	}

	public void setInitWork(int sum, List<Sale> saleList) { // 주문창에서 받아온 sale list
		this.saleList = saleList;
		this.sum = sum;
		panelInfo.setSum(sum);
		panelInfo.setInitWork(sum, saleList);
	}

	public void setMainFrame(MainFrame frame) {
		this.frame = frame;
	}

}
