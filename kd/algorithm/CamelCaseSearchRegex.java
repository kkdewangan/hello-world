package com.kd.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelCaseSearchRegex {
	private static final List<String> classNames;
	static  {
		classNames = new ArrayList<String>();
		classNames.add("Order");
		classNames.add("OrderDetail");
		classNames.add("OrderDetailTest");
		classNames.add("OrderSummary");
		classNames.add("OrderSummaryTest");
		classNames.add("MyTest");
		
	}
	
	public static void main(String[] args) {
 		String search1= "Order";
		String search2= "Te";
		String search3= "OS";
		String search4= "MTe";
		String search5= "OrTe";
		String search6= "rSu";
		
		doRegexCamelCaseSearch(search1);
		/*doRegexCamelCaseSearch(search2);
		doRegexCamelCaseSearch(search3);
		doRegexCamelCaseSearch(search4);
		doRegexCamelCaseSearch(search5);
		doRegexCamelCaseSearch(search6);*/
	}
	
	public static void doRegexCamelCaseSearch(String searchString) {
	  /*
	  String content = "This is Chaitanya from Beginnersbook.com.";
	  String patternString = ".*book.*";//false ".*book.";//false
	  Pattern 	pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
	
	  Matcher matcher = 	pattern.matcher(content);
	  boolean isMatched = matcher.matches();
	  System.out.println("Is it a Match?" + isMatched);
	  
	  */  
	  String content = "eclipseRCPExt";//"Kamal Dewangan";
	  String patternString = "(?<=[a-z])(?=[A-Z])";//"([A-Za-z]\\S\\w+)|([a-z]\\s[])";

	  
	  System.out.println("Content String : "+content);
	  System.out.println("Search String : " + patternString);
	  Pattern 	pattern = Pattern.compile(patternString);
	  Matcher matcher = 	pattern.matcher(content);
	  
	  while(matcher.find()) {
		  System.out.println("Group index:" + matcher.group());
		  System.out.println("Start index:" + matcher.start());
		  System.out.println("End index:" + matcher.end());
	  }
	  boolean isMatched = matcher.matches();
	  System.out.println("Pattern match: " + isMatched);	  
	  
	}

}
