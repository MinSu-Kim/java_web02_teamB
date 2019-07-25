package kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.dto.Menu;

public class PanelDrink extends AbstractPanelMenuList {

	
	public PanelDrink() {
		super();
	}

	@Override
	protected void setting() {
		menu = new Menu(3);
		panel.setLayout(new GridLayout(0, 2, 0, 0));		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(FoodKind fk : list) {
			if(e.getActionCommand().equals(fk.getName())) {
				JOptionPane.showMessageDialog(null, e.getActionCommand());
			}
		}
	}
	

}
