package kr.or.yi.food_mgm_program.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import kr.or.yi.food_mgm_program.ui.insert.PanelPaymentInfo;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class PaymentFrame extends JFrame {

	private JPanel contentPane;

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
	}

	private void initComponents() {
		setTitle("결제화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 15, 0));

		PanelPaymentInfo panel = new PanelPaymentInfo();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		
		

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnNewButton = new JButton("현금");
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("신용카드");
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("마일리지");
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("회원");
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("쿠폰");
		panel_2.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("종료");
		panel_2.add(btnNewButton_5);
	}

}
