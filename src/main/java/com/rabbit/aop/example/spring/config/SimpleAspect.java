package com.rabbit.aop.example.spring.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SimpleAspect {

	@Pointcut("execution(* com.rabbit.aop.example.Bar.bar(..))")
	public void pointcut() {}

	@Before("pointcut()")
	public void before() {
		System.out.println("Before...");
	}

	@After("pointcut()")
	public void after() {
		System.out.println("After...");
	}

	@Around("pointcut()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Before...");
		pjp.proceed();
		System.out.println("After...");
	}

}
