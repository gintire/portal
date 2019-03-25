package com.gintire.lotto.vo;

import java.util.List;

public class ResponseFreqNumsByYearListObject {
	private String year;
	private List<ResponseFreqNumsObject> list;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<ResponseFreqNumsObject> getList() {
		return list;
	}
	public void setList(List<ResponseFreqNumsObject> list) {
		this.list = list;
	}
	
}
