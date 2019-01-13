package com.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class demo1_Reflect {
	public static void main(String[] args) throws Exception {
		//读取配置文件
		BufferedReader br=new BufferedReader(new FileReader("xxx.properties"));
		Class clazz=Class.forName(br.readLine());
		
		
	}
}
