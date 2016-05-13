package com.rabbit.aop.example.proxy;

import java.lang.reflect.Proxy;

import com.rabbit.aop.example.Bar;
import com.rabbit.aop.example.Foo;
import com.rabbit.aop.example.Impl;

public class Main {

	public static void main(String[] args) {
		Impl impl = new Impl();
		Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { Foo.class, Bar.class }, new MyInvocationHandler(impl));
		Foo foo = (Foo) proxy;
		foo.foo(1);
		Bar bar = (Bar) proxy;
		bar.bar();
	}

}
