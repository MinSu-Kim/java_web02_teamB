package kr.or.yi.food_mgm_program.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;


	public LoginFrame() {
		setTitle("로그인 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("아이디를 입력하세요");
		textField.setBounds(42, 149, 250, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(42, 195, 250, 44);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(42, 278, 117, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("관리자 로그인");
		btnNewButton_1.setBounds(169, 278, 123, 44);
		contentPane.add(btnNewButton_1);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
