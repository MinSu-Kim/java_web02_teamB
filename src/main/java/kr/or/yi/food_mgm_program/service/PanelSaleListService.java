package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.PaymentDao;
import kr.or.yi.food_mgm_program.daoImpl.PaymentDaoImpl;
import kr.or.yi.food_mgm_program.dto.Payment;

public class PanelSaleListService {
	private static PanelSaleListService service = new PanelSaleListService();
	private PaymentDao dao;
	
	public static PanelSaleListService getInstance() {
		return service;
	}

	public PanelSaleListService() {
		dao = new PaymentDaoImpl();
	}
	
	public List<Payment> selectPaymentByAll(){
		return dao.selectPaymentByAll();
	}
	
	public List<Payment> selectPaymentByDate(String date){
		return dao.selectPaymentByDate(date);
	}
	
}
