
public class MyThread extends Thread {
	int count =5;
	public MyThread(String name) {
		// TODO Auto-generated constructor stub
		this.setName(name);
	}
	@Override
	public void run() {
		super.run();
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
