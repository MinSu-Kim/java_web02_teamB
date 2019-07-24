package kr.or.yi.food_mgm_program.dto;

public class Post {
	private String zipcode;
	private String doro;
	private String oldDoro;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public String getOldDoro() {
		return oldDoro;
	}

	public void setOldDoro(String oldDoro) {
		this.oldDoro = oldDoro;
	}

	@Override
	public String toString() {
		return String.format("Post [zipcode=%s, doro=%s, oldDoro=%s]", zipcode, doro, oldDoro);
	}

}
