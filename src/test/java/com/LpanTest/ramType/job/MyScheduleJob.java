package com.LpanTest.ramType.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyScheduleJob implements Job{
	
	private Logger logger = Logger.getLogger(MyScheduleJob.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("��ʱ����ʼ�ˡ�����");
		
		logger.info("��ʱ��������ˡ�����");
	}
}
