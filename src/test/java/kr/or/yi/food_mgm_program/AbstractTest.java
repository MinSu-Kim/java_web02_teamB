package kr.or.yi.food_mgm_program;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;

public class AbstractTest {
	protected static final Log log = LogFactory.getLog(AbstractTest.class);

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

}
