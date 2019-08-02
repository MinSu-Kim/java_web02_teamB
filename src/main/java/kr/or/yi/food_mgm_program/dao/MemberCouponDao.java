package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.MemberCoupon;

public interface MemberCouponDao {
	public int insertMemberCoupon(MemberCoupon memberCoupon);
	public List<MemberCoupon> selectByMbNo(MemberCoupon memberCoupon);
	public int deleteByMbNo(MemberCoupon memberCoupon);
	public List<MemberCoupon> selectByAll();
	
}
