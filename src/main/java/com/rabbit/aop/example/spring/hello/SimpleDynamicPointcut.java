package com.rabbit.aop.example.spring.hello;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.rabbit.aop.example.Foo;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> klass, Object[] args) {
		int x = (Integer) args[0];
		return (x != 100);
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			public boolean matches(Class<?> klass) {
				return Foo.class.isAssignableFrom(klass);
			}
		};
	}

}
