package kr.or.yi.food_mgm_program.dto;

public class FoodKind {
	private int fkNo;
	private String name;
	private Menu menuNo;
	
	public FoodKind() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public FoodKind(int fkNo) {
		this.fkNo = fkNo;
	}



	public FoodKind(Menu menuNo) {
		this.menuNo = menuNo;
	}

	
	public FoodKind(int fkNo, String name, Menu menuNo) {
		this.fkNo = fkNo;
		this.name = name;
		this.menuNo = menuNo;
	}



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
		return String.format("FoodKind [fkNo=%s, name=%s]", fkNo, name);
	}

}
