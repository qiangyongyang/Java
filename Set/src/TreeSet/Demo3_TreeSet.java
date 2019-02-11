package TreeSet;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 从键盘输入一串字符，程序对其中所有的字符排序，例如输入helloitcast ,输出acehillostt
 */
public class Demo3_TreeSet {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.println("请输入一串字符：");
		String str = cin.nextLine();
		char ch[] = str.toCharArray();
		TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				int num = o1 - o2;
				return num == 0 ? 1 : num;
			}
		});
		
		for (char c : ch) {
			ts.add(c);
		}
		
		for (Character character : ts) {
			System.out.print(character);
		}

	}
}
