package hive2web;

public class test {
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
	public static void main(String[] args) {
		
		
		
		
		Long RT = 35822887L;
		double rrt = ((double)RT)/1000;
		double rrrt = rrt/60;
		String runTime1 = ""+((RT)>1000?
							(rrt>60.00?(rrrt>60.00?
										(giveHour(rrrt))
										:giveMiniter(rrt))
									:rrt+"s")
							:(RT+"ms"));
		
		
		System.out.println(runTime1);
		

	}

}
