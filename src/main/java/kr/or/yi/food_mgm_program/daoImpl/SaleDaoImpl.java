package kr.or.yi.food_mgm_program.daoImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.dto.SalesStatus;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class SaleDaoImpl implements SaleDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.SaleMapper.";

	@Override
	public List<Sale> selectSaleByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectSaleByAll");
		}
	}

	@Override
	public List<SalesStatus> selectSalesStatusByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectSalesStatusByAll");
		}
	}

	@Override
	public List<SalesStatus> selectSalesStatusByDate(Date date) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectSalesStatusByDate",date);
		}
	}

	@Override
	public int insertSale(Map<String, Object> map) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + "insertSale", map);
			sqlSession.commit();
			return res;
		}
	}
	
}
