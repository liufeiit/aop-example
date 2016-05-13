package com.rabbit.aop.example.spring.introduction;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import com.rabbit.aop.example.Bar;
import com.rabbit.aop.example.Foo;
import com.rabbit.aop.example.Impl;

public class Main {

	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		//proxyFactory.setOptimize(true);
		proxyFactory.setProxyTargetClass(true);
		TestBean target = new TestBean();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvisor(new DefaultIntroductionAdvisor(new DelegatingIntroductionInterceptor(new Impl())));
		Object proxy = proxyFactory.getProxy();
		ITestBean testBean = (ITestBean) proxy;
		testBean.test();
		Foo foo = (Foo) proxy;
		foo.foo(1);
		Bar bar = (Bar) proxy;
		bar.bar();
	}

}