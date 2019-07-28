package kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.yi.food_mgm_program.dao.FoodDao;
import kr.or.yi.food_mgm_program.dao.FoodKindDao;
import kr.or.yi.food_mgm_program.daoImpl.FoodDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.FoodKindDaoImpl;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.dto.Menu;
import kr.or.yi.food_mgm_program.ui.MenuListFrame;
import kr.or.yi.food_mgm_program.ui.content.seatMgm.orderList.PanelOrderList;
import javax.swing.JLabel;

public abstract class AbstractPanelMenuList extends JPanel implements ActionListener {
	
	protected List<FoodKind> list;
	private FoodKindDao dao;
	private FoodKind foodkind;
	protected Food food;
	protected FoodDao fDao;
	protected Menu menu;
	protected JPanel panel;
	protected PanelOrderList pOrder;
	protected MenuListFrame frame;
	
	public AbstractPanelMenuList() {
		
		initComponents();
		frame = new MenuListFrame();
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
	
	private void addBtn(List<FoodKind> list) {
		for(int i=0; i<list.size(); i++) {
			ImageIcon image = new ImageIcon("image/"+list.get(i).getFkName()+".jpg");
			Image image1 = image.getImage();
			Image image3 = null;
			if(list.get(i).getFkName().equals("사이드 메뉴")) {
				image3 = image1.getScaledInstance(600, 240, Image.SCALE_SMOOTH);
			}else if(list.get(i).getFkName().equals("음료") || list.get(i).getFkName().equals("맥주")) {
				image3 = image1.getScaledInstance(260, 240, Image.SCALE_SMOOTH);
			}else {
				image3 = image1.getScaledInstance(200, 120, Image.SCALE_SMOOTH);
			}
			ImageIcon image4 = new ImageIcon(image3);
			JButton btn = new JButton(list.get(i).getFkName(), image4);
			JPanel panelMenu = new JPanel();
			JPanel panelName = new JPanel();
			JLabel labelName = new JLabel(list.get(i).getFkName());
			panelName.add(labelName);
			panelMenu.setLayout(new BorderLayout(0, 0));
			panelMenu.add(panelName, BorderLayout.NORTH);
			panelMenu.add(btn, BorderLayout.CENTER);
			panel.add(panelMenu);
			btn.addActionListener(this);
		}
		
	}
	public void setOrderList(PanelOrderList orderlist) {
		this.pOrder = orderlist;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, "dd");
		for(FoodKind fk : list) {
			if(e.getActionCommand().equals(fk.getFkName())) {
			
				actionPerformedBtn(fk);
			}
		}
		
		
	}

	private void actionPerformedBtn(FoodKind fk) {
		food.setFkNo(fk);//음식종류
//		JOptionPane.showMessageDialog(null, fk.toString());
		fDao.selectByNo(food); // 해당 종류의 음식리스트
//		JOptionPane.showMessageDialog(null, fDao.selectByNo(food).toString());
		frame.setFood(fDao.selectByNo(food));
		frame.setDao(fDao);
		frame.setPOrder(pOrder);
		showMainMenu();
	}

	private void showMainMenu() {
		frame.reloadData();
		frame.setVisible(true);
	}


}
