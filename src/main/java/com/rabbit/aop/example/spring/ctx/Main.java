package com.rabbit.aop.example.spring.ctx;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("aop-ctx.xml");
		context.registerShutdownHook();
		Foo foo = context.getBean(Foo.class);
		foo.foo2();
	}

}
