package com.lb.entity;

public class Order {

	private int orderid;
	private int userid;
	private int addressid;
	private double total;
	private int paystatus;
	private String time;
	private int status;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Order(int orderid, int userid, int addressid, double total, int paystatus, String time, int status) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.addressid = addressid;
		this.total = total;
		this.paystatus = paystatus;
		this.time = time;
		this.status = status;
	}
	public Order() {
		super();
	}
	
	
}
