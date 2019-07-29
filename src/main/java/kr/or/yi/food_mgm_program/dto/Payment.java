package kr.or.yi.food_mgm_program.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
	private int payNo;
	private Date payTime;
	private String payMenu;
	private int payPrice;
	private int payType;
	private String payMember;
	private String payDiscountInfo;
	private int payDiscountPrice;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int payNo, Date payTime, String payMenu, int payPrice, int payType, String payMember,
			String payDiscountInfo, int payDiscountPrice) {
		super();
		this.payNo = payNo;
		this.payTime = payTime;
		this.payMenu = payMenu;
		this.payPrice = payPrice;
		this.payType = payType;
		this.payMember = payMember;
		this.payDiscountInfo = payDiscountInfo;
		this.payDiscountPrice = payDiscountPrice;
	}

	@Override
	public String toString() {
		return String.format(
				"Payment [payNo=%s, payTime=%s, payMenu=%s, payPrice=%s, payType=%s, payMember=%s, payDiscountInfo=%s, payDiscountPrice=%s]",
				payNo, payTime, payMenu, payPrice, payType, payMember, payDiscountInfo, payDiscountPrice);
	}

	public Object[] toArray() {
		SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String[] arrPayMenu = payMenu.split(",");
		return new Object[] { payNo, sDate.format(payTime), payMenu, payPrice, payDiscountInfo, payDiscountPrice,
				payType == 1 ? "현금" : "카드", payMember };
	}

}
