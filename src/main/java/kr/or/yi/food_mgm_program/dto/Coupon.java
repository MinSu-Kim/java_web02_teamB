package kr.or.yi.food_mgm_program.dto;

public class Coupon {
	private int cpNo;
	private String cpName;
	private int cpDiscount;
	
	public Coupon() {
	}

	public Coupon(int cpNo) {
		super();
		this.cpNo = cpNo;
	}
	
	public Coupon(String cpName) {
		super();
		this.cpName = cpName;
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
		return String.format("%s", cpName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		return result;
	}


	public String toString2() {
		return String.format("Coupon [cpNo=%s, cpName=%s, cpDiscount=%s]", cpNo, cpName, cpDiscount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		return true;
	}

	

	
}
