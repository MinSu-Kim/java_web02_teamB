package kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList;

import java.awt.GridLayout;

import kr.or.yi.food_mgm_program.dto.FoodMenu;

public class PanelDrink extends AbstractPanelMenuList {

	
	public PanelDrink() {
		super();
	}

	@Override
	protected void setting() {
		menu = new FoodMenu(3);
		panel.setLayout(new GridLayout(0, 2, 0, 0));		
	}
	

}
