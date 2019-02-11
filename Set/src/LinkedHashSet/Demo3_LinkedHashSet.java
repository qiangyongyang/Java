package LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Scanner;

/*
 * 使用Scanner对象从键盘获取一行输入，去掉其中重复字符，打印出不重复字符：
 * 
 */
public class Demo3_LinkedHashSet {
	public static void main(String[] args) {
		LinkedHashSet<Character> lhs = new LinkedHashSet<>();
		System.out.print("请输入一段字符：");
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine();
		char ch[] = str.toCharArray();
		for (char c : ch) {
			lhs.add(c);
		}

		System.out.println(lhs);
	}
}
