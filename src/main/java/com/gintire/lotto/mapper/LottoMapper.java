package com.gintire.lotto.mapper;

import java.util.List;
import java.util.Map;

import com.gintire.lotto.vo.LottoVO;
import com.gintire.lotto.vo.ResponseFreqNumByYearObject;
import com.gintire.lotto.vo.ResponseFreqNumsObject;
import com.gintire.lotto.vo.ResponseLottoObject;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * Mapper Interface
 *  - 메서드명과 쿼리 ID를 매핑하여 쿼리 호출
 * */
@Mapper("lottoMapper")
public interface LottoMapper {
	public void initData(Map<String, List<LottoVO>> map);
	public Integer selectTotNum();
	public List<LottoVO> selectList(LottoVO lottoVO);
	public List<LottoVO> selectPageBoard(ResponseLottoObject responseLottoObject);
	public ResponseLottoObject selectPageBoardCount(ResponseLottoObject responseLottoObject);
	public List<ResponseFreqNumsObject> selectAllPeriodFreq(ResponseFreqNumsObject responseFreqNumsObject);
	public List<ResponseFreqNumByYearObject> selectAllPeriodFreqByYear(
			ResponseFreqNumByYearObject responseFreqNumByYearObject);
	public List<ResponseFreqNumsObject> selectWorstNums(ResponseFreqNumsObject responseFreqNumsObject);
	public List<ResponseFreqNumsObject> selectBestNums(ResponseFreqNumsObject responseFreqNumsObject);
}
