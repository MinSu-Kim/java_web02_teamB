package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.FoodDao;
import kr.or.yi.food_mgm_program.dao.FoodKindDao;
import kr.or.yi.food_mgm_program.daoImpl.FoodDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.FoodKindDaoImpl;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.dto.FoodKind;

public class MenuListService {
	private static MenuListService service = new MenuListService();
	private FoodDao dao;
	private FoodKindDao FKDao;
	
	public static MenuListService getInstance() {
		return service;
	}

	public MenuListService() {
		dao = new FoodDaoImpl();
		FKDao = new FoodKindDaoImpl();
	}
	
	public Food selectByName(Food food) {
		return dao.selectByNames(food);
	}
	
	public List<Food> selectByName1(Food food) {
		return dao.selectByName(food);
	}
	
	public List<FoodKind> selectByNo(FoodKind foodkind){
		return FKDao.selectByNo(foodkind);
	}
	
	public List<Food> selectByNo(Food food){
		return dao.selectByNo(food);
	}
	
	public List<Food> selectFoodByAll(){
		return dao.selectFoodByAll();
	}
	
	public List<FoodKind> selectFoodKindByAll(){
		return FKDao.selectFoodKindByAll();
	}
	
	public int updateFood(Food food) {
		return dao.updateFood(food);
	}
	
	public int deleteFood(Food food) {
		return dao.deletFood(food);
	}
	
	public int insertFood(Food food) {
		return dao.insertFood(food);
	}
	
	public List<Food> selectFoodByAllF() {
		return dao.selectFoodByAllF();
	}
}
