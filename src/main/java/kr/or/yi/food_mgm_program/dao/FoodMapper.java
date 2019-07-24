package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Food;

public interface FoodMapper {
	List<Food> selectFoodByAll();
	int insertFood(Food food);
}
