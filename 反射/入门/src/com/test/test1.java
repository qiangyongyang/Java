package com.test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class test1 {
	/*
	 * 泛型擦除，泛型反射：
	 * ArrayList<Integer>的一个对象，在这个对象中添加一个字符串数据，怎么做？
	 */
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(111);
		list.add(222);
		
		Class clazz=Class.forName("java.util.ArrayList");  //获取字节码对象
		Method method =clazz.getMethod("add", Object.class);  //获取add方法
		method.invoke(list, "abc");
		System.out.println(list);
		
		
	}
}
