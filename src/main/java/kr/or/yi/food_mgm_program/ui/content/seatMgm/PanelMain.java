package kr.or.yi.food_mgm_program.ui.content.seatMgm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList.PanelDrink;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList.PanelMenuList;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList.PanelSide;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.seat.PanelSeat;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.seat.PanelSeatOne;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList.PanelOrderList;

public class PanelMain extends JPanel implements ActionListener {

	private JPanel pC;
	private JPanel pCC;
	private JPanel pCCN;
	private JPanel pCCC;
	private PanelSeat pSeat;
	private JPanel pS;
	private JPanel pPay;
	private JPanel pOder;
	private JPanel pMenu;
	private PanelOrderList pList;
	private JPanel pCancel;
	private JButton btnAllCancel;
	private JButton btnSelectCancel;
	private JButton btnPlus;
	private JButton btnMinus;
	private JPanel pPayment;
	private JButton btnPay;
	private JPanel pBtn;
	private JButton btnMainMenu;
	private JButton btnSide;
	private JButton btnDrink;
	private JPanel pMenuList;
	private PanelMenuList pMainMenu;
	private PanelSide pSideMenu;
	private PanelDrink pDrink;
	private CardLayout cards = new CardLayout();
	private JButton btnAdd;
	private PanelSeatOne seatOne;
	
	
	public PanelMain() {

		initComponents();
	}
	private void initComponents() {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLayout(new BorderLayout(0, 0));
		
		pC = new JPanel();
		add(pC, BorderLayout.CENTER);
		pC.setLayout(new BorderLayout(0, 0));
		
		pCC = new JPanel();
		pC.add(pCC, BorderLayout.CENTER);
		pCC.setLayout(new BorderLayout(0, 0));
		
		pCCN = new JPanel();
		pCC.add(pCCN, BorderLayout.NORTH);
		pCCN.setPreferredSize(new Dimension(100, 30));
		
		pCCC = new JPanel();
		pCC.add(pCCC, BorderLayout.CENTER);
		pCCC.setLayout(new BorderLayout(0, 0));
		
		pSeat = new PanelSeat();
		pCCC.add(pSeat, BorderLayout.CENTER);
		
		pPay = new JPanel();
		pCCC.add(pPay, BorderLayout.WEST);
		pPay.setLayout(new GridLayout(0, 1, 0, 10));
		pPay.setPreferredSize(new Dimension(500, 30));
		
		pOder = new JPanel();
		pPay.add(pOder);
		pOder.setLayout(new BorderLayout(0, 0));
		
		pList = new PanelOrderList();
		pOder.add(pList, BorderLayout.CENTER);
		
		pCancel = new JPanel();
		pOder.add(pCancel, BorderLayout.SOUTH);
		pCancel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAllCancel = new JButton("전체취소");
		btnAllCancel.addActionListener(this);
		pCancel.add(btnAllCancel);
		
		btnSelectCancel = new JButton("선택취소");
		btnSelectCancel.addActionListener(this);
		pCancel.add(btnSelectCancel);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(this);
		pCancel.add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(this);
		pCancel.add(btnMinus);
		
		btnAdd = new JButton("확인");
		btnAdd.addActionListener(this);
		pCancel.add(btnAdd);
		
		pMenu = new JPanel();
		pPay.add(pMenu);
		pMenu.setLayout(new BorderLayout(0, 0));
		
		pBtn = new JPanel();
		pMenu.add(pBtn, BorderLayout.NORTH);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnMainMenu = new JButton("주메뉴");
		btnMainMenu.addActionListener(this);
		pBtn.add(btnMainMenu);
		
		btnSide = new JButton("부메뉴");
		btnSide.addActionListener(this);
		pBtn.add(btnSide);
		
		btnDrink = new JButton("음료");
		btnDrink.addActionListener(this);
		pBtn.add(btnDrink);
		
		pPayment = new JPanel();
		pMenu.add(pPayment, BorderLayout.SOUTH);
		pPayment.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnPay = new JButton("결제");
		pPayment.add(btnPay);
		
		pMenuList = new JPanel();
		pMenuList.setBorder(new EmptyBorder(5, 0, 0, 0));
		pMenu.add(pMenuList, BorderLayout.CENTER);
		pMenuList.setLayout(cards);
		
		pMainMenu = new PanelMenuList();
		pMenuList.add(pMainMenu, "pMain");
		
		pSideMenu = new PanelSide();
		pMenuList.add(pSideMenu, "pSide");
		
		pDrink = new PanelDrink();
		pMenuList.add(pDrink, "pDrink");
		
		pS = new JPanel();
		add(pS, BorderLayout.SOUTH);
		pS.setPreferredSize(new Dimension(200, 30));
		
		pMainMenu.setOrderList(pList);
		pSideMenu.setOrderList(pList);
		pDrink.setOrderList(pList);
		pSeat.setPlist(pList);
		pSeat.setPanelMain(this);
		pSeat.setPanelSeatOne();

		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
		if (e.getSource() == btnMainMenu) {
			actionPerformedBtnMainMenu(e);
		}
		if (e.getSource() == btnSide) {
			actionPerformedBtnSide(e);
		}
		if (e.getSource() == btnDrink) {
			actionPerformedBtnDrink(e);
		}
		if (e.getSource() == btnAllCancel) {
			actionPerformedBtnAllCancel();
		}
		if (e.getSource() == btnSelectCancel) {
			actionPerformedBtnSelectCancel();
		}
		if (e.getSource() == btnPlus) {
			actionPerformedBtnPlus();
		}
		if (e.getSource() == btnMinus) {
			actionPerformedBtnMinus();
		}
	}
	private void actionPerformedBtnMinus() {
		pList.setMinus();
		
	}
	private void actionPerformedBtnPlus() {
		pList.setPlus();
		
	}
	private void actionPerformedBtnSelectCancel() {
		pList.selectCancel();
		
	}
	private void actionPerformedBtnAllCancel() {
		pList.resetList();
		
		
	}
	protected void actionPerformedBtnDrink(ActionEvent e) {
		cards.show(pMenuList, "pDrink");
	}
	protected void actionPerformedBtnSide(ActionEvent e) {
		cards.show(pMenuList, "pSide");
	}
	protected void actionPerformedBtnMainMenu(ActionEvent e) {
		cards.show(pMenuList, "pMain");
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		seatOne.setPcc(pList.getList());
		int price = 0;
		String price1 = "";
		for(Food food : pList.getList()) {
			price += food.getFdPrice()*food.getCount();
		}
		if(price == 0) {
			seatOne.setLblPrice(price1);

			return;
		}
		price1 = Food.formatter.format(price);
		seatOne.setLblPrice(price1);
		
		
		
		
	}
	public void setSeatOne(PanelSeatOne seatOne) {
		this.seatOne = seatOne;
	}
	
}







