package kr.or.yi.food_mgm_program.dto;

public class Menu {
	private int menuNo;
	private String menuKind;
	
	public Menu() {
	}
	
	public Menu(int menuNo) {
		this.menuNo = menuNo;
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + menuNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (menuNo != other.menuNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Menu [menuNo=%s, menuKind=%s]", menuNo, menuKind);
	}
	
}
