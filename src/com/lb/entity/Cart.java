package com.lb.entity;

public class Cart {
	private int id;
	private int userid;
	private int foodid;
	private int foodcount;
	private double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cart(int id, int userid, int foodid, int foodcount, double total) {
		super();
		this.id = id;
		this.userid = userid;
		this.foodid = foodid;
		this.foodcount = foodcount;
		this.total = total;
	}

	public Cart() {
		super();
	}

	public Cart(int userid, int foodid, int foodcount, double total) {
		super();
		this.userid = userid;
		this.foodid = foodid;
		this.foodcount = foodcount;
		this.total = total;
	}

}
