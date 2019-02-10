package Demo;
import java.util.ArrayList;
import java.util.Collection;

public class Demo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("abc");
		c.add(true);
		c.add(123);
		c.add(456);

		c.remove(456);

		// 清空集合
		// c.clear();

		// 判断是否包含
		System.out.println(c.contains(true));
		System.out.println(c);
	}
}
