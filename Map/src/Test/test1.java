package Test;

import java.util.HashMap;

/*
 * 统计字符串中每个字符出现的次数
 */
public class test1 {
	public static void main(String[] args) {
		String str = "aaassswercccddd";
		char ch[] = str.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		for (char c : ch) {
			hm.put(c, !hm.containsKey(c) ? 1 : hm.get(c) + 1);
		}

		for (Character key : hm.keySet()) {
			System.out.println(key + "=" + hm.get(key));
		}
	}
}
