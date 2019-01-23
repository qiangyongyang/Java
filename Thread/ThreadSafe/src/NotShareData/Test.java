package NotShareData;

public class Test {
	public static void main(String[] args) throws Exception {
		MyThread my = new MyThread();
		Thread t1 = new Thread(my, "t1");
		Thread t2 = new Thread(my, "t2");
		Thread t3 = new Thread(my, "t3");
		Thread t4 = new Thread(my, "t4");
		
		t1.start();
		t1.sleep(200);
		t1.interrupt();

		System.out.println(Thread.currentThread().isInterrupted());
		
		System.out.println(t1.isInterrupted());
		
		/*t2.start();
		t3.start();
		t4.start();*/
	}
}
