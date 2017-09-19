package entity;

import java.text.SimpleDateFormat;

public class task_status {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//日志时间
	private Long LogTime;
	//StageID
	private String stageID;
	//TaskID
	private String taskID;
	//StartRunNodeName、RunMode、RunEndNodeName、StageInsideTaskNum
	private String taskRunDetail;
	//RunTime
	private String runTime;
	//TaskStatus
	private String taskStatus;
	//FailedDetail
	private String failedDetail;
	public String getLogTime() {
		return sdf.format(LogTime);
	}
	public void setLogTime(Long logTime) {
		LogTime = logTime;
	}
	public String getStageID() {
		return stageID;
	}
	public void setStageID(String stageID) {
		this.stageID = stageID;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getTaskRunDetail() {
		return taskRunDetail;
	}
	public void setTaskRunDetail(String taskRunDetail) {
		this.taskRunDetail = taskRunDetail;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getFailedDetail() {
		return failedDetail;
	}
	public void setFailedDetail(String failedDetail) {
		this.failedDetail = failedDetail;
	}
	@Override
	public String toString() {
		return "task_status [LogTime=" + LogTime + ", stageID=" + stageID + ", taskID=" + taskID + ", taskRunDetail="
				+ taskRunDetail + ", runTime=" + runTime + ", taskStatus=" + taskStatus + ", failedDetail="
				+ failedDetail + "]";
	}
	
	
	
	
	
}
