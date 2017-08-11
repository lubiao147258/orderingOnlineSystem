package com.lb.entity;

public class Address {
	private int id;
	private String sex;
	private String addressdetail;
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddressdetail() {
		return addressdetail;
	}

	public void setAddressdetail(String addressdetail) {
		this.addressdetail = addressdetail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address() {
		super();
	}

	public Address(String sex, String addressdetail, String phone) {
		super();
		this.sex = sex;
		this.addressdetail = addressdetail;
		this.phone = phone;
	}

}
