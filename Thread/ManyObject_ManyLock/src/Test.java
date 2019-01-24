/*
 * 1.多个线程访问一个对象：
 * 关键字synchronized取得的锁都是对象锁，而不是一段代码或者一个方法，
 * 所以哪个线程先执行带synchronized关键字的方法，那个线程就持有该方法所属对象的锁。
 * 其他线程只能等待她结束。
 * 
 * 2.多个线程访问多个对象：
 * JVM会创建多个锁，效果是以异步的方式运行的。
 * 本代码中，系统产生2个锁，一个线程用一个，异步执行。
 * 
 */



public class Test {
	public static void main(String[] args) {
		Num num1 = new Num();
		Num num2 = new Num();
		MyThreadA A = new MyThreadA(num1);
		A.setName("A");
		A.start();

		MyThreadB B = new MyThreadB(num2);
		B.setName("B");
		B.start();
	}
}
