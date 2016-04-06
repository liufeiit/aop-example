package com.rabbit.aop.example.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

public class Main {
	
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SimpleClass.class);
		enhancer.setCallback(new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("Before...");
				Object result = method.invoke(new SimpleClass(), args);
				System.out.println("After...");
				return result;
			}

		});
		SimpleClass proxy = (SimpleClass) enhancer.create();
		proxy.echo();
	}

	public static class SimpleClass {
		public void echo() {
			System.out.println("Hello World");
		}
	}
	
}
