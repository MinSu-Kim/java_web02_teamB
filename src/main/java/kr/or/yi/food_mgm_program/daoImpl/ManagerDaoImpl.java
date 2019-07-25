package kr.or.yi.food_mgm_program.daoImpl;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.ManagerDao;
import kr.or.yi.food_mgm_program.dto.Manager;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class ManagerDaoImpl implements ManagerDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.ManagerMapper";
	

	@Override
	public Manager selectByPass(Manager manager) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".selectByPass", manager);
		}
	}
}
