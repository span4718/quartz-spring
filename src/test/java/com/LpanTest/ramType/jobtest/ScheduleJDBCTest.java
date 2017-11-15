package com.LpanTest.ramType.jobtest;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.LpanTest.ramType.job.MySchedule3;


public class ScheduleJDBCTest {
	
	private static Scheduler scheduler;
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext-quartz-test.xml");
		scheduler = ac.getBean(Scheduler.class);
		startSchedule();
		//remove("shipan","shipan","liupp","liupp");
	}

	public static void startSchedule() {
		JobDetail jobDetail = JobBuilder.newJob(MySchedule3.class).withIdentity("shipan", "liupp1").build();
		
		Date date = new Date();
		Date cdate = new Date(date.getTime()+3);
		
		//定义trigger
		Trigger trigger = TriggerBuilder.newTrigger()
										.forJob(jobDetail)
										.startAt(cdate)
										.withIdentity("liupp", "shipan1")
										.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
										.build();
		
			try {
				scheduler.scheduleJob(jobDetail, trigger);
				scheduler.start();
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		
	}

}
