package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserImp implements UserDAO {
	private Connection connection;

	public UserImp(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean UserRegister(User user) {
		boolean create=false;
		try {
			String sql="insert into user(name,email,phone_no,password) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone_no());
			ps.setString(4, user.getPassword());
			int i=ps.executeUpdate();
			if(i==1) {
				create=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return create;
		
	}

	public User UserLogin(String email, String password) {
		User user=null;
		try {
			String sql="Select * from user where email=? and password=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhone_no(rs.getString(6));
				user.setCity(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean checkPassword(int id,String pw) {
		boolean f=false;
		try {
			String sql="select * from user where uid=? and password=?";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, pw);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updateProfile(User user) {
		
		boolean create=false;
		try {
			String sql = "UPDATE user SET name=?, email=?, phone_no=? WHERE uid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone_no());
			ps.setInt(4, user.getId());
			int i=ps.executeUpdate();
			if(i==1) {
				create=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return create;
		
	}

	@Override
	public boolean checkUser(String email) {
		boolean f=true;
		try {
			String sql = "select * from user where email=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				f=false;
		}} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
}