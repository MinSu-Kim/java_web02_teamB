package kr.or.yi.food_mgm_program.ui.insert;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

public class InsertFood extends JPanel {
	private JComboBox tfKind;
	private JTextField tfName;
	private JTextField tfPrice;

	/**
	 * Create the panel.
	 */
	public InsertFood() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(10, 10, 10, 20));
		setLayout(new GridLayout(0, 2, 20, 10));
		
		JLabel lblKind = new JLabel("음식 종류");
		lblKind.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblKind);
		
		tfKind = new JComboBox();
		add(tfKind);
		
		JLabel lblName = new JLabel("음식명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);
		
		JLabel lblPrice = new JLabel("가격");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		add(tfPrice);
	}

}
