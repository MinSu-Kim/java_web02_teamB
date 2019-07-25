package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class MemberDaoImpl implements MemberDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.MemberMapper";
	
	@Override
	public List<Member> selectMemberByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectMemberByAll");
		}
	}

	@Override
	public int insertMember(Member member) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertMember", member);
			sqlSession.commit();
			return res;
		}

	}

	@Override
	public List<Member> selectMemberByTel(Member member) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectMemberByTel", member);
		}
	}

	@Override
	public int updateMember(Member member) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateMember", member);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteMember(Member member) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteMember", member);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public List<Member> selectMemberByNo(Member member) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectMemberByNo", member);
		}
	}

}
