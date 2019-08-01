package kr.or.yi.food_mgm_program.daoImpl;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.MemberCouponDao;
import kr.or.yi.food_mgm_program.dto.MemberCoupon;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class MemberCouponDaoImpl implements MemberCouponDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.MemberCouponMapper";

	@Override
	public int insertMemberCoupon(MemberCoupon memberCoupon) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertMemberCoupon", memberCoupon);
			sqlSession.commit();
			return res;
		}
	}

}
