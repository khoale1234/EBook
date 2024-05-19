package com.DAO;

import com.entity.User;

public interface UserDAO {
	public boolean UserRegister(User user);
	public User UserLogin(String email, String password);
	public boolean checkPassword(int id,String pw);
	public boolean updateProfile(User u);
	public boolean checkUser(String email);
}
