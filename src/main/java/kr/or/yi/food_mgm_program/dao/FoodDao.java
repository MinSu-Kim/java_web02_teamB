package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Food;

public interface FoodDao {
	List<Food> selectFoodByAll();
	int insertFood(Food food);
	List<Food> selectByNo(Food food);
	int updateFood(Food food);
}
