package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Member;

public interface MemberDao {
	public List<Member> selectMemberByAll();
	public int insertMember(Member member);
	public List<Member> selectMemberByTel(Member member);
	public int updateMember(Member member);
	public int deleteMember(Member member);
	public List<Member> selectMemberByNo(Member member);
	public Member selectByTel(int tel);
}
