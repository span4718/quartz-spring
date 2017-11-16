package com.Lpan.taskSchedule.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Lpan.taskSchedule.model.TaskScheduleCfg;
import com.Lpan.taskSchedule.service.TaskScheduleCfgService;

@Controller
@RequestMapping("/taskScheduleCfg")
public class TaskScheduleCfgController {
	
	private Logger logger = Logger.getLogger(TaskScheduleCfgController.class);
	
	@Autowired
	private TaskScheduleCfgService taskScheduleCfgService;
	
	@RequestMapping("/showlist")
	public String showTaskList(HttpServletRequest request,HttpServletResponse response) {
		List<TaskScheduleCfg> task = taskScheduleCfgService.selectAllTask();
		
		request.setAttribute("task", task);
		return "/taskSchedule/cfglist";
	}
	
	@RequestMapping("/addtask") 
	public String addTask(HttpServletRequest request,TaskScheduleCfg taskScheduleCfg) {
		logger.info("添加定时任务配置："+taskScheduleCfg.toString());
		taskScheduleCfgService.addTask(taskScheduleCfg);
		return "";
	}
	
	/**
	 * 开始一个定时任务
	 * @param request
	 * @param jobId
	 */ 
	@RequestMapping("/startTask/{jobId}")
	public void startTask(HttpServletRequest request,@PathVariable("jobId") String jobId) {
		System.out.println(jobId);
	}

}
