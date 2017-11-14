package com.LpanTest.ramType.jobtest;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.LpanTest.ramType.job.MySchedule3;
import com.LpanTest.ramType.job.MyScheduleJob;

public class ScheduleTest {
	
	public static void main(String[] args) {
		
		//创建JobDetail
		JobDetail jobDetail = JobBuilder.newJob(MySchedule3.class).withIdentity("shipan", "shipan").build();
		
		Date date = new Date();
		Date cdate = new Date(date.getTime()+3);
		
		//创建trigger
		Trigger trigger = TriggerBuilder.newTrigger()
										.forJob(jobDetail)
										.startAt(cdate)
										.withIdentity("liupp", "liupp")
										.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
										.build();
		
		SchedulerFactory sf =new StdSchedulerFactory();
		try {
			Scheduler scheduler = sf.getScheduler();
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
