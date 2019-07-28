package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Food;

public interface FoodDao {
	public List<Food> selectFoodByAll();
	public int insertFood(Food food);
	public List<Food> selectByNo(Food food);
	public int updateFood(Food food);
	public int deletFood(Food food);
	public List<Food> selectByName(Food food);
	public Food selectByNames(Food food);
}
