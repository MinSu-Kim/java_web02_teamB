package kr.or.yi.food_mgm_program.service;

import java.util.List;

import kr.or.yi.food_mgm_program.dao.ReservationDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.ReservationDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Reservation;

public class PanelReservationService {
	private static PanelReservationService service = new PanelReservationService();
	private MemberDaoImpl mDao;
	private ReservationDao rDao;
	public static PanelReservationService getInstance() {
		return service;
	}

	public PanelReservationService() {
		mDao = new MemberDaoImpl();
		rDao = new ReservationDaoImpl();
	}
	
	public Member selectByNameTel(Member member) {
		return mDao.selectByNameTel(member);
	}
	
	public int insertRsv(Reservation rsv) {
		return rDao.insertRsv(rsv);
	}
	
	public List<Reservation> selectByTime(){
		return rDao.selectByTime();
	}
	
}
