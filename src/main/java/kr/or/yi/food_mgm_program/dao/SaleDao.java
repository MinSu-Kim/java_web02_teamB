package kr.or.yi.food_mgm_program.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Payment;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.dto.SalesStatus;

public interface SaleDao {
	public List<Sale> selectSaleByAll();
	public List<Sale> selectSaleByDate(String date);
	public int insertSale(Map<String, List<Sale>> map);
	
	public int updateSaleByCancel(Map<String,Integer> map);
	public Sale selectLastNo();
	
	public int totalPrice(int number);
}
