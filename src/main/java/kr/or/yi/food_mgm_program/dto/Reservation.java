package kr.or.yi.food_mgm_program.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	private int rsvNo;
	private int rsvNumber; //인원
	private Date rsvTime; //예약시간
	private Member mbNo; // 회원번호
	private String rsvTableNo; // 테이블 번호
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int rsvNumber, Date rsvTime, Member mbNo, String rsvTableNo) {
		this.rsvNumber = rsvNumber;
		this.rsvTime = rsvTime;
		this.mbNo = mbNo;
		this.rsvTableNo = rsvTableNo;
	}



	public int getRsvNo() {
		return rsvNo;
	}

	public void setRsvNo(int rsvNo) {
		this.rsvNo = rsvNo;
	}

	public int getRsvNumber() {
		return rsvNumber;
	}

	public void setRsvNumber(int rsvNumber) {
		this.rsvNumber = rsvNumber;
	}

	public Date getRsvTime() {
		return rsvTime;
	}

	public void setRsvTime(Date rsvTime) {
		this.rsvTime = rsvTime;
	}

	public Member getMbNo() {
		return mbNo;
	}

	public void setMbNo(Member mbNo) {
		this.mbNo = mbNo;
	}

	public String getRsvTableNo() {
		return rsvTableNo;
	}

	public void setRsvTableNo(String rsvTableNo) {
		this.rsvTableNo = rsvTableNo;
	}

	@Override
	public String toString() {
		return String.format("Reservation [rsvNo=%s, rsvNumber=%s, rsvTime=%s, mbNo=%s, rsvTableNo=%s]", rsvNo,
				rsvNumber, rsvTime, mbNo, rsvTableNo);
	}
	
	public Object[] toArray() {
		
		
		return new Object[]{mbNo.getMbNo(), mbNo.getMbName(), mbNo.getMbTel(), rsvNumber, rsvTime, rsvTableNo };
	}
	
	
	
}
