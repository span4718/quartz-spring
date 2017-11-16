package com.Lpan.test.ramType.job;

import org.apache.log4j.Logger;

public class MySchedule2 {
	
	private Logger logger = Logger.getLogger(MySchedule2.class);
	
	public void execute() {
		logger.info("定时任务开始了。。。");
		
		logger.info("定时任务结束了。。。");
	}
}
