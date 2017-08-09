package com.lb.service;

import com.lb.dao.IUser;
import com.lb.dao.impl.IUserImpl;
import com.lb.entity.User;

public class UserService {

	private static IUser user = new IUserImpl();
	public static Integer loginService(User u){
		return  user.checkLogin(u);
	}
	
	
	public static boolean registerService(User u){
		return user.userRegister(u);
	}
	
	
	public static User getUserInfoService(int id){				
		return user.getUserInfo(id);		
	}
	
	public static Integer getUserIdService(String name,String password){
		
		return user.getUserId(name, password);
	}
		
	//测试
	public static void main(String[] args) {
		User u = new User("lubiao","147258");
		IUser user =new IUserImpl();
		
		System.out.println(loginService(u));
	}
}
