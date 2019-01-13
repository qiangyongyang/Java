package OGNL;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/*
 * OGNL在java环境中的使用
 */
public class OgnlDemo1 {
	
	@Test
	/*
	 * OGNL调用对象的方法：
	 */
	public void demo1() throws OgnlException{
		//获得context
		OgnlContext context=new OgnlContext();
		//获得root对象
		Object root = context.getRoot();
		//执行表达式
 		Object object = Ognl.getValue("'helloworld'.length()", context, root);
		System.out.println(object);
	}
	
	@Test
	/*
	 * 访问对象的静态方法
	 */
	public void demo2() throws OgnlException{
		//获得context
		OgnlContext context=new OgnlContext();
		//获得root对象
		Object root = context.getRoot();
		//执行表达式:@类名@方法名
		Object object = Ognl.getValue("@java.lang.Math@random()", context, root);
		System.out.println(object);
	}
}
