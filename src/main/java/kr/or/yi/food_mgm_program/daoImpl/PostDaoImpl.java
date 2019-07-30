package kr.or.yi.food_mgm_program.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.PostDao;
import kr.or.yi.food_mgm_program.dto.Post;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class PostDaoImpl implements PostDao {
	private String namespace = "kr.or.yi.food_mgm_program.dao.PostMapper";
	
	@Override
	public List<Post> selectBySiGunGu(Post post) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectBySiGunGu", post);
		}
	}

}
