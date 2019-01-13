package com.test;

import java.lang.reflect.Field;

public class test2 {
	/*
	 * A:案例演示
	 * 	public void setProperty(Object obj,String propertyName,Object value){},
	 * 此方法可将对象名为propertyName的属性值设置为value
	 */
	public static void main(String[] args) throws Exception {
		student s=new student("23");
		System.out.println(s);
		
		setProperty(s,"age","27");
		System.out.println(s);
	}
	
	public static void setProperty(Object obj,String propertyName,Object value) throws Exception{
		Class clazz=obj.getClass();
		Field f =clazz.getDeclaredField(propertyName);
		
		f.setAccessible(true);
		f.set(obj, value);
		
	}
}








class student{
	String age;

	
	public student(String age) {
		super();
		this.age = age;
	}
	

	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public student() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "student [age=" + age + "]";
	}
	
}