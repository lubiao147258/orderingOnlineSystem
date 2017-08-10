package com.lb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lb.dao.IUser;
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

}
