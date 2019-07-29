package kr.or.yi.food_mgm_program.dto;

public class Coupon {
	private int cpNo;
	private String cpName;
	private int cpDiscount;
	private boolean cpUse;
	
	public Coupon() {
	}

	public Coupon(int cpNo) {
		super();
		this.cpNo = cpNo;
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
	
	public boolean isCpUse() {
		return cpUse;
	}

	public void setCpUse(boolean cpUse) {
		this.cpUse = cpUse;
	}

	@Override
	public String toString() {
		return String.format("%s", cpName);
	}
}
