package kr.or.yi.food_mgm_program.ui.insert;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class PanelPaymentInfo extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_1;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public PanelPaymentInfo() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACB0\uC81C\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("번호");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		textField_6 = new JTextField();
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label = new JLabel("총 금액");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		add(textField);
		
		JLabel label_1 = new JLabel("할인 금액");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1);
		
		JLabel label_5 = new JLabel("할인정보");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		add(textField_5);
		
		JLabel label_2 = new JLabel("받을 금액");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		add(textField_2);
		
		JLabel label_3 = new JLabel("받은 금액");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		add(textField_3);
		
		JLabel label_4 = new JLabel("거스름돈");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		add(textField_4);
		
		lblNewLabel_1 = new JLabel("회원 정보");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		textField_7 = new JTextField();
		add(textField_7);
		textField_7.setColumns(10);
	}

}
