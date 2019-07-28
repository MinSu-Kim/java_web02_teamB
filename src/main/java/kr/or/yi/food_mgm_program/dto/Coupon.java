package kr.or.yi.food_mgm_program.dto;

public class Coupon {
	private int cpNo;
	private String cpName;
	private int cpDiscount;
	
	public Coupon() {
	}

	public int getCpNo() {
		return cpNo;
	}

	public void setCpNo(int cpNo) {
		this.cpNo = cpNo;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public int getCpDiscount() {
		return cpDiscount;
	}

	public void setCpDiscount(int cpDiscount) {
		this.cpDiscount = cpDiscount;
	}

	@Override
	public String toString() {
		return String.format("Coupon [cpNo=%s, cpName=%s, cpDiscount=%s]", cpNo, cpName, cpDiscount);
	}
}
