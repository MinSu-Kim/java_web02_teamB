package kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.yi.food_mgm_program.dao.FoodDao;
import kr.or.yi.food_mgm_program.dao.FoodKindDao;
import kr.or.yi.food_mgm_program.daoImpl.FoodDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.FoodKindDaoImpl;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.dto.Menu;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList.PanelOrderList;

public abstract class AbstractPanelMenuList extends JPanel implements ActionListener {
	
	protected List<FoodKind> list;
	private FoodKindDao dao;
	private FoodKind foodkind;
	protected Food food;
	protected FoodDao fDao;
	protected Menu menu;
	protected JPanel panel;
	protected PanelOrderList pOrder;
	
	public AbstractPanelMenuList() {
		
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		dao = new FoodKindDaoImpl();
		fDao = new FoodDaoImpl();
		food = new Food();
		setting();
		
		foodkind = new FoodKind(menu);
		
		list = dao.selectByNo(foodkind);
		addBtn(list);
		
	}
	protected abstract void setting(); 
	
	private void addBtn(List<FoodKind> list2) {
		for(int i=0; i<list2.size(); i++) {
			JButton btn = new JButton(list2.get(i).getFkName());
			panel.add(btn);
			btn.addActionListener(this);
		}
		
	}
	public void setOrderList(PanelOrderList orderlist) {
		this.pOrder = orderlist;
	}

}
