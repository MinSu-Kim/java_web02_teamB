package kr.or.yi.food_mgm_program.dto;

public class Coupon {
	private int cpNo;
	private String name;
	private int discount;

	public int getCpNo() {
		return cpNo;
	}

	public void setCpNo(int cpNo) {
		this.cpNo = cpNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return String.format("Coupon [cpNo=%s, name=%s, discount=%s]", cpNo, name, discount);
	}

}
