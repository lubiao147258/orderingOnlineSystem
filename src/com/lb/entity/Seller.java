package com.lb.entity;


/**
 * 
 * @描述   商家信息实体类	
 * @作者 lubiao
 * @时间 2017年8月10日-上午9:11:46
 *
 */
public class Seller {
	private int id;
	private String loginName;
	private String password;
	private String shopName;
	private String shop_Info;
	private String phone;
	public String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShop_Info() {
		return shop_Info;
	}
	public void setShop_Info(String shop_Info) {
		this.shop_Info = shop_Info;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Seller(int id, String loginName, String password, String shopName, String shop_Info, String phone,
			String location) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.password = password;
		this.shopName = shopName;
		this.shop_Info = shop_Info;
		this.phone = phone;
		this.location = location;
	}
	public Seller() {
		super();
	}
	public Seller(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}
	
	
	

}
