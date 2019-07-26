package kr.or.yi.food_mgm_program.ui.content;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dao.FoodDao;
import kr.or.yi.food_mgm_program.dao.FoodKindDao;
import kr.or.yi.food_mgm_program.daoImpl.FoodDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.FoodKindDaoImpl;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.ui.insert.PanelFoodInfo;
import kr.or.yi.food_mgm_program.ui.list.FoodList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelFood extends JPanel implements ActionListener {
	private JTextField tfSearch;
	
	private FoodDao fDao;
	private FoodKindDao fkDao;
	private List<Food> fList;
	private List<FoodKind> fkList;

	private FoodList pFoodList;
	private JButton btnAdd;
	private JButton btnCancel;

	private PanelFoodInfo pFood;
	public DefaultComboBoxModel<FoodKind> fkModels;
	
	public PanelFood() {
		fDao = new FoodDaoImpl();
		fkDao = new FoodKindDaoImpl();
		
		fList = fDao.selectFoodByAll();
		fkList = fkDao.selectFoodKindByAll();
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel pInsert = new JPanel();
		add(pInsert);
		
		pInsert.setLayout(new BoxLayout(pInsert, BoxLayout.X_AXIS));
		
		pFood = new PanelFoodInfo();
		pFood.setFoodKindCmbModel(fkList);
		
		GridLayout gl_pFood = (GridLayout) pFood.getLayout();
		gl_pFood.setHgap(10);
		pInsert.add(pFood);
		
		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(0, 0, 0, 30));
		pInsert.add(pBtn);
		pBtn.setLayout(new BoxLayout(pBtn, BoxLayout.Y_AXIS));
		
		btnAdd = new JButton("추가");
		btnAdd.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		JPanel pList = new JPanel();
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));
		
		JPanel pSearch = new JPanel();
		pList.add(pSearch, BorderLayout.NORTH);
		pSearch.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		tfSearch = new JTextField();
		tfSearch.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSearch.add(tfSearch);
		tfSearch.setColumns(30);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBorder(new EmptyBorder(10, 20, 10, 20));
		pSearch.add(btnSearch);
		
		pFoodList = new FoodList((String) null);
		pList.add(pFoodList, BorderLayout.CENTER);
		reloadList();
	}
	
	public void reloadList() {
		fList = fDao.selectFoodByAll();
		pFoodList.setItemList(fList);
		pFoodList.reloadData();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Food food = pFood.getFood();
		fDao.insertFood(food);
		reloadList();
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pFood.clearFoodInfo();
	}
}
