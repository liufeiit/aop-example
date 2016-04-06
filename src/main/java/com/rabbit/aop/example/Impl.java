package com.rabbit.aop.example;

import org.springframework.aop.framework.AopContext;

public class Impl implements Bar, Foo {
	
	public Boolean preserveTargetClass = Boolean.TRUE;
	
	@Override
	public void bar() {
		System.out.println("invoked Bar interface...");
	}

	@Override
	public void foo(int arg) {
		Bar bar = (Bar) AopContext.currentProxy();
		bar.bar();
		System.out.println("invoked Foo interface..." + arg);
	}

}
