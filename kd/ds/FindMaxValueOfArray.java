package com.kd.ds;

public class FindMaxValueOfArray {
	public static int[] arr = {2, 4, 8};//, 3, 5};
	
	public static void main(String[] args) {
		System.out.println(findMax(arr, 0, arr.length -1));
	}

	
	//Kamal do it your way ...dont check anyone's solution, use recursion
	/*
	 there are many many ways to solve, but you do it with recursion. 
	 */
	public static int findMax(int[] arr, int start, int end) {
		int mid = end/2;

		if(start == mid) {
			if(arr[start] > arr[end]) {
				return start;
			} else {
				return end;
			}
		} else {
			findMax(arr, start, mid);
		}
		
		return -1;
		
	}
}
