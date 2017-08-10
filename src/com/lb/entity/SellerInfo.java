package com.lb.entity;

public class SellerInfo {

	private int Sellerid;
	private String loginname;
	private String password;
	private String shopname;
	private String shopinfo;
	private String phone;
	private String location;
	public int getSellerid() {
		return Sellerid;
	}
	public void setSellerid(int sellerid) {
		Sellerid = sellerid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShopinfo() {
		return shopinfo;
	}
	public void setShopinfo(String shopinfo) {
		this.shopinfo = shopinfo;
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
	public SellerInfo(int sellerid, String loginname, String password, String shopname, String shopinfo, String phone,
			String location) {
		super();
		Sellerid = sellerid;
		this.loginname = loginname;
		this.password = password;
		this.shopname = shopname;
		this.shopinfo = shopinfo;
		this.phone = phone;
		this.location = location;
	}
	public SellerInfo() {
		super();
	}
	public SellerInfo(String shopname, String shopinfo, String phone, String location) {
		super();
		this.shopname = shopname;
		this.shopinfo = shopinfo;
		this.phone = phone;
		this.location = location;
	}
	
	
	
}
