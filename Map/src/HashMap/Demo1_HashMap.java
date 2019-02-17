package HashMap;

import java.util.HashMap;

import Bean.Student;

public class Demo1_HashMap {
	public static void main(String[] args) {
		HashMap<Student, String> hm = new HashMap<>();
		hm.put(new Student("张三", 25), "北京");
		hm.put(new Student("张三", 25), "上海");
		hm.put(new Student("李四", 26), "广州");
		hm.put(new Student("王五", 27), "深圳");
		
		System.out.println(hm.size());
	}
}
