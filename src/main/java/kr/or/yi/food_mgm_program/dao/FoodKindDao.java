package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.FoodKind;

public interface FoodKindDao {
	public List<FoodKind> selectByNo(FoodKind foodkind);
}
