package kr.or.yi.food_mgm_program.dto;

public class Manager {
	private int mNo;
	private int id;
	private int pwd;

	
	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return String.format("Manager [mNo=%s, id=%s, pwd=%s]", mNo, id, pwd);
	}

}
