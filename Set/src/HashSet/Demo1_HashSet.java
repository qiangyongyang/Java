package HashSet;
import java.util.HashSet;

import Bean.Person;
/*
 * set无索引，不可以重复，无序
 */
public class Demo1_HashSet {
	
	public static void main(String[] args) {
		HashSet<Person> hs = new HashSet<>();
		hs.add(new Person("张安", 18));
		hs.add(new Person("张安", 18));
		hs.add(new Person("张安", 18));
		hs.add(new Person("张安", 18));
		hs.add(new Person("张安", 18));
		hs.add(new Person("张安", 18));
		hs.add(new Person("李四", 18));
		/*
		 * 重写equals和hashcode方法 
		 */
		System.out.println(hs.size() );
	}
}
