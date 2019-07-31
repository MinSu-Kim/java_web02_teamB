package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Coupon;

public interface CouponDao {
	public List<Coupon> selectByCouponAll();
}
