package kr.or.yi.food_mgm_program.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.food_mgm_program.dao.ReservationDao;
import kr.or.yi.food_mgm_program.daoImpl.ReservationDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Reservation;

public class PanelCurrentReservationService {
	private static PanelCurrentReservationService service = new PanelCurrentReservationService();
	private ReservationDao dao;
	
	
	public static PanelCurrentReservationService getInstance() {
		return service;
	}

	public PanelCurrentReservationService() {
		dao = new ReservationDaoImpl();
		
	}
	
	public List<Reservation> selectByTime(){
		return dao.selectByTime();
	}
	
	public void deleteRsv(Reservation rsv) {
		dao.deleteRsv(rsv);
	}
	
	public List<Reservation> selectByTel(Member member){
		return dao.selectByTel(member);
	}
	
	public List<Reservation> selectByDate(String date){
		return dao.selectByDate(date);
	}
	
	public Reservation selectByTimeTable(Reservation rsv) {
		return dao.selectByTimeTable(rsv);
	}
	
	public List<Reservation> selectByRangeDate(Map<String, Object> map){
		return dao.selectByRangeDate(map);
	}
	
}
