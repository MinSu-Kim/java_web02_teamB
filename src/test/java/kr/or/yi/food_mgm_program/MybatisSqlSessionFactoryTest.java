package kr.or.yi.food_mgm_program;


import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;


public class MybatisSqlSessionFactoryTest extends AbstractTest{
	@Test
	public void testOpenSession() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		SqlSession session = MybatisSqlSessionFactory.openSession();
		log.debug("session"+session);
		Assert.assertNotNull(session);
	}

}
