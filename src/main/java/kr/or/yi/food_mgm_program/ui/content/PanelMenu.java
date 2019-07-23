package kr.or.yi.food_mgm_program.ui.content;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelMenu extends JPanel {
	private JPanel panel;
	private JPanel pN;
	private JPanel pS;
	private JPanel pW;
	private JPanel pE;
	private JPanel pC;
	private JButton btnSeat;
	private JButton btnSale;
	private JButton btnMember;
	private JButton btnFood;
	private JButton btnLogout;

	public PanelMenu() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		pN = new JPanel();
		panel.add(pN, BorderLayout.NORTH);
		pN.setPreferredSize(new Dimension(100, 150));
		
		pS = new JPanel();
		panel.add(pS, BorderLayout.SOUTH);
		pS.setPreferredSize(new Dimension(100, 150));
		
		pW = new JPanel();
		panel.add(pW, BorderLayout.WEST);
		pW.setPreferredSize(new Dimension(30, 50));
		
		pE = new JPanel();
		panel.add(pE, BorderLayout.EAST);
		pE.setPreferredSize(new Dimension(30, 50));
		
		pC = new JPanel();
		panel.add(pC, BorderLayout.CENTER);
		pC.setLayout(new GridLayout(0, 1, 0, 30));
		
		btnSeat = new JButton("좌석관리");
		pC.add(btnSeat);
		
		btnSale = new JButton("매출관리");
		pC.add(btnSale);
		
		btnMember = new JButton("회원관리");
		pC.add(btnMember);
		
		btnFood = new JButton("음식관리");
		pC.add(btnFood);
		
		btnLogout = new JButton("로그아웃");
		pC.add(btnLogout);
	}

}
