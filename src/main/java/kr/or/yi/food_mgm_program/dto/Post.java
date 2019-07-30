package kr.or.yi.food_mgm_program.dto;

public class Post {
	private String pZipcode;
	private String pSido;
	private String pSigungu;
	private String pDoro;
	private String pAddress1;
	private String pAddress2;
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public String getpZipcode() {
		return pZipcode;
	}

	public void setpZipcode(String pZipcode) {
		this.pZipcode = pZipcode;
	}

	public String getpSido() {
		return pSido;
	}

	public void setpSido(String pSido) {
		this.pSido = pSido;
	}

	public String getpSigungu() {
		return pSigungu;
	}

	public void setpSigungu(String pSigungu) {
		this.pSigungu = pSigungu;
	}

	public String getpDoro() {
		return pDoro;
	}

	public void setpDoro(String pDoro) {
		this.pDoro = pDoro;
	}

	public String getpAddress1() {
		return pAddress1;
	}

	public void setpAddress1(String pAddress1) {
		this.pAddress1 = pAddress1;
	}

	public String getpAddress2() {
		return pAddress2;
	}

	public void setpAddress2(String pAddress2) {
		this.pAddress2 = pAddress2;
	}

	@Override
	public String toString() {
		return String.format("Post [pZipcode=%s, pSido=%s, pSigungu=%s, pDoro=%s, pAddress1=%s, pAddress2=%s]",
				pZipcode, pSido, pSigungu, pDoro, pAddress1, pAddress2);
	}
	
}
