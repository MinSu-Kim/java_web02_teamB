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
	
	public static PanelSaleListService getInstance() {
		return service;
	}	

	public PanelSaleListService() {
		dao = new PaymentDaoImpl();
		dao2 = new SaleDaoImpl();
	}
	
	public List<Payment> selectPaymentByAll(){
		return dao.selectPaymentByAll();
	}
	
	public List<Payment> selectPaymentByDate(String date){
		return dao.selectPaymentByDate(date);
	}
	
	public int updateSaleByCancel(Map<String,Integer> map) {
		return dao2.updateSaleByCancel(map);
	}
	
	public void updateCancelUpdateMileage(Map<String,Integer> map,Member member) {
		int resUpdateMileage= 0;
		int resUpdateCancel = 0;
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			resUpdateCancel +=  sqlSession.update(namespace + "updateSaleByCancel",map);
			resUpdateMileage += sqlSession.update(namespace2 + "mileageUpdateKCM", member);

			if (resUpdateCancel > 0 && resUpdateMileage >0) {
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
