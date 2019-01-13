package crm.web.service.impl;

import crm.web.Bean.User;
import crm.web.dao.UserDao;
import crm.web.dao.impl.UserDaoImpl;
import crm.web.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	// 业务层用户登录的方法:
	public User login(User user) {
		return dao.login(user);
	}

}
