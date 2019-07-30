package kr.or.yi.food_mgm_program.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Sale;

public class PaymentService {
	private static PaymentService service = new PaymentService();
	private SaleDao sDao;
	private MemberDao mDao;
	
	
	public static PaymentService getInstance() {
		return service;
	}

	public PaymentService() {
		sDao = new SaleDaoImpl();
		mDao = new MemberDaoImpl();
	}
	
	public Member selectByTel(int number) {
		return mDao.selectByTel(number);
	}
	
	public int insertSale(Map<String, List<Sale>> map) {
		return sDao.insertSale(map);
	}
	
	public void insertSaleUpdateMileageTransaciton(Map<String, List<Sale>> map,Member member) {
		sDao.insertSaleUpdateMileage(map, member);
	}
	
}
