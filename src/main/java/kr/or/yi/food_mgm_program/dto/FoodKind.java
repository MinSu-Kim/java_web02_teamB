package kr.or.yi.food_mgm_program.dto;

public class FoodKind {
	private int fkNo;
	private String fkName;
	private Menu menuNo;
	
	public FoodKind() {
	}
	
	public FoodKind(int fkNo) {
		this.fkNo = fkNo;
	}

	public FoodKind(Menu menuNo) {
		this.menuNo = menuNo;
	}
	
	public FoodKind(int fkNo, String fkName, Menu menuNo) {
		this.fkNo = fkNo;
		this.fkName = fkName;
		this.menuNo = menuNo;
	}

	public int getFkNo() {
		return fkNo;
	}

	public void setFkNo(int fkNo) {
		this.fkNo = fkNo;
	}

	public String getFkName() {
		return fkName;
	}

	public void setFkName(String fkName) {
		this.fkName = fkName;
	}

	public Menu getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(Menu menuNo) {
		this.menuNo = menuNo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuNo == null) ? 0 : menuNo.hashCode());
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
		FoodKind other = (FoodKind) obj;
		if (menuNo == null) {
			if (other.menuNo != null)
				return false;
		} else if (!menuNo.equals(other.menuNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("FoodKind [fkNo=%s, fkName=%s, menuNo=%s]", fkNo, fkName, menuNo);
	}
}
