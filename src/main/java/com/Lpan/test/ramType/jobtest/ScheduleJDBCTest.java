package com.Lpan.test.ramType.jobtest;

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

import com.Lpan.test.ramType.job.MySchedule3;



public class ScheduleJDBCTest {
	
	private static Scheduler scheduler;
	
	public static void main(String[] args) {
		//配置文件需要更改才可生效
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext-quartz.xml");
		scheduler = ac.getBean(Scheduler.class);
		startSchedule();
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
