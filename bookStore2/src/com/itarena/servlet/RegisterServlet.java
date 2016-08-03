package com.itarena.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itarena.exception.UserException;
import com.itarena.javabean.User;
import com.itarena.service.UserService;
import com.itarena.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html,charset=UTF-8");
		
		String uname = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User();
		user.setUsername(uname);
		user.setPassword(password);
		try {
			System.out.println(uname);
			userService.regist(user);
		} catch (UserException e) {
			String msg = e.getMessage();
			req.setAttribute("msg", msg);
			System.out.println(msg);
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
			e.printStackTrace();
		}
		/*
		 * 一个程序一旦进入catch后执行完里面的代码，就结束程序，不会再接着执行catch完的代码
		 */
		resp.sendRedirect("login.jsp");
		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
