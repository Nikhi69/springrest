package com.nikhil.truyum.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.nikhil.truyum.entity.User;
@Component
public class LoginValidtion {
	public int userid;
	public String uname;
	@Autowired
	UserMapper umapper;
	
	@Autowired
	JdbcTemplate jdbc;
	
	public String[] validate(String user_name, String password) {
		
		String sql = "select * from user";
		List<User> list = jdbc.query(sql, umapper);
		String[] profile = new String[3];
		profile[0] = "no user";
		profile[1] = "no user";
		for (User user : list) {
			if (user.getUser_name().equals(user_name) && user.getPassword().equals(password)) {
				 
				profile[0] = user.getRole();
				profile[1] = user.getUser_name();
				uname=user.getUser_name();
				userid =user.getUser_id();
				profile[2] = Integer.toString(user.getUser_id());
				break;
			}
		}
		
		return profile;
	}
	
	public  int getUserId(String name) {
		String sql= "select * from user";
		List<User> list = jdbc.query(sql, umapper);
		User user =new User();
		for(User ele : list) {
			if(ele.getUser_name().equals(name)) {
				user=ele;
			}
		}
		
		return user.getUser_id();
	}
	
	
}
