package com.lb.entity;

/**
 * 
 * @描述 商品实体类
 * @作者 lubiao
 * @时间 2017年8月10日-上午10:02:25
 *
 */
public class Food {

	private int id;
	private String foodName;
	private double price;
	private int type_id;
	private int isOnsale;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getIsOnsale() {
		return isOnsale;
	}

	public void setIsOnsale(int isOnsale) {
		this.isOnsale = isOnsale;
	}

	public Food(int id, String foodName, double price, int type_id, int isOnsale) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.type_id = type_id;
		this.isOnsale = isOnsale;
	}

	public Food() {
		super();
	}

	public Food(int type_id,String foodName, double price, int isOnsale) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.type_id = type_id;
		this.isOnsale = isOnsale;
	}
	
	

}
