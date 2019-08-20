package kr.or.yi.food_mgm_program.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.food_mgm_program.dao.MemberDao;
import kr.or.yi.food_mgm_program.dao.PaymentDao;
import kr.or.yi.food_mgm_program.dao.SaleDao;
import kr.or.yi.food_mgm_program.daoImpl.MemberDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.PaymentDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.SaleDaoImpl;
import kr.or.yi.food_mgm_program.dto.Member;
import kr.or.yi.food_mgm_program.dto.Payment;
import kr.or.yi.food_mgm_program.dto.Sale;
import kr.or.yi.food_mgm_program.jdbc.MybatisSqlSessionFactory;

public class PanelSaleListService {
	private static PanelSaleListService service = new PanelSaleListService();
	private String namespace = "kr.or.yi.food_mgm_program.dao.SaleMapper.";
	private String namespace2 = "kr.or.yi.food_mgm_program.dao.MemberMapper.";
	private PaymentDao dao;
	private SaleDao dao2;
	private MemberDao dao3;
	
	public static PanelSaleListService getInstance() {
		return service;
	}	

	public PanelSaleListService() {
		dao = new PaymentDaoImpl();
		dao2 = new SaleDaoImpl();
		dao3 = new MemberDaoImpl();
	}
	
	public List<Payment> selectPaymentByAll(){
		return dao.selectPaymentByAll();
	}
	public List<Payment> selectPaymentByNo(){
		return dao.selectPaymentByNo();
	}
	
	public List<Payment> selectPaymentByDate(String date){
		return dao.selectPaymentByDate(date);
	}
	public List<Payment> selectPaymentByNoDate(String date){
		return dao.selectPaymentByNoDate(date);
	}
	
	public int updateSaleByCancel(Map<String,Integer> map) {
		return dao2.updateSaleByCancel(map);
	}
	
	public int totalPrice(int number) {
		return dao2.totalPrice(number);
	}
	
	public int updateGrade(Member mem) {
		return dao3.updateGrade(mem);
	}
	
	
	
	public void updateCancelUpdateMileageCoupon(Map<String,Integer> map,Member member,Map<String, Object> map2) {
		int resUpdateMileage= 0;
		int resUpdateCancel = 0;
		int resupdateCount = 0;
		int resUpdateCoupon = 0;
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			resUpdateCancel +=  sqlSession.update(namespace + "updateSaleByCancel",map); //결제를 취소로 변경
			resUpdateMileage += sqlSession.update(namespace2 + "mileageUpdateKCM", member); //마일리지 원상복구
			resupdateCount += sqlSession.update(namespace2 + "CountUpdateKCM2", member); // 사용 횟수를 -1
			resUpdateCoupon += sqlSession.update(namespace2 + "couponDelete",map2); //사용한 쿠폰을 없앰
			
			if (resUpdateCancel > 0 && resUpdateMileage >0 && resupdateCount>0 && resUpdateCoupon>0) {
				sqlSession.commit();
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateCancelUpdateMileage(Map<String,Integer> map,Member member) {
		int resUpdateMileage= 0;
		int resUpdateCancel = 0;
		int resupdateCount = 0;
		
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			resUpdateCancel +=  sqlSession.update(namespace + "updateSaleByCancel",map); //결제를 취소로 변경
			resUpdateMileage += sqlSession.update(namespace2 + "mileageUpdateKCM", member); //마일리지 원상복구
			resupdateCount += sqlSession.update(namespace2 + "CountUpdateKCM2", member); // 사용 횟수를 -1
			
			
			if (resUpdateCancel > 0 && resUpdateMileage >0 && resupdateCount>0) {
				sqlSession.commit();
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateCancel(Map<String,Integer> map,Member member) {
		int resUpdateCancel = 0;
		int resupdateCount = 0;
		
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			resUpdateCancel +=  sqlSession.update(namespace + "updateSaleByCancel",map); //결제를 취소로 변경
			resupdateCount += sqlSession.update(namespace2 + "CountUpdateKCM2", member); // 사용 횟수를 -1
			
			
			if (resUpdateCancel > 0 && resupdateCount>0) {
				sqlSession.commit();
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	
}
