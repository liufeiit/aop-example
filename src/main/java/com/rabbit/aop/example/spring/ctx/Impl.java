package com.rabbit.aop.example.spring.ctx;

import org.springframework.aop.framework.AopContext;

public class Impl implements Foo {

	@Override
	public void foo1() {
		System.out.println("foo1");
	}

	@Override
	public void foo2() {
		//foo1();
		Foo foo = (Foo) AopContext.currentProxy();
		foo.foo1();
		System.out.println("foo2");
	}

}
