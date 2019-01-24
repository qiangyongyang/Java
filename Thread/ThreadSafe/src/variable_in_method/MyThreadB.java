package variable_in_method;

public class MyThreadB extends Thread{
	
	private Num num;
	public MyThreadB(Num num) {
		super();
		this.num = num;
	}
	@Override
	public void run() {
		super.run();
		num.login();
	}

}
