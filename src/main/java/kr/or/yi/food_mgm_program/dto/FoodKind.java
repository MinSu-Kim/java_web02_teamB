package kr.or.yi.food_mgm_program.dto;

public class FoodKind {
	public int fkNo;
	public String name;

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

	@Override
	public String toString() {
		return String.format("FoodKind [fkNo=%s, name=%s]", fkNo, name);
	}

}
