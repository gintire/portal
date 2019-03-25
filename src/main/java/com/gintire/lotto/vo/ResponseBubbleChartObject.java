package com.gintire.lotto.vo;

public class ResponseBubbleChartObject {
	private String name;
	private Integer size;
	
	public ResponseBubbleChartObject() {
		super();
	}
	public ResponseBubbleChartObject(String name, Integer size) {
		super();
		this.name = name;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
}
