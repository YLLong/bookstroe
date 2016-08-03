package com.itarena.service.impl;

import com.itarena.dao.UserDao;
import com.itarena.dao.impl.UserDaoImpl;
import com.itarena.exception.UserException;
import com.itarena.javabean.User;
import com.itarena.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	/**
	 * 将user中的uname与数据库中的数据比较 如果存在，则注册失败，回显 如果不存在，则成功，回显
	 * 
	 * @throws UserException
	 */
	@Override
	public void regist(User user) throws UserException {
		String uname = user.getUsername();
		User rUser = userDao.findUserByUname(uname);
		if (rUser != null) {
			throw new UserException("用户名已存在！");
		}
		// 完成注册
		userDao.addUser(user);
	}

	/**
	 * 登录事务处理
	 */
	@Override
	public void login(User user) throws UserException {
		String uname = user.getUsername();
		User login_user = userDao.findUserByUname(uname);
		if (login_user == null) {
			throw new UserException("用户名不存在！");
		} else if (!(login_user.getPassword().equals(user.getPassword()))) {
			throw new UserException("密码错误！");
		}
		user.setUid(login_user.getUid());
	}

}
