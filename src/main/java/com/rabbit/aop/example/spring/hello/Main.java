package com.rabbit.aop.example.spring.hello;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.rabbit.aop.example.Foo;
import com.rabbit.aop.example.Impl;

/**
 * 
 * @author Ethan Finch
 */
public class Main {
	
    public static void main(String[] args) {
        Foo foo = new Impl();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTargetClass(Foo.class);
        pf.setProxyTargetClass(false);
        pf.setTarget(foo);
        pf.addAdvisor(advisor);
        Foo proxy = (Foo) pf.getProxy();
        proxy.foo(1000);
        proxy.foo(100);
        Advised advised = (Advised) proxy;
        System.out.println(advised.getAdvisors());
		System.out.println(AopUtils.isCglibProxy(proxy));
    }
    
}
