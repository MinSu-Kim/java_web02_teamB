package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.FoodDao;
import kr.or.yi.food_mgm_program.dto.Food;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class FoodDaoImpl implements FoodDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.FoodMapper";
	
	@Override
	public List<Food> selectFoodByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectFoodByAll");
		}
	}
	
	@Override
	public int insertFood(Food food) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertFood", food);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public List<Food> selectByNo(Food food) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectByNo", food);
		}
	}

	@Override
	public int updateFood(Food food) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateFood", food);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deletFood(Food food) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deletFood", food);
			sqlSession.commit();
			return res;
		}
	}
	
}
