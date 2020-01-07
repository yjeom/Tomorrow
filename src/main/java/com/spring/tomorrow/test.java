package com.spring.tomorrow;

public class test {
	public static void main(String[]args) {
		
System.out.println((int)Math.ceil((double)2/10)+"sdas");
		Paging paging=new Paging(11, 2);
		System.out.println(paging.getTotalPage());
		System.out.println(paging.getTotalBlock());
		System.out.println(paging.getCurBlock());
		System.out.println(paging.getStartPage());
		
	}
}
