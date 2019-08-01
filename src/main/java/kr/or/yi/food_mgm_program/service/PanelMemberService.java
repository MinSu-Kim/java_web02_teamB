package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.MemberCouponDao;
import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberCouponDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.MemberCoupon;

public class PanelMemberService {
	private static PanelMemberService service = new PanelMemberService();
	private MemberDao dao;
	private MemberCouponDao mcDao;
	
	public static PanelMemberService getInstance() {
		return service;
	}

	public PanelMemberService() {
		dao = new MemberDaoImpl();
		mcDao = new MemberCouponDaoImpl();
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
	
	public List<Member> selectMemberByAllNM(){
		return dao.selectMemberByAllNM();
	}
	
	public int updateTrnasMember(Member member) {
		return dao.updateTrnasMember(member);
	}
	
	public int insertMemberCoupon(MemberCoupon memberCoupon) {
		return mcDao.insertMemberCoupon(memberCoupon);
	}
	
}
