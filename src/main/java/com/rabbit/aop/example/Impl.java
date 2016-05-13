package com.rabbit.aop.example;

import org.springframework.aop.framework.AopContext;

public class Impl implements Bar, Foo {
	
	@Override
	public void bar() {
		System.out.println("invoked Bar interface...");
	}

	@Override
	public void foo(int arg) {
		System.out.println("invoked Foo interface..." + arg);
	}

}
