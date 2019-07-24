package kr.or.yi.food_mgm_program.ui.content.seatMgm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Component;

public class PanelMain extends JPanel {

	private JPanel pC;
	private JPanel pCC;
	private JPanel pCCN;
	private JPanel pCCC;
	private PanelSeat pSeat;
	private JPanel pS;
	private JPanel pPay;
	private JPanel pOder;
	private JPanel pMenu;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnAllCancel;
	private JButton btnSelectCancel;
	private JButton btnPlus;
	private JButton btnMinus;
	private PanelMenuList panel_2;
	private JPanel panel_3;
	private JButton btnPay;
	private JPanel panel_4;
	private JButton btnMainMenu;
	private JButton btnSide;
	private JButton btnDrink;

	
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
		pPay.setPreferredSize(new Dimension(300, 30));
		
		pOder = new JPanel();
		pPay.add(pOder);
		pOder.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		pOder.add(panel, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		pOder.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAllCancel = new JButton("전체취소");
		panel_1.add(btnAllCancel);
		
		btnSelectCancel = new JButton("선택취소");
		panel_1.add(btnSelectCancel);
		
		btnPlus = new JButton("+");
		panel_1.add(btnPlus);
		
		btnMinus = new JButton("-");
		panel_1.add(btnMinus);
		
		pMenu = new JPanel();
		pPay.add(pMenu);
		pMenu.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		pMenu.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnMainMenu = new JButton("주메뉴");
		panel_4.add(btnMainMenu);
		
		btnSide = new JButton("부메뉴");
		panel_4.add(btnSide);
		
		btnDrink = new JButton("음료");
		panel_4.add(btnDrink);
		
		panel_2 = new PanelMenuList();
		pMenu.add(panel_2, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		pMenu.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnPay = new JButton("결제");
		panel_3.add(btnPay);
		
		pS = new JPanel();
		add(pS, BorderLayout.SOUTH);
		pS.setPreferredSize(new Dimension(200, 30));
	}

}
