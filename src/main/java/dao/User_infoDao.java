package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

import entity.User_info;
import util.DBUtil;

public class User_infoDao implements Serializable {


	/**
	 * 
	 * @param status
	 * @param user_name
	 * @return 根据给出的ip、user_name添加相关监控集群到表中，添加成功返回结果为1，失败为0
	 */
	public int countByCode(String code) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"select count(uuid) from user_info where status=? or ip=?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1,code);
			ps.setString(2,code);
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
	
	
	public int countByCode() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"select count(uuid) from user_info";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
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
	 * @return 返回一个ArrayList数组 泛型为User_info实例
	 */
	public ArrayList<User_info> findByCode(String code1,int limit,int offset) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select ip,status,name from user_info where status=? or ip=? LIMIT ?,?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1,code1);
			ps.setString(2,code1);		
			ps.setInt(3,offset);
			ps.setInt(4,limit);
			System.out.println("select ip,status from user_info where status="+code1+" or ip="+code1+" LIMIT"+limit+","+offset);
			ResultSet rs = ps.executeQuery();
			ArrayList<User_info> as = new ArrayList<User_info>();
			while(rs.next()) {
				User_info u = new User_info();
				u.setStatus(rs.getString("status"));
				u.setIp(rs.getString("Ip"));
				u.setName(rs.getString("name"));
				as.add(u);
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
	 * @return 返回一个ArrayList数组 泛型为User_info实例
	 */
	public ArrayList<User_info> findByCode(int limit,int offset) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select ip,status,name from user_info LIMIT ?,?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1,offset);
			ps.setInt(2,limit);
//			System.out.println("select ip,status from user_info where status="+code1+" or ip="+code1+" LIMIT"+limit+","+offset);
			ResultSet rs = ps.executeQuery();
			ArrayList<User_info> as = new ArrayList<User_info>();
			while(rs.next()) {
				User_info u = new User_info();
				u.setStatus(rs.getString("status"));
				u.setIp(rs.getString("Ip"));
				u.setName(rs.getString("name"));
				as.add(u);
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
	 * @param status 
	 * @param user_name
	 * @return 返回查询情况，若查询得到结果返回1，否则为0，查询出错返回为0
	 */
	public int findByCode(String ip,String status,String name) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"select * from user_info where status=? AND ip=? AND name=?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1,status);
			ps.setString(2,ip);
			ps.setString(3,name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("status"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("Ip"));
				return 1;
			}		
			return 0;
		} catch  (SQLException e) {
			return 0;
			} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 
	 * @param status
	 * @param user_name
	 * @return 根据给出的ip、user_name添加相关监控集群到表中，添加成功返回结果为1，失败为0
	 */
	public int addByCode(String ip,String status,String name) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"INSERT INTO user_info (UUID,ip,status,name) VALUES (?,?,?,?)";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString();
			ps.setString(1,uuid);
			ps.setString(2,ip);
			ps.setString(3,status);
			ps.setString(4,name);
			ps.executeUpdate();
			System.out.println(sql);
			return 1;
		} catch (SQLException e) {
			return 0;
			} finally {
			DBUtil.close(conn);
		}
	}
	
	
	/**
	 * 
	 * @param ip
	 * @param user_name
	 * @return 根据给出的ip、user_name删除相关监控集群到表中，添加成功返回结果为1，失败为0
	 */
	public int delByCode(String ip,String status,String name) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"DELETE FROM user_info WHERE status =? AND ip=? AND name=?;";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1,status);
			ps.setString(2,ip);
			ps.setString(3,name);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"删除失败",e);
			} finally {
			DBUtil.close(conn);
		}
	}
	//测试用main
	public static void main(String[] args) {
//		String inputString ="10.19.104.20";
		User_infoDao dao = new User_infoDao();
		ArrayList<User_info> as = dao.findByCode(10,0);
		for (User_info ui:as){
			System.out.println(ui);
		}
//		System.out.println(as);
//		if (as.isEmpty()){
//			System.out.println("yes");
//		}else{
//			System.out.println("no");
//			for(User_info ui:as){
//				System.out.println(ui.toString());
//			}
//		}
//		
//		String ip ="10.19.104.20";
//		String user_name ="hive";
//		User_infoDao dao = new User_infoDao();
//		int a = dao.findByCode(ip, user_name);
//		System.out.println(a);
//		if (a == 0){
//			int b =dao.addByCode(ip, user_name);
//		}
//		String ip ="10.19.104.20";
//		String status ="hive";
//		User_infoDao dao = new User_infoDao();
//		int a = dao.delByCode(ip, status);
//		System.out.println(a);
//		if (a == 0){
//			int b =dao.addByCode(ip, status);
//			System.out.println(1);
//		}
//		
//
	}
	
}






