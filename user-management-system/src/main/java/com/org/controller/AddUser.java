package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/addUser")
public class AddUser extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String email=request.getParameter("email");
		String password =request.getParameter("password");
		
		User user=new User();
		user.setName(name);
		user.setAge(age);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setPassword(password);
		UserDao dao=new UserDao();
		dao.saveUser(user);
		
		HttpSession session=request.getSession();
		session.setAttribute("user","Added Successful");
		
		response.sendRedirect("addUser.jsp");
	}
	
}
