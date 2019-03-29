package com.gintire.lotto.dao;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.gintire.lotto.vo.LottoVO;
import com.gintire.lotto.vo.ResponseFreqNumByYearObject;
import com.gintire.lotto.vo.ResponseFreqNumsObject;
import com.gintire.lotto.vo.ResponseLottoObject;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

//@EnableCaching
@Repository(value="LottoDao")
public class LottoDao extends EgovAbstractMapper {
	/**
	 * @author IT1702016
	 * @date 2017. 7. 4.
	 * @version v.1.0
	 * @기능
	 * @설명
	 */
	//private static final Logger logger = LoggerFactory.getLogger(LottoDao.class);
	
	/*@Autowired 
	protected SqlSession sqlSession;*/

	public void initData(Map<String, List<LottoVO>> map) {
		/*try{
			LottoMapper lottoMapper = sqlSession.getMapper(LottoMapper.class);
			lottoMapper.initData(map);
		}
		catch(Exception e){
			e.printStackTrace();
			logger.debug(" [ERROR] "+e);
		}	*/
		insert("Lotto.initData", map);
	}


	public Integer getTotNum() throws Exception {
		//Integer result = 0;
		/*try {
			LottoMapper lottoMapper = sqlSession.getMapper(LottoMapper.class);
			result =lottoMapper.selectTotNum();
		} catch (NullPointerException e) {
			throw new Exception("selectMemberAdminCount==>null.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("selectMemberAdminCount==>exception.");
		}
		return result;*/
		return selectOne("Lotto.selectTotNum");
	}
	
//	@Cacheable(value ="doCache",key="{#LottoVO.drwNo}")
	public List<LottoVO> readList(LottoVO lottoVO) {
		//List<LottoVO> list = null;
		/*try{			
			LottoMapper lottoMapper = sqlSession.getMapper(LottoMapper.class);
			list = lottoMapper.selectList(lottoVO);
		}
		catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}		*/
		return selectList("Lotto.selectList", lottoVO);
	}
	
	public Integer pageBoardCount(ResponseLottoObject responseLottoObject) {
		ResponseLottoObject resResponseLottoObject = null;
		/*try{			
			LottoMapper lottoMapper = sqlSession.getMapper(LottoMapper.class);
			resResponseLottoObject = lottoMapper.selectPageBoardCount(responseLottoObject);
		}
		catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}	*/
		resResponseLottoObject = selectOne("Lotto.selectPageBoardCount", responseLottoObject);
		return resResponseLottoObject.getiTotalRecords();
	}
	@Cacheable(value ="doCache",key="{#LottoVO.drwNo}")
	public List<LottoVO> pageBoard(ResponseLottoObject responseLottoObject) {
		//List<LottoVO> list = null;
		/*try{			
			LottoMapper lottoMapper = sqlSession.getMapper(LottoMapper.class);
			list = lottoMapper.selectPageBoard(responseLottoObject);
		}
		catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}	*/	
		return selectList("selectPageBoard", responseLottoObject);
	}

	public List<ResponseFreqNumsObject> allPeriodFreq(ResponseFreqNumsObject responseFreqNumsObject) {
		//List<ResponseFreqNumsObject> list =null;
		/*try{			
			LottoMapper lottoMapper = sqlSession.getMapper(LottoMapper.class);
			list = lottoMapper.selectAllPeriodFreq(responseFreqNumsObject);
		}
		catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}	*/	
		return selectList("Lotto.selectAllPeriodFreq", responseFreqNumsObject);
	}

	public List<ResponseFreqNumByYearObject> allPeriodFreqByYear(
		ResponseFreqNumByYearObject responseFreqNumByYearObject) {
		//List<ResponseFreqNumByYearObject> list =null;
		/*try{			
			LottoMapper lottoMapper = sqlSession.getMapper(LottoMapper.class);
			list = lottoMapper.selectAllPeriodFreqByYear(responseFreqNumByYearObject);
		}
		catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}	*/	
		return selectList("Lotto.selectAllPeriodFreqByYear", responseFreqNumByYearObject);
	}

	public List<ResponseFreqNumsObject> worstNums(ResponseFreqNumsObject responseFreqNumsObject) {
		//List<ResponseFreqNumsObject> list =null;
		/*try{			
			LottoMapper lottoMapper = sqlSession.getMapper(LottoMapper.class);
			list = lottoMapper.selectWorstNums(responseFreqNumsObject);
		}
		catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}*/		
		return selectList("Lotto.selectWorstNums", responseFreqNumsObject);
	}

	public List<ResponseFreqNumsObject> bestNums(ResponseFreqNumsObject responseFreqNumsObject) {
		//List<ResponseFreqNumsObject> list =null;
		/*try{			
			LottoMapper lottoMapper = sqlSession.getMapper(LottoMapper.class);
			list = lottoMapper.selectBestNums(responseFreqNumsObject);
		}
		catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}	*/	
		return selectList("Lotto.selectBestNums", responseFreqNumsObject);
	}
}
