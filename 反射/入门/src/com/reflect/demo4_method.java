package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.bean.person;

public class demo4_method {
	/*
	 * Class.getMethod(String,class....) 和Class.getDeclaredMethod(String,Class..)方法
	 * 可以获取类中指定的方法，调用invoke（Object,Object...）可以调用该方法，
	 *  Class.getMethod("eat").invoke(obj)和
	 *  Class.getMethod("eat",int.class).invoke(obj,10)执行方法
	 */
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.bean.person");
		Constructor c=clazz.getConstructor(String.class,int.class);
		person p=(person) c.newInstance("张三",25);			
		
		Method method=clazz.getMethod("eat"); //获取eat方法
		method.invoke(p);
		
		Method method1=clazz.getMethod("eat", int.class);
		method1.invoke(p, 10);
		
	}
}















































