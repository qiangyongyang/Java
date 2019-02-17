package TreeMap;

import java.util.TreeMap;
import Bean.Student;

/*
 * 必须实现compareable接口
 */
public class Demo1_TreeMap {
	public static void main(String[] args) {
		TreeMap<Student, String> tm = new TreeMap<>();
		tm.put(new Student("张三", 25), "北京");
		tm.put(new Student("张三", 25), "上海");
		tm.put(new Student("李四", 26), "广州");
		tm.put(new Student("王五", 27), "深圳");
		
		System.out.println(tm);
		
	}
}
