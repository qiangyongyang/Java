
public class Test {
	
	public static void main(String[] args) {
		Runnable runable = new MyThread();
		Thread t1 = new Thread(runable);
		t1.setName("Thread1");
		t1.start();
		System.out.println("run= "+Thread.currentThread().getName());
	}
}
