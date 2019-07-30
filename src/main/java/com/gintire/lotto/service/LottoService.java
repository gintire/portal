package com.gintire.lotto.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gintire.lotto.dao.LottoDao;
import com.gintire.lotto.vo.LottoListVO;
import com.gintire.lotto.vo.LottoVO;
import com.gintire.lotto.vo.ResponseBubbleChartObject;
import com.gintire.lotto.vo.ResponseFreqNumByYearObject;
import com.gintire.lotto.vo.ResponseFreqNumsByYearListObject;
import com.gintire.lotto.vo.ResponseFreqNumsByYearObject;
import com.gintire.lotto.vo.ResponseFreqNumsObject;
import com.gintire.lotto.vo.ResponseLottoObject;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service(value = "LottoService")
public class LottoService extends EgovAbstractServiceImpl {
	
	@Resource(name = "LottoDao")
	private LottoDao lottoDao;
	
	private static final Logger logger = LoggerFactory.getLogger(LottoService.class);
	
	//초기화
	public void init() throws Exception {
		 List<LottoVO> listLottoVO = new ArrayList<LottoVO>();
	   	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   	 Integer totNumber = 0;
	     
	   	 totNumber = lottoDao.getTotNum();
        //RestTemplate - rest를 던저서 xml로 받아오기 위한 것
    	if(totNumber!=0){
	        disableSslVerification();
	        String res = getJSON("https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo="+totNumber+1, 3000);
    		 try {
 	        	JSONParser jsonParser = new JSONParser();
 	        	//JSON데이터를 넣어 JSON Object로 만들어준다
 	        	JSONObject jsonObject = (JSONObject) jsonParser.parse(res);
 	        	//JSONObject jsonObject = (JSONObject)JSONValue.parse(isr);
 	        	
 	        	LottoVO lottoVO= new LottoVO();
 	        	lottoVO.setBnusNo( Integer.parseInt(jsonObject.get("bnusNo").toString()));
 	        	lottoVO.setFirstWinamnt( Long.parseLong(jsonObject.get("firstWinamnt").toString()));
 	        	lottoVO.setTotSellamnt(Long.parseLong(jsonObject.get("totSellamnt").toString()));
 	        	lottoVO.setDrwNo(Integer.parseInt(jsonObject.get("drwNo").toString()));
 	        	lottoVO.setDrwtNo1(Integer.parseInt(jsonObject.get("drwtNo1").toString()));
 	        	lottoVO.setDrwtNo2(Integer.parseInt(jsonObject.get("drwtNo2").toString()));
 	        	lottoVO.setDrwtNo3(Integer.parseInt(jsonObject.get("drwtNo3").toString()));
 	        	lottoVO.setDrwtNo4(Integer.parseInt(jsonObject.get("drwtNo4").toString()));
 	        	lottoVO.setDrwtNo5(Integer.parseInt(jsonObject.get("drwtNo5").toString()));
 	        	lottoVO.setDrwtNo6(Integer.parseInt(jsonObject.get("drwtNo6").toString()));
 				lottoVO.setDrwNoDate(sdf.parse(jsonObject.get("drwNoDate").toString()));
 	        	lottoVO.setFirstPrzwnerCo(Integer.parseInt(jsonObject.get("firstPrzwnerCo").toString()));
 	        	listLottoVO.add(lottoVO);
 	        }catch (java.text.ParseException e) {
 				e.printStackTrace();
 			}
     	} else {
	    	for(int i = 1;i<=851;i++){
		        disableSslVerification();
		        String res = getJSON("https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo="+i, 3000);
	    		 try { 
	 	        	JSONParser jsonParser = new JSONParser();
	 	        	//JSON데이터를 넣어 JSON Object로 만들어준다
	 	        	JSONObject jsonObject = (JSONObject) jsonParser.parse(res);
	 	        	//JSONObject jsonObject = (JSONObject)JSONValue.parse(isr);
		        	
		        	LottoVO lottoVO= new LottoVO();
		        	lottoVO.setBnusNo( Integer.parseInt(jsonObject.get("bnusNo").toString()));
	 	        	lottoVO.setFirstWinamnt( Long.parseLong(jsonObject.get("firstWinamnt").toString()));
	 	        	lottoVO.setTotSellamnt(Long.parseLong(jsonObject.get("totSellamnt").toString()));
	 	        	lottoVO.setDrwNo(Integer.parseInt(jsonObject.get("drwNo").toString()));
	 	        	lottoVO.setDrwtNo1(Integer.parseInt(jsonObject.get("drwtNo1").toString()));
	 	        	lottoVO.setDrwtNo2(Integer.parseInt(jsonObject.get("drwtNo2").toString()));
	 	        	lottoVO.setDrwtNo3(Integer.parseInt(jsonObject.get("drwtNo3").toString()));
	 	        	lottoVO.setDrwtNo4(Integer.parseInt(jsonObject.get("drwtNo4").toString()));
	 	        	lottoVO.setDrwtNo5(Integer.parseInt(jsonObject.get("drwtNo5").toString()));
	 	        	lottoVO.setDrwtNo6(Integer.parseInt(jsonObject.get("drwtNo6").toString()));
	 				lottoVO.setDrwNoDate(sdf.parse(jsonObject.get("drwNoDate").toString()));
	 	        	lottoVO.setFirstPrzwnerCo(Integer.parseInt(jsonObject.get("firstPrzwnerCo").toString()));
	 	        	System.out.println(lottoVO.toString());
		        	listLottoVO.add(lottoVO);
		        }catch (java.text.ParseException e) {
					e.printStackTrace();
				}
	    	}
     	}
    	Map<String,List<LottoVO>> map = new HashMap<String, List<LottoVO>>();
    	map.put("list", listLottoVO);
    	lottoDao.initData(map);
	}

	//현재까지 총 당첨 번호
	public List<LottoVO> readList(LottoVO lottoVO) {
		List<LottoVO> list = lottoDao.readList(lottoVO);
		return list;
	}
	public Integer pageBoardCount(ResponseLottoObject responseLottoObject) {
		Integer totNum = lottoDao.pageBoardCount(responseLottoObject);
		return totNum;
	}

	//페이징된 로또 당첨번호 기록
	public List<LottoListVO> pageBoard(ResponseLottoObject responseLottoObject) {
		List<LottoVO> list = lottoDao.pageBoard(responseLottoObject);
		List<LottoListVO> resList = new ArrayList<LottoListVO>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i =0; i<list.size();i++) {
			LottoVO vo = list.get(i);
			LottoListVO vo2 =new LottoListVO();
			vo2.setDrwNo(vo.getDrwNo());
			vo2.setDrwtNo(vo.getDrwtNo1()+", "+vo.getDrwtNo2()+", "+vo.getDrwtNo3()+", "+vo.getDrwtNo4()+", "+vo.getDrwtNo5()+", "+vo.getDrwtNo6());
			vo2.setBnusNo(vo.getBnusNo());
			vo2.setDrwnodate(sdf.format(vo.getDrwNoDate()));
			vo2.setFirstwinamnt(vo.getFirstWinamnt());
			vo2.setDrwtNo1(vo.getDrwtNo1());
			vo2.setDrwtNo2(vo.getDrwtNo2());
			vo2.setDrwtNo3(vo.getDrwtNo3());
			vo2.setDrwtNo4(vo.getDrwtNo4());
			vo2.setDrwtNo5(vo.getDrwtNo5());
			vo2.setDrwtNo6(vo.getDrwtNo6());
			
			resList.add(vo2);
		}
		return resList;
	}

	public List<ResponseFreqNumsObject> allPeriodFreq(ResponseFreqNumsObject responseFreqNumsObject) {
		List<ResponseFreqNumsObject> list = lottoDao.allPeriodFreq(responseFreqNumsObject);
		
		return list;
	}

	public List<ResponseFreqNumsByYearListObject> allPeriodFreqByYearList(
			ResponseFreqNumByYearObject responseFreqNumByYearObject) {
		List<ResponseFreqNumByYearObject> list = lottoDao.allPeriodFreqByYear(responseFreqNumByYearObject);
		List<ResponseFreqNumsObject> vList = new ArrayList<ResponseFreqNumsObject>();
		List<ResponseFreqNumsByYearListObject> resList = new ArrayList<ResponseFreqNumsByYearListObject>();
		int minYear = Integer.parseInt(list.get(0).getYear());
		int maxYear = Integer.parseInt(list.get(0).getYear());
		for (int i=0; i<list.size();i++) {
			ResponseFreqNumByYearObject vObject = list.get(i);
			if(minYear>Integer.parseInt(vObject.getYear()))
				minYear = Integer.parseInt(vObject.getYear());
			if(maxYear<Integer.parseInt(vObject.getYear()))
				maxYear = Integer.parseInt(vObject.getYear());
		}
		for(int year = minYear; year<maxYear;year++) {
			ResponseFreqNumsByYearListObject tmpObject2 = new ResponseFreqNumsByYearListObject();
			for (int i=0; i<list.size();i++) {
				ResponseFreqNumByYearObject vObject = list.get(i);
				if(Integer.parseInt(vObject.getYear())==year){
					ResponseFreqNumsObject tmpObject = new ResponseFreqNumsObject();
					tmpObject.setNum(vObject.getNum());
					tmpObject.setFreq(vObject.getFreq());

					vList.add(tmpObject);
				}
				tmpObject2.setYear(year+"");
				tmpObject2.setList(vList);
				resList.add(tmpObject2);
			}
		}
		return resList;
	}
	@SuppressWarnings("unused")
	public List<ResponseFreqNumsByYearObject> allPeriodFreqByYear(
			ResponseFreqNumByYearObject responseFreqNumByYearObject) {
		List<ResponseFreqNumByYearObject> list = lottoDao.allPeriodFreqByYear(responseFreqNumByYearObject);
		List<ResponseFreqNumsObject> vList = new ArrayList<ResponseFreqNumsObject>();
		List<ResponseFreqNumsByYearObject> resList = new ArrayList<ResponseFreqNumsByYearObject>();
		int minYear = Integer.parseInt(list.get(0).getYear());
		int maxYear = Integer.parseInt(list.get(0).getYear());
		for (int i=0; i<list.size();i++) {
			ResponseFreqNumByYearObject vObject = list.get(i);
			if(minYear>Integer.parseInt(vObject.getYear()))
				minYear = Integer.parseInt(vObject.getYear());
			if(maxYear<Integer.parseInt(vObject.getYear()))
				maxYear = Integer.parseInt(vObject.getYear());
		}
		for(int year = minYear; year<=maxYear;year++) {
			ResponseFreqNumsByYearObject tmpObject2 = new ResponseFreqNumsByYearObject();
			ResponseFreqNumByYearObject vObject = new ResponseFreqNumByYearObject();;
			for (int i=0; i<list.size();i++) {
				vObject = list.get(i);
				if(Integer.parseInt(vObject.getYear())==year){
					if(vObject.getNum()==1)
						tmpObject2.setNum1Freq(vObject.getFreq());
					if(vObject.getNum()==2)
						tmpObject2.setNum2Freq(vObject.getFreq());
					if(vObject.getNum()==3)
						tmpObject2.setNum3Freq(vObject.getFreq());
					if(vObject.getNum()==4)
						tmpObject2.setNum4Freq(vObject.getFreq());
					if(vObject.getNum()==5)
						tmpObject2.setNum5Freq(vObject.getFreq());
					if(vObject.getNum()==6)
						tmpObject2.setNum6Freq(vObject.getFreq());
					if(vObject.getNum()==7)
						tmpObject2.setNum7Freq(vObject.getFreq());
					if(vObject.getNum()==8)
						tmpObject2.setNum8Freq(vObject.getFreq());
					if(vObject.getNum()==9)
						tmpObject2.setNum9Freq(vObject.getFreq());
					if(vObject.getNum()==10)
						tmpObject2.setNum10Freq(vObject.getFreq());
					if(vObject.getNum()==11)
						tmpObject2.setNum11Freq(vObject.getFreq());
					if(vObject.getNum()==12)
						tmpObject2.setNum12Freq(vObject.getFreq());
					if(vObject.getNum()==13)
						tmpObject2.setNum13Freq(vObject.getFreq());
					if(vObject.getNum()==14)
						tmpObject2.setNum14Freq(vObject.getFreq());
					if(vObject.getNum()==15)
						tmpObject2.setNum15Freq(vObject.getFreq());
					if(vObject.getNum()==16)
						tmpObject2.setNum16Freq(vObject.getFreq());
					if(vObject.getNum()==17)
						tmpObject2.setNum17Freq(vObject.getFreq());
					if(vObject.getNum()==18)
						tmpObject2.setNum18Freq(vObject.getFreq());
					if(vObject.getNum()==19)
						tmpObject2.setNum19Freq(vObject.getFreq());
					if(vObject.getNum()==20)
						tmpObject2.setNum20Freq(vObject.getFreq());
					if(vObject.getNum()==21)
						tmpObject2.setNum21Freq(vObject.getFreq());
					if(vObject.getNum()==22)
						tmpObject2.setNum22Freq(vObject.getFreq());
					if(vObject.getNum()==23)
						tmpObject2.setNum23Freq(vObject.getFreq());
					if(vObject.getNum()==24)
						tmpObject2.setNum24Freq(vObject.getFreq());
					if(vObject.getNum()==25)
						tmpObject2.setNum25Freq(vObject.getFreq());
					if(vObject.getNum()==26)
						tmpObject2.setNum26Freq(vObject.getFreq());
					if(vObject.getNum()==27)
						tmpObject2.setNum27Freq(vObject.getFreq());
					if(vObject.getNum()==28)
						tmpObject2.setNum28Freq(vObject.getFreq());
					if(vObject.getNum()==29)
						tmpObject2.setNum29Freq(vObject.getFreq());
					if(vObject.getNum()==30)
						tmpObject2.setNum30Freq(vObject.getFreq());
					if(vObject.getNum()==31)
						tmpObject2.setNum31Freq(vObject.getFreq());
					if(vObject.getNum()==32)
						tmpObject2.setNum32Freq(vObject.getFreq());
					if(vObject.getNum()==33)
						tmpObject2.setNum33Freq(vObject.getFreq());
					if(vObject.getNum()==34)
						tmpObject2.setNum34Freq(vObject.getFreq());
					if(vObject.getNum()==35)
						tmpObject2.setNum35Freq(vObject.getFreq());
					if(vObject.getNum()==36)
						tmpObject2.setNum36Freq(vObject.getFreq());
					if(vObject.getNum()==37)
						tmpObject2.setNum37Freq(vObject.getFreq());
					if(vObject.getNum()==38)
						tmpObject2.setNum38Freq(vObject.getFreq());
					if(vObject.getNum()==39)
						tmpObject2.setNum39Freq(vObject.getFreq());
					if(vObject.getNum()==40)
						tmpObject2.setNum40Freq(vObject.getFreq());
					if(vObject.getNum()==41)
						tmpObject2.setNum41Freq(vObject.getFreq());
					if(vObject.getNum()==42)
						tmpObject2.setNum42Freq(vObject.getFreq());
					if(vObject.getNum()==43)
						tmpObject2.setNum43Freq(vObject.getFreq());
					if(vObject.getNum()==44)
						tmpObject2.setNum44Freq(vObject.getFreq());
					if(vObject.getNum()==45)
						tmpObject2.setNum45Freq(vObject.getFreq());
				}
			}
			tmpObject2.setYear(year+"");
			resList.add(tmpObject2);
		}
		return resList;
	}

	public List<ResponseFreqNumsObject> worstNums(ResponseFreqNumsObject responseFreqNumsObject) {
		List<ResponseFreqNumsObject> list = lottoDao.worstNums(responseFreqNumsObject);
		return list;
	}

	public List<ResponseFreqNumsObject> bestNums(ResponseFreqNumsObject responseFreqNumsObject) {
		List<ResponseFreqNumsObject> list = lottoDao.bestNums(responseFreqNumsObject);
		return list;
	}

	public List<ResponseBubbleChartObject> allPeriodFreqD3(ResponseFreqNumsObject responseFreqNumsObject) {
		List<ResponseFreqNumsObject> list = lottoDao.allPeriodFreq(responseFreqNumsObject);
		List<ResponseBubbleChartObject> resList = new ArrayList<ResponseBubbleChartObject>();
		int sum0s = 0, sum10s = 0, sum20s = 0, sum30s = 0, sum40s =0;
		
		for(int i =0; i<list.size();i++) {
			ResponseBubbleChartObject vObject = new ResponseBubbleChartObject();
			vObject.setName(list.get(i).getNum().toString());
			vObject.setSize(list.get(i).getFreq());
			if(list.get(i).getNum()/10==0)
				sum0s+=list.get(i).getFreq();
			if(list.get(i).getNum()/10==1)
				sum10s+=list.get(i).getFreq();
			if(list.get(i).getNum()/10==2)
				sum20s+=list.get(i).getFreq();
			if(list.get(i).getNum()/10==3)
				sum30s+=list.get(i).getFreq();
			if(list.get(i).getNum()/10==4)
				sum40s+=list.get(i).getFreq();
			resList.add(vObject);
		}
		/*resList.add(new ResponseBubbleChartObject("1~9",sum0s));
		resList.add(new ResponseBubbleChartObject("10~19",sum10s));
		resList.add(new ResponseBubbleChartObject("20~29",sum20s));
		resList.add(new ResponseBubbleChartObject("30~39",sum30s));
		resList.add(new ResponseBubbleChartObject("40~45",sum40s));*/
		return resList;
	}
	
	 public static JSONObject readJsonFromUrl(String url) throws IOException, ParseException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONParser jsonParser = new JSONParser();
	      //JSON데이터를 넣어 JSON Object로 만들어준다
	      JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonText);
	      return jsonObject;
	    } finally {
	      is.close();
	    }
	  }
	 private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	 public static String getJSON(String url, int timeout) throws IOException {

		    URL u = new URL(url);
		    HttpsURLConnection c = (HttpsURLConnection) u.openConnection();
		    c.setRequestMethod("GET");
		    c.setRequestProperty("Content-length", "0");
		    c.setUseCaches(false);
		    c.setAllowUserInteraction(false);
		    c.setConnectTimeout(timeout);
		    c.setReadTimeout(timeout);
		    c.connect();
		    int status = c.getResponseCode();

		    switch (status) {
		        case 200:
		        case 201:
		            BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
		            StringBuilder sb = new StringBuilder();
		            String line;
		            while ((line = br.readLine()) != null) {
		                sb.append(line + "\n");
		            }
		            br.close();
		            return sb.toString();
		         default:
		        	 logger.error("Wrong request");
		    }

		    return null;
		}
	 private static void disableSslVerification() {
	        try
	        {
	            // Create a trust manager that does not validate certificate chains
	            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                    return null;
	                }
	                public void checkClientTrusted(X509Certificate[] certs, String authType) {
	                }
	                public void checkServerTrusted(X509Certificate[] certs, String authType) {
	                }
	            }
	            };
	 
	            // Install the all-trusting trust manager
	            SSLContext sc = SSLContext.getInstance("SSL");
	            sc.init(null, trustAllCerts, new java.security.SecureRandom());
	            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	 
	            // Create all-trusting host name verifier
	            HostnameVerifier allHostsValid = new HostnameVerifier() {
	                public boolean verify(String hostname, SSLSession session) {
	                    return true;
	                }
	            };
	 
	            // Install the all-trusting host verifier
	            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } catch (KeyManagementException e) {
	            e.printStackTrace();
	        }
	    }
}