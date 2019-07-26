package kr.or.yi.food_mgm_program.ui.content.seatMgm.menuList;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.dto.Menu;

public class PanelSide extends AbstractPanelMenuList {

	
	public PanelSide() {
		super();
	}

	@Override
	protected void setting() {
		menu = new Menu(2);
		panel.setLayout(new GridLayout(0, 1, 0, 0));		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(FoodKind fk : list) {
			if(e.getActionCommand().equals(fk.getFkName())) {
				JOptionPane.showMessageDialog(null, e.getActionCommand());
			}
		}
		
	}

	

	

}
