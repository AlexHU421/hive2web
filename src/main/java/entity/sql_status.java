package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 * 初始化sql_status内容实例
 * @author Alex.hu
 */
public class sql_status implements Serializable {
//	目标inceptor server ip
	private String ip;
	//jobid
	private String jobid;
	//操作用户
//	private String user_name;
	//相关job运行的sql
	private String description;
	//job提交的时间
	private String submission_time;
	//job完成/终止的时间
	private String completion_time;
	//job执行状态
//	private String status;
	//stage任务数
	private String stages;
	//totaltask
	private String totalTask;
	//job状态
	private String status;
	//失败的stageID
	private String failedstageID;
	//运行时间
	private String RunTime;
	public String getTotalTask() {
		return totalTask;
	}
	public void setTotalTask(String totalTask) {
		this.totalTask = totalTask;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFailedstageID() {
		return failedstageID;
	}
	public void setFailedstageID(String failedstageID) {
		this.failedstageID = failedstageID;
	}
	//初始化时间转换器
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public String getRunTime() {
		return RunTime;
	}
	public void setRunTime(String runTime1) {
		RunTime = runTime1;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
//	public String getUser_name() {
//		return user_name;
//	}
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	public String getSubmission_time() {
		return submission_time;
	}
	public void setSubmission_time(long submission_time) {
		this.submission_time = sdf.format(submission_time);
	}
	public String getCompletion_time() {
		return completion_time;
	}
	public void setCompletion_time(long completion_time) {
		this.completion_time = sdf.format(completion_time);
	}
	
	public String getStages() {
		return stages;
	}
	public void setStages(String stages) {
		this.stages = stages;
	}
	@Override
	public String toString() {
		return "sql_status [ip=" + ip + ", jobid=" + jobid + ", description=" + description + ", submission_time="
				+ submission_time + ", completion_time=" + completion_time + ", stages=" + stages + ", totalTask="
				+ totalTask + ", status=" + status + ", failedstageID=" + failedstageID + ", RunTime=" + RunTime + "]";
	}
	public sql_status(String ip, String jobid, String description, String submission_time, String completion_time,
			String stages, String totalTask, String status, String failedstageID, String runTime) {
		this.ip = ip;
		this.jobid = jobid;
		this.description = description;
		this.submission_time = submission_time;
		this.completion_time = completion_time;
		this.stages = stages;
		this.totalTask = totalTask;
		this.status = status;
		this.failedstageID = failedstageID;
		this.RunTime = runTime;
	}
	public sql_status(){}
}





