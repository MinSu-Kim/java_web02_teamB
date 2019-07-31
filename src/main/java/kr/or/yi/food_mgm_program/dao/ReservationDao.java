package kr.or.yi.food_mgm_program.dao;

import java.util.Date;
import java.util.List;

import kr.or.yi.food_mgm_program.dto.Reservation;

public interface ReservationDao {
	public int insertRsv(Reservation rsv);
	public List<Reservation> selectByTime();
	public int deleteRsv(Reservation rsv);
}
