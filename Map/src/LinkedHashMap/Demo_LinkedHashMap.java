package LinkedHashMap;

import java.util.LinkedHashMap;

public class Demo_LinkedHashMap {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lhm =new LinkedHashMap<>();
		lhm.put("张三", 25);
		lhm.put("李四", 26);
		lhm.put("王五", 27);
		lhm.put("赵六", 28);
		
		System.out.println(lhm);
		
	}
}
