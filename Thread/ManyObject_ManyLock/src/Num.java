
public class Num {
	int i= 0;
	synchronized public void add(){
		try {
			i++;
			System.out.println("currentThread ="+Thread.currentThread().getName() +  "   "+i);
			Thread.sleep(2000);
			System.out.println("currentThread ="+Thread.currentThread().getName() +  "   "+i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
