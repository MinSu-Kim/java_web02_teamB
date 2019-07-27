package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.SalesStatus;

public interface SalesStatusDao {
	public List<SalesStatus> selectSalesStatusByAll();
	public List<SalesStatus> selectSalesStatusByDate(String date);
}
