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
		List<Sale> lists = dao.selectSaleByDate("2019-07-24");
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
	//@Test
	public void test04selectSalesStatusByDate() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<SalesStatus> lists = dao.selectSalesStatusByDate("2019-07-24");
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
	//@Test
	public void test03selectSalesStatusByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<SalesStatus> lists = dao.selectSalesStatusByAll();
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
	//@Test
	public void test03insertSale() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Sale s1 = new Sale( 2, new Date(), 2, false, 0, new Food(1), new Member(2));
		Sale s2 = new Sale( 2, new Date(), 2, false, 0, new Food(1), new Member(2));
		Sale s3 = new Sale( 4, new Date(), 2, false, 0, new Food(1), new Member(2));
		
		List<Sale> list = Arrays.asList(s1,s2,s3);
		Map<String, List<Sale>> map = new HashMap<>();
		
		map.put("list", list);
		int res = dao.insertSale(map);
		
		
		Assert.assertEquals(3, res);
	}


}
