
public class Test {
	public static void main(String[] args) {
		Son son =new Son();
		
		MyThreadA a = new MyThreadA(son);
		a.setName("a");
		a.start();
		
		MyThreadB b =new MyThreadB(son);
		b.setName("b");
		b.start();
	}
}
