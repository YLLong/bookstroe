package com.itarena.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itarena.exception.UserException;
import com.itarena.javabean.User;
import com.itarena.service.UserService;
import com.itarena.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

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
			System.out.println(user);
			userService.login(user);
		} catch (UserException e) {
			req.setAttribute("msg", e.getMessage());
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			e.printStackTrace();
		}
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		req.getRequestDispatcher("jsps/main.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
