
package kr.or.yi.food_mgm_program.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.service.PanelReservationService;
import kr.or.yi.food_mgm_program.ui.content.PanelFood;
import kr.or.yi.food_mgm_program.ui.content.PanelMember;
import kr.or.yi.food_mgm_program.ui.content.PanelReservation;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.PanelMain;
import kr.or.yi.food_mgm_program.ui.content.statistics.PanelSaleList;
import kr.or.yi.food_mgm_program.ui.content.statistics.PanelSalesList;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLogout;
	private JTabbedPane tabbedPane;
	private JButton btnLogout;
	private LoginFrame parent;
	private JPanel pFood;
	private JPanel pSale;
	private JPanel pSales;
	private PanelReservationService service;
	private PanelMember pMember;


	
	public JPanel getpSale() {
		return pSale;
	}
	public JPanel getpSales() {
		return pSales;
	}
	
	
	public JPanel getpMember() {
		return pMember;
	}
	public MainFrame() {
		service = PanelReservationService.getInstance();
		initComponents();
	}
	private void initComponents() {
		setTitle("음식점 관리 프로그램");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 100, 1800, 800);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pLogout = new JPanel();
		contentPane.add(pLogout, BorderLayout.NORTH);
		pLogout.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		pLogout.add(panel, BorderLayout.EAST);
		
		JLabel lblManager = new JLabel();
		lblManager.setForeground(SystemColor.activeCaptionText);
		lblManager.setFont(new Font("새굴림", Font.BOLD, 20));
		
		panel.add(lblManager);
		
		btnLogout = new JButton("로그 아웃");
		panel.add(btnLogout);
		btnLogout.addActionListener(this);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		PanelMain pSeat = new PanelMain(this);
		tabbedPane.addTab("주문 관리", null, pSeat, null);

		if(LoginFrame.manager!=null && LoginFrame.noManager==null) {	
			
			pSale = new PanelSaleList(this);
			tabbedPane.addTab("결제 관리", null, pSale, null);

			pSales = new PanelSalesList();
			tabbedPane.addTab("판매 관리", null, pSales, null);
			
			pFood = new PanelFood();
			tabbedPane.addTab("음식 관리", null, pFood, null);
			
			lblManager.setText(LoginFrame.manager.getMgId2());
			JOptionPane.showMessageDialog(null, LoginFrame.manager.getMgId()+"님 환영합니다.");
			
		}else if(LoginFrame.noManager!=null && LoginFrame.manager==null) {
			
			lblManager.setText("["+LoginFrame.noManager.getNmgId()+"]");
			JOptionPane.showMessageDialog(null, LoginFrame.noManager.getNmgId()+"님 환영합니다.");
		}
		pMember = new PanelMember();
		tabbedPane.addTab("회원 관리", null, pMember, null);
		
		PanelReservation pRsv = new PanelReservation(pMember, service, pSeat);
		tabbedPane.addTab("예약 관리", null, pRsv, null);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogout) {
			int a = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "", JOptionPane.YES_NO_OPTION);
			if(a==0) {
				LoginFrame.manager = null;
				LoginFrame.noManager = null;
				this.setVisible(false);
				parent.setVisible();
			}else {
				return;
			}
			
			
		}
		
	}
	public void setLoginForm(LoginFrame frame) {
		this.parent = frame;
	}
	
}





