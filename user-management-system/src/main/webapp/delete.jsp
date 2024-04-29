<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrap-css.jsp" %>
</head>
<body>
<% User sessionUser =(User) session.getAttribute("userObj");
	if(sessionUser==null){
		response.sendRedirect("login.jsp");
	}
	else{
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		UserDao dao =new UserDao();
		User user =dao.fetchAllUserById(id);
		%>
<%@ include file="components/homeNavbar.jsp"%>
<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
					<h2 class="fs-3 text-center text" >Are You Sure To Delete User</h2>
						<a href="delete?id=<%=id %>" class="text-decoration-none btn btn-danger">Yes</a>
						<a href="home.jsp" class="text-decoration-none btn btn-success">No</a>	
					</div>
				</div>
			</div>
		</div>
	</div>
	<%} %>
</body>
</html>