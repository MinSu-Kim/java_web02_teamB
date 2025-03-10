package kr.or.yi.food_mgm_program.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.food_mgm_program.AbstractTest;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.dto.SalesStatus;

public class SaleDaoTest extends AbstractTest{
	private static SaleDao dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new SaleDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	//@Test
	public void test01selectSaleByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Sale> lists = dao.selectSaleByAll();
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
	//@Test
	public void test02selectSaleByDate() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Sale> lists = dao.selectSaleByDate("2019-07-29");
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
	//@Test
	public void test03updateSaleByCancel() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("cancel", 1);
		map.put("no", 1);
		dao.updateSaleByCancel(map);
	}
	
	@Test
		public void test04updateSaleByCancel() {
			log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
			dao.totalPrice(2);
		}


}
