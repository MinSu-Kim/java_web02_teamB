package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.dao.ReservationDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.ReservationDaoImpl;
import kr.or.yi.food_mgm_program.dto.Reservation;

public class PanelCurrentReservationService {
	private static PanelCurrentReservationService service = new PanelCurrentReservationService();
	private ReservationDao dao;
	private MemberDao mDao;
	
	public static PanelCurrentReservationService getInstance() {
		return service;
	}

	public PanelCurrentReservationService() {
		dao = new ReservationDaoImpl();
		mDao = new MemberDaoImpl();
	}
	
	public List<Reservation> selectByTime(){
		return dao.selectByTime();
	}
	
	public void deleteRsv(Reservation rsv) {
		dao.deleteRsv(rsv);
	}
	
	public int selectListSize() {
		return mDao.selectMemberByAll().size()+1;
	}
}
