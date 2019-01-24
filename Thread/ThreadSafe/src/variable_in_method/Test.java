package variable_in_method;
/*
 * 变量在方法内部，则不用加锁，线程安全
 */
public class Test {
	public static void main(String[] args) {
		Num num = new Num();
		MyThreadA a =new MyThreadA(num);
		a.setName("A");
		a.start();
		
		MyThreadB b =new MyThreadB(num);
		b.setName("B");
		b.start();
		
	}
}
