
public class MyThreadB extends Thread{
	
	private Num num;
	public MyThreadB(Num num) {
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
