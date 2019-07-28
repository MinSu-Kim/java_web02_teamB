package kr.or.yi.food_mgm_program.daoImpl;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.NoManagerDao;
import kr.or.yi.food_mgm_program.dto.NoManager;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class NoManagerDaoImpl implements NoManagerDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.NoManagerMapper";


	@Override
	public NoManager selectByPass(NoManager noManager) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".selectByPass", noManager);
		}
	}
}
