package kr.or.yi.food_mgm_program.daoImpl;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.MenuDao;
import kr.or.yi.food_mgm_program.dto.FoodMenu;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class MenuDaoImpl implements MenuDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.MenuMapper";

	@Override
	public FoodMenu selectByNo(FoodMenu menu) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".selectByNo", menu);
		}
	}
}
