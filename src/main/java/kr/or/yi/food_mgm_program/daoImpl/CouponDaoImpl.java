package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.CouponDao;
import kr.or.yi.food_mgm_program.dto.Coupon;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class CouponDaoImpl implements CouponDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.CouponMapper";
	
	@Override
	public List<Coupon> selectByCouponAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectByCouponAll");
		}
	}

}
