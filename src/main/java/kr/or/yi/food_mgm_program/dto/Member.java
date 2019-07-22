package kr.or.yi.food_mgm_program.dto;

import java.util.Date;

public class Member {
	private int mbNo;
	private String name;
	private Date birth;
	private int tel;
	private int Mileage;
	private Grade grade;
	private String address;

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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
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

	@Override
	public String toString() {
		return String.format("Member [mbNo=%s, name=%s, birth=%s, tel=%s, Mileage=%s, grade=%s, address=%s]", mbNo,
				name, birth, tel, Mileage, grade, address);
	}

}
