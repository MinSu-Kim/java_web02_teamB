package kr.or.yi.food_mgm_program.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.food_mgm_program.AbstractTest;
import kr.or.yi.food_mgm_program.daoImpl.ReservationDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Reservation;

public class ReservationDaoTest extends AbstractTest{
	private static ReservationDao rDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rDao = new ReservationDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		rDao = null;
	}


//	@Test
//	public void test01InsertRsv() throws ParseException {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
//		Member member = new Member(1);
//		member.setMbName("김우빈");
//		member.setMbTel("01012345678");
//		int rsvNumber =  10;
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//		Date date =  sd.parse("2019-08-13 13:10");
//		String tableNo = "no.1";
//		
//		Reservation rsv = new Reservation(rsvNumber, date, member, tableNo);
//		
//		int res = rDao.insertRsv(rsv);
//		log.debug(rsv.toString());
//		Assert.assertEquals(1, res);
//		
//	}
	
	@Test
	public void test01SelectByTime() throws ParseException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Reservation> list = rDao.selectByTime();
		log.debug(list.toString());
		Assert.assertNotNull(list);
		
	}

}
