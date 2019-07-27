package kr.or.yi.food_mgm_program.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
	private int payNo;
	private Date payTime;
	private String payMenu;
	private int PayPrice;
	private int payType;
	private String PayMember;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int payNo, Date payTime, String payMenu, int payPrice, int payType, String payMember) {
		super();
		this.payNo = payNo;
		this.payTime = payTime;
		this.payMenu = payMenu;
		PayPrice = payPrice;
		this.payType = payType;
		PayMember = payMember;
	}

	@Override
	public String toString() {
		return String.format("Payment [payNo=%s, payTime=%s, payMenu=%s, PayPrice=%s, payType=%s, PayMember=%s]", payNo,
				payTime, payMenu, PayPrice, payType, PayMember);
	}
	
	public Object[] toArray() {
		SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return new Object[] { payNo, sDate.format(payTime), payMenu,PayPrice, payType==1?"현금" : "카드",PayMember };
	}

}
