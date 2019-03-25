package com.gintire.lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gintire.lotto.service.LottoService;
import com.gintire.lotto.vo.D3;
import com.gintire.lotto.vo.LottoListVO;
import com.gintire.lotto.vo.ParentD3;
import com.gintire.lotto.vo.ResponseBubbleChar2;
import com.gintire.lotto.vo.ResponseBubbleChartList;
import com.gintire.lotto.vo.ResponseBubbleChartObject;
import com.gintire.lotto.vo.ResponseFreqNumByYearObject;
import com.gintire.lotto.vo.ResponseFreqNumsByYearListObject;
import com.gintire.lotto.vo.ResponseFreqNumsByYearObject;
import com.gintire.lotto.vo.ResponseFreqNumsObject;
import com.gintire.lotto.vo.ResponseLottoObject;
import com.gintire.lotto.vo.ResponseMorrisDonutCharObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class LottoController {

	@Resource(name="LottoService")
	private LottoService lottoService;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(LottoController.class);

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "pages/login";
    }
	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
    public String httpGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		lottoService.init();
        return "pages/index";
    }
	
	@RequestMapping(value="/home.do", method = RequestMethod.GET)
	public String board(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "pages/index";
	}
	@RequestMapping(value = "/goXChart.do", method = RequestMethod.GET)
	public String xChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "pages/xchart";
	}
	@RequestMapping(value = "/goMorrisChart.do", method = RequestMethod.GET)
	public String morrisChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "pages/morris";
	}
	@RequestMapping(value = "/goD3Chart.do", method = RequestMethod.GET)
	public String d3Chart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "pages/bubblechart";
	}
	@RequestMapping(value = "/goFlotChart.do", method = RequestMethod.GET)
	public String flotChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "pages/flot";
	}
	//Morris Bar, Area Chart
	@RequestMapping(value = "/morrisBarChart.do", method = RequestMethod.GET)
	public @ResponseBody Object morrisBarChart(HttpServletRequest request, HttpServletResponse response, ResponseFreqNumsObject responseFreqNumsObject) throws Exception {
		response.setCharacterEncoding("UTF-8");
	 	response.setContentType("application/json; charset=UTF-8");
	 	
	 	List<ResponseFreqNumsObject> list = lottoService.allPeriodFreq(responseFreqNumsObject); 
	 	
		return list;
	}
	//D3
		@RequestMapping(value = "/d3.do", method = RequestMethod.GET)
		public @ResponseBody Object d3(HttpServletRequest request, HttpServletResponse response, ResponseFreqNumsObject responseFreqNumsObject) throws Exception {
			ParentD3 d3 = new ParentD3();
			D3 childD3 = new D3();
			
			response.setCharacterEncoding("UTF-8");
		 	response.setContentType("application/json; charset=UTF-8");
		 	
		 	List<D3> d3List = new ArrayList<D3>();
		 	
		 	List<ResponseBubbleChartObject> list = lottoService.allPeriodFreqD3(responseFreqNumsObject); 
		 	
		
		 	List<D3> childrenD3List = new ArrayList<D3>();
		 	for(int i=0; i<list.size();i++) {
		 		List<ResponseBubbleChartObject> vList = new ArrayList<ResponseBubbleChartObject>();
		 		ResponseBubbleChartObject vObject = new ResponseBubbleChartObject();
		 		D3 childrenD3 = new D3();
		 		vObject.setName(list.get(i).getName());
		 		vObject.setSize(list.get(i).getSize());
		 		vList.add(vObject);
		 		childrenD3.setName(list.get(i).getName());
		 		childrenD3.setChildren(vList);
		 		
		 		childrenD3List.add(childrenD3);
		 	}
		 	d3.setName("flare");
		 	d3.setChildren(childrenD3List);
		 	
		 	Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json2 = gson.toJson(d3);
			System.out.println("json"+json2);
			
			return d3;
		}
		//D3
				@RequestMapping(value = "/test.do", method = RequestMethod.GET)
				public @ResponseBody Object test(HttpServletRequest request, HttpServletResponse response, ResponseFreqNumsObject responseFreqNumsObject) throws Exception {
//					ParentD3 d3 = new ParentD3();
//					D3 childD3 = new D3();
//					
					response.setCharacterEncoding("UTF-8");
				 	response.setContentType("application/json; charset=UTF-8");
//				 	
//				 	List<D3> d3List = new ArrayList<D3>();
//				 	
				 	//List<ResponseBubbleChartObject> list = lottoService.allPeriodFreqD3(responseFreqNumsObject); 
//				 	
//				
//				 	List<D3> childrenD3List = new ArrayList<D3>();
					List<ResponseBubbleChartObject> list = lottoService.allPeriodFreqD3(responseFreqNumsObject);
					List<ResponseBubbleChar2> resList = new ArrayList<ResponseBubbleChar2>();
					List<ResponseBubbleChar2> v0ObjectList = new ArrayList<ResponseBubbleChar2>();
					List<ResponseBubbleChar2> v10ObjectList = new ArrayList<ResponseBubbleChar2>();
					List<ResponseBubbleChar2> v20ObjectList = new ArrayList<ResponseBubbleChar2>();
					List<ResponseBubbleChar2> v30ObjectList = new ArrayList<ResponseBubbleChar2>();
					List<ResponseBubbleChar2> v40ObjectList = new ArrayList<ResponseBubbleChar2>();
					int sum0 =0;int sum10 =0;int sum20 =0;int sum30 =0;int sum40 =0;
				 	for(int i=0; i<list.size();i++) {
				 		ResponseBubbleChar2 vObject = new ResponseBubbleChar2();
				 		
				 		if(Integer.parseInt(list.get(i).getName())/10==0) {
				 			vObject.setText(list.get(i).getName());
				 			vObject.setCount(list.get(i).getSize());
				 			sum0+=list.get(i).getSize();
				 			
				 			v0ObjectList.add(vObject);
				 		}
				 		if(Integer.parseInt(list.get(i).getName())/10==1) {
				 			vObject.setText(list.get(i).getName());
				 			vObject.setCount(list.get(i).getSize());
				 			
				 			sum10+=list.get(i).getSize();
				 			v10ObjectList.add(vObject);
				 		}
				 		if(Integer.parseInt(list.get(i).getName())/10==2) {
				 			vObject.setText(list.get(i).getName());
				 			vObject.setCount(list.get(i).getSize());
				 			
				 			sum20+=list.get(i).getSize();
				 			v20ObjectList.add(vObject);
				 		}
				 		if(Integer.parseInt(list.get(i).getName())/10==3) {
				 			vObject.setText(list.get(i).getName());
				 			vObject.setCount(list.get(i).getSize());
				 			
				 			sum30+=list.get(i).getSize();
				 			v30ObjectList.add(vObject);
				 		}
				 		if(Integer.parseInt(list.get(i).getName())/10==4) {
				 			vObject.setText(list.get(i).getName());
				 			vObject.setCount(list.get(i).getSize());
				 			
				 			sum40+=list.get(i).getSize();
				 			v40ObjectList.add(vObject);
				 		}
				 		
				 	}
				 	ResponseBubbleChar2 v0Object = new ResponseBubbleChar2();
				 	ResponseBubbleChar2 v10Object = new ResponseBubbleChar2();
				 	ResponseBubbleChar2 v20Object = new ResponseBubbleChar2();
				 	ResponseBubbleChar2 v30Object = new ResponseBubbleChar2();
				 	ResponseBubbleChar2 v40Object = new ResponseBubbleChar2();
				 	ResponseBubbleChar2 v777Object = new ResponseBubbleChar2();
				 	
				 	v777Object.setText("처음으로");
				 	v777Object.setCount(0);
				 	v0Object.setText("1~9");
				 	v0Object.setCount(sum0);
				 	v10Object.setText("10~19");
				 	v10Object.setCount(sum10);
				 	v20Object.setText("20~29");
				 	v20Object.setCount(sum20);
				 	v30Object.setText("30~39");
				 	v30Object.setCount(sum30);
				 	v40Object.setText("40~45");
				 	v40Object.setCount(sum40);
				 	
			 		
			 		resList.add(v0Object);
			 		resList.add(v10Object);
			 		resList.add(v20Object);
			 		resList.add(v30Object);
			 		resList.add(v40Object);
			 		resList.add(v777Object);
			 		v0ObjectList.add(v777Object);
			 		v10ObjectList.add(v777Object);
			 		v20ObjectList.add(v777Object);
			 		v30ObjectList.add(v777Object);
			 		v40ObjectList.add(v777Object);
			 		
			 		
			 		ResponseBubbleChartList finalListTot = new ResponseBubbleChartList();
			 		ResponseBubbleChartList finalList0 = new ResponseBubbleChartList();
			 		ResponseBubbleChartList finalList10 = new ResponseBubbleChartList();
			 		ResponseBubbleChartList finalList20 = new ResponseBubbleChartList();
			 		ResponseBubbleChartList finalList30 = new ResponseBubbleChartList();
			 		ResponseBubbleChartList finalList40 = new ResponseBubbleChartList();
			 		
			 		finalList0.setList(v0ObjectList);
			 		finalList0.setName("0");
			 		finalList10.setList(v10ObjectList);
			 		finalList10.setName("10");
			 		finalList20.setList(v20ObjectList);
			 		finalList20.setName("20");
			 		finalList30.setList(v30ObjectList);
			 		finalList30.setName("30");
			 		finalList40.setList(v40ObjectList);
			 		finalList40.setName("40");
			 		finalListTot.setList(resList);
			 		finalListTot.setName("total");
			 		
			 		List<ResponseBubbleChartList> finalList = new ArrayList<ResponseBubbleChartList>();
			 		finalList.add(finalListTot);
			 		finalList.add(finalList0);
			 		finalList.add(finalList10);
			 		finalList.add(finalList20);
			 		finalList.add(finalList30);
			 		finalList.add(finalList40);
//					for(int i=0; i<10;i++) {
//						ResponseBubbleChar2 vObject = new ResponseBubbleChar2();
//						vObject.setText(list.get(i).getName());
//						vObject.setCount(list.get(i).getSize());
//						
//						resList.add(vObject);
//					}
//				 	D3 children0D3 = new D3();
//				 	D3 children10D3 = new D3();
//				 	D3 children20D3 = new D3();
//				 	D3 children30D3 = new D3();
//				 	D3 children40D3 = new D3();
//				 	
//				 	children0D3.setName("1~9");
//			 		children0D3.setChildren(v0List);
//			 		
//			 		children10D3.setName("10~19");
//			 		children10D3.setChildren(v10List);
//			 		
//			 		children20D3.setName("20~29");
//			 		children20D3.setChildren(v20List);
//			 		
//			 		children30D3.setName("30~39");
//			 		children30D3.setChildren(v30List);
//			 		
//			 		children40D3.setName("40~45");
//			 		children40D3.setChildren(v40List);
//			 		
//			 		childrenD3List.add(children0D3);
//			 		childrenD3List.add(children10D3);
//			 		childrenD3List.add(children20D3);
//			 		childrenD3List.add(children30D3);
//			 		childrenD3List.add(children40D3);
//			 		
//				 	d3.setName("bubble");
//				 	d3.setChildren(resList);
			 		System.out.println(finalList);
					return finalList;
				}
	//Get All Data Count
	@RequestMapping(value = "/allDataCount.do", method = RequestMethod.GET)
	public @ResponseBody Integer allDataCount(HttpServletRequest request, HttpServletResponse response, ResponseLottoObject responseLottoObject) throws Exception {
	 	
		Integer res = lottoService.pageBoardCount(responseLottoObject);
		System.out.println(res);
		return res;
	}
	//Get Freq by year , num Chart
	@RequestMapping(value = "/freqNumByYear.do", method = RequestMethod.GET)
	public @ResponseBody Object freqNumByYear(HttpServletRequest request, HttpServletResponse response, ResponseFreqNumByYearObject responseFreqNumByYearObject) throws Exception {
		response.setCharacterEncoding("UTF-8");
	 	response.setContentType("application/json; charset=UTF-8");
	 	
	 	List<ResponseFreqNumsByYearListObject> list = lottoService.allPeriodFreqByYearList(responseFreqNumByYearObject); 
	 	
		return list;
	}
	//The Worst Numbers Of year
	@RequestMapping(value = "/worstNums.do", method = RequestMethod.GET)
	public @ResponseBody Object worstNums(HttpServletRequest request, HttpServletResponse response, ResponseFreqNumsObject responseFreqNumsObject) throws Exception {
		response.setCharacterEncoding("UTF-8");
	 	response.setContentType("application/json; charset=UTF-8");
	 	
	 	List<ResponseFreqNumsObject> list = lottoService.worstNums(responseFreqNumsObject); 
	 	
		return list;
	}
	//The Best Numbers Of year
		@RequestMapping(value = "/bestNums.do", method = RequestMethod.GET)
		public @ResponseBody Object bestNums(HttpServletRequest request, HttpServletResponse response, ResponseFreqNumsObject responseFreqNumsObject) throws Exception {
			response.setCharacterEncoding("UTF-8");
		 	response.setContentType("application/json; charset=UTF-8");
		 	
		 	List<ResponseFreqNumsObject> list = lottoService.bestNums(responseFreqNumsObject); 
		 	
			return list;
		}
	//Morris Line Chart
			@RequestMapping(value = "/morrisLineChart.do", method = RequestMethod.GET)
			public @ResponseBody Object morrisLineChart(HttpServletRequest request, HttpServletResponse response, ResponseFreqNumByYearObject responseFreqNumByYearObject) throws Exception {
				response.setCharacterEncoding("UTF-8");
			 	response.setContentType("application/json; charset=UTF-8");
			 	
			 	List<ResponseFreqNumsByYearObject> list = lottoService.allPeriodFreqByYear(responseFreqNumByYearObject); 
			 	
				return list;
			}
	//Morris Donut Chart
	@RequestMapping(value = "/morrisDonutChart.do", method = RequestMethod.GET)
	public @ResponseBody Object morrisDonutChart(HttpServletRequest request, HttpServletResponse response, ResponseFreqNumsObject responseFreqNumsObject) throws Exception {
		response.setCharacterEncoding("UTF-8");
	 	response.setContentType("application/json; charset=UTF-8");
	 	
	 	List<ResponseFreqNumsObject> list = lottoService.allPeriodFreq(responseFreqNumsObject); 
	 	List<ResponseMorrisDonutCharObject> resList = new ArrayList<ResponseMorrisDonutCharObject>();
	 	for(int i = 0; i<list.size();i++){
	 		ResponseMorrisDonutCharObject vObject = new ResponseMorrisDonutCharObject();
	 		vObject.setLabel(list.get(i).getNum());
	 		vObject.setValue(list.get(i).getFreq());
	 		resList.add(vObject);
	 	}
	 	 
		return resList;
	}
	@RequestMapping(value = "/dataTable.do", method = RequestMethod.GET)
	public @ResponseBody Object springPaginationDataTables(HttpServletRequest  request, HttpServletResponse response, ResponseLottoObject responseLottoObject){
		response.setCharacterEncoding("UTF-8");
	 	response.setContentType("application/json; charset=UTF-8");
		//Here is server side pagination logic. Based on the page number you could make call 
		//to the data base create new list and send back to the client. For demo I am shuffling 
		//the same list to show data randomly
    	List<LottoListVO> lottoList = lottoService.pageBoard(responseLottoObject);
		Integer iTotCount = lottoService.pageBoardCount(responseLottoObject);
		
		//Search functionality: Returns filtered list based on search parameter
		//Set Total display record
		responseLottoObject.setiTotalDisplayRecords(iTotCount);
		//Set Total record
		responseLottoObject.setiTotalRecords(iTotCount);
		responseLottoObject.setData(lottoList);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(responseLottoObject);
		System.out.println("json"+json2);
		return json2;
	}
	@RequestMapping(value = "/flotChart.do", method = RequestMethod.GET)
	public @ResponseBody String floatChartPage(HttpServletRequest  request, HttpServletResponse response, ResponseLottoObject responseLottoObject){
		response.setCharacterEncoding("UTF-8");
	 	response.setContentType("application/json; charset=UTF-8");
		//Here is server side pagination logic. Based on the page number you could make call 
		//to the data base create new list and send back to the client. For demo I am shuffling 
		//the same list to show data randomly
    	List<LottoListVO> lottoList = lottoService.pageBoard(responseLottoObject);
		Integer iTotCount = lottoService.pageBoardCount(responseLottoObject);
		
		//Search functionality: Returns filtered list based on search parameter
		//Set Total display record
		responseLottoObject.setiTotalDisplayRecords(iTotCount);
		//Set Total record
		responseLottoObject.setiTotalRecords(iTotCount);
		responseLottoObject.setData(lottoList);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(responseLottoObject);
		System.out.println("json"+json2);
		return json2;
	}

}

