package com.org.controller;

import java.io.IOException;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.UserDao;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		UserDao dao=new UserDao();
		 dao.deleteUserById(id);
		
		response.sendRedirect("home.jsp");
	}

}
