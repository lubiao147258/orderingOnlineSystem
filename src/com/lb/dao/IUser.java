package com.lb.dao;

import com.lb.entity.User;

/**
 * 
 * @描述   用户接口类
 * @作者 lubiao
 * @时间 2017年8月8日-下午1:08:50
 *
 */
public interface IUser {

	Integer checkLogin(User user); //用户登录验证接口
	
	boolean userRegister(User user);  //用户注册接口
	
	//boolean userUpdateInfo(User user); //用户修改个人信息
	
}
