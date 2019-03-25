package com.gintire.java8.vo;

public class Apple {
	public int id;
	public String color;
	public int weight;
	
	public Apple(int id, String color, int weight) {
		super();
		this.id = id;
		this.color = color;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
