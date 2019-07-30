package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Post;

public interface PostDao {
	List<Post> selectBySiGunGu(Post post);
	List<Post> selectByDoro(Post post);
	List<Post> selectBySiGunGuDoroAddr1(Post post);
	List<Post> selectByAll(Post post);
}
