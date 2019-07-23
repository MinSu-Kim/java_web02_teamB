package kr.or.yi.food_mgm_program.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import kr.or.yi.food_mgm_program.ui.list.memberList;
import java.awt.CardLayout;
import java.awt.FlowLayout;

public class PanelMember extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public PanelMember() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("이름");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JLabel label_1 = new JLabel("전화번호");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel label_2 = new JLabel("생년월일");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		JLabel label_3 = new JLabel("주소");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("가입");
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel_3.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.NORTH);
		
		textField_5 = new JTextField();
		panel_4.add(textField_5);
		textField_5.setColumns(20);
		
		JButton btnNewButton_2 = new JButton("검색");
		panel_4.add(btnNewButton_2);
		
		memberList panel_5 = new memberList((String) null);
		panel_1.add(panel_5, BorderLayout.CENTER);
	}

}
