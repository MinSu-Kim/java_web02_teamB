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
		
		JPanel pInsert = new JPanel();
		add(pInsert);
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		pInsert.setLayout(new BoxLayout(pInsert, BoxLayout.X_AXIS));
		
		InsertFood pFood = new InsertFood();
		GridLayout gl_pFood = (GridLayout) pFood.getLayout();
		gl_pFood.setHgap(10);
		pInsert.add(pFood);
		
		JPanel pBtn = new JPanel();
		pInsert.add(pBtn);
		pBtn.setLayout(new BoxLayout(pBtn, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("추가");
		pBtn.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		pBtn.add(btnNewButton_1);
		
		
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel pSearch = new JPanel();
		panel_1.add(pSearch, BorderLayout.NORTH);
		pSearch.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		textField = new JTextField();
		pSearch.add(textField);
		textField.setColumns(30);
		
		JButton btnNewButton_2 = new JButton("검색");
		pSearch.add(btnNewButton_2);
		
		FoodList pList = new FoodList((String) null);
		panel_1.add(pList, BorderLayout.CENTER);
	}

}
