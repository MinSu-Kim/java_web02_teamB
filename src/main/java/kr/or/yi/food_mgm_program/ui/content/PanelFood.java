package kr.or.yi.food_mgm_program.ui.content;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.ui.insert.PanelFoodInfo;
import kr.or.yi.food_mgm_program.ui.list.FoodList;

@SuppressWarnings("serial")
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
		
		PanelFoodInfo pFood = new PanelFoodInfo();
		GridLayout gl_pFood = (GridLayout) pFood.getLayout();
		gl_pFood.setHgap(10);
		pInsert.add(pFood);
		
		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(0, 0, 0, 30));
		pInsert.add(pBtn);
		pBtn.setLayout(new BoxLayout(pBtn, BoxLayout.Y_AXIS));
		
		JButton btnAdd = new JButton("추가");
		pBtn.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
		
		
		
		JPanel pList = new JPanel();
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));
		
		JPanel pSearch = new JPanel();
		pList.add(pSearch, BorderLayout.NORTH);
		pSearch.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		textField = new JTextField();
		pSearch.add(textField);
		textField.setColumns(30);
		
		JButton btnNewButton_2 = new JButton("검색");
		pSearch.add(btnNewButton_2);
		
		FoodList pFoodList = new FoodList((String) null);
		pList.add(pFoodList, BorderLayout.CENTER);
	}

}
