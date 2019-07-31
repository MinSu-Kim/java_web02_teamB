package kr.or.yi.food_mgm_program.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.food_mgm_program.dao.PaymentDao;
import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.daoImpl.PaymentDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Payment;

public class PanelSaleListService {
	private static PanelSaleListService service = new PanelSaleListService();
	private PaymentDao dao;
	private SaleDao dao2;
	
	public static PanelSaleListService getInstance() {
		return service;
	}

	public PanelSaleListService() {
		dao = new PaymentDaoImpl();
		dao2 = new SaleDaoImpl();
	}
	
	public List<Payment> selectPaymentByAll(){
		return dao.selectPaymentByAll();
	}
	
	public List<Payment> selectPaymentByDate(String date){
		return dao.selectPaymentByDate(date);
	}
	
	public int updateSaleByCancel(Map<String,Integer> map) {
		return dao2.updateSaleByCancel(map);
	}
	
}
