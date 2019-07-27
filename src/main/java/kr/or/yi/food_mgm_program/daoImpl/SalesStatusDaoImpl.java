package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.SalesStatusDao;
import kr.or.yi.food_mgm_program.dto.SalesStatus;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class SalesStatusDaoImpl implements SalesStatusDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.SalesStatusMapper.";
	@Override
	public List<SalesStatus> selectSalesStatusByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectSalesStatusByAll");
		}
	}

	@Override
	public List<SalesStatus> selectSalesStatusByDate(String date) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectSalesStatusByDate",date);
		}
	}

}
