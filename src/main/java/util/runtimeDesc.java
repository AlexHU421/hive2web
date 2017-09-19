package util;

import java.util.Comparator;

import entity.sql_status;

public class runtimeDesc implements Comparator{
	public int compare(Object o1,Object o2) {
		sql_status p1=(sql_status)o1;
		sql_status p2=(sql_status)o2;  
	      if(Long.parseLong(p1.getRunTime())<Long.parseLong(p2.getRunTime())){
	          return 1;
	      }else{
	          return -1;
	      }
	}
}
