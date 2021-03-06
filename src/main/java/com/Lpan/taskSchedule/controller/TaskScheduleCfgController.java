package com.Lpan.taskSchedule.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Lpan.taskSchedule.model.TaskScheduleCfg;
import com.Lpan.taskSchedule.service.TaskScheduleCfgService;
import com.Lpan.taskSchedule.service.TaskSchedulerTransfer;

@Controller
@RequestMapping("/taskScheduleCfg")
public class TaskScheduleCfgController {
	
	private Logger logger = Logger.getLogger(TaskScheduleCfgController.class);
	
	@Autowired
	private TaskScheduleCfgService taskScheduleCfgService;
	@Autowired
	private TaskSchedulerTransfer taskSchedulerTransfer;
	
	@RequestMapping("/showList")
	public String showTaskList(HttpServletRequest request,HttpServletResponse response) {
		List<TaskScheduleCfg> task = taskScheduleCfgService.selectAllTask();
		
		request.setAttribute("tasks", task);
		return "/taskSchedule/cfglist";
	}
	
	@RequestMapping("/toaddtask")
	public String toaddTask(HttpServletRequest request) {
		String  jobId = request.getParameter("jobId");
		TaskScheduleCfg scheduleCfg = new TaskScheduleCfg();
		if(jobId != null && !"".equals(jobId)) {
			scheduleCfg = taskScheduleCfgService.selecTaskById(jobId);
		}
		request.setAttribute("task", scheduleCfg);
		return "/taskSchedule/addtask";
	}
	
	@RequestMapping("/addTask") 
	public void addTask(HttpServletRequest request,TaskScheduleCfg taskScheduleCfg) {
		logger.info("添加定时任务配置："+taskScheduleCfg.toString());
		taskScheduleCfg.setJobId(UUID.randomUUID().toString());
		//添加一个定时任务
		taskScheduleCfgService.addTask(taskScheduleCfg);
	}
	
	/**
	 * 更新一个定时任务
	 * @param request
	 * @param taskScheduleCfg
	 * @return
	 */
	@RequestMapping("/updateTask")
	public String updateTask(HttpServletRequest request,TaskScheduleCfg taskScheduleCfg) {
		logger.info("更新一个任务，详情是："+taskScheduleCfg.toString()); 
		taskScheduleCfgService.updateTask(taskScheduleCfg);
		return "/taskSchedule/cfglist";
	}
	
	/**
	 * 开始一个定时任务
	 * @param request
	 * @param jobId
	 */ 
	@RequestMapping("/startTask/{jobId}")
	public void startTask(HttpServletRequest request,@PathVariable("jobId") String jobId) {
		//根据jobId查询task实例
		TaskScheduleCfg taskScheduleCfg = taskScheduleCfgService.selecTaskById(jobId);
		
		taskSchedulerTransfer.addTask(taskScheduleCfg);
	}
	
	/**
	 * 停止一个定时任务
	 * @param request
	 * @param jobId
	 */
	@RequestMapping("/stopTask/{jobId}")
	public void stopTask(HttpServletRequest request,@PathVariable("jobId") String jobId) {
		//根据jobId查询task实例
		TaskScheduleCfg taskScheduleCfg = taskScheduleCfgService.selecTaskById(jobId);
		
		taskSchedulerTransfer.removeTask(taskScheduleCfg);
	}
	
	/**
	 * 停止所有定时任务
	 * @param request
	 */
	@RequestMapping("/stopAllTask")
	public void stopAllTask(HttpServletRequest request) {
		
		taskSchedulerTransfer.reomveAllTask();
		
	}
	

}
