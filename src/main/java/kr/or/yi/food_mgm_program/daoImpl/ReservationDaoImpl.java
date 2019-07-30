package kr.or.yi.food_mgm_program.daoImpl;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.ReservationDao;
import kr.or.yi.food_mgm_program.dto.Reservation;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class ReservationDaoImpl implements ReservationDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.ReservationMapper";
	@Override
	public int insertRsv(Reservation rsv) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace+".insertRsv", rsv);
			sqlSession.commit();
			return res;
		}
	}

}
