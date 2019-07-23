package kr.or.yi.food_mgm_program.ui.insert;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class InsertMember extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public InsertMember() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(0, 2, 20, 10));
		
		JLabel label = new JLabel("아이디");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		add(textField);
		
		JLabel label_1 = new JLabel("이름");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1);
		
		JLabel label_2 = new JLabel("전화번호");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		add(textField_2);
		
		JLabel label_3 = new JLabel("생년월일");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		add(textField_3);
		
		JLabel label_4 = new JLabel("주소");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		add(textField_4);
	}

}
