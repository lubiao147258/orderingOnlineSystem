package com.lb.service;

import java.util.List;

import com.lb.dao.ISeller;
import com.lb.dao.impl.ISellerImpl;
import com.lb.entity.Food;
import com.lb.entity.FoodType;
import com.lb.entity.Seller;
import com.lb.entity.SellerInfo;

public class SellerService {
	
	private static ISeller seller = new ISellerImpl();
	
	public static Integer loginService(Seller s){
		return seller.checkLogin(s);
	}
	
	
	
	public static List<FoodType> getFoodTyleService(){
		return seller.getFoodType();
	}
	
	
	public static boolean addFoodTypeService(String foodtypename){
		return seller.addFoodType(foodtypename);
		
	}
	
	public static Integer checkFoodTypeNameIsExistsService(String name){
		return seller.checkFoodTypeNameIsExists(name);
	}
	
	public static boolean addFoodService(Food food){
		return seller.addFood(food);
		
	}
	
	public static Integer checkFoodNameIsExistsService(String name){
		return seller.checkFoodNameIsExists(name);
	}
	
	public static List<Food>  getFoodInfoService(){
		
		return seller.getFoodInfo();
	}
	
	
	public static String getFoodTypeById(int id){
		return seller.getFoodTypeById(id);
	}
	
	public static Integer getFoodTypeIdByName(String name){
		return seller.getFoodTypeIdByName(name);
	}
	
	public static Food getFoodInfoById(int id){
		return seller.getFoodInfoById(id);
	}
	
	public static SellerInfo getSellerInfo(){
		return seller.getSellerInfo();
	}
	
	public static  List<Food> getFoodsBySize(int pageNum, int pageSize){
		return seller.getFoodsBySize(pageNum, pageSize);
	}
	
	//测试
	public static void main(String[] args) {
		//System.out.println(SellerService.addFoodService(new Food(1,"炒饭",20.0,1)));
//		System.out.println(SellerService.checkFoodNameIsExistsService("炒饭"));
		
//		for (Food food :getFoodInfoService() ) {
//			System.out.println(food.getId()+" "+food.getFoodName());
//		}
		
//		System.out.println(getFoodInfoById(18).getIsOnsale()+"+++"+getFoodInfoById(18).getPrice());
		
		System.out.println(getSellerInfo().getShopname());
	}

}

