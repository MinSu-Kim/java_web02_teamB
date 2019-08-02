package kr.or.yi.food_mgm_program.dto;

public class MemberCoupon {
	private Coupon cpNo;
	private Member mbNo;
	private boolean cpUse;
	
	public MemberCoupon() {
	}

	public MemberCoupon(Coupon cpNo, Member mbNo) {
		this.cpNo = cpNo;
		this.mbNo = mbNo;
	}

	public Coupon getCpNo() {
		return cpNo;
	}

	public void setCpNo(Coupon cpNo) {
		this.cpNo = cpNo;
	}

	public Member getMbNo() {
		return mbNo;
	}

	public void setMbNo(Member mbNo) {
		this.mbNo = mbNo;
	}

	public boolean isCpUse() {
		return cpUse;
	}

	public void setCpUse(boolean cpUse) {
		this.cpUse = cpUse;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpNo == null) ? 0 : cpNo.hashCode());
		result = prime * result + ((mbNo == null) ? 0 : mbNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		MemberCoupon other = (MemberCoupon) obj;
		if (mbNo.getMbNo()==other.mbNo.getMbNo() && cpNo.getCpName().equals(other.cpNo.getCpName()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return String.format("MemberCoupon [cpNo=%s, mbNo=%s, cpUse=%s]", cpNo.toString2(), mbNo, cpUse);
	}
}








