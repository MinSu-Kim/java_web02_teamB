package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class SaleDaoImpl implements SaleDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.SaleMapper.";
	

	@Override
	public List<Sale> selectSaleByAll() {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectSaleByAll");
		}
	}

	@Override
	public List<Sale> selectSaleByDate(String date) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectSaleByDate", date);
		}
	}

	@Override
	public int insertSale(Map<String, List<Sale>> map) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + "insertSale", map);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Sale selectLastNo() {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + "selectLastNo");
		}
	}



	@Override
	public int updateSaleByCancel(Map<String,Integer> map) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + "updateSaleByCancel",map);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int totalPrice(int number) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int total = sqlSession.selectOne(namespace + "totalPrice", number);
			return total;
		}
				
				
	}

}
