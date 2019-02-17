package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * 相同键不存储，值覆盖，返回被覆盖的值
 */
public class Demo1_Map {
	
	private static void demo1() {
		Map<String, Integer> map = new HashMap<>();
		Integer add = map.put("张三", 26); // put返回的是被覆盖的值，现在被覆盖的是null，所以返回null
		map.put("李四", 27);
		map.put("王五", 15);
		
		Integer del = map.remove("李四");  //根据键删除元素，返回键对应的值
		
		System.out.println("是否包含张三？"+map.containsKey("张三"));
		System.out.println("是否包含15？"+map.containsValue(15));
		System.out.println(add);
		System.out.println(del);
		System.out.println(map);
	}
	
	private static void demo2() {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 26); 
		map.put("李四", 27);
		map.put("王五", 15);
		
		Collection<Integer> values = map.values();
		System.out.println(values);
	}
	
	public static void main(String[] args) {
		//demo1();
		demo2();
	}

	

	
}
