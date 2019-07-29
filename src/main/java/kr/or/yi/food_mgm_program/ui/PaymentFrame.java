package kr.or.yi.food_mgm_program.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.core.impl.MementoMessage;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.ui.insert.PanelPaymentInfo;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnExit;
	private MemberDao mDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentFrame frame = new PaymentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaymentFrame() {
		initComponents();
		mDao = new MemberDaoImpl();
	}

	private void initComponents() {
		setTitle("결제화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panelButton.add(btnCash);

		btnCard = new JButton("신용카드");
		panelButton.add(btnCard);

		btnMileage = new JButton("마일리지");
		panelButton.add(btnMileage);

		btnMember = new JButton("회원");
		btnMember.addActionListener(this);
		panelButton.add(btnMember);

		btnCoupon = new JButton("쿠폰");
		panelButton.add(btnCoupon);

		btnExit = new JButton("종료");
		panelButton.add(btnExit);
		
		btnMileage.setEnabled(false);
		btnCoupon.setEnabled(false);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMember) {
			actionPerformedBtnNewButton_3(e);
		}
	}
	protected void actionPerformedBtnNewButton_3(ActionEvent e) {//회원 버튼 클릭시
		String sNumber = JOptionPane.showInputDialog("번호를 입력하세요");
		int number = Integer.parseInt(sNumber);
		
		
		btnMileage.setEnabled(true);
		btnCoupon.setEnabled(true);
		
		//Member mem = mDao.selectMemberByTel(number);
		//panelInfo.setMemberInfo(mem);
		
		
	}
}
