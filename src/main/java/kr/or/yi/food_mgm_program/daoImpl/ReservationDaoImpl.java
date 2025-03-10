package kr.or.yi.food_mgm_program.daoImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.ReservationDao;
import kr.or.yi.food_mgm_program.dto.Member;
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
	@Override
	public List<Reservation> selectByTime() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectByTime");
		}
	}
	@Override
	public int deleteRsv(Reservation rsv) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace+".deleteRsv", rsv);
			sqlSession.commit();
			return res;
		}
	}
	@Override
	public List<Reservation> selectByTel(Member member) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectByTel",member);
		}
	}
	@Override
	public List<Reservation> selectByDate(String date) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectByDate",date);
		}
	}
	@Override
	public Reservation selectByTimeTable(Reservation rsv) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectByTimeTable",rsv);
		}
	}
	@Override
	public int updateRsv(Map<String, Object> map) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace+".updateRsv", map);
			sqlSession.commit();
			return res;
		}
	}
	@Override
	public List<Reservation> selectByRangeTime(Reservation rsv) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectByRangeTime",rsv);
		}
	}
	
	@Override
	public List<Reservation> selectByRangeDate(Map<String, Object> map) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectByRangeDate",map);
		}
	}
}







