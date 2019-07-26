package kr.or.yi.food_mgm_program.dto;

public class Grade {
	private String grade;
	private int gDiscount;
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	
	public Grade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getG_discount() {
		return gDiscount;
	}

	public void setG_discount(int g_discount) {
		this.gDiscount = g_discount;
	}

	@Override
	public String toString() {
		return String.format("Grade [grade=%s, g_discount=%s]", grade, gDiscount);
	}
}
