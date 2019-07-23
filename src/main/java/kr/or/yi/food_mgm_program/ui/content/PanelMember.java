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
import kr.or.yi.food_mgm_program.ui.insert.InsertMember;

public class PanelMember extends JPanel {
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
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		InsertMember panel_2 = new InsertMember();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 10, 10));
		
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
		textField_5.setColumns(15);
		
		JButton btnNewButton_2 = new JButton("검색");
		panel_4.add(btnNewButton_2);
		
		memberList panel_5 = new memberList((String) null);
		panel_1.add(panel_5, BorderLayout.CENTER);
	}

}
