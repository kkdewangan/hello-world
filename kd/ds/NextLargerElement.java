package com.kd.ds;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//Check problem statement at the end of the program code

public class NextLargerElement {

	public static int[] getInputArray() {
		//int arr[] = {1,3,2,4}; //case1
		//int arr[] = {5,1,3,2,4}; //case2
		//int arr[] = {1,4,3,5,2}; //case3
		//int arr[] = {-3,-2,-4,-1}; //case4
		//int arr[] = {1,4,-1,2}; //case5
		//int arr[] = {10, 3, 12, 4, 2, 9, 13, 0, 8, 11, 1, 7,5,6};//case6
		//int arr[] = {6, 2, 7, 3, 1, 0, 4, 5};//case7
		   Scanner sc=new Scanner(System.in);  
		   System.out.println("Input:");  
		   int nos=new Integer(sc.next());
		   /* input is 
			14
			10 3 12 4 2 9 13 0 8 11 1 7 5 6
		    */
		   
		   int[] arr = new int[nos];   
		   for(int i = 0; i < nos; i++) {
			   String s = sc.next();
			   arr[i] = new Integer(s);
		   }
		   
		   sc.close();  
		
		return arr;
	}
	public static void main (String[] args) {
	   int arr[] = getInputArray();
	   Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
	   
	   for(int i = 0; i < arr.length; i++) {
	        boolean foundMax = false;
	        int counter = 1;
	        if(i == arr.length -1) {
	        	result.put(arr[i], -1);
	        	break;
	        }
	        
	        while(!foundMax) {
                if((i + counter) < arr.length  && arr[i] < arr[i+counter]) {
                      result.put(arr[i], arr[i+counter]);
                      foundMax = true;
                } else {
                	counter++;
                	if((i+counter) == arr.length) {
                		result.put(arr[i], -1);
                		foundMax = true;
                	} else {
                		foundMax = false;
                	}
                }   
	        }
	   }
	   
	   Iterator it = result.entrySet().iterator();
	   while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            //System.out.println(pair.getKey() + ">>" + pair.getValue());
            System.out.print(pair.getValue()+" ");
            it.remove(); 
        }
	}
}

/**
Given an array A [ ] having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. If no such element exists, output -1 

Input:
The first line of input contains a single integer T denoting the number of test cases.Then T test cases follow. Each test case consists of two lines. The first line contains an integer N denoting the size of the array. The Second line of each test case contains N space separated positive integers denoting the values/elements in the array A[ ].
 
Output:
For each test case, print in a new line, the next greater element for each array element separated by space in order.

Constraints:
1<=T<=100
1<=N<=1000
1<=A[i]<=1000

Example:
Input
1
4
1 3 2 4 

Output
3 4 4 -1

Explanation
In the array, the next larger element to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? since it doesn't exist hence -1.
**/