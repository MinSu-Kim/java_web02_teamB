package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.CouponDao;
import kr.or.yi.food_mgm_program.dao.MemberCouponDao;
import kr.or.yi.food_mgm_program.daoImpl.CouponDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.MemberCouponDaoImpl;
import kr.or.yi.food_mgm_program.dto.Coupon;
import kr.or.yi.food_mgm_program.dto.MemberCoupon;

public class PanelMCouponService {
	private static PanelMCouponService service = new PanelMCouponService();
	private CouponDao dao;
	private MemberCouponDao mcDao;
	
	public static PanelMCouponService getInstance() {
		return service;
	}

	public PanelMCouponService() {
		dao = new CouponDaoImpl();
		mcDao = new MemberCouponDaoImpl();
	}
	
	public List<Coupon> selectByCouponAll(){
		return dao.selectByCouponAll();
	}
	
	public int insertMemberCoupon(MemberCoupon memberCoupon) {
		return mcDao.insertMemberCoupon(memberCoupon);
	}
}
