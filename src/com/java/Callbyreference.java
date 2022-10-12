package com.java;

public class Callbyreference {

	public static void main(String[] args) {
		int[] example = {-1,-1,-1,-1};
		
		
		for(int i=0;i<example.length;i++) {
			int index = (int)(Math.random()*16);
			example[i] = index;
			System.out.println(example[i]);
		}
		callbyFun(example);
	}

		
	static void callbyFun(int[] e) {
		int[] ex = new int[4];
		
		for(int i=0;i<ex.length;i++) {
			ex[i] = e[i];
		}
	}
}