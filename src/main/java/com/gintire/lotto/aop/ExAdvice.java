package com.gintire.lotto.aop;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gintire.lotto.service.LottoService;
import com.gintire.lotto.vo.LottoVO;

public class ExAdvice {
	private static final Logger log = LoggerFactory.getLogger(ExAdvice.class);
//ProceedingJoinPoint pJoinPoint, 
	
	@Resource(name = "LottoService")
	private LottoService lottoService;
	
	public void pointCutBefore(JoinPoint joinPoint) {

		try {
			Object[] args = joinPoint.getArgs();
			for (Object arg : args) {
				LottoVO vo = (LottoVO) arg;
				log.info("pointCutBefore.getOt_seq="+vo.getDrwNo());
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public void pointCutAfterThrowing(JoinPoint joinPoint, Throwable error) {
		log.info("logAfterThrowing() is running!");
		log.info("hijacked : " + joinPoint.getSignature().getName());
		log.info("Exception : " + error);
		log.info("******");
	}

}