package TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * 用来对元素进行排序的，也可以保证元素唯一
 */
public class Demo2_TreeSet {
	public static void main(String[] args) {
		TreeSet<String> ts =new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int num = s1.length() - s2.length();
				return num == 0 ? s1.compareTo(s2) : num;
			}
		});
		ts.add("asd");
		ts.add("z");
		ts.add("nba");
		ts.add("cbaqw");
		ts.add("we");
		
		System.out.println(ts);
	}

}

