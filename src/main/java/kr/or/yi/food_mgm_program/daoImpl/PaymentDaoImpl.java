package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.PaymentDao;
import kr.or.yi.food_mgm_program.dto.Payment;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class PaymentDaoImpl implements PaymentDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.PaymentMapper.";
	@Override
	public List<Payment> selectPaymentByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectPaymentByAll");
		}
	}

	@Override
	public List<Payment> selectPaymentByDate(String date) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectPaymentByDate",date);
		}
	}

	@Override
	public List<Payment> selectPaymentByNo() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectPaymentByNo");
		}
	}

	@Override
	public List<Payment> selectPaymentByNoDate(String date) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectPaymentByNoDate",date);
		}
	}

}
