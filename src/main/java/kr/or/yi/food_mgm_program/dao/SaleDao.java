package kr.or.yi.food_mgm_program.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.dto.SalesStatus;

public interface SaleDao {
	public List<Sale> selectSaleByAll();
	public List<SalesStatus> selectSalesStatusByAll();
	public List<SalesStatus> selectSalesStatusByDate(Date date);
	
	public int insertSale(Map<String, Object> map);
}
