package kr.or.yi.food_mgm_program.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dao.ManagerDao;
import kr.or.yi.food_mgm_program.daoImpl.ManagerDaoImpl;
import kr.or.yi.food_mgm_program.dto.Manager;

import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class LoginFrame extends JFrame implements ActionListener, FocusListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField pfPass;
	private JButton btnLogin;
	private JButton btnMLogin;
	private ManagerDao dao;

	public LoginFrame() {
		dao = new ManagerDaoImpl();
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
		
		tfId = new JTextField();
		
		tfId.addFocusListener(this);
		
		tfId.setBounds(42, 149, 250, 44);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(42, 195, 250, 44);
		contentPane.add(pfPass);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(42, 278, 117, 44);
		contentPane.add(btnLogin);
		
		btnMLogin = new JButton("관리자 로그인");
		btnMLogin.addActionListener(this);
		btnMLogin.setBounds(169, 278, 123, 44);
		contentPane.add(btnMLogin);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMLogin) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnLogin) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfId) {
			focusGainedTextField(e);
		}
	}
	public void focusLost(FocusEvent e) {
		
	}
	protected void focusGainedTextField(FocusEvent e) {
		tfId.setText("");
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		Manager manager = inputManager(); // 입력한 정보
		Manager manager1 = dao.selectByPass(manager);
		if(manager1 == null) {
			JOptionPane.showMessageDialog(null, "아이디가 없거나 비밀번호가 일치하지 않습니다.");
		}else {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
		}
	}
	
	public Manager inputManager() {
		String id = tfId.getText();
		char[] pass = pfPass.getPassword();
		String password = "";
		for(char cha : pass) {
			password+=cha;
		}
		Manager manager = new Manager();
		manager.setId(id);
		manager.setPwd(password);
		return manager;
	}
}









