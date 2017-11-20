package com.Lpan.taskSchedule.service;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.util.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Lpan.taskSchedule.model.TaskScheduleCfg;
import com.Lpan.taskSchedule.quartz.QuartzScheduleManager;
import com.alibaba.fastjson.JSON;

@Component
public class TaskSchedulerTransfer {
	
	private Logger logger = Logger.getLogger(TaskSchedulerTransfer.class);
	
	@Autowired
	private QuartzScheduleManager quartzScheduleManager;
	
	/**
	 * 添加一个定时任务
	 * @param taskScheduleCfg
	 */
	public void addTask(TaskScheduleCfg taskScheduleCfg) {
		String cronExpression = taskScheduleCfg.getCronExpression();
		//判断不为空 并且cron 表达式均正确
		if(taskScheduleCfg != null && StringUtils.isNotBlank(cronExpression) && CronExpression.isValidExpression(cronExpression)) {
			quartzScheduleManager.addJob(taskScheduleCfg, taskScheduleCfg.getJobClass());
		}else {
			logger.info("调度任务cron表达式错误:"+JSON.toJSONString(taskScheduleCfg));
		}
	}
	
	
	/**
	 * 移除一个定时任务
	 * @param taskSchedule
	 */
	public void removeTask(TaskScheduleCfg taskSchedule) {
		if(taskSchedule != null) {
			quartzScheduleManager.removeJob(taskSchedule);
		}
	}

	/**
	 * 移除所有定时任务
	 */
	public void reomveAllTask() {
		quartzScheduleManager.removeAllTask();
	}

}
