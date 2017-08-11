package com.lb.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lb.dao.IUser;
import com.lb.entity.Address;
import com.lb.entity.Cart;
import com.lb.entity.Food;
import com.lb.entity.User;
import com.lb.util.DBManager;

/**
 * 
 * @描述   用户接口实现类
 * @作者 lubiao
 * @时间 2017年8月9日-上午8:56:42
 *
 */
public class IUserImpl implements IUser {
	
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static PreparedStatement preparedStatement = null;
	private static Connection connection=DBManager.getConnection();

	@Override
	public Integer checkLogin(User user) {
		// TODO Auto-generated method stub
					if(connection==null){
						return null;
					}
					Integer count = null;
					try {
						String sql = "select count(1) from [user] where username =? and password=?";
						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setString(1, user.getUsername());
						preparedStatement.setString(2, user.getPassword());
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
	public boolean userRegister(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String[] userobject = new String[]{user.getUsername(),user.getPassword(),user.getEmail(),String.valueOf(user.getDefaultAddressId()),user.getCreateTime()};
		if(DBManager.executeUpdate("insert into [user] values(?,?,?,?,?)", userobject)){
			flag=true;
		}
		return flag;
	}
	
	
	public static void main(String[] args) {
		IUserImpl iu = new IUserImpl();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		User user = new User("55","55","55",0,df.format(new Date()));
		System.out.println(iu.userRegister(user));
	}

	@Override
	public User getUserInfo(int id) {
		if(connection==null){
			return null;
		}	
		User user = new User(); 
		try {
			String sql = "select username,phone,email,password from [user] where user_Id =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				user.setUsername(resultSet.getString(1));
				user.setPhone(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
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
		return user;
	}
	
	@Override
	public Integer getUserId(String username,String password ){
		
		if(connection==null){
			return null;
		}
		Integer id = null;
		try {
			String sql = "select user_Id from [user] where username =? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
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
	public Integer getFoodCountById(int id,int userId) {
		if(connection==null){
			return null;
		}
		int count = 0;
		try {
			String sql = "select food_count from [cart] where food_Id=? and user_Id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, userId);
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
	public Double getFoodPriceById(int foodId) {
		if(connection==null){
			return null;
		}
		double price = 0;
		try {
			String sql = "select food_price from [food] where food_Id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, foodId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				price=resultSet.getInt(1);
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
		return price;
	}
	
	public  List<Cart> getCartsBySize(int pageNum,int pageSize,int userId){
		if (pageNum <= 0 || pageSize < 0) {
			return null;
		}
		if (connection == null) {
			return null;
		}

		List<Cart> lists = new ArrayList<>();
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "{call usp_getCartBySize(?,?,?)}";
			callableStatement = connection.prepareCall(sql);
			callableStatement.setInt(1, pageNum);
			callableStatement.setInt(2, pageSize);
			callableStatement.setInt(3, userId);
			boolean flag = callableStatement.execute();
			if (flag) {
				resultSet = callableStatement.getResultSet();
				while (resultSet.next()) {
					Cart cart = new Cart();
					cart.setId(resultSet.getInt(1));
					cart.setUserid(resultSet.getInt(2));
					cart.setFoodid(resultSet.getInt(3));
					cart.setFoodcount(resultSet.getInt(4));
					cart.setTotal(resultSet.getDouble(5));
					lists.add(cart);
				}
			}else{
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
		
	}

	@Override
	public List<Cart> getCartsInfo(int userId) {
		if (connection == null) {
			return null;
		}
		List<Cart> list = new ArrayList();
		try {
			String sql = "select * from [cart] where user_Id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Cart cart = new Cart();
				cart.setId(resultSet.getInt(1));
				cart.setUserid(resultSet.getInt(2));
				cart.setFoodid(resultSet.getInt(3));
				cart.setFoodcount(resultSet.getInt(4));
				cart.setTotal(resultSet.getDouble(5));
				list.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
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
	public List<Food> getFoodInfo() {
		if (connection == null) {
			return null;
		}
		List<Food> list = new ArrayList();
		try {
			String sql = "select * from [food] where onsale=1";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
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
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
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
	public List<Address> getAddressInfo(int userID){
		if (connection == null) {
			return null;
		}
		List<Address> list = new ArrayList<>();
		try {
			String sql = "select * from [address] where user_Id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Address address = new Address();
				address.setId(resultSet.getInt(1));
				address.setSex(resultSet.getString(3));
				address.setAddressdetail(resultSet.getString(4));
				address.setPhone(resultSet.getString(5));
				list.add(address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
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
	public boolean addAddress(int userId,Address address) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String[] objs = new String[]{String.valueOf(userId),address.getSex(),address.getAddressdetail(),address.getPhone()};
		if(DBManager.executeUpdate("insert into address values(?,?,?,?)",objs)){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean delAddress(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String[] objs = new String[]{String.valueOf(id)};
		if(DBManager.executeUpdate("delete from [address] where address_Id = ?", objs)){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateAddress(int id,Address address) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String[] objs = new String[]{address.getSex(),address.getAddressdetail(),address.getPhone(),String.valueOf(id)};
		if(DBManager.executeUpdate("update [address] set user_sex=?,address_detail=?,phone=? where address_Id = ?", objs)){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean setDefaultAddress(int userId,int addressId) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String[] objs = new String[]{String.valueOf(addressId),String.valueOf(userId)};
		if(DBManager.executeUpdate("update [user] set default_address_Id = ? where user_Id=?", objs)){
			flag=true;
		}
		return flag;
	}

}
