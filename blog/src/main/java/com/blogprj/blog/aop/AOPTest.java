package com.blogprj.blog.aop;

public class AOPTest {
	public void beforeMethod() {
		System.out.println("beforeMethod()호출!");
	}
 
	public void afterMethod() {
		System.out.println("afterMethod()호출!");
	}
}
