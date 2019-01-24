package variable_out_method.copy;
/*
 * 变量在方法外面，线程不安全，需要加锁
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
