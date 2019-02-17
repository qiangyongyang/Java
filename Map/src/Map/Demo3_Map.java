package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/*
 * 相同键不存储，值覆盖，返回被覆盖的值
 */
public class Demo3_Map {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 26);
		map.put("李四", 27);
		map.put("王五", 15);

		/*
		 * Map.Entry说明Entry是Map的内部接口，将键和值封装成Entry对象，存储在Set集合中
		 */
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		// 获取每一个对象
		/*Iterator<Map.Entry<String, Integer>> it = entrySet.iterator(); while
		 * (it.hasNext()) { // 获取每一个entry对象 Map.Entry<String, Integer> en =
		 * it.next(); String key = en.getKey(); Integer value = en.getValue();
		 * System.out.println(key + "=" + value); }
		 */
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key + "=" + value);
		}
	}

}
