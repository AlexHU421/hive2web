package util;

import java.util.ArrayList;

import entity.sql_status;

public class Long2String {
	public  static String giveMiniter(Double secound){
		String time = "";
			int minite = (int)(secound/60);
			secound-=minite*60;
		return time+=minite+"m "+secound+"s";
	}
	public  static String giveHour(Double Minite){
		String time = "";
			int hour = (int)(Minite/60);
			int m  = (int)(Minite-(hour*60));
		return time+=hour+"h "+m+"m";
	}
	
	public ArrayList<sql_status> s2l(ArrayList<sql_status> list){
		ArrayList<sql_status> list1 = new ArrayList<sql_status>();
	     for (sql_status s : list){
	    	 list1.add(new sql_status(s.getIp(),s.getJobid(),s.getDescription(),s.getSubmission_time(),s.getCompletion_time(),s.getStages(),s.getTotalTask(),s.getStatus(),s.getFailedstageID(),getlong(Long.parseLong(s.getRunTime()))));
	    	 }
	     return list1;
		}
	
	public static String getlong(long l){
		double rrt = ((double)l)/1000;
		double rrrt = rrt/60;
		return ((l)>1000?
							(rrt>60.00?(rrrt>60.00?
										(giveHour(rrrt))
										:giveMiniter(rrt))
									:rrt+"s")
							:(l+"ms"));
//		System.out.println(runTime1);
	}
}
