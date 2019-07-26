package kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.dto.Menu;
import kr.or.yi.food_mgm_program.ui.MenuListFrame;

public class PanelMenuList extends AbstractPanelMenuList {
		
	private MenuListFrame frame;

	public PanelMenuList() {
		super();
		frame = new MenuListFrame();
	}

	@Override
	protected void setting() {
		menu = new Menu(1);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(FoodKind fk : list) {
			if(e.getActionCommand().equals(fk.getName())) {
			
				actionPerformedBtn(fk);
			}
		}
		
		
	}

	private void actionPerformedBtn(FoodKind fk) {
		food.setFkNo(fk);//음식종류
		fDao.selectByNo(food); // 해당 종류의 음식리스트
		frame.setFood(fDao.selectByNo(food));
		showMainMenu();
	}

	private void showMainMenu() {
		frame.reloadData();
		frame.setVisible(true);
	}

	
	
	
	

}
