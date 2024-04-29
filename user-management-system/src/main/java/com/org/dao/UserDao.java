package com.org.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;

import com.org.dto.User;

public class UserDao {

	public void saveUser(User user) {
	
		
		Connection con;
		PreparedStatement pst;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			pst=con.prepareStatement("insert into user(name,age,mobile,email,password) value(?,?,?,?,?)");
			
			
			String name=user.getName();
			int age=user.getAge();
			long mobile=user.getMobile();
			String email=user.getEmail();
			String password=user.getPassword();
			
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setLong(3, mobile);
			pst.setString(4, email);
			pst.setString(5, password);
			
			pst.executeUpdate();
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public User fetchUserByEmailAndPassword(String email,String password) {
		
		Connection con;
		PreparedStatement pst;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			pst=con.prepareStatement("select * from user where email=? and password=?");
			
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rst=pst.executeQuery();
			
			if(rst.next()) {
				User user =new User();
				
				int id=rst.getInt("id");
				String name=rst.getString("name");
				int age =rst.getInt("age");
				long mobile=rst.getLong("mobile");
				
				user.setId(id);
				user.setName(name);
				user.setAge(age);
				user.setMobile(mobile);
				user.setEmail(email);
				user.setPassword(password);
				
				return user;
			}
			
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public User fetchAllUserById(int id) {
		
		Connection con;
		PreparedStatement pst;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			pst=con.prepareStatement("select * from user where id=?");
			
			pst.setInt(1, id);
			
			
			ResultSet rst=pst.executeQuery();
			
			if(rst.next()) {
				User user =new User();
				String name=rst.getString("name");
				int age =rst.getInt("age");
				long mobile=rst.getLong("mobile");
				String email=rst.getString("email");
				String password=rst.getString("password");
				
				user.setId(id);
				user.setName(name);
				user.setAge(age);
				user.setMobile(mobile);
				user.setEmail(email);
				user.setPassword(password);
				
				return user;
			}
			
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> fetchAllUser(){
		
		ArrayList<User> list=new ArrayList<>();
		Connection con;
		PreparedStatement pst;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			pst=con.prepareStatement("select * from user");
			
			ResultSet rst=pst.executeQuery();
			
			while(rst.next()) {
				User user =new User();
				int id=rst.getInt("id");
				String name=rst.getString("name");
				int age =rst.getInt("age");
				long mobile=rst.getLong("mobile");
				String email=rst.getString("email");
				String password=rst.getString("password");
				
				user.setId(id);
				user.setName(name);
				user.setAge(age);
				user.setMobile(mobile);
				user.setEmail(email);
				user.setPassword(password);
				
				list.add(user);
				
			}
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void updateUser(User user) {

		Connection con;
		PreparedStatement pst;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			pst=con.prepareStatement("update user set name=?,age=?,mobile=?,email=? where id=?");
			
			int id=user.getId();
			String name=user.getName();
			int age=user.getAge();
			long mobile=user.getMobile();
			String email=user.getEmail();
			
			
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setLong(3, mobile);
			pst.setString(4, email);
			pst.setInt(5, id);
			
			pst.executeUpdate();
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void changePwdById(int id,String pwd) {
		Connection con;
		PreparedStatement pst;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			pst=con.prepareStatement("update user set password=? where id=?");
			
			pst.setString(1, pwd);
			pst.setInt(2, id);

			
			pst.executeUpdate();
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pst;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			pst=con.prepareStatement("delete from user where id=?");
			
			pst.setInt(1, id);

			
			pst.executeUpdate();
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
