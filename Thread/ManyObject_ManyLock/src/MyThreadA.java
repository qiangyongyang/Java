
public class MyThreadA extends Thread{
	
	private Num num;
	public MyThreadA(Num num) {
		// TODO Auto-generated constructor stub
		super();
		this.num = num;
	}
	
	@Override
	public void run() {
		super.run();
		num.add();
	}
	
}
