package com.gintire.lotto.batch;

import java.util.Calendar;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gintire.lotto.service.LottoService;

@Component
public class BatchJob {
	
	@Resource(name = "LottoService")
	private LottoService lottoService;
	
	private static final Logger logger = LoggerFactory.getLogger(BatchJob.class);

	public void doBatch() {
		try{
		lottoService.init();
		logger.info("=BatchJob 배치============"
				+Calendar.getInstance(Locale.KOREA).get(Calendar.HOUR_OF_DAY)+"시="
				+Calendar.getInstance(Locale.KOREA).get(Calendar.MINUTE)+"분===============");
		}
		catch(Exception e) {
			logger.debug(" [ERROR] "+e);
			doBatch();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BatchJob proc = new BatchJob();
		proc.doBatch();
	}
}
