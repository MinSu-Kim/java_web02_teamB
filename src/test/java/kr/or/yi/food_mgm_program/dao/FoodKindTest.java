package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.food_mgm_program.AbstractTest;
import kr.or.yi.food_mgm_program.dao.FoodKindDao;
import kr.or.yi.food_mgm_program.dao.MenuDao;
import kr.or.yi.food_mgm_program.daoImpl.FoodKindDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.MenuDaoImpl;
import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.dto.Menu;

public class FoodKindTest extends AbstractTest {
	private static FoodKindDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new FoodKindDaoImpl();
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
		
	}

	@Test
	public void test01SelectByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Menu menu = new Menu();
		menu.setMenuNo(1);
		FoodKind food = new FoodKind();
		food.setMenuNo(menu);
		List<FoodKind> list = dao.selectByNo(food);
		System.out.println(list.toString());
		Assert.assertNotNull(list);
	}
	
	
}
