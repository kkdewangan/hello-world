package com.kd.algorithm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class CamelCaseSearch {
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
		
		doCamelCaseSearch(search1);
		doCamelCaseSearch(search2);
		doCamelCaseSearch(search3);
		doCamelCaseSearch(search4);
		doCamelCaseSearch(search5);
		doCamelCaseSearch(search6);
	}

	public static void doCamelCaseSearch(String searchString) {
		System.out.println("Search string : '" + searchString  + "'");
		Set<String> result = new LinkedHashSet<String>();
		Set<String> toRemove = new HashSet<String>();
		
		List<String> charSeqList = processSearchString(searchString);
		
		boolean isFirst = true;
		
		for(String toSearch : charSeqList) {
			Iterator<String> it = result.iterator();
			if(isFirst) {
				for(String className : classNames) {
					if(className.contains(toSearch)) {
						result.add(className);
					}
				}
				isFirst = false;
			} else {
				while(it.hasNext()) {
					String s = it.next();
					if(!s.contains(toSearch)) {
						toRemove.add(s);
					}
				}
			}
		}
		
		result.removeAll(toRemove);
		
		System.out.println("Result :::");
		Iterator<String> resultIt = result.iterator();
		while(resultIt.hasNext()) {
			System.out.println(resultIt.next());
		}
		System.out.println("*******************************************************************");
	}
	public static List<String> processSearchString(String searchString) {
		List<String> charSeqList = new ArrayList<String>();
		char[] c = searchString.toCharArray();
		int count = 0;
		
		StringBuilder forSearch = null;//new StringBuilder();
		for(int i = 0; i < c.length; i++) {
			if(Character.isUpperCase(c[i])) {
				
				if(forSearch != null) {
					charSeqList.add(forSearch.toString());
				}
				
				forSearch = new StringBuilder();
				forSearch.append(c[i]);
			} else if(Character.isLowerCase(c[i]) || Character.isDigit(c[i])) {
				if(forSearch == null) {
					forSearch = new StringBuilder();
				}
				forSearch.append(c[i]);
			}
			
			if(count == 0 && (c.length == i+1)) {
				charSeqList.add(forSearch.toString());
			}
		}
		
		return charSeqList;
	}
	

}
