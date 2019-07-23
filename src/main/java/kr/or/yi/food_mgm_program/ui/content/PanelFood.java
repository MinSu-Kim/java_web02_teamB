package kr.or.yi.food_mgm_program.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import kr.or.yi.food_mgm_program.ui.list.FoodList;
import java.awt.Component;

public class PanelFood extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelFood() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(20);
		
		JButton btnNewButton_2 = new JButton("검색");
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("종류추가");
		panel_4.add(btnNewButton_3);
		
		FoodList panel_5 = new FoodList((String) null);
		panel_1.add(panel_5, BorderLayout.CENTER);
	}

}
