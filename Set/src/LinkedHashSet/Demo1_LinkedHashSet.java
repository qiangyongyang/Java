package LinkedHashSet;

import java.util.LinkedHashSet;

/*
 * 地层是链表实现的
 * 是set集合中唯一保证存取有序，且元素唯一的集合对象
 */
public class Demo1_LinkedHashSet {
	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("a");
		lhs.add("b");
		lhs.add("c");
		
		System.out.println(lhs);
	}
}
