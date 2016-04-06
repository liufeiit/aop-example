package com.rabbit.aop.example.spring.config;

import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rabbit.aop.example.Bar;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("aop-config2.xml");
		context.registerShutdownHook();
		Bar bar = context.getBean(Bar.class);
		bar.bar();
		System.out.println(bar instanceof Advised);
		System.out.println(bar instanceof SpringProxy);
		System.out.println(AopUtils.isCglibProxy(bar));
	}

}
