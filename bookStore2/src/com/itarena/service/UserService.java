package com.itarena.service;

import com.itarena.exception.UserException;
import com.itarena.javabean.User;

public interface UserService {

	void regist(User user) throws UserException;

	void login(User user) throws UserException;

	
	
}
