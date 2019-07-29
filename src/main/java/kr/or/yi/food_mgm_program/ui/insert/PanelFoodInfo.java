package kr.or.yi.food_mgm_program.ui.insert;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.FoodKind;

@SuppressWarnings("serial")
public class PanelFoodInfo extends JPanel {
	public JComboBox<FoodKind> cmbKind;
	private JTextField tfName;
	private JTextField tfPrice;
	private List<FoodKind> fkList;
	private DefaultComboBoxModel<FoodKind> fkModels;
	private int no = 0;
	
	public PanelFoodInfo() {
		
		initComponents();
	}
	
	private void initComponents() {
		setBorder(new EmptyBorder(10, 10, 10, 20));
		setLayout(new GridLayout(0, 2, 20, 10));
		
		JLabel lblKind = new JLabel("음식 종류");
		lblKind.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblKind);
		
		cmbKind = new JComboBox<FoodKind>();
		add(cmbKind);
		
		
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
	
	public void setFoodKindCmbModel() {
		fkModels = new DefaultComboBoxModel<FoodKind>(new Vector<FoodKind>(fkList));
		cmbKind.setModel(fkModels);
		
		
	}
	
	public void clearFoodInfo() {
		cmbKind.setSelectedIndex(-1);
		tfName.setText("");
		tfPrice.setText("");
	}
	
	public void setFood(Food food) {
		no = food.getFdNo();
		cmbKind.setSelectedItem(food.getFkNo());
		tfName.setText(food.getFdName());
		tfPrice.setText(food.getFdPrice()+"");
	}
	
	public Food getFood() throws Exception {
		validCheck();
		
		FoodKind fk = (FoodKind) cmbKind.getSelectedItem();
		String name = tfName.getText().trim();
		int price = Integer.parseInt(tfPrice.getText().trim());
		return new Food(price, name, fk);
	}
	
	public Food getFoodUP() throws Exception {
		validCheck();
		
		FoodKind fk = (FoodKind) cmbKind.getSelectedItem();
		String name = tfName.getText().trim();
		int price = Integer.parseInt(tfPrice.getText().trim());
		return new Food(no, price, name, fk);
	}
		
	private void validCheck() throws Exception {
		if(cmbKind.getSelectedItem() == null) {
			throw new Exception("음식종류를 선택하세요.");
		}
		if(tfName.getText().equals("")) {
			throw new Exception("이름을 입력하세요.");
		}
		if(tfPrice.getText().equals("")) {
			throw new Exception("가격을 입력하세요.");
		}
	}
	
	public void setList(List<FoodKind> list) {
		this.fkList = list;
	}
	
	public FoodKind getFoods() {
		return (FoodKind) cmbKind.getSelectedItem();
	}
}
