package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * 遍历map
 */
public class Demo2_Map {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 26);
		map.put("李四", 27);
		map.put("王五", 15);

		//1.获取所有键
		/*Set<String> keySet = map.keySet(); // 获取所有键的集合
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next(); // 获取键
			Integer value = map.get(key); // 根据键取值 
			System.out.println(key + "=" + value);
		}*/
		
		//2.使用增强for循环 
		for (String key : map.keySet()) { 
			System.out.println(key + "="+ map.get(key));
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
