package LinkedHashSet;

import java.util.HashSet;
import java.util.Random;

/*
 * 编写一个程序，获取10个1~20的随机数，且不能重复:
 * 		1.有random类创建随机数
 * 		2.用HashSet集合
 * 		3.如果HashSet的size小于10就不断存储
 * 		4.通过Random类中的nextInt（n）方法获取到1~20之间的随机数，并且存储到集合中
 */
public class Demo2_LinkedHashSet {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		Random r =new Random();
		while(hs.size()<10){
			int num = r.nextInt(20)+1;
			hs.add(num);
		}
		for (Integer integer : hs) {
			System.out.print(integer +" ");
		}
		System.out.println();
	}
}
