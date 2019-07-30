package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;

public class PanelMemberService {
	private static PanelMemberService service = new PanelMemberService();
	private MemberDao dao;
	
	public static PanelMemberService getInstance() {
		return service;
	}

	public PanelMemberService() {
		dao = new MemberDaoImpl();
	}
	
	public List<Member> selectMemberByAll(){
		return dao.selectMemberByAll();
	}
	public List<Member> selectMemberByTel(Member member){
		return dao.selectMemberByTel(member);
	}
	
	public int updateMember(Member member) {
		return dao.updateMember(member);
	}
	public int deleteMember(Member member) {
		return dao.deleteMember(member);
	}
	public int insertMember(Member member) {
		return dao.insertMember(member);
	}
	
}
