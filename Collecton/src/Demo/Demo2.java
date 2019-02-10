package Demo;

import java.util.ArrayList;
import java.util.Collection;

import Bean.Student;

public class Demo2 {

	public static void main(String[] args) {
		/*
		 * 1.集合的遍历： *依次获取集合中的每一个元素
		 */
		Collection c = new ArrayList();
		c.add("abc");
		c.add(true);
		c.add(123);
		c.add(new Student("zhudan", 28));

		Object arr[] = c.toArray(); // 集合转化成数组
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
