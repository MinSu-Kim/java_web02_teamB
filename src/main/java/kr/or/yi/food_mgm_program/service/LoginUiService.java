package kr.or.yi.food_mgm_program.service;

import kr.or.yi.food_mgm_program.dao.ManagerDao;
import kr.or.yi.food_mgm_program.dao.NoManagerDao;
import kr.or.yi.food_mgm_program.daoImpl.ManagerDaoImpl;
import kr.or.yi.food_mgm_program.daoImpl.NoManagerDaoImpl;
import kr.or.yi.food_mgm_program.dto.Manager;
import kr.or.yi.food_mgm_program.dto.NoManager;

public class LoginUiService {
	private static LoginUiService service = new LoginUiService();
	private ManagerDao dao;
	private NoManagerDao nDao;
	
	public static LoginUiService getInstance() {
		return service;
	}

	public LoginUiService() {
		dao = new ManagerDaoImpl();
		nDao = new NoManagerDaoImpl();
	}
	
	public Manager selectByManager(Manager manager) {
		return dao.selectByPass(manager);
	}
	
	public NoManager selectByNoManager(NoManager noManager) {
		return nDao.selectByPass(noManager);
	}
	
}
