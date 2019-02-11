package TreeSet;

import java.util.TreeSet;

import Bean.Person;

/*
 * 用来对元素进行排序的，也可以保证元素唯一
 */
public class Demo1_TreeSet {

	// 储存Integer类型对象
	public static void demo1() {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(1);
		ts.add(3);
		ts.add(2);
		ts.add(3);

		System.out.println(ts);
	}

	/*
	 * 储存自定义类型对象:  需要实现Comparable接口,重写compareTo方法
	 * 	当compareTo方法返回0的时候集合中只有一个元素
	 * 	当compareTo方法返回正数的时候集合会怎么存就怎么取
	 * 	当compareTo方法返回负数的时候集合会怎么存就反着取
	 */
	public static void demo2() {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("张三", 23));
		ts.add(new Person("李四", 24));
		ts.add(new Person("周七", 24));
		ts.add(new Person("王五", 18));
		ts.add(new Person("赵六", 20));
		
		for (Person person : ts) {
			System.out.println(person.getName() +"  "+person.getAge());
		}
	}

	public static void main(String[] args) {
		// demo1();
		demo2();
	}

}
