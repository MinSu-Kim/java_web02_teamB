package kr.or.yi.food_mgm_program.dto;

public class FoodKind {
	private int fkNo;
	private String name;
	private Menu menuNo;
	
	public int getFkNo() {
		return fkNo;
	}

	public void setFkNo(int fkNo) {
		this.fkNo = fkNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Menu getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(Menu menuNo) {
		this.menuNo = menuNo;
	}

	@Override
	public String toString() {
		return String.format("FoodKind [fkNo=%s, name=%s]", fkNo, name);
	}

}
