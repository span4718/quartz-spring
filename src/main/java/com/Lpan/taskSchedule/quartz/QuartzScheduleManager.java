package com.Lpan.taskSchedule.quartz;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.Lpan.taskSchedule.model.TaskScheduleCfg;
import com.alibaba.fastjson.JSON;


@Component
public class QuartzScheduleManager implements InitializingBean{
	
	private Logger logger = Logger.getLogger(QuartzScheduleManager.class);
	
//	@Autowired
//	private MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean;
	
	private String JOB_PREFIX = "LPAN_JOB_";
	private String JOB_GROUP_NAME = "JOB_LPAN";
	private String TRIGGER_PREFIX = "LPAN_TRIGGER_";
	private String TRIGGER_GROUP_NAME = "TRIGGER_LPAN";
	
	private boolean clearJob = false;

	private Scheduler scheduler;
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	/**
	 * 添加一个定时任务  使用默认的 任务组名，触发器名，触发器组名
	 * @param taskScheduleCfg   	任务对象
	 * @param jobClass  任务类
	 */
	@SuppressWarnings("unchecked")
	public void addJob(TaskScheduleCfg taskScheduleCfg,String jobClass) {
		/**
		 * 根据jobCode 判断job当前状态时否开启
		 */
		String string = getJobRunneringStatus(taskScheduleCfg.getJobCode());
		if(null != scheduler && TaskScheduleConstant.JOB_RUNNERING_STATUS_OFF.equals(getJobRunneringStatus(taskScheduleCfg.getJobCode()))) {
				JobDataMap jobDataMap = new JobDataMap();
				jobDataMap.put(TaskScheduleConstant.SCHEDULER_JOB_KEY, JSON.toJSONString(taskScheduleCfg));
				try {
					//methodInvokingJobDetailFactoryBean.setTargetObject(taskScheduleCfg.getJobClass());
					//methodInvokingJobDetailFactoryBean.setTargetMethod(taskScheduleCfg.getJobClassMethodName());
					
					//根据类名获取类再强转未Job类型  创建jobDetail
					JobBuilder jobBuilderl = JobBuilder.newJob((Class<Job>)Class.forName(jobClass));
					//JobDetail
					JobDetail jobDetail = jobBuilderl.withIdentity(JOB_PREFIX+taskScheduleCfg.getJobCode(), JOB_GROUP_NAME)
													 .usingJobData(jobDataMap)
													 .build();
					
					//Trigger
					TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
					Trigger	trigger = triggerBuilder.withIdentity(TRIGGER_PREFIX+taskScheduleCfg.getJobCode(),TRIGGER_GROUP_NAME)
										.withSchedule(CronScheduleBuilder.cronSchedule(taskScheduleCfg.getCronExpression()))
										.build();
					scheduler.scheduleJob(jobDetail, trigger);
					//开启定时任务
					if(!scheduler.isShutdown()) {
						scheduler.start();
					}
				} catch (ClassNotFoundException e) {
					logger.info("添加定时任务异常");
					e.printStackTrace();
				} catch (SchedulerException e) {
					logger.info("scheduler 创建定义任务异常");
					e.printStackTrace();
				}
		}else {
			logger.info("定时任务已经启动，不能重复启动"+JSON.toJSONString(taskScheduleCfg));
		}
	}
	
	/**
	 * 
	 * @param jobCode
	 * 
	 * @param JobGroupName
	 * 
	 * @param jobClass
	 * 
	 * @param triggerName
	 * 
	 * @param triggerGroupName
	 * 
	 * @param cronExpress
	 */
	@SuppressWarnings("unchecked")
	public void addJob(String jobCode,String jobGroupName,String jobClass,String triggerName,String triggerGroupName,String cronExpression) {
		try {
			//创建jobDetail
			JobBuilder jobBuilder = JobBuilder.newJob((Class<Job>)Class.forName(jobClass));
			JobDetail jobDetail = jobBuilder.withIdentity(jobCode, jobGroupName)
							.build();
			//创建trigger
			
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			CronTrigger trigger = triggerBuilder.withIdentity(triggerName, triggerGroupName)
								 .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
								.build();
			scheduler.scheduleJob(jobDetail, trigger);
			
			scheduler.start();
		} catch (ClassNotFoundException e) {
			logger.info("添加定时任务异常");
			e.printStackTrace();
		} catch (SchedulerException e) {
			logger.info("创建定时任务异常");
			e.printStackTrace();
		}
	}
	
	/**
	 *  修改一个定时任务 执行时间
	 * @param taskScheduleCfg
	 */
	public void updateJob(TaskScheduleCfg taskScheduleCfg) {
		try {
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(TriggerKey.triggerKey(JOB_PREFIX+taskScheduleCfg.getJobCode(), TRIGGER_GROUP_NAME));
			String oldexpression = trigger.getCronExpression();
			String expression = taskScheduleCfg.getCronExpression();
			if(trigger != null) {
				if(!oldexpression.equals(expression)) {
					JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(TRIGGER_PREFIX+taskScheduleCfg.getJobCode(),TRIGGER_GROUP_NAME));
					Class<? extends Job> jobClass = jobDetail.getJobClass();
					String className = jobClass.getName();
					//删除之前的定时任务
					removeJob(taskScheduleCfg);
					//创建新的定时任务
					addJob(taskScheduleCfg, className);
				}
			}
		} catch (SchedulerException e) {
			logger.info("更新定时任务更新异常");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 根据任务类 获取任务的状态 是否启动
	 * @param jobCode
	 * @return
	 */
	public String getJobRunneringStatus(String jobCode) {
		try {
			JobKey jobKey = JobKey.jobKey(JOB_PREFIX+jobCode, JOB_GROUP_NAME);
			JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(JOB_PREFIX+jobCode, JOB_GROUP_NAME));
			Trigger trigger = scheduler.getTrigger(TriggerKey.triggerKey(TRIGGER_PREFIX+jobCode,TRIGGER_GROUP_NAME));
			if(null != jobDetail && trigger == null) {
				removeJob(jobCode);
			}
			if(null != jobDetail && null != trigger) {
				return TaskScheduleConstant.JOB_RUNNERING_STATUS_ON;
			}
		} catch (SchedulerException e) {	
			logger.info("获取任务状态失败");
			e.printStackTrace();
		}
		 return TaskScheduleConstant.JOB_RUNNERING_STATUS_OFF;
	}
	
	
	/**
	 * 根据jobCode  移除一个定时任务
	 * @param jobCode
	 */
	public void removeJob(String jobCode) {
		try {
			//停止触发器
			scheduler.pauseTrigger(TriggerKey.triggerKey(TRIGGER_PREFIX+jobCode,TRIGGER_GROUP_NAME));
			//移除触发器
			scheduler.unscheduleJob(TriggerKey.triggerKey(TRIGGER_PREFIX+jobCode,TRIGGER_GROUP_NAME));
			//删除任务
			scheduler.deleteJob(JobKey.jobKey(JOB_PREFIX+jobCode, JOB_GROUP_NAME));
		} catch (SchedulerException e) {
			logger.info("删除任务失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据任务组名移除掉一个定时任务
	 * @param taskSchedule
	 */
	public void removeJob(TaskScheduleCfg taskSchedule) {
		try {
			//停止触发器
			scheduler.pauseJob(JobKey.jobKey(TRIGGER_PREFIX+taskSchedule.getJobCode(), TRIGGER_GROUP_NAME));
			//移除触发器
			scheduler.unscheduleJob(TriggerKey.triggerKey(TRIGGER_PREFIX+taskSchedule.getJobCode(), TRIGGER_GROUP_NAME));
			//移除定时任务
			scheduler.deleteJob(JobKey.jobKey(JOB_PREFIX+taskSchedule.getJobCode(), JOB_GROUP_NAME));
		} catch (SchedulerException e) {
			logger.info("删除定时任务失败");
			e.printStackTrace();
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		initScedule(clearJob);
		
	}
	
	/**
	 * 初始化scheduler
	 * @param clearJob
	 */
	private void initScedule(boolean clearJob) {
		logger.info("初始化scheduler");
		scheduler = schedulerFactoryBean.getScheduler();
		logger.info("created schedule");
		
		if(clearJob) {
			logger.warn("删除已存在的job/trigger");
			clearSchedule();
		}
		
		try {
			scheduler.start();
		} catch (SchedulerException e) {
			logger.info("启动定时任务异常");
			e.printStackTrace();
		}
	}

	private void clearSchedule() {
		try {
			scheduler.clear();
		} catch (SchedulerException e) {
			logger.info("清除scheduler 异常");
			e.printStackTrace();
		}
	}
	
	/**
	 * 移除所有定时任务
	 */
	public void removeAllTask() {
		try {
			if(!scheduler.isShutdown()) {
				scheduler.shutdown();
			}
		} catch (SchedulerException e) {
			logger.info("关闭定时任务异常");
			e.printStackTrace();
		}
	}
	
}