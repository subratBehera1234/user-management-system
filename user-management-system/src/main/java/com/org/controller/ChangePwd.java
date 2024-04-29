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

@WebServlet("/change")
public class ChangePwd extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("userObj");
		String userPwd=user.getPassword();
		int id=Integer.parseInt(request.getParameter("id"));
		String oldPwd=request.getParameter("password");
		String pwd1=request.getParameter("password1");
		String pwd2=request.getParameter("password2");
		
		if(userPwd.equals(oldPwd) && pwd1.equals(pwd2)) {
			
			UserDao dao=new UserDao();
			dao.changePwdById(id,pwd1);
			
			response.sendRedirect("home.jsp");
		}
		else {
			session.setAttribute("fail","Enter Corectly");
			response.sendRedirect("changePwd.jsp");
		}
	}
}
