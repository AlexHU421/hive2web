package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Stage_status;
import entity.sql_status;
import util.DBUtil;

public class Stage_statusDao implements Serializable {
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
	
	public ArrayList<Stage_status> findByCode(long stime,long etime,int limit,int offset) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"SELECT LogTime,JobID,StageID,StageStatus,FailedTaskID,StageDetail,StageAllTaskInfo FROM stage_info WHERE LogTime>=? AND LogTime<=? LIMIT ?,?;";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setLong(1,stime);
			ps.setLong(2,etime);
			ps.setInt(3,offset);
			ps.setInt(4,limit);
			ResultSet rs = ps.executeQuery();
			ArrayList<Stage_status> as = new ArrayList<Stage_status>();
			while(rs.next()) {
				Stage_status s = new Stage_status();
				s.setLogTime(rs.getLong("LogTime"));
				s.setJobID(rs.getString("JobID"));
				s.setStageID(rs.getString("StageID"));
				s.setStageStatus(rs.getString("StageStatus"));
				s.setFailedTaskID(rs.getString("FailedTaskID"));
				s.setStageDetail(rs.getString("StageDetail"));
				s.setStageAllTaskInfo(rs.getString("StageAllTaskInfo"));
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
	
	public ArrayList<Stage_status> findByCode(String code1,long stime,long etime,int limit,int offset) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"SELECT LogTime,JobID,StageID,StageStatus,FailedTaskID,StageDetail,StageAllTaskInfo FROM stage_info WHERE (JobID=? OR StageID=?) AND LogTime>=? AND LogTime<=? LIMIT ?,?;";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1,code1);
			ps.setString(2,code1);
			ps.setLong(3,stime);
			ps.setLong(4,etime);
			ps.setInt(5,offset);
			ps.setInt(6,limit);
			ResultSet rs = ps.executeQuery();
			ArrayList<Stage_status> as = new ArrayList<Stage_status>();
			while(rs.next()) {
				Stage_status s = new Stage_status();
				s.setLogTime(rs.getLong("LogTime"));
				s.setJobID(rs.getString("JobID"));
				s.setStageID(rs.getString("StageID"));
				s.setStageStatus(rs.getString("StageStatus"));
				s.setFailedTaskID(rs.getString("FailedTaskID"));
				s.setStageDetail(rs.getString("StageDetail"));
				s.setStageAllTaskInfo(rs.getString("StageAllTaskInfo"));
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
