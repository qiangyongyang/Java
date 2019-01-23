package NotShareData;

public class MyThread extends Thread{
	int count = 10;
	
	@Override
	synchronized public void run() {
		super.run();
		while(count >0){
			System.out.println(count);
			count--;
		}
		
	}
}