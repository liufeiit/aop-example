package com.rabbit.aop.example.spring.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rabbit.aop.example.Foo;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("aop-config.xml");
		context.registerShutdownHook();
		Foo foo = context.getBean(Foo.class);
		foo.foo(1);
	}

}
