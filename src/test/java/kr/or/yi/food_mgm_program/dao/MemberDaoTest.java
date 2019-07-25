package kr.or.yi.food_mgm_program.dao;


import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.food_mgm_program.AbstractTest;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;

public class MemberDaoTest extends AbstractTest {
	private static MemberDao memberDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		memberDao = new MemberDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		memberDao = null;
	}

	@Test
	public void testSelectMemberByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Member> lists = memberDao.selectMemberByAll();
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}

}
