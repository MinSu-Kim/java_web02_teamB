package kr.or.yi.food_mgm_program.dto;

public class Manager {
	private String mgId;
	private String mgPwd;
	
	public Manager() {
	}
	
	public Manager(String mgId) {
		this.mgId = mgId;
	}

	public String getMgId() {
		return mgId;
	}
	public void setMgId(String mgId) {
		this.mgId = mgId;
	}
	public String getMgPwd() {
		return mgPwd;
	}
	public void setMgPwd(String mgPwd) {
		this.mgPwd = mgPwd;
	}
	
	@Override
	public String toString() {
		return String.format("Manager [mgId=%s, mgPwd=%s]", mgId, mgPwd);
	}
}
