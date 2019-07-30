package kr.or.yi.food_mgm_program.service;

import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Sale;

public class PanelSeatService {
	private static PanelSeatService service = new PanelSeatService();
	private SaleDao dao;
	
	public static PanelSeatService getInstance() {
		return service;
	}

	public PanelSeatService() {
		dao = new SaleDaoImpl();
	}
	
	public Sale selectLastNo() {
		return dao.selectLastNo();
	}
	
}
