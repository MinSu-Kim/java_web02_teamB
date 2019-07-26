package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.FoodKindDao;
import kr.or.yi.food_mgm_program.dto.FoodKind;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;


public class FoodKindDaoImpl implements FoodKindDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.FoodKindMapper";
	
	@Override
	public List<FoodKind> selectByNo(FoodKind foodkind) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectByNo", foodkind);
		}
	}

	@Override
	public List<FoodKind> selectFoodKindByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectFoodKindByAll");
		}
	}

}
