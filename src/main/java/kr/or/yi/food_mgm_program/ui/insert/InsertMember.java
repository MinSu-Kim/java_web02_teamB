package kr.or.yi.food_mgm_program.ui.insert;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class InsertMember extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel pN;
	private JPanel pS;
	private JPanel pC;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public InsertMember() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pN = new JPanel();
		add(pN, BorderLayout.NORTH);
		pN.setPreferredSize(new Dimension(100, 70));
		pS = new JPanel();
		add(pS, BorderLayout.SOUTH);
		pS.setPreferredSize(new Dimension(100, 30));
		pC = new JPanel();
		add(pC, BorderLayout.CENTER);
		pC.setLayout(new GridLayout(0, 2, 10, 15));
		
		JLabel label = new JLabel("아이디");
		pC.add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		pC.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("이름");
		pC.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_1 = new JTextField();
		pC.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("전화번호");
		pC.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_2 = new JTextField();
		pC.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("생년월일");
		pC.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_3 = new JTextField();
		pC.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("주소");
		pC.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_5 = new JTextField();
		pC.add(textField_5);
		textField_5.setColumns(10);
	}

}
