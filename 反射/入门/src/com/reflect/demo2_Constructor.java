package com.reflect;

import java.lang.reflect.Constructor;

import com.bean.person;

public class demo2_Constructor {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.bean.person");
		/*
		 * class类的newInstacne（）方法是使用该类的无参构造方法，若没有无参构造方法，就不能创建了；
		 * 
		 * 此时可以调用Class类的Constructor（String.class,int.class)去制定一个构造函数，
		 * 再调用Constructor的newInstance（参数1，参数2.....）方法创建对象
		 */
		Constructor c=clazz.getConstructor(String.class,int.class);
		person p=(person) c.newInstance("张三",25);
		System.out.println(p);
	
	}
}
