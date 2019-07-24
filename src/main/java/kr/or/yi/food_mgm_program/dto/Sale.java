package kr.or.yi.food_mgm_program.dto;

import java.util.Date;

public class Sale {
	private int no;
	private int saleNo;
	private Date saletime;
	private int orderCnt;
	private boolean orderKind;
	private int saleType;
	private Food fdNo;
	private Member mbNo;

	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(int saleNo) {
		this.saleNo = saleNo;
	}
	public Date getSaletime() {
		return saletime;
	}
	public void setSaletime(Date saletime) {
		this.saletime = saletime;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public boolean isOrderKind() {
		return orderKind;
	}
	public void setOrderKind(boolean orderKind) {
		this.orderKind = orderKind;
	}
	public int getSaleType() {
		return saleType;
	}
	public void setSaleType(int saleType) {
		this.saleType = saleType;
	}
	public Food getFdNo() {
		return fdNo;
	}
	public void setFdNo(Food fdNo) {
		this.fdNo = fdNo;
	}
	public Member getMbNo() {
		return mbNo;
	}
	public void setMbNo(Member mbNo) {
		this.mbNo = mbNo;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Sale [no=%s, saleNo=%s, saletime=%s, orderCnt=%s, orderKind=%s, saleType=%s, fdNo=%s, mbNo=%s]", no,
				saleNo, saletime, orderCnt, orderKind, saleType, fdNo, mbNo);
	}

}
