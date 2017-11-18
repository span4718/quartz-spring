

package com.Lpan.taskSchedule.client;

import java.io.Serializable;
import java.util.Date;

/**  
 * @author zhanghuibo
 */
public class SubsysTaskData  implements Serializable{
	
	private static final long serialVersionUID = -637681508369350609L;
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 任务名称
	 */
	private String jobName ;
	/**
	 * 任务编码
	 */
	private String jobCode;

	/**
	 * 子系统实体类全路径
	 */
	private String jobClass;
	
	private Date startTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
}
