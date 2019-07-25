package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class MemberDaoImpl implements MemberDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.MemberMapper.";
	
	@Override
	public List<Member> selectMemberByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectMemberByAll");
		}
	}

}
