package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.CouponDao;
import kr.or.yi.food_mgm_program.dao.MemberCouponDao;
import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.daoImpl.CouponDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.MemberCouponDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.dto.Coupon;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.MemberCoupon;
import kr.or.yi.food_mgm_program.ui.list.memberList;

public class PanelMemberService {
	private static PanelMemberService service = new PanelMemberService();
	private MemberDao dao;
	private MemberCouponDao mcDao;
	private CouponDao cDao;
	
	public static PanelMemberService getInstance() {
		return service;
	}

	public PanelMemberService() {
		dao = new MemberDaoImpl();
		mcDao = new MemberCouponDaoImpl();
		cDao = new CouponDaoImpl(); 
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
	
	public Member selectByNameTel(Member member){
		return dao.selectByNameTel(member);
	}
	
	public List<Coupon> selectByCouponAll(){
		return cDao.selectByCouponAll();
	}
	
	public List<MemberCoupon> selectByMbNo(MemberCoupon memberCoupon){
		return mcDao.selectByMbNo(memberCoupon);
	}
	
	public int deleteByMbNo(MemberCoupon memberCoupon) {
		return mcDao.deleteByMbNo(memberCoupon);
	}
	
}










