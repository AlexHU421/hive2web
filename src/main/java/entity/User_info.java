package entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 初始化User_info内容实例
 * @author Alex.hu
 */
public class User_info implements Serializable {
	//目标inceptor server status
	private String status;
	//操作用户
	private String ip;
	private String name;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User_info [status=" + status + ", ip=" + ip + ", name=" + name + "]";
	}
	
	
		
}





