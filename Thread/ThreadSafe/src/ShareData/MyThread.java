package ShareData;

public class MyThread extends Thread{
	int count = 5;
	public MyThread(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		 
		while(count >0 ){
			System.out.println(Thread.currentThread().getName()+ "    "+count);
			count--;
		}
	}

	
}
