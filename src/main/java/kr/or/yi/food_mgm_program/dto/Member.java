package kr.or.yi.food_mgm_program.dto;

import java.util.Date;
import java.util.List;

public class Member {
	private int mbNo;
	private String name;
	private Date birth;
	private String tel;
	private int Mileage;
	private Grade grade;
	private String address;
	private List<Coupon> coupon;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int mbNo) {
		super();
		this.mbNo = mbNo;
	}
	
	public Member(String name, Date birth, String tel, int mileage, Grade grade, String address, List<Coupon> coupon) {
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		Mileage = mileage;
		this.grade = grade;
		this.address = address;
		this.coupon = coupon;
	}
	
	public Member(int mbNo, String name, Date birth, String tel, String address) {
		this.mbNo = mbNo;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.address = address;
	}

	public int getMbNo() {
		return mbNo;
	}

	public void setMbNo(int mbNo) {
		this.mbNo = mbNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getMileage() {
		return Mileage;
	}

	public void setMileage(int mileage) {
		Mileage = mileage;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Coupon> getCoupon() {
		return coupon;
	}

	public void setCoupon(List<Coupon> coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return String.format("Member [mbNo=%s, name=%s, birth=%s, tel=%s, Mileage=%s, grade=%s, address=%s, coupon=%s]",
				mbNo, name, birth, tel, Mileage, grade, address, coupon);
	}

	public Object[] toArray() {
		return new Object[]{String.format("M%03d", mbNo), name, String.format("%tF", birth), tel, address};
	}
	
	public Object[] toArray2() {
		return new Object[]{String.format("M%03d", mbNo), name, String.format("%tF", birth), tel, Mileage, String.format("%s", grade.getGrade()), address};
	}
}
