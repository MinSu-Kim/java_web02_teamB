package kr.or.yi.food_mgm_program.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import kr.or.yi.food_mgm_program.ui.list.FoodList;
import javax.swing.JLabel;
import kr.or.yi.food_mgm_program.ui.insert.InsertFood;
import java.awt.Component;

public class PanelFood extends JPanel {
	private JTextField textField;

	public PanelFood() {

		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		InsertFood panel_2 = new InsertFood();
		GridLayout gridLayout = (GridLayout) panel_2.getLayout();
		gridLayout.setHgap(10);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("추가");
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel_3.add(btnNewButton_1);
		
		
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(30);
		
		JButton btnNewButton_2 = new JButton("검색");
		panel_4.add(btnNewButton_2);
		
		FoodList panel_5 = new FoodList((String) null);
		panel_1.add(panel_5, BorderLayout.CENTER);
	}

}
