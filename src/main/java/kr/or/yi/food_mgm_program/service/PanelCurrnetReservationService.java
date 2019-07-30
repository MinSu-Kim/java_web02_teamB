package kr.or.yi.food_mgm_program.service;

import kr.or.yi.food_mgm_program.dao.ReservationDao;
import kr.or.yi.food_mgm_program.daoImpl.ReservationDaoImpl;

public class PanelCurrnetReservationService {
	private static PanelCurrnetReservationService service = new PanelCurrnetReservationService();
	private ReservationDao dao;
	
	public static PanelCurrnetReservationService getInstance() {
		return service;
	}

	public PanelCurrnetReservationService() {
		dao = new ReservationDaoImpl();
	}
	
	
}
