package com.LpanTest.ramType.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MySchedule3 extends QuartzJobBean {
	
	private Logger logger = Logger.getLogger(MyScheduleJob.class);

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		
		logger.info("定时任务开始了3。。。");
		
		logger.info("定时任务结束了3。。。");

	}

}
