package Demo;

import java.util.ArrayList;
import java.util.Collection;
import Bean.Student;

public class Demo3_CollectionAll {

	public static void main(String[] args) {

		Collection c1 = new ArrayList();
		c1.add("abc");
		c1.add(true);
		c1.add(123);
		System.out.print(c1);
		System.out.println();

		Collection c2 = new ArrayList();
		c2.add("abc");
		c2.add(false);
		c2.add(123);
		System.out.print(c2);
		System.out.println();
		
		/*
		 * 求c1和c2的交集，若果调用的集合改变就返回true，否则返回false；
		 * 	即c1若果改变则返回true
		 */
		boolean b = c1.retainAll(c2); 
		System.out.println(b);
		System.out.print(c1);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
