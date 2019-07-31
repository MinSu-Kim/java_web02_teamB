package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.food_mgm_program.AbstractTest;
import kr.or.yi.food_mgm_program.daoImpl.CouponDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.ManagerDaoImpl;
import kr.or.yi.food_mgm_program.dto.Coupon;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.Manager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CouponDaoTest extends AbstractTest {
	private static CouponDao couponDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		couponDao = new CouponDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		couponDao = null;
	}

	@Test
	public void test01SelectByCouponAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Coupon> lists = couponDao.selectByCouponAll();
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
}
