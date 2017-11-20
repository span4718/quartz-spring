package com.Lpan.taskSchedule.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LpanOne implements Job{
	
	private Logger logger = LoggerFactory.getLogger(LpanOne.class);
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("定时任务开始了。。。");
		
		logger.info("定时任务结束了。。。");
	}

}
