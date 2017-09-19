package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Stage_statusDao;
import dao.User_infoDao;
import dao.sql_statusDao;
import dao.task_statusDao;
import entity.Stage_status;
import entity.User_info;
import entity.sql_status;
import entity.task_status;
import net.sf.json.JSONObject;
import util.Long2String;
import util.runtimeAsc;
import util.runtimeDesc;

public class Servlet extends HttpServlet {
	//1.首次访问Servlet时tomcat实例化它
	//2.或启动tomcat时直接实例化Servlet
	public Servlet() {
		System.out.println(
			"实例化Servlet");
	}
	
	//该方法的调用时机是在调用构造器之后
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println(
			"初始化HelloServlet");
	}
	
	//每次发请求访问Servlet时都会调用此方法
		@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) 
		throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println(
			"调用Servlet");
		ServletConfig cfg = getServletConfig();
		String path=req.getServletPath();
		System.out.println("path="+path);
		if("/check_sql".equals(path)){
			toGet_sql(req,res);
		} else if ("/check_user".equals(path)){
			toGet_user(req,res);
		} else if ("/add_user".equals(path)){
			add_user(req,res);
		} else if ("/del_user".equals(path)){
			del_user(req,res);
//		}else if ("/check_stage".equals(path)){
//			toGet_stage(req,res);
//		}else if ("/check_task".equals(path)){
//			toGet_task(req,res);
		} else	{
			throw new RuntimeException("无效路径");
		}
		
	}
		
	//关闭tomcat时它会调用此方法
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁Servlet");
	}
	/**
	 *  处理搜索sql_status表中监控集群用户信息的消息头
	 *  调用sql_statusDao.findByCode方法返回sql_status实例
	 * @param req 
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toGet_sql(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		Long2String l2s = new Long2String();
		System.out.println("捕获到搜索");
		sql_statusDao dao = new sql_statusDao();
		int limit = req.getParameter("rows")==null? 20:Integer.valueOf(req.getParameter("rows"));
		int offset = req.getParameter("page")==null?1:Integer.valueOf(req.getParameter("page"));
		String search = req.getParameter("search");
		long stime = Long.parseLong(req.getParameter("subtime"));
		long etime = Long.parseLong(req.getParameter("comtime"));
		String sortName = "";
		sortName += req.getParameter("sidx");
		String sortOrder = req.getParameter("sord");
//		System.out.println(sortName);
//		System.out.println(sortOrder);
		if (sortName.equals("")){
			sortName = "RunTIME";
		}
//		System.out.println("Start:"+stime);
//		System.out.println("End:"+etime);
		ArrayList<sql_status> list =  new ArrayList<sql_status>();
		int count =0;
		if (search.equals("")){
			System.out.println("search is null");
			list = dao.findByCode(stime,etime,limit,((offset-1)*limit));
			if ("asc".equals(sortOrder)){
				Comparator comp = new runtimeAsc();
				Collections.sort(list,comp);
			}
			if ("desc".equals(sortOrder)){
				Comparator comp = new runtimeDesc();
				Collections.sort(list,comp);  
			}
			count =dao.countByCode(stime,etime);
			}else{
			list = dao.findByCode(search,stime,etime,limit,((offset-1)*limit));
			if ("asc".equals(sortOrder)){
				Comparator comp = new runtimeAsc();
				Collections.sort(list,comp);  
			}
			if ("desc".equals(sortOrder)){
				Comparator comp = new runtimeDesc();
				Collections.sort(list,comp);  
			}
			count =dao.countByCode(search,stime,etime);
			}
//		PrintWriter out = res.getWriter();
//		ObjectMapper obj = new ObjectMapper();
//		String jsonstr = obj.writeValueAsString(list);
//		System.out.println(jsonstr);
//		out.print(jsonstr);
		System.out.println("查看list顺序");
		for (sql_status sqls:list){
			System.out.println(sqls.getRunTime());
		}
		System.out.println("list:"+list);
//		System.out.println("count:"+count);
//		System.out.println("limit:"+limit);
		int total = (count)/limit;
//		System.out.println("total : "+total);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("total", count);
		jsonObject.put("page", offset);
		jsonObject.put("total", total+1);
		jsonObject.put("rows", l2s.s2l(list));	
		
		PrintWriter out = res.getWriter();
		out.print(jsonObject.toString());
	}
	
	
//	protected void toGet_stage(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
//		System.out.println("捕获到搜索");
//		Stage_statusDao dao = new Stage_statusDao();
//		int limit = req.getParameter("limit")==null? 20:Integer.valueOf(req.getParameter("limit"));
//		int offset = req.getParameter("offset")==null?1:Integer.valueOf(req.getParameter("offset"));
//		String search = req.getParameter("search");
//		long stime = Long.parseLong(req.getParameter("stime"));
//		long etime = Long.parseLong(req.getParameter("etime"));
//		System.out.println("Start:"+stime);
//		System.out.println("End:"+etime);
//		ArrayList<Stage_status> list =  new ArrayList<Stage_status>();
//		int count =0;
//		if (search.equals("")){
//			list = dao.findByCode(stime,etime,limit,offset);
//			count =dao.countByCode(stime,etime);
//			}else{
//			list = dao.findByCode(search,stime,etime,limit,offset);
//			count =dao.countByCode(search,stime,etime);
//			}
////		PrintWriter out = res.getWriter();
////		ObjectMapper obj = new ObjectMapper();
////		String jsonstr = obj.writeValueAsString(list);
////		System.out.println(jsonstr);
////		out.print(jsonstr);
//		System.out.println("list:"+list);
//		PrintWriter out = res.getWriter();
//		System.out.println("count:"+count);
//		JSONObject jsonObject=new JSONObject();
//		jsonObject.put("rows", list);
//		jsonObject.put("total", count);
//		out.print(jsonObject.toString());
//	}
	
//	protected void toGet_task(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
//		System.out.println("捕获到搜索");
//		task_statusDao dao = new task_statusDao();
//		int limit = req.getParameter("limit")==null? 20:Integer.valueOf(req.getParameter("limit"));
//		int offset = req.getParameter("offset")==null?1:Integer.valueOf(req.getParameter("offset"));
//		String search = req.getParameter("search");
//		long stime = Long.parseLong(req.getParameter("stime"));
//		long etime = Long.parseLong(req.getParameter("etime"));
//		System.out.println("Start:"+stime);
//		System.out.println("End:"+etime);
//		ArrayList<task_status> list =  new ArrayList<task_status>();
//		int count =0;
//		if (search.equals("")){
//			list = dao.findByCode(stime,etime,limit,offset);
//			count =dao.countByCode(stime,etime);
//			}else{
//			list = dao.findByCode(search,stime,etime,limit,offset);
//			count =dao.countByCode(search,stime,etime);
//			}
////		PrintWriter out = res.getWriter();
////		ObjectMapper obj = new ObjectMapper();
////		String jsonstr = obj.writeValueAsString(list);
////		System.out.println(jsonstr);
////		out.print(jsonstr);
//		System.out.println("list:"+list);
//		PrintWriter out = res.getWriter();
//		System.out.println("count:"+count);
//		JSONObject jsonObject=new JSONObject();
//		jsonObject.put("rows", list);
//		jsonObject.put("total", count);
//		out.print(jsonObject.toString());
//	}
	
	
	/**
	 * 处理搜索user_info表中监控集群用户信息的消息头
	 * 调用user_infoDao.findByCode方法返回user_info实例
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toGet_user(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		System.out.println("捕获到搜索");
		User_infoDao dao = new User_infoDao();
		int limit = req.getParameter("limit")==null? 20:Integer.valueOf(req.getParameter("limit"));
		int offset = req.getParameter("offset")==null?1:Integer.valueOf(req.getParameter("offset"));
		String search = req.getParameter("search");
		ArrayList<User_info> list = new ArrayList<User_info>();
		if (search.equals("")){
		list = dao.findByCode(limit,offset);
		}else{
		list = dao.findByCode(search,limit,offset);
		}
		System.out.println("list:"+list);
		PrintWriter out = res.getWriter();
		int count =dao.countByCode(search);
		System.out.println("count:"+count);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", list);
		jsonObject.put("total", count);
		out.print(jsonObject.toString());
	}
	
	/**
	 * 处理添加user_info表中监控集群用户信息的消息头
	 * 调用suser_infoDao.findByCode方法若返回查询结果为0则继续调用addByCode方法
	 * 处理后返回json消息1给前端
	 * 若返回为1则返回给消息0给前端
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void add_user(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		System.out.println("捕获到添加");
		String status =req.getParameter("status");
		String name =req.getParameter("name");
		String ip = req.getParameter("ip");
		System.out.println(status);
		System.out.println(name);
		System.out.println(ip);
		User_infoDao dao = new User_infoDao();
		int num;
		int findnum=dao.findByCode(ip,status,name);
		System.out.println("findnum:"+findnum);
		if (findnum==0){
			num = dao.addByCode(ip,status,name);
		}else{
			num = 0;
		}
		//测试添加后返回的int值，0为添加失败，1为添加成功
//		int num = 0;
//		int num = 1;
		System.out.println(num);
		PrintWriter out = res.getWriter();
		out.print(num);
	}
	/**
	 * 处理删除user_info表中监控集群用户信息的消息头
	 * 调用suser_infoDao.findByCode方法若返回查询结果为0则继续调用delByCode方法
	 * 处理后返回json消息1给前端
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void del_user(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		System.out.println("捕获到删除");
		String ip =req.getParameter("ip");
		String name =req.getParameter("name");
		String status = req.getParameter("status");
		System.out.println(ip);
		System.out.println(name);
		System.out.println(status);
		User_infoDao dao = new User_infoDao();	
		int num = dao.delByCode(ip, status,name);
		//测试添加后返回的int值，0为添加失败，1为添加成功
//		int num = 0;
//		int num = 1;
		System.out.println(num);
		PrintWriter out = res.getWriter();
		out.print(num);
	}
}
