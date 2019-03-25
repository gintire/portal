package com.gintire.lotto.vo;

import java.io.Serializable;
import java.util.List;

public class ResponseLottoObject implements Serializable {
	/**
	 * @author IT1702016
	 * @date 2017. 7. 4.
	 * @version v.1.0
	 * @기능
	 * @설명
	 */
	private static final long serialVersionUID = 7501398976875818495L;

	private int iTotalRecords;
	 
	private int iTotalDisplayRecords;
	 
	private int start;
    
	private  int length;

	List<LottoListVO> data;

	public int getiTotalRecords() {
		return iTotalRecords;
	}



	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}



	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}



	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}



	public int getStart() {
		return start;
	}



	public void setStart(int start) {
		this.start = start;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	public List<LottoListVO> getData() {
		return data;
	}



	public void setData(List<LottoListVO> data) {
		this.data = data;
	}

}
