package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.bean.person;

public class demo3_Field {
	
	
	/*
	 * Class.getField(String)方法可以获取类中指定的字段：
	 * 
	 * 1.如果是私有的，可以用getDeclaedField("name")方法获取，通过set(obj,"李四")方法可以设置指定对象上该字段的值
	 * 2.如果是私有的，要先调用setAccessible(true)设置访问权限。
	 */
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.bean.person");
		Constructor c=clazz.getConstructor(String.class,int.class);  //获取有参构造
		person p=(person) c.newInstance("张三",25);			//通过有参构造创建对象
		System.out.println(p);
		
		/*Field f=clazz.getField("name");   //获取姓名字段
		f.set(p, "李四"); */       //这是因为是私有的，无法修改；要想修改，要获得权限
		
		
		
		Field f=clazz.getDeclaredField("name");   //暴力反射获取字段
		f.setAccessible(true);    //去除私有权限
		f.set(p, "李四");
		System.out.println(p);  
	}
}















































