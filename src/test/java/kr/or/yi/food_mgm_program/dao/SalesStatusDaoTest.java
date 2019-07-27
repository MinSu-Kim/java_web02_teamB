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
import kr.or.yi.food_mgm_program.daoImpl.SalesStatusDaoImpl;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.dto.SalesStatus;

public class SalesStatusDaoTest extends AbstractTest{
	private static SalesStatusDao dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new SalesStatusDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	
	
	//@Test
	public void test04selectSalesStatusByDate() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<SalesStatus> lists = dao.selectSalesStatusByDate("2019-07-24");
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test03selectSalesStatusByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<SalesStatus> lists = dao.selectSalesStatusByAll();
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
	


}
