package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Member;

public interface MemberDao {
	public List<Member> selectMemberByAll();
	
}
