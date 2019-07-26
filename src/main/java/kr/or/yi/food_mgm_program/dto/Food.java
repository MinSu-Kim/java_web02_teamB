package kr.or.yi.food_mgm_program.dto;

public class Food {
	private int fdNo;
	private int price;
	private String name;
	private FoodKind fkNo;
	
	public Food() {
		// TODO Auto-generated constructor stub
	}
	
	public Food(FoodKind fkNo) {
		this.fkNo = fkNo;
	}

	public Food(int fdNo) {
		this.fdNo = fdNo;
	}

	
	public Food(int fdNo, int price, String name, FoodKind fkNo) {
		this.fdNo = fdNo;
		this.price = price;
		this.name = name;
		this.fkNo = fkNo;
	}
	
	public int getFdNo() {
		return fdNo;
	}

	public void setFdNo(int fdNo) {
		this.fdNo = fdNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodKind getFkNo() {
		return fkNo;
	}

	public void setFkNo(FoodKind fkNo) {
		this.fkNo = fkNo;
	}

	@Override
	public String toString() {
		return String.format("Food [fdNo=%s, price=%s, name=%s, fkNo=%s]", fdNo, price, name, fkNo);
	}

	public Object[] toArray() {
		return new Object[]{fkNo.getName() , String.format("F%03d", fdNo), name, price};
	}
	
}
