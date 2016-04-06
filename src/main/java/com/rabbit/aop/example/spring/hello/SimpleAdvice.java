package com.rabbit.aop.example.spring.hello;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {
	 
    @Override
    public Object invoke(MethodInvocation arg0) throws Throwable {
        System.out.println("before invoke...");
        Object obj = arg0.proceed();
        System.out.println("after invoke...");
        return obj;
    }
 
}
