package kr.or.yi.food_mgm_program.dto;

public class Manager {
	private int mNo;
	private String id;
	private String pwd;

	
	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return String.format("Manager [mNo=%s, id=%s, pwd=%s]", mNo, id, pwd);
	}

}
