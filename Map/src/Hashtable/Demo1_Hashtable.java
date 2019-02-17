package Hashtable;

import java.util.HashMap;
import java.util.Hashtable;

public class Demo1_Hashtable {
	/*
	 * HashMap和Hashtable的区别
	 * 共同点：
	 * 	底层都是hash算法，都是双列集合
	 * 区别：
	 * 	1.HashMap是线程不安全的，效率高
	 * 	  Hashtable是线程安全的，效率低
	 * 	2.HashMap可以存储null键和null值
	 * 	  Hashtable不可以
	 * 
	 */
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put(null, 23);
		System.out.println(hm);
		
		Hashtable<String, Integer> ht = new Hashtable<>();
		ht.put(null, 23);
		System.out.println(ht);
	}
}
