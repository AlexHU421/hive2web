package hive2web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import util.Long2String;

class test1 {
	
	public static void main(String[] args) {
	     ArrayList<Person> list = new ArrayList();
	               list.add(new Person("lcl","28"));
	               list.add(new Person("fx","230"));
	               list.add(new Person("wqx","292512"));
	               System.out.println("原始");
	      	     for (Person s : list){
	      		    	System.out.println(s.getAge());
	      		     }                    
	      	          
	     ArrayList<Person> list1 = new ArrayList<Person>();
	     Long2String l2s = new Long2String();
	          
	     for (Person s : list){
	    	 list1.add(new Person(s.getName(), l2s.getlong(Long.parseLong(s.getAge()))));
	     }
	     System.out.println("转型后");
	     for (Person s : list1){
	    	System.out.println(s.getAge());
	     }                    
//	               System.out.println("升序");
//	               Comparator comp = new s();
//	               Collections.sort(list,comp);  
//	               for(int i = 0;i<list.size();i++){
//	                   Person p = (Person)list.get(i);
//	                   System.out.println(p.getAge());
//	               }
//	               
//	               System.out.println("降序");
//	               Comparator comp1 = new j();
//	               Collections.sort(list,comp1);  
//	               for(int i = 0;i<list.size();i++){
//	                   Person p = (Person)list.get(i);
//	                   System.out.println(p.getAge());
//	               }  
	               
	               
	           }

}
