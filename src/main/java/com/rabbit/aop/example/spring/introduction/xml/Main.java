package com.rabbit.aop.example.spring.introduction.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rabbit.aop.example.Bar;
import com.rabbit.aop.example.Foo;
import com.rabbit.aop.example.spring.introduction.ITestBean;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("aop-mixin.xml");
		context.registerShutdownHook();
		ITestBean testBean = context.getBean(ITestBean.class);
		testBean.test();
		Foo foo = (Foo) testBean;
		foo.foo(1);
		Bar bar = (Bar) testBean;
		bar.bar();
	}

}