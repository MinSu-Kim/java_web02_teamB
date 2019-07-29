package kr.or.yi.food_mgm_program.dto;

public class FoodKind {
	private int fkNo;
	private String fkName;
	private FoodMenu foodMenuNo;
	
	public FoodKind() {
	}
	
	public FoodKind(int fkNo) {
		this.fkNo = fkNo;
	}

	public FoodKind(FoodMenu menuNo) {
		this.foodMenuNo = menuNo;
	}
	
	public FoodKind(int fkNo, String fkName, FoodMenu menuNo) {
		this.fkNo = fkNo;
		this.fkName = fkName;
		this.foodMenuNo = menuNo;
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

	public FoodMenu getMenuNo() {
		return foodMenuNo;
	}

	public void setMenuNo(FoodMenu menuNo) {
		this.foodMenuNo = menuNo;
	}
	

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((foodMenuNo == null) ? 0 : foodMenuNo.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		FoodKind other = (FoodKind) obj;
//		if (foodMenuNo == null) {
//			if (other.foodMenuNo == null)
//				return false;
//		} else if (!foodMenuNo.equals(other.foodMenuNo))
//			return false;
//		return true;
//	}

	@Override
	public String toString() {
		return String.format("%s", fkName);
	}
}
