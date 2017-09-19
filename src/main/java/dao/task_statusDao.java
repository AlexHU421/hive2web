package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Stage_status;
import entity.sql_status;
import entity.task_status;
import util.DBUtil;

public class task_statusDao implements Serializable {
	public int countByCode(String code1,long stime,long etime) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"select count(LogTime) from session_info WHERE (JobID=? OR StageID=?) AND LogTime>=? AND LogTime<=?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1, code1);
			ps.setString(2, code1);
			ps.setLong(3,stime);
			ps.setLong(4,etime);
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
					"select count(LogTime) from session_info where LogTime>=? AND LogTime<=?";
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
	
	public ArrayList<task_status> findByCode(long stime,long etime,int limit,int offset) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"SELECT LogTime,StageID,TaskID,StartRunNodeName,RunMode,RunTime,RunEndNodeName,StageInsideTaskNum,TaskStatus,FailedDetail FROM task_info WHERE LogTime>=? AND LogTime<=? LIMIT ?,?;";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setLong(1,stime);
			ps.setLong(2,etime);
			ps.setInt(3,offset);
			ps.setInt(4,limit);
			ResultSet rs = ps.executeQuery();
			ArrayList<task_status> as = new ArrayList<task_status>();
			while(rs.next()) {
				task_status s = new task_status();
				s.setLogTime(rs.getLong("LogTime"));
				s.setStageID(rs.getString("StageID"));
				s.setTaskID(rs.getString("TaskID"));
				String Detail =  "StartNode:"+rs.getString("StartRunNodeName")
								+"\\/rRunMode:"+rs.getString("RunMode")
								+"\\/rEndNode:"+rs.getString("RunEndNodeName")
								+"\\/rTask4StageNum:"+rs.getString("StageInsideTaskNum");
				s.setTaskRunDetail(Detail);
				s.setRunTime(rs.getString("RunTime"));
				s.setTaskStatus(rs.getString("TaskStatus"));
				s.setFailedDetail(rs.getString("FailedDetail"));
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
	
	public ArrayList<task_status> findByCode(String code1,long stime,long etime,int limit,int offset) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"SELECT LogTime,StageID,TaskID,StartRunNodeName,RunMode,RunTime,RunEndNodeName,StageInsideTaskNum,TaskStatus,FailedDetail FROM task_info WHERE (JobID=? OR StageID=?) AND LogTime>=? AND LogTime<=? LIMIT ?,?;";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1,code1);
			ps.setString(2,code1);
			ps.setLong(3,stime);
			ps.setLong(4,etime);
			ps.setInt(5,offset);
			ps.setInt(6,limit);
			ResultSet rs = ps.executeQuery();
			ArrayList<task_status> as = new ArrayList<task_status>();
			while(rs.next()) {
				task_status s = new task_status();
				s.setLogTime(rs.getLong("LogTime"));
				s.setStageID(rs.getString("StageID"));
				s.setTaskID(rs.getString("TaskID"));
				String Detail =  "StartNode:"+rs.getString("StartRunNodeName")
								+" RunMode:"+rs.getString("RunMode")
								+" EndNode:"+rs.getString("RunEndNodeName")
								+" Task4StageNum:"+rs.getString("StageInsideTaskNum");
				s.setTaskRunDetail(Detail);
				s.setRunTime(rs.getString("RunTime"));
				s.setTaskStatus(rs.getString("TaskStatus"));
				s.setFailedDetail(rs.getString("FailedDetail"));
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
}
