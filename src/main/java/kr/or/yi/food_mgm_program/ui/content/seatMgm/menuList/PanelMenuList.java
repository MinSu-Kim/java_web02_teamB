package kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList;

import java.awt.GridLayout;

import kr.or.yi.food_mgm_program.dto.FoodMenu;

public class PanelMenuList extends AbstractPanelMenuList {
		
	

	public PanelMenuList() {
		super();
		
	}

	@Override
	protected void setting() {
		menu = new FoodMenu(1);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
	}

}
