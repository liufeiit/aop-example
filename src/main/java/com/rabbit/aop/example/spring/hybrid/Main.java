package com.rabbit.aop.example.spring.hybrid;

import org.springframework.aop.framework.autoproxy.AutoProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rabbit.aop.example.Foo;

public class Main {

	public static void main(String[] args) {
		// 要求苛刻：bean必须延迟加载
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("aop-hybrid.xml");
		context.registerShutdownHook();
		ConfigurableListableBeanFactory bf = context.getBeanFactory();
		BeanDefinition bd = bf.getBeanDefinition("impl");
		bd.setAttribute(AutoProxyUtils.PRESERVE_TARGET_CLASS_ATTRIBUTE, Boolean.TRUE);
		Foo foo = bf.getBean(Foo.class);
		foo.foo(1);
		System.out.println(AopUtils.isCglibProxy(foo));
	}

}
