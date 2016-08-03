package com.itarena.dao;

import com.itarena.javabean.User;

public interface UserDao {

	User findUserByUname(String uname);

	void addUser(User user);

}
