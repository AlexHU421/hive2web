package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import entity.User_info;
import entity.sql_status;
import util.DBUtil;

public class sql_statusDao implements Serializable {
	
	/**
	 * 
	 * @param status
	 * @param user_name
	 * @return 根据给出的ip、user_name添加相关监控集群到表中，添加成功返回结果为1，失败为0
	 */
	public int countByCode(String code,long stime,long etime) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"select count(SUBTIME) from session_info_hbase where JobID=? And (SUBTIME>=? AND COMTIME<=?)";
//					"select count(SUBTIME) from sql_status where (ip=? or status=?) And (SUBTIME>=? AND COMTIME<=?)";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1,code);
//			ps.setString(2,code);
			ps.setLong(2,stime);
			ps.setLong(3,etime);
			ResultSet rs = ps.executeQuery();
			int total=0;
			if (rs.next()){
				total = rs.getInt(1);
		    }
			System.out.println("tt"+total);
			return total;
		} catch (SQLException e) {
			return 0;
			} finally {
			DBUtil.close(conn);
		}
	}
	
	
	public int countByCode(long stime,long etime) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"select count(SUBTIME) from session_info_hbase where SUBTIME>=? AND COMTIME<=?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setLong(1,stime);
			ps.setLong(2,etime);
			ResultSet rs = ps.executeQuery();
			int total=0;
			if (rs.next()){
				total = rs.getInt(1);
		    }
			System.out.println("tt"+total);
			return total;
		} catch (SQLException e) {
			return 0;
			} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 
	 * @param code1 查询条件的字符串
	 * @param code2 查询条件的字符串
	 * @return 返回一个sql_status实例对象
	 */
	public ArrayList<sql_status> findByCode(String code1,long stime,long etime,int limit,int offset) {
		Connection conn = null;
		try {
			System.out.println("SELECT IP,Description,SUBTIME,COMTIME,RunTime,JobStatus,TotalTask FROM session_info WHERE (IP="+code1+" OR user = "+code1+") And (SUBTIME>="+stime+" AND COMTIME<="+etime+") LIMIT "+offset+","+limit+";");
			conn = DBUtil.getConnection();
			String sql =
				"select key.IP IP,Description,SUBTIME,COMTIME,RunTime,JobStatus,TotalTask  from session_info_hbase where (IP=? OR user = ?) And  (SUBTIME>=? AND COMTIME<=?) LIMIT ?,?";
//				"select IP,Description,SUBTIME,COMTIME,RunTime,JobStatus,TotalTask  from session_info where (IP=? OR user = ?) And (SUBTIME>=? AND COMTIME<=?) ORDER BY ? ? LIMIT ?,?";
//				"select * from sql_status where (ip=? or status=?) And (submission_time>=? AND completion_time<=?) LIMIT ?,?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1,code1);
			ps.setString(2,code1);
			ps.setLong(3,stime);
			ps.setLong(4,etime);
			ps.setInt(5,offset);
			ps.setInt(6,limit);
			ResultSet rs = ps.executeQuery();
			ArrayList<sql_status> as = new ArrayList<sql_status>();
			while(rs.next()) {
				sql_status s = new sql_status();
				s.setIp(rs.getString("ip"));
//				s.setJobid(rs.getString("JobID"));
//				s.setUser_name(rs.getString("User_name"));
				s.setDescription(rs.getString("Description"));
				Long subTime = rs.getLong("SUBTIME");
				Long comTime =  rs.getLong("COMTIME");
				s.setSubmission_time(subTime);
				s.setCompletion_time(comTime);
//				s.setStatus(rs.getString("status"));
//				s.setStages(rs.getString("StageIDS"));
				s.setTotalTask(rs.getString("TotalTask"));
				s.setRunTime(rs.getString("RunTime"));
				s.setStatus(rs.getString("JobStatus"));
//				s.setFailedstageID(rs.getString("FailedStageID"));
				as.add(s);
			}
			return as;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询失败",e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 
	 * @param code1 查询条件的字符串
	 * @param code2 查询条件的字符串
	 * @return 返回一个sql_status实例对象
	 */
	public ArrayList<sql_status> findByCode(long stime,long etime,int limit,int offset) {
		Connection conn = null;
		try {
			System.out.println("SELECT key.IP,Description,SUBTIME,COMTIME,RunTime,JobStatus,TotalTask FROM session_info_hbase WHERE (SUBTIME>="+stime+" AND COMTIME<="+etime+") LIMIT "+offset+","+limit+";");
			conn = DBUtil.getConnection();
			String sql = 
					"select key.IP IP,Description,SUBTIME,COMTIME,RunTime,JobStatus,TotalTask  from session_info_hbase where (SUBTIME>=? AND COMTIME<=?) LIMIT ?,?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setLong(1,stime);
			ps.setLong(2,etime);
			ps.setInt(3,offset);
			ps.setInt(4,limit);
//			System.out.println(sql);
//			System.out.println(stime);
//			System.out.println(etime);
//			System.out.println(offset);
//			System.out.println(limit);
			ResultSet rs = ps.executeQuery();
			ArrayList<sql_status> as = new ArrayList<sql_status>();
			while(rs.next()) {
				sql_status s = new sql_status();
				s.setIp(rs.getString("ip"));
//				s.setJobid(rs.getString("JobID"));
//				s.setUser_name(rs.getString("User_name"));
				s.setDescription(rs.getString("Description"));
				Long subTime = rs.getLong("SUBTIME");
				Long comTime =  rs.getLong("COMTIME");
				s.setSubmission_time(subTime);
				s.setCompletion_time(comTime);
//				s.setStatus(rs.getString("status"));
//				String spl = rs.getString("StageIDS");
				s.setTotalTask(rs.getString("TotalTask"));
				s.setRunTime(rs.getString("RunTime"));
				s.setStatus(rs.getString("JobStatus"));
//				s.setFailedstageID(rs.getString("FailedStageID"));
				as.add(s);
			}
			return as;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询失败",e);
		} finally {
			DBUtil.close(conn);
		}
	}
	//测试用main
//	public static void main(String[] args) {
//		String inputString ="hive";
//		sql_statusDao dao = new sql_statusDao();
//		ArrayList<sql_status> as = dao.findByCode(inputString);
//		for(sql_status ss:as){
//			System.out.println(ss.toString());
//		}
//		System.out.println(s.getIp());
//		System.out.println(s.getJobid());
//		System.out.println(s.getUser_name());
//		System.out.println(s.getDescription());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sdf.format(s.getSubmission_time()));
//		System.out.println(sdf.format(s.getCompletion_time()));
//		System.out.println(s.getStatus());
//	}
	
}







