
package kr.or.yi.food_mgm_program.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.PanelMain;
import javax.swing.JLabel;
import kr.or.yi.food_mgm_program.ui.content.PanelMember;
import kr.or.yi.food_mgm_program.ui.content.PanelFood;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel pLogout;
	private JTabbedPane tabbedPane;
	

	public MainFrame() {
		initComponents();
	}
	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 100, 1800, 800);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		PanelMain pSeat = new PanelMain();
		tabbedPane.addTab("좌석 관리", null, pSeat, null);
		

		JPanel pSale = new JPanel();
		tabbedPane.addTab("매출 관리", null, pSale, null);
		
		PanelMember pMember = new PanelMember();
		tabbedPane.addTab("회원 관리", null, pMember, null);
		
		PanelFood pFood = new PanelFood();
		tabbedPane.addTab("음식 관리", null, pFood, null);
		
		
		pLogout = new JPanel();
		contentPane.add(pLogout, BorderLayout.NORTH);
		pLogout.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("로그 아웃");
		pLogout.add(btnNewButton, BorderLayout.EAST);

	}

}
