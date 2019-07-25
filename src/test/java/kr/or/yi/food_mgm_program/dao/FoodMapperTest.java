package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.food_mgm_program.AbstractTest;
import kr.or.yi.food_mgm_program.daoImpl.FoodMapperImpl;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.FoodKind;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FoodMapperTest extends AbstractTest {
	private static FoodMapper foodDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		foodDao = new FoodMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		foodDao = null;
	}

	@Test
	public void test01selectFoodByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Food> lists = foodDao.selectFoodByAll();
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
//	@Test
//	public void test02InsertFood() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
//		Food food = new Food(75, 1000, "공기밥", new FoodKind(1));
//		int res = foodDao.insertFood(food);
//		Assert.assertEquals(1, res);
//	}
}
