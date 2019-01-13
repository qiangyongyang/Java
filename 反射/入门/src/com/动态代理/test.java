package com.动态代理;

import java.lang.reflect.Proxy;

public class test {
	
	public static void main(String[] args) {
		/*UserImpl ui=new UserImpl();
		
		MyInvocationHandler m=new MyInvocationHandler(ui);
		User u =(User) Proxy.newProxyInstance(ui.getClass().getClassLoader(), ui.getClass().getInterfaces(), m);
		                                       //类加载器							//拿到所有接口                    //代理类
		u.add();
		u.delete();*/
		
		StudentImpl sl=new StudentImpl();
			
		MyInvocationHandler m=new MyInvocationHandler(sl);
		Student s =(Student) Proxy.newProxyInstance(sl.getClass().getClassLoader(), sl.getClass().getInterfaces(), m);
		                                       //类加载器							//拿到所有接口                    //代理类
		s.login();
		s.submit();
		
		
		
	}
	
}
 