package com.lb.entity;

/**
 * 
 * @描述 用户登录实体类
 * @作者 lubiao
 * @时间 2017年8月8日-下午12:55:59
 *
 */
public class User {

	private int id;
	private String username;
	private String password;
	private String email;
	private int defaultAddressId;
	private String phone;
	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDefaultAddressId() {
		return defaultAddressId;
	}

	public void setDefaultAddressId(int defaultAddressId) {
		this.defaultAddressId = defaultAddressId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(int id, String username, String password, String email, int defaultAddressId, String createTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.defaultAddressId = defaultAddressId;
		this.createTime = createTime;
	}

	public User(String username, String password, String email, int defaultAddressId, String createTime) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.defaultAddressId = defaultAddressId;
		this.createTime = createTime;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String email, String phone) {
		super();
		this.username = username;
		this.email = email;
		this.phone = phone;
	}

	public User() {
		super();
	}

}
