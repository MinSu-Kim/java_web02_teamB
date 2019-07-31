package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.CouponDao;
import kr.or.yi.food_mgm_program.daoImpl.CouponDaoImpl;
import kr.or.yi.food_mgm_program.dto.Coupon;

public class PanelMCouponService {
	private static PanelMCouponService service = new PanelMCouponService();
	private CouponDao dao;
	
	public static PanelMCouponService getInstance() {
		return service;
	}

	public PanelMCouponService() {
		dao = new CouponDaoImpl();
	}
	
	public List<Coupon> selectByCouponAll(){
		return dao.selectByCouponAll();
	}
}
