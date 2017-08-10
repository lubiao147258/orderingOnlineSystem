package com.lb.dao;

import java.util.List;

import com.lb.entity.Food;
import com.lb.entity.FoodType;
import com.lb.entity.Seller;
import com.lb.entity.SellerInfo;

public interface ISeller {

	Integer checkLogin(Seller seller); //商家登录验证接口
	
	boolean addFood(Food food); //商家添加菜品接口
	
	boolean addFoodType(String foodtypename); //商家添加菜类别
	
	List<FoodType> getFoodType(); //获得菜品类别
	
	List<Food> getFoodInfo();   //获得所有商品
	
	Food getFoodInfoById(int id);//通过id获得Food对象
	
	Integer checkFoodTypeNameIsExists(String name);  //检查添加的菜类别是否已经存在
	
	Integer checkFoodNameIsExists(String name);  //检查添加的菜名是否已经存在
	
	String getFoodTypeById(int id);  //根据类别id获得类别名称
	
	Integer getFoodTypeIdByName(String name);//根据类别名称获得id
	
	SellerInfo getSellerInfo();//获取商家信息
	
	List<Food> getFoodsBySize(int pageNum,int pageSize);
}
