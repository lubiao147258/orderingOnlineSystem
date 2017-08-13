package com.lb.entity;

public class FoodVO {
	
	private int orderid;
	private int foodid;
	private int foodcount;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public int getFoodcount() {
		return foodcount;
	}
	public void setFoodcount(int foodcount) {
		this.foodcount = foodcount;
	}
	public FoodVO(int foodid, int foodcount) {
		super();
		this.foodid = foodid;
		this.foodcount = foodcount;
	}
	
	public FoodVO(int orderid, int foodid, int foodcount) {
		super();
		this.orderid = orderid;
		this.foodid = foodid;
		this.foodcount = foodcount;
	}
	public FoodVO() {
		super();
	}
	
	

}
