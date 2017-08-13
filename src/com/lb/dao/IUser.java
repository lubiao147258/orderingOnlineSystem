package com.lb.dao;

import java.util.List;

import com.lb.entity.Address;
import com.lb.entity.Cart;
import com.lb.entity.Food;
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
	
	User getUserInfo(int id) ;  //的用户信息接口
	
	Integer getUserId(String username,String password);//获得id
	
	Integer getFoodCountById(int id,int userId); //根据id查询购物车表中的数量
	
	Double getFoodPriceById(int foodId); //根据id获得单价
	
	List<Cart> getCartsBySize(int pageNum,int pageSize,int userId);
	
	List<Cart> getCartsInfo(int userId); //获得指定用户id的购物车的信息
	
	List<Food> getFoodInfo();//获取正在售的商品
	
	//用户地址管理接口
	boolean addAddress(int userId,Address address);				//添加地址
	boolean delAddress(int id);									//删除地址
	boolean updateAddress(int id,Address address);				//修改地址
	boolean setDefaultAddress(int userId,int addressId);		//选择默认收货地址
	
	
	
	//String getInfoById(String key,int id);       //通过Id得到key
	//boolean userUpdateInfo(User user); //用户修改个人信息
	
	
	List<Address> getAddressInfo(int userID);  //得到用户的地址信息
	
	Address getAddressInfoById(int id);		//获得一条地址信息
	
}
