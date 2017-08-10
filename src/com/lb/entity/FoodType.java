package com.lb.entity;

/**
 * 
 * @描述 商品类别实体类
 * @作者 lubiao
 * @时间 2017年8月10日-上午10:08:37
 *
 */
public class FoodType {

	private int id;
	private String typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public FoodType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public FoodType() {
		super();
	}

	public FoodType(String typeName) {
		super();
		this.typeName = typeName;
	}

}
