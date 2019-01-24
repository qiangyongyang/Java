/*
 * 锁不能继承：
 * 	若是父类方法定义了锁，子类方法也想拥有锁，那么子类必须自己定义。
 * 	父类的锁不能继承给子类
 */
public class Son extends Father{

	@Override
	synchronized public void method()  {
		System.out.println("int son sta  " + Thread.currentThread().getName());
		System.out.println("int son end  " + Thread.currentThread().getName());
	}
	
}
