package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.MemberCouponDao;
import kr.or.yi.food_mgm_program.dto.Member;
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

	@Override
	public List<MemberCoupon> selectByMbNo(MemberCoupon memberCoupon) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectByMbNo", memberCoupon);
		}

	}

	@Override
	public int deleteByMbNo(MemberCoupon memberCoupon) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".deleteByMbNo", memberCoupon);
			sqlSession.commit();
			return res;
		}
	}
}
