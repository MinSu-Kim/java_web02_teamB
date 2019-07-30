package kr.or.yi.food_mgm_program.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.food_mgm_program.AbstractTest;
import kr.or.yi.food_mgm_program.daoImpl.PostDaoImpl;
import kr.or.yi.food_mgm_program.dto.Post;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostDaoTest extends AbstractTest{
	private static PostDao postDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		postDao = new PostDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		postDao = null;
	}

	@Test
	public void test01SelectBySiGunGu() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Post post = new Post();
		post.setpSigungu("동구");
		List<Post> list = postDao.selectBySiGunGu(post);
		log.debug(list.toString());
		Assert.assertNotNull(list);
	}

}
