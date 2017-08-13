package com.lb.service;

import java.util.List;

import com.lb.dao.IUser;
import com.lb.dao.impl.IUserImpl;
import com.lb.entity.Address;
import com.lb.entity.Cart;
import com.lb.entity.Food;
import com.lb.entity.FoodVO;
import com.lb.entity.Order;
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
	
	public static Integer getFoodCountById(int id,int userId){
		return user.getFoodCountById(id,userId);
	}
	
	public static Double getFoodPriceById(int foodId){
		return user.getFoodPriceById(foodId);
	}
	
	public static  List<Cart> getCartsBySize(int pageNum,int pageSize,int userId){
		return user.getCartsBySize(pageNum, pageSize,userId);
	}
	
	public static  List<Cart> getCartsInfo(int userId){
		return user.getCartsInfo(userId);
	}
	
	public static List<Food> getFoodInfo(){
		return user.getFoodInfo();
	}
	
	public static List<Address> getAddressInfoService(int userId){
		return user.getAddressInfo(userId);
	}
	
	public static boolean addAddressService(int userId,Address address){
		return user.addAddress(userId, address);
	}
	
	public static boolean delAddressService(int id){
		return user.delAddress(id);
	}
	
	public static boolean updateAddress(int id,Address address) {
		return user.updateAddress(id, address);
	}
	
	public static boolean setDefaultAddressService(int userId,int addressId){
		return user.setDefaultAddress(userId, addressId);
	}
	public static Address getAddressInfoByIdService(int id){
		return user.getAddressInfoById(id);
	}
	
	public static Integer getMaxIdService(){
		return user.getMaxId();
	}
	
	public static List<Order> getOrderInfoService(int userId){
		return user.getOrderInfo(userId);
	}
	
	public static List<FoodVO> getOrderDetailInfoByOrderIdService(int orderid){
		return user.getOrderDetailInfoByOrderId(orderid);
	}
	
	
	
	
	
	
		
	//测试
	public static void main(String[] args) {
//		User u = new User("lubiao","147258");
//		IUser user =new IUserImpl();
		
//		System.out.println(UserService.getUserInfoService(1).getPassword());
//		System.out.println(getFoodPriceById(19));
		
//		for (Cart cart : getCartsBySize(2,1)) {
//			System.out.println(cart.getFoodid()+" "+cart.getFoodcount()+" "+ cart.getTotal());
//		}
//		for(Address address : getAddressInfoService(1)){
//			System.out.println(address.getAddressdetail());
//		}
		
//		System.out.println(delAddressService(2));
		
//		System.out.println(updateAddress(1,new Address("女","武汉市再次的某某地区","1554545454656")));
//		System.out.println(getAddressInfoByIdService(3).getSex());
//		int addressId=5;
//		String[] objs = new String[]{UserService.getAddressInfoByIdService(addressId).getSex(),UserService.getAddressInfoByIdService(addressId).getAddressdetail(),UserService.getAddressInfoByIdService(addressId).getPhone(),String.valueOf(addressId)};
//
//		if(DBManager.executeUpdate("update [address] set user_sex=?,address_detail=?,phone=? where address_Id=?", objs)){
//			System.out.println("ok");
//		}
		for(FoodVO order :getOrderDetailInfoByOrderIdService(5)){
			System.out.println(order.getFoodid());
		}
		

	}
}
