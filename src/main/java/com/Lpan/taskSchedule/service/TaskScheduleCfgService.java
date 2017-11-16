package com.Lpan.taskSchedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Lpan.taskSchedule.dao.TaskScheduleCfgMapper;
import com.Lpan.taskSchedule.model.TaskScheduleCfg;

@Service
@Transactional
public class TaskScheduleCfgService {
	
	//private Logger logger = Logger.getLogger(TaskScheduleCfgService.class);
	@Autowired
	private TaskScheduleCfgMapper taskScheduleCfgMapper;
	
	public void addTask(TaskScheduleCfg taskSchdeuleCfg){
		taskScheduleCfgMapper.insert(taskSchdeuleCfg);
	}
	
	public void deleteTask(String jobId) {
		taskScheduleCfgMapper.deleteByPrimaryKey(jobId);
	}
	
	public void updateTask(TaskScheduleCfg taskSchdeuleCfg) {
		taskScheduleCfgMapper.updateByPrimaryKey(taskSchdeuleCfg);
	}
	
	public TaskScheduleCfg selecTask(String jobId) {
		return taskScheduleCfgMapper.selectByPrimaryKey(jobId);
	}
	
	public List<TaskScheduleCfg> selectAllTask() {
		return taskScheduleCfgMapper.selectAll();
	}
}
