package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.FoodMapper;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class FoodMapperImpl implements FoodMapper {
	private String namespace = "kr.or.yi.food_mgm_program.dao.FoodMapper.";
	
	@Override
	public List<Food> selectFoodByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectFoodByAll");
		}
	}
	@Override
	public int insertFood(Food food) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + "insertFood", food);
			sqlSession.commit();
			return res;
		}
	}
	
}
