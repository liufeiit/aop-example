package com.rabbit.aop.example.javassist;

import com.rabbit.aop.example.Impl;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Main {

	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass klass = pool.get("com.rabbit.aop.example.Impl");
		CtMethod method = klass.getDeclaredMethod("bar");
		method.insertBefore("System.out.println(\"Before...\");");
		method.insertAfter("System.out.println(\"After...\");");
		Class<?> clazz = klass.toClass();
		Impl impl = (Impl) clazz.newInstance();
		impl.bar();
	}

}
