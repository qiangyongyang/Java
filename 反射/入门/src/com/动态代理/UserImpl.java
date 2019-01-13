package com.动态代理;

public class UserImpl implements User{

	@Override
	public void add() {
		System.out.println("添加纪录");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("删除记录");
	}
	
}
