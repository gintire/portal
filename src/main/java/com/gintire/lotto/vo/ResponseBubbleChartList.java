package com.gintire.lotto.vo;

import java.util.ArrayList;
import java.util.List;

public class ResponseBubbleChartList {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private List<ResponseBubbleChar2> list = new ArrayList<ResponseBubbleChar2>();

	public List<ResponseBubbleChar2> getList() {
		return list;
	}

	public void setList(List<ResponseBubbleChar2> list) {
		this.list = list;
	}
	
}
