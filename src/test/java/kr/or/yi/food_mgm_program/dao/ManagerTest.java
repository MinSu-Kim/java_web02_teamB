package kr.or.yi.food_mgm_program.dao;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.food_mgm_program.AbstractTest;
import kr.or.yi.food_mgm_program.daoImpl.ManagerDaoImpl;
import kr.or.yi.food_mgm_program.dto.Manager;

public class ManagerTest extends AbstractTest {
	private static ManagerDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new ManagerDaoImpl();
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
		
	}

	
	
	
}
