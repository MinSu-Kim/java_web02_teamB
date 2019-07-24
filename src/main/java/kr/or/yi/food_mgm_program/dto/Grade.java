package kr.or.yi.food_mgm_program.dto;

public class Grade {
	private String grade;
	private int discount;

	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return String.format("Grade [grade=%s, discount=%s]", grade, discount);
	}

}
