package kr.or.yi.food_mgm_program.dto;

import java.util.Date;

public class Sale {
	private int salNo;
	private Food fdNo;
	private Date date;
	private Date time;
	private int orderCnt;
	private Member mbNo;
	private boolean orderKind;

	public int getSalNo() {
		return salNo;
	}

	public void setSalNo(int salNo) {
		this.salNo = salNo;
	}

	public Food getFdNo() {
		return fdNo;
	}

	public void setFdNo(Food fdNo) {
		this.fdNo = fdNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getOrderCnt() {
		return orderCnt;
	}

	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}

	public Member getMbNo() {
		return mbNo;
	}

	public void setMbNo(Member mbNo) {
		this.mbNo = mbNo;
	}

	public boolean isOrderKind() {
		return orderKind;
	}

	public void setOrderKind(boolean orderKind) {
		this.orderKind = orderKind;
	}

	@Override
	public String toString() {
		return String.format("Sale [salNo=%s, fdNo=%s, date=%s, time=%s, orderCnt=%s, mbNo=%s, orderKind=%s]", salNo,
				fdNo, date, time, orderCnt, mbNo, orderKind);
	}

}
