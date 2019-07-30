package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.SalesStatusDao;
import kr.or.yi.food_mgm_program.daoImpl.SalesStatusDaoImpl;
import kr.or.yi.food_mgm_program.dto.SalesStatus;

public class PanelSaleListService2 {
	private static PanelSaleListService2 service = new PanelSaleListService2();
	private SalesStatusDao dao;
	
	public static PanelSaleListService2 getInstance() {
		return service;
	}

	public PanelSaleListService2() {
		dao = new SalesStatusDaoImpl();
	}
	
	public List<SalesStatus> selectSalesStatusByAll(){
		return dao.selectSalesStatusByAll();
	}
	
	public List<SalesStatus> selectSalesStatusByDate(String searchDate){
		return dao.selectSalesStatusByDate(searchDate);
	}
}
