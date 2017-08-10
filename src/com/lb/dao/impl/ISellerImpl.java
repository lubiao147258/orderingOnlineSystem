package com.lb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lb.dao.ISeller;
import com.lb.entity.Food;
import com.lb.entity.FoodType;
import com.lb.entity.Seller;
import com.lb.entity.SellerInfo;
import com.lb.util.DBManager;

public class ISellerImpl implements ISeller{
	
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static PreparedStatement preparedStatement = null;
	private static Connection connection=DBManager.getConnection();

	@Override
	public Integer checkLogin(Seller seller) {
		// TODO Auto-generated method stub
		if(connection==null){
			return null;
		}
		Integer count = null;
		try {
			String sql = "select count(1) from [sellerInfo] where loginname =? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, seller.getLoginName());
			preparedStatement.setString(2, seller.getPassword());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				count=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return count;
	}

	@Override
	public boolean addFood(Food food) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(connection==null){
			return false;
		}
		if(DBManager.executeUpdate("insert into [food] (type_id,food_name,food_price,onsale) values(?,?,?,?)", new String[]{String.valueOf(food.getType_id()),food.getFoodName(),String.valueOf(food.getPrice()),String.valueOf(food.getIsOnsale())})){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean addFoodType(String foodtypename) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(connection==null){
			return flag;
		}
		if(DBManager.executeUpdate("insert into [food_type] values(?)", new String[]{foodtypename})){
			flag=true;
		}
		return flag;
	}

	@Override
	public List<FoodType> getFoodType() {
		if(connection==null){
			return null;
		}
		List<FoodType> list = new ArrayList();
		try {
			String sql = "select * from [food_type]";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				FoodType foodtype = new FoodType();
				foodtype.setId(resultSet.getInt(1));
				foodtype.setTypeName(resultSet.getString(2));
				list.add(foodtype);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}

	@Override
	public Integer checkFoodTypeNameIsExists(String name) {
		// TODO Auto-generated method stub
		int count=0;
		if(connection==null){
			return null;
		}
		try {
			String sql = "select count(1) from [food_type] where type_name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				count=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return count;
	}

	@Override
	public Integer checkFoodNameIsExists(String name) {
		int count=0;
		if(connection==null){
			return null;
		}
		try {
			String sql = "select count(1) from [food] where food_name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				count=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return count;
	}

	@Override
	public List<Food> getFoodInfo() {
		if(connection==null){
			return null;
		}
		List<Food> list = new ArrayList();
		try {
			String sql = "select * from [food]";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Food food = new Food();
				food.setId(resultSet.getInt(1));
				food.setFoodName(resultSet.getString(2));
				food.setPrice(resultSet.getDouble(4));
				food.setType_id(resultSet.getInt(5));
				food.setIsOnsale(resultSet.getInt(6));
				list.add(food);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}

	@Override
	public String getFoodTypeById(int id) {
		// TODO Auto-generated method stub
		String name = null;
		if(connection==null){
			return null;
		}
		try {
			String sql = "select type_name from [food_type] where type_Id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				name=resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return name;
	}

	@Override
	public Integer getFoodTypeIdByName(String name) {
		int id=0;
		if(connection==null){
			return null;
		}
		try {
			String sql = "select type_Id from [food_type] where type_name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				id=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return id;
	}

	@Override
	public Food getFoodInfoById(int id) {
		if(connection==null){
			return null;
		}
		Food food = new Food();
		try {
			String sql = "select * from [food] where food_Id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				food.setType_id(resultSet.getInt(5));
				food.setFoodName(resultSet.getString(2));
				food.setPrice(resultSet.getDouble(4));
				food.setIsOnsale(resultSet.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return food;
	}

	@Override
	public SellerInfo getSellerInfo() {
		if(connection==null){
			return null;
		}
		SellerInfo sellerinfo = new SellerInfo();
		try {
			String sql = "select * from sellerInfo";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				sellerinfo.setShopname(resultSet.getString(4));
				sellerinfo.setShopinfo(resultSet.getString(5));
				sellerinfo.setPhone(resultSet.getString(6));
				sellerinfo.setLocation(resultSet.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return sellerinfo;
	}

	

}
