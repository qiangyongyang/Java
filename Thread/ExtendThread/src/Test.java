
public class Test {
	public static void main(String[] args) {
		MyThread t1 =new MyThread("thread1");
		t1.start();
		try {
			for (int i = 0; i < 5; i++) {
				int timer = (int) (Math.random() * 1000);
				Thread.sleep(timer);
				System.out.println("run= "+Thread.currentThread().getName());
			} 
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
