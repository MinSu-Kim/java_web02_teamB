package kr.or.yi.food_mgm_program.dao;

import kr.or.yi.food_mgm_program.dto.FoodMenu;

public interface MenuDao {
	public FoodMenu selectByNo(FoodMenu menu);
}
