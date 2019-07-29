package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Post;

public interface PostDao {
	List<Post> selectBySiGunGu(Post post);
}
