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

}
