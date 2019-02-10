package Demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Bean.Student;
/*
 * 迭代：
 */
public class Demo5_Iterator {
	
	public static void main(String[] args) {
		Collection c = new  ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		c.add(new Student("zhangsan", 28));
		
		//对集合中的元素迭代（遍历）
		Iterator it = c.iterator();   //获取迭代器
		
		boolean b1 = it.hasNext();    //判断集合中是否有元素，有就返回true
		/*Object  obj1 = it.next();
		System.out.println(b1);
		System.out.println(obj1);*/
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
