package kr.or.yi.food_mgm_program.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class Food {
	private int fdNo;
	private int fdPrice;
	private String fdName;
	private FoodKind fkNo;
	
	private int count = 1;
	
	public Food() {
		// TODO Auto-generated constructor stub
	}
	
	public Food(FoodKind fkNo) {
		this.fkNo = fkNo;
	}

	public Food(int fdNo) {
		this.fdNo = fdNo;
	}
	
	public Food(int fdNo, int fdPrice, String fdName, FoodKind fkNo) {
		this.fdNo = fdNo;
		this.fdPrice = fdPrice;
		this.fdName = fdName;
		this.fkNo = fkNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getFdNo() {
		return fdNo;
	}

	public void setFdNo(int fdNo) {
		this.fdNo = fdNo;
	}

	public int getFdPrice() {
		return fdPrice;
	}

	public void setFdPrice(int fdPrice) {
		this.fdPrice = fdPrice;
	}

	public String getFdName() {
		return fdName;
	}

	public void setFdName(String fdName) {
		this.fdName = fdName;
	}

	public FoodKind getFkNo() {
		return fkNo;
	}

	public void setFkNo(FoodKind fkNo) {
		this.fkNo = fkNo;
	}

	@Override
	public String toString() {
		return String.format("Food [fdNo=%s, fdPrice=%s, fdName=%s, fkNo=%s, count=%s]", fdNo, fdPrice, fdName, fkNo, count);
	}
	
	public Object[] toArray() {
		NumberFormat formatter = new DecimalFormat("###,###");
		String price = formatter.format(this.fdPrice);
		String total = formatter.format(this.fdPrice*this.count);
		return new Object[]{fdName, price, count, total };
	}

	public Object[] toArray2() {
		return new Object[]{fkNo.getFkName(), String.format("F%03d", fdNo), fdName, String.format("%,d", fdPrice)};
	}
	
}
