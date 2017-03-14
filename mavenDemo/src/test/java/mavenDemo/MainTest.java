package mavenDemo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainTest {
	
	public static void main(String[] args) {
		//TestThread.getInstance();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		Date beforeDate = cal.getTime();
		Integer a = 100 ;
		Integer b = 100 ;
		System.err.println(beforeDate);
		System.err.println(1000==1000);
		System.err.println(a==b);
		
		ArrayList<String> arr1 = new ArrayList();
		ArrayList arr2 = new ArrayList<String>();
		arr1.add("±‡“Î÷Æ«∞ºÏ≤È");
		arr2.add(1);
	}
	
	void get(int i){
		
	}
	
	void get(Object i){
		
	}

}
