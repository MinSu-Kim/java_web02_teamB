package kr.or.yi.food_mgm_program.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class LoginFrame extends JFrame implements ActionListener, FocusListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;


	public LoginFrame() {
		initComponents();
	}
	private void initComponents() {
		setResizable(false);
		setTitle("로그인 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 250, 351, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addFocusListener(this);
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
	public void focusGained(FocusEvent e) {
		if (e.getSource() == textField) {
			focusGainedTextField(e);
		}
	}
	public void focusLost(FocusEvent e) {
		textField.setText("아이디를 입력하세요");
	}
	protected void focusGainedTextField(FocusEvent e) {
		textField.setText("");
	}
}









