package kr.or.yi.food_mgm_program.dao;

import java.util.List;

import kr.or.yi.food_mgm_program.dto.Payment;

public interface PaymentDao {
	public List<Payment> selectPaymentByAll();
	public List<Payment> selectPaymentByDate(String date);
}
