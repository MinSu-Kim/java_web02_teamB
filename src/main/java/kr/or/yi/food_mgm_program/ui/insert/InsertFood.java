package kr.or.yi.food_mgm_program.ui.insert;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class InsertFood extends JPanel {
	private JComboBox textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public InsertFood() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(0, 2, 20, 10));
		
		JLabel lblNewLabel = new JLabel("음식 종류");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel);
		
		textField = new JComboBox();
		add(textField);
		
		JLabel label = new JLabel("음식명");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1);
		
		JLabel label_1 = new JLabel("가격");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		add(textField_2);
	}

}
