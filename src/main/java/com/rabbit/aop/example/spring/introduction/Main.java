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
		proxyFactory.setProxyTargetClass(false);
		//proxyFactory.setOptimize(true);
		TestBean target = new TestBean();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvisor(new DefaultIntroductionAdvisor(new DelegatingIntroductionInterceptor(new Impl())));
		Object proxy = proxyFactory.getProxy();
		//TestBean testBean = (TestBean) proxy;
		//testBean.test();
		Foo foo = (Foo) proxy;
		foo.foo(1);
		Bar bar = (Bar) proxy;
		bar.bar();
	}

}

class TestBean {
	
	public void test() {
		System.out.println("invoked TestBean...");
	}

}
