package kr.or.yi.food_mgm_program.dto;

public class Menu {
	private int menuNo;
	private String menuKind;
	
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuKind() {
		return menuKind;
	}
	public void setMenuKind(String menuKind) {
		this.menuKind = menuKind;
	}
	
	@Override
	public String toString() {
		return String.format("Menu [menuNo=%s, menuKind=%s]", menuNo, menuKind);
	}
}
