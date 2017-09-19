package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 * 初始化sql_status内容实例
 * @author Alex.hu
 */
public class Stage_status implements Serializable {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//LOGtime
	private Long LogTime;
	//JobID
	private String JobID;
	//stageID
	private String StageID;
	//stage状态
	private String StageStatus;
	//失败的taskID
	private String FailedTaskID;
	//stage明细信息
	private String StageDetail;
	//单个stage中task汇总信息
	private String StageAllTaskInfo;
	
	public String getLogTime() {
		return sdf.format(LogTime);
	}
	public void setLogTime(Long logTime) {
		LogTime = logTime;
	}
	public String getJobID() {
		return JobID;
	}
	public void setJobID(String jobID) {
		JobID = jobID;
	}
	public String getStageID() {
		return StageID;
	}
	public void setStageID(String stageID) {
		StageID = stageID;
	}
	public String getStageStatus() {
		return StageStatus;
	}
	public void setStageStatus(String stageStatus) {
		StageStatus = stageStatus;
	}
	public String getFailedTaskID() {
		return FailedTaskID;
	}
	public void setFailedTaskID(String failedTaskID) {
		FailedTaskID = failedTaskID;
	}
	public String getStageDetail() {
		return StageDetail;
	}
	public void setStageDetail(String stageDetail) {
		StageDetail = stageDetail;
	}
	public String getStageAllTaskInfo() {
		return StageAllTaskInfo;
	}
	public void setStageAllTaskInfo(String stageAllTaskInfo) {
		StageAllTaskInfo = stageAllTaskInfo;
	}
	@Override
	public String toString() {
		return "Stage_status [StageID=" + StageID + ", StageStatus=" + StageStatus + ", FailedTaskID=" + FailedTaskID
				+ ", StageDetail=" + StageDetail + ", StageAllTaskInfo=" + StageAllTaskInfo + "]";
	}
	
	
	
	
		
}





